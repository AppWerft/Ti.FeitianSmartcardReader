/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 */
package com.ftsafe;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.ftsafe.CCIDScheme;
import com.ftsafe.CCIDScheme$frame;
import com.ftsafe.DK;
import com.ftsafe.readerScheme.FTReaderInf;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.BitwiseOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.slib.srfi60;
import gnu.kawa.slib.srfi69;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.EofClass;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequences;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Char;
import java.io.Externalizable;
import java.io.Serializable;
import java.util.Iterator;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.exceptions;
import kawa.lib.kawa.hashtable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.hashtables;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;
import kawa.standard.syntax_case;

public class CCIDScheme {
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

    public CCIDScheme(FTReaderInf fTReaderInf, Handler handler) {
        void ftReaderInf;
        void handler2;
        public class Frame17
        extends ModuleBody {
            CCIDScheme $this$;
            final ModuleMethod lambda$Fn34;
            final ModuleMethod lambda$Fn35;
            final ModuleMethod lambda$Fn36;
            final ModuleMethod lambda$Fn38;
            final ModuleMethod lambda$Fn39;

            public Frame17() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 19, null, 20485);
                moduleMethod.setProperty("source-location", "ccid_7816/CCIDScheme.scm:57");
                this.lambda$Fn34 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 20, null, 8194);
                moduleMethod2.setProperty("source-location", "ccid_7816/CCIDScheme.scm:61");
                this.lambda$Fn35 = moduleMethod2;
                ModuleMethod moduleMethod3 = new ModuleMethod(this, 21, null, 4097);
                moduleMethod3.setProperty("source-location", "ccid_7816/CCIDScheme.scm:64");
                this.lambda$Fn36 = moduleMethod3;
                ModuleMethod moduleMethod4 = new ModuleMethod(this, 22, null, 4097);
                moduleMethod4.setProperty("source-location", "ccid_7816/CCIDScheme.scm:73");
                this.lambda$Fn38 = moduleMethod4;
                ModuleMethod moduleMethod5 = new ModuleMethod(this, 23, null, 4097);
                moduleMethod5.setProperty("source-location", "ccid_7816/CCIDScheme.scm:77");
                this.lambda$Fn39 = moduleMethod5;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 23: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    case 22: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    case 21: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                if (moduleMethod.selector == 20) {
                    callContext.value1 = object2;
                    callContext.value2 = object3;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, object2, object3, callContext);
            }

            public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
                if (moduleMethod.selector == 19) {
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
                    case 21: {
                        return CCIDScheme.lambda53(this, object2);
                    }
                    case 22: {
                        return CCIDScheme.lambda55(this, object2);
                    }
                    case 23: {
                        return CCIDScheme.lambda56(this, object2);
                    }
                }
                return super.apply1(moduleMethod, object2);
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                if (moduleMethod.selector == 20) {
                    CCIDScheme.lambda52(this, object2, object3);
                    return Values.empty;
                }
                return super.apply2(moduleMethod, object2, object3);
            }

            public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
                if (moduleMethod.selector == 19) {
                    return CCIDScheme.lambda51(this, arrobject[0], arrobject[1], arrobject[2], arrobject[3], arrobject[4]);
                }
                return super.applyN(moduleMethod, arrobject);
            }
        }
        Frame17 $heapFrame = new Frame17();
        $heapFrame.$this$ = this;
        $heapFrame.$this$.mFTReaderInf = ftReaderInf;
        $heapFrame.$this$.mHandler = handler2;
        USB_CONTROL_IN = $heapFrame.lambda$Fn34;
        USB_SEND = $heapFrame.lambda$Fn35;
        USB_RECV = $heapFrame.lambda$Fn36;
        USB_SEND_RECV = lambda$Fn37;
        USB_INTERRUPT_RECV = $heapFrame.lambda$Fn38;
        pp = $heapFrame.lambda$Fn39;
        $heapFrame.$this$.showLog("(*init* (ftReaderInf ::FTReaderInf) (handler ::Handler)) #!void");
    }

    public Object readerFind() {
        this.mFTReaderInf.ft_find();
        return Values.empty;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object readerOpen(Object device) {
        LList lList;
        public class Frame19
        extends ModuleBody {
            Object index;
            Frame18 staticLink;
            final ModuleMethod lambda$Fn40;

            public Frame19() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 24, null, 0);
                moduleMethod.setProperty("source-location", "ccid_7816/CCIDScheme.scm:99");
                this.lambda$Fn40 = moduleMethod;
            }

            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                if (moduleMethod.selector == 24) {
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                }
                return super.match0(moduleMethod, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply0(ModuleMethod moduleMethod) {
                if (moduleMethod.selector == 24) {
                    return CCIDScheme.lambda57(this);
                }
                return super.apply0(moduleMethod);
            }
        }
        Frame19 $heapFrame;
        Pair pair;
        Iterator iterator;
        block12 : {
            Object object2;
            public class Frame18
            extends ModuleBody {
                CCIDScheme $this$;
            }
            Frame18 $heapFrame2 = new Frame18();
            $heapFrame2.$this$ = this;
            $heapFrame2.$this$.mFTReaderInf.ft_open(device);
            GET_DEVICES_INF = CCIDScheme.doInitDescriptorInf(USB_CONTROL_IN);
            XfrBlock$Mnhash$Mntable = srfi69.makeHashTable();
            iterator = Sequences.getIterator(((Procedure)Scheme.applyToArgs).apply1(GET_DEVICES_INF));
            lList = LList.Empty;
            pair = null;
            do {
                Values values;
                Pair pair2;
                block11 : {
                    Values values2;
                    block10 : {
                        new Frame19().staticLink = $heapFrame2;
                        $heapFrame = new Frame19();
                        if (!iterator.hasNext()) break;
                        Object e = iterator.next();
                        object2 = Promise.force(e, Pair.class);
                        $heapFrame.index = lists.car((Pair)object2);
                        object2 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(lists.assoc(Lit226, lists.cdr((Pair)object2)))) break block10;
                        CCIDScheme.threadStart$Ex(CCIDScheme.makeThread($heapFrame.lambda$Fn40));
                        values2 = Values.empty;
                        break block11;
                    }
                    values2 = values = Values.empty;
                }
                if (pair == null) {
                    pair2 = new Pair(values, LList.Empty);
                } else {
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
            } while (true);
            break block12;
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, object2);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, object2);
            }
        }
        iterator = Sequences.getIterator(CCIDScheme.lambda58loop(Lit1));
        lList = LList.Empty;
        pair = null;
        while (iterator.hasNext()) {
            Pair pair3;
            $heapFrame = iterator.next();
            if (pair == null) {
                pair3 = new Pair(((Procedure)Scheme.applyToArgs).apply3(GET_DEVICES_INF, Lit218, $heapFrame), LList.Empty);
            } else {
                pair3 = lList;
                pair.setCdr(lList);
            }
            pair = pair3;
        }
        return ((Procedure)Scheme.apply).apply2(Lit255, lList);
    }

    public Object readerClose() {
        this.mFTReaderInf.ft_close();
        GET_DEVICES_INF = GET_DEVICES_INF_default;
        XfrBlock$Mnhash$Mntable = Boolean.FALSE;
        return Values.empty;
    }

    public Object readerPowerOn(int index) {
        public class Frame20
        extends ModuleBody {
            int index;
            final ModuleMethod lambda$Fn41;
            final ModuleMethod lambda$Fn42;

            public Frame20() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 25, null, 4097);
                moduleMethod.setProperty("source-location", "ccid_7816/CCIDScheme.scm:136");
                this.lambda$Fn41 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 26, null, 0);
                moduleMethod2.setProperty("source-location", "ccid_7816/CCIDScheme.scm:138");
                this.lambda$Fn42 = moduleMethod2;
            }

            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                if (moduleMethod.selector == 26) {
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                }
                return super.match0(moduleMethod, callContext);
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 25) {
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

            public Object apply0(ModuleMethod moduleMethod) {
                if (moduleMethod.selector == 26) {
                    return CCIDScheme.lambda60(this);
                }
                return super.apply0(moduleMethod);
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 25) {
                    return CCIDScheme.lambda59(this, object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame20 $heapFrame = new Frame20();
        $heapFrame.index = index;
        Pair ret = CCIDScheme.doPowerOn($heapFrame.lambda$Fn41, $heapFrame.lambda$Fn42);
        Object object2 = Promise.force(XfrBlock$Mnhash$Mntable, hashtable.HashTable.class);
        try {
            hashtables.hashtableSet$Ex((hashtable.HashTable)object2, $heapFrame.index, lists.cadr(lists.assoc(Lit252, ret)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-set!", 1, object2);
        }
        return ((Procedure)Scheme.apply).apply2(Lit0, lists.cadr(lists.assoc(Lit251, ret)));
    }

    public Object readerPowerOff(int index) {
        Values values;
        block5 : {
            block4 : {
                public class Frame21
                extends ModuleBody {
                    int index;
                    final ModuleMethod lambda$Fn43;

                    public Frame21() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 27, null, 4097);
                        moduleMethod.setProperty("source-location", "ccid_7816/CCIDScheme.scm:148");
                        this.lambda$Fn43 = moduleMethod;
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 27) {
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
                        if (moduleMethod.selector == 27) {
                            return CCIDScheme.lambda61(this, object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame21 $heapFrame = new Frame21();
                $heapFrame.index = index;
                CCIDScheme.doPowerOff($heapFrame.lambda$Fn43);
                Object object2 = Promise.force(XfrBlock$Mnhash$Mntable, hashtable.HashTable.class);
                try {
                    if (!hashtables.isHashtableContains((hashtable.HashTable)object2, $heapFrame.index)) break block4;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "hashtable-contains?", 1, object2);
                }
                object2 = Promise.force(XfrBlock$Mnhash$Mntable, hashtable.HashTable.class);
                try {
                    hashtables.hashtableDelete$Ex((hashtable.HashTable)object2, $heapFrame.index);
                    values = Values.empty;
                    break block5;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "hashtable-delete!", 1, object2);
                }
            }
            values = Values.empty;
        }
        return values;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object readerXfrBlock(int index, byte[] data) {
        block4 : {
            Object object2 = Promise.force(XfrBlock$Mnhash$Mntable, hashtable.HashTable.class);
            try {
                if (!hashtables.isHashtableContains((hashtable.HashTable)object2, index)) break block4;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "hashtable-contains?", 1, object2);
            }
            object2 = Promise.force(XfrBlock$Mnhash$Mntable, hashtable.HashTable.class);
            return ((Procedure)Scheme.apply).apply2(Lit0, ((Procedure)Scheme.applyToArgs).apply2(srfi69.hashTableRef((hashtable.HashTable)object2, index), ((Procedure)Scheme.apply).apply2(LangObjType.listType, data)));
        }
        Type.NeverReturns neverReturns = exceptions.error("readerXfr error readerPowerOn first");
        throw Special.reachedUnexpected;
    }

    public Object readerEscape(int index, byte[] data) {
        public class Frame22
        extends ModuleBody {
            int index;
            final ModuleMethod lambda$Fn44;

            public Frame22() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 28, null, 4097);
                moduleMethod.setProperty("source-location", "ccid_7816/CCIDScheme.scm:169");
                this.lambda$Fn44 = moduleMethod;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 28) {
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
                if (moduleMethod.selector == 28) {
                    return CCIDScheme.lambda62(this, object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame22 $heapFrame = new Frame22();
        $heapFrame.index = index;
        return ((Procedure)Scheme.apply).apply2(Lit0, CCIDScheme.doEscape($heapFrame.lambda$Fn44, ((Procedure)Scheme.apply).apply2(LangObjType.listType, data)));
    }

    public int readerSlotStatus(int index) {
        public class Frame23
        extends ModuleBody {
            int index;
            final ModuleMethod lambda$Fn45;

            public Frame23() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 29, null, 4097);
                moduleMethod.setProperty("source-location", "ccid_7816/CCIDScheme.scm:179");
                this.lambda$Fn45 = moduleMethod;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 29) {
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
                if (moduleMethod.selector == 29) {
                    return CCIDScheme.lambda63(this, object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame23 $heapFrame = new Frame23();
        $heapFrame.index = index;
        return ((Number)Promise.force(CCIDScheme.doSlotStatus($heapFrame.lambda$Fn45))).intValue();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int readerGetPid() {
        if (KawaConvert.isTrue(this.mFTReaderInf.isFtExist())) {
            Object object2 = Promise.force(lists.assoc(Lit216, descriptor$Mninfo), Pair.class);
            return ((Number)Promise.force(lists.cadr(lists.assoc(Lit37, lists.cdr((Pair)object2))))).intValue();
        }
        Type.NeverReturns neverReturns = exceptions.error("USB Not Opened");
        throw Special.reachedUnexpected;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int readerGetBcdDevice() {
        if (KawaConvert.isTrue(this.mFTReaderInf.isFtExist())) {
            Object object2 = Promise.force(lists.assoc(Lit216, descriptor$Mninfo), Pair.class);
            return ((Number)Promise.force(lists.cadr(lists.assoc(Lit38, lists.cdr((Pair)object2))))).intValue();
        }
        Type.NeverReturns neverReturns = exceptions.error("USB Not Opened");
        throw Special.reachedUnexpected;
    }

    public Object showLog(String log) {
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(null, (Object)this.mHandler))) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(DK.CCIDSCHEME_LOG, (Object)log));
        }
        return Log.d((String)"CCIDScheme", (String)log);
    }

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        pp = lambda$Fn3;
        descriptor$Mninfo = LList.Empty;
        _current_interface_ = Lit27;
        current_dev_interface = lambda$Fn5;
        _ccid_bSeq_ = Lit1;
        ccid$Mndata$Mnrates$Mnsupported = false;
        USB_TIMEOUT = Lit181;
        ns = Lit1;
        T1$MnTPDU$MnIblock$MnN_S = lambda$Fn21;
        nr = Lit1;
        T1$MnTPDU$MnRblock$MnN_R = lambda$Fn22;
        _debug_ = true;
        CCID$MnDEBUG = lambda$Fn23;
        GET_DEVICES_INF = GET_DEVICES_INF_default;
        USB_CONTROL_IN = lambda$Fn29;
        USB_SEND = lambda$Fn30;
        USB_RECV = lambda$Fn31;
        USB_SEND_RECV = lambda$Fn32;
        USB_INTERRUPT_RECV = lambda$Fn33;
        XfrBlock$Mnhash$Mntable = Boolean.FALSE;
    }

    public static U8Vector list$To$U8vector(Object l) {
        byte[] b = (byte[])Promise.force(((Procedure)Scheme.apply).apply2(Lit0, l));
        return new U8Vector(b);
    }

    public static Object u8vector$To$List(Object data) {
        return ((Procedure)Scheme.apply).apply2(LangObjType.listType, data);
    }

    public static U8Vector makeU8vector(Object object2) {
        return CCIDScheme.makeU8vector(object2, Lit1);
    }

    public static U8Vector makeU8vector(Object num, Object fixed) {
        Object object2 = Promise.force(num);
        try {
            return new U8Vector(((Number)object2).intValue(), 1);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.lists.U8Vector.<init>(int,byte)", 1, object2);
        }
    }

    public static String object$To$String(Object obj) {
        return Format.formatToString(0, "~A", obj);
    }

    /*
     * Exception decompiling
     */
    public static Object slice(Object lst, Object offset, Object length) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Object buildDwordFromlst$V(Object lst, Object[] argsArray) {
        Object object2;
        Object endia = Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
        if (endia == Lit4) {
            object2 = ((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 3), Lit5), ((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 2), Lit6)), ((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 1), Lit7)), lists.listRef(lst, 0));
        } else if (endia == Lit8) {
            object2 = ((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 0), Lit5), ((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 1), Lit6)), ((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 2), Lit7)), lists.listRef(lst, 3));
        } else {
            Type.NeverReturns neverReturns = exceptions.error("build-dword-fromlst", "parameter error!");
            throw Special.reachedUnexpected;
        }
        return object2;
    }

    public static Pair buildDwordInlst$V(Object dword, Object[] argsArray) {
        Pair pair;
        Object endia = Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
        if (endia == Lit4) {
            pair = LList.list4(((Procedure)BitwiseOp.and).apply2(dword, Lit9), ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(dword, Lit10), Lit9), ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(dword, Lit11), Lit9), ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(dword, Lit12), Lit9));
        } else if (endia == Lit8) {
            pair = LList.list4(((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(dword, Lit12), Lit9), ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(dword, Lit11), Lit9), ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(dword, Lit10), Lit9), ((Procedure)BitwiseOp.and).apply2(dword, Lit9));
        } else {
            Type.NeverReturns neverReturns = exceptions.error("build-dword-inlst", "parameter error!");
            throw Special.reachedUnexpected;
        }
        return pair;
    }

    public static Object buildWordFromlst$V(Object lst, Object[] argsArray) {
        Object object2;
        Object endia = Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
        if (endia == Lit4) {
            object2 = ((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 1), Lit7), lists.listRef(lst, 0));
        } else if (endia == Lit8) {
            object2 = ((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ashift).apply2(lists.listRef(lst, 0), Lit7), lists.listRef(lst, 1));
        } else {
            Type.NeverReturns neverReturns = exceptions.error("build-word-fromlst", "parameter error!");
            throw Special.reachedUnexpected;
        }
        return object2;
    }

    public static Pair buildWordInlst$V(Object word, Object[] argsArray) {
        Pair pair;
        Object endia = Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
        if (endia == Lit4) {
            pair = LList.list2(((Procedure)BitwiseOp.and).apply2(word, Lit9), ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(word, Lit10), Lit9));
        } else if (endia == Lit8) {
            pair = LList.list2(((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(word, Lit10), Lit9), ((Procedure)BitwiseOp.and).apply2(word, Lit9));
        } else {
            Type.NeverReturns neverReturns = exceptions.error("build-word-inlst", "parameter error!");
            throw Special.reachedUnexpected;
        }
        return pair;
    }

    public static Procedure makeCounter() {
        return CCIDScheme.makeCounter(Lit1, Lit2);
    }

    public static Procedure makeCounter(Object object2) {
        return CCIDScheme.makeCounter(object2, Lit2);
    }

    public static Procedure makeCounter(Object start, Object step) {
        public class Frame0
        extends ModuleBody {
            Object step;
            Object counter;
            final ModuleMethod lambda$Fn1;

            public Frame0() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 0);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:84");
                this.lambda$Fn1 = moduleMethod;
            }

            Object lambda1() {
                this.counter = AddOp.apply2(1, this.counter, this.step);
                return this.counter;
            }

            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                if (moduleMethod.selector == 1) {
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                }
                return super.match0(moduleMethod, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply0(ModuleMethod moduleMethod) {
                if (moduleMethod.selector == 1) {
                    return this.lambda1();
                }
                return super.apply0(moduleMethod);
            }
        }
        Frame0 $heapFrame = new Frame0();
        $heapFrame.step = step;
        $heapFrame.counter = AddOp.apply2(-1, start, $heapFrame.step);
        return $heapFrame.lambda$Fn1;
    }

    public static Procedure makeContainer(Object func) {
        public class Frame1
        extends ModuleBody {
            Object func;
            Object _container;
            final ModuleMethod lambda$Fn2;

            public Frame1() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 2, null, 8193);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:93");
                this.lambda$Fn2 = moduleMethod;
            }

            Object lambda2(Object object2) {
                return this.lambda2(object2, Boolean.FALSE);
            }

            Object lambda2(Object op, Object arg) {
                Object object2;
                if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, CCIDScheme.Lit13))) {
                    this._container = arg;
                    object2 = Values.empty;
                } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, CCIDScheme.Lit14))) {
                    this._container = ((Procedure)Scheme.applyToArgs).apply3(this.func, this._container, arg);
                    object2 = Values.empty;
                } else {
                    object2 = KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, CCIDScheme.Lit15)) ? this._container : Values.empty;
                }
                return object2;
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
                    return this.lambda2(object2);
                }
                return super.apply1(moduleMethod, object2);
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                if (moduleMethod.selector == 2) {
                    return this.lambda2(object2, object3);
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame1 $heapFrame = new Frame1();
        $heapFrame.func = func;
        $heapFrame._container = Boolean.FALSE;
        return $heapFrame.lambda$Fn2;
    }

    public static Object toList$V(Object A, Object[] argsArray) {
        LList lList;
        LList B = lList = LList.makeList(argsArray, 0);
        return append.append$V(new Object[]{LList.list1(A), B});
    }

    public static Object readU8s(Object n, Object port) {
        Object b;
        return NumberCompare.$Gr(n, Lit1) ? (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(b = ports.readU8(port), EofClass.eofValue)) ? LList.Empty : lists.cons(b, CCIDScheme.readU8s(AddOp.apply2(-1, n, Lit2), port))) : LList.Empty;
    }

    /*
     * Exception decompiling
     */
    public static Object callWithInputU8vector(Object u8, Object proc) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    static void lambda3(Object obj) {
        CCIDScheme.object$To$String(obj);
    }

    public static Object subu8list(Object lst, Object start, Object end) {
        return CCIDScheme.slice(lst, start, AddOp.apply2(-1, end, start));
    }

    public static Object groupList(Object lst, Object gl) {
        return NumberCompare.$Gr(gl, Lit1) ? append.append$V(new Object[]{LList.list1(CCIDScheme.slice(lst, Lit1, gl)), NumberCompare.$Gr(AddOp.apply2(-1, Sequences.getSize(lst), gl), Lit1) ? CCIDScheme.groupList(CCIDScheme.slice(lst, gl, Sequences.getSize(lst)), gl) : LList.Empty}) : Boolean.FALSE;
    }

    /*
     * Exception decompiling
     */
    public static Object filter(Object predicate, Object lst) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object assocEX(Object n, Object l) {
        Object object2;
        if (!lists.isList(l)) {
            object2 = Boolean.FALSE;
            return object2;
        }
        Object r = lists.assoc(n, CCIDScheme.filter(lists.list$Qu, l));
        if (!KawaConvert.isTrue(r)) {
            object2 = Boolean.FALSE;
            return object2;
        }
        Object object22 = Promise.force(r, Pair.class);
        try {
            object2 = lists.cdr((Pair)object22);
            return object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object22);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object listXor(Object l) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static CharSequence toHexStr(Object object2) {
        return CCIDScheme.toHexStr(object2, Lit16);
    }

    public static CharSequence toHexStr(Object number, Object len) {
        CharSequence s;
        CharSequence charSequence;
        Object object2 = Promise.force(number, Number.class);
        try {
            s = numbers.number$To$String((Number)object2, 16);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, object2);
        }
        if (NumberCompare.$Gr(strings.stringLength(s), len)) {
            charSequence = s;
        } else {
            Object[] arrobject = new Object[2];
            object2 = Sequences.getIterator(CCIDScheme.u8vector$To$List(CCIDScheme.makeU8vector(AddOp.apply2(-1, len, strings.stringLength(s)), Lit17)));
            LList lList = LList.Empty;
            Pair pair = null;
            while (object2.hasNext()) {
                Pair pair2;
                Object e = object2.next();
                if (pair == null) {
                    pair2 = new Pair(Char.make(((Number)Promise.force(e)).intValue()), LList.Empty);
                } else {
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
            }
            arrobject[0] = strings.list$To$String(lList);
            arrobject[1] = s;
            charSequence = strings.stringAppend(arrobject);
        }
        return charSequence;
    }

    public static CharSequence toOctStr(Object object2) {
        return CCIDScheme.toOctStr(object2, Lit18);
    }

    public static CharSequence toOctStr(Object number, Object len) {
        CharSequence s;
        CharSequence charSequence;
        Object object2 = Promise.force(number, Number.class);
        try {
            s = numbers.number$To$String((Number)object2, 8);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, object2);
        }
        if (NumberCompare.$Gr(strings.stringLength(s), len)) {
            charSequence = s;
        } else {
            Object[] arrobject = new Object[2];
            object2 = Sequences.getIterator(CCIDScheme.u8vector$To$List(CCIDScheme.makeU8vector(AddOp.apply2(-1, len, strings.stringLength(s)), Lit17)));
            LList lList = LList.Empty;
            Pair pair = null;
            while (object2.hasNext()) {
                Pair pair2;
                Object e = object2.next();
                if (pair == null) {
                    pair2 = new Pair(Char.make(((Number)Promise.force(e)).intValue()), LList.Empty);
                } else {
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
            }
            arrobject[0] = strings.list$To$String(lList);
            arrobject[1] = s;
            charSequence = strings.stringAppend(arrobject);
        }
        return charSequence;
    }

    public static CharSequence toBinStr(Object object2) {
        return CCIDScheme.toBinStr(object2, Lit7);
    }

    public static CharSequence toBinStr(Object number, Object len) {
        CharSequence s;
        CharSequence charSequence;
        Object object2 = Promise.force(number, Number.class);
        try {
            s = numbers.number$To$String((Number)object2, 2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, object2);
        }
        if (NumberCompare.$Gr(strings.stringLength(s), len)) {
            charSequence = s;
        } else {
            Object[] arrobject = new Object[2];
            object2 = Sequences.getIterator(CCIDScheme.u8vector$To$List(CCIDScheme.makeU8vector(AddOp.apply2(-1, len, strings.stringLength(s)), Lit17)));
            LList lList = LList.Empty;
            Pair pair = null;
            while (object2.hasNext()) {
                Pair pair2;
                Object e = object2.next();
                if (pair == null) {
                    pair2 = new Pair(Char.make(((Number)Promise.force(e)).intValue()), LList.Empty);
                } else {
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
            }
            arrobject[0] = strings.list$To$String(lList);
            arrobject[1] = s;
            charSequence = strings.stringAppend(arrobject);
        }
        return charSequence;
    }

    public static Object u8list$To$String(Object object2) {
        return CCIDScheme.u8list$To$String(object2, "");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object u8list$To$String(Object _l, Object fixed) {
        if (lists.isNull(_l)) {
            return "";
        }
        Object[] arrobject = new Object[3];
        Object object2 = Promise.force(_l, Pair.class);
        try {
            arrobject[0] = CCIDScheme.toHexStr(lists.car((Pair)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        object2 = Promise.force(_l, Pair.class);
        try {
            arrobject[1] = lists.isNull(lists.cdr((Pair)object2)) ? "" : fixed;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        object2 = Promise.force(_l, Pair.class);
        try {
            arrobject[2] = CCIDScheme.u8list$To$String(lists.cdr((Pair)object2), fixed);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        CharSequence charSequence = strings.stringAppend(arrobject);
        return charSequence;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object isInList(Object n, Object lst) {
        do {
            if (lists.isNull(lst)) {
                v0 = Boolean.FALSE;
                return v0;
            }
            object2 = Promise.force(lst, Pair.class);
            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(n, lists.car((Pair)object2)))) ** break block6
            v0 = n;
            return v0;
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "car", 1, object2);
        }
        {
            
            object2 = Promise.force(lst, Pair.class);
            lst = lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException v2) {
            throw new WrongType(v2, "cdr", 1, object2);
        }
    }

    public static LList byte$To$Bit(Object object2) {
        Object object3 = Lit19;
        LList lList = LList.Empty;
        Pair pair = null;
        while (object3 != LList.Empty) {
            Pair pair2;
            Pair pair3 = (Pair)Promise.force(object3, Pair.class);
            Object object4 = pair3.getCar();
            if (pair == null) {
                pair2 = new Pair(srfi60.bit$Mnset$Qu.apply2(object4, object2), LList.Empty);
            } else {
                pair2 = lList;
                pair.setCdr(lList);
            }
            pair = pair2;
            object3 = pair3.getCdr();
        }
        return lList;
    }

    /*
     * Exception decompiling
     */
    public static Object listRemoveDuplication(Object lst) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static int float$To$Integer(Object f) {
        return ((Number)Promise.force(f)).intValue();
    }

    public static Object stringlst$To$String(Object object2) {
        return CCIDScheme.stringlst$To$String(object2, "");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object stringlst$To$String(Object lst, Object fixed) {
        if (lists.isNull(lst)) {
            return "";
        }
        Object[] arrobject = new Object[3];
        Object object2 = Promise.force(lst, Pair.class);
        try {
            arrobject[0] = lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        object2 = Promise.force(lst, Pair.class);
        try {
            arrobject[1] = lists.isNull(lists.cdr((Pair)object2)) ? "" : fixed;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        object2 = Promise.force(lst, Pair.class);
        try {
            arrobject[2] = CCIDScheme.stringlst$To$String(lists.cdr((Pair)object2), fixed);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        CharSequence charSequence = strings.stringAppend(arrobject);
        return charSequence;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object alist$To$List(Object alst) {
        Object object2;
        if (lists.isNull(alst)) {
            object2 = LList.Empty;
            return object2;
        }
        Object[] arrobject = new Object[2];
        Object object22 = Promise.force(alst, Pair.class);
        try {
            arrobject[0] = lists.car((Pair)object22);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object22);
        }
        object22 = Promise.force(alst, Pair.class);
        try {
            arrobject[1] = CCIDScheme.alist$To$List(lists.cdr((Pair)object22));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object22);
        }
        object2 = append.append$V(arrobject);
        return object2;
    }

    public static Object getConfigurationDescriptor(Object usb_control_in) {
        Object configdescLen = CCIDScheme.buildWordFromlst$V(CCIDScheme.slice(((Procedure)Scheme.applyToArgs).applyN(new Object[]{usb_control_in, Lit20, Lit21, Lit22, Lit1, Lit7}), Lit16, Lit16), new Object[]{Lit3, Lit4});
        return ((Procedure)Scheme.applyToArgs).applyN(new Object[]{usb_control_in, Lit20, Lit21, Lit22, Lit1, configdescLen});
    }

    /*
     * Exception decompiling
     */
    public static CharSequence getStringDescriptor(Object usb_control_in, Object index) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Object getDeviceDescriptor(Object usb_control_in) {
        return ((Procedure)Scheme.applyToArgs).applyN(new Object[]{usb_control_in, Lit20, Lit21, Lit25, Lit1, Lit26});
    }

    static Object lambda5() {
        return CCIDScheme.lambda5(Lit15, Lit1);
    }

    static Object lambda5(Object object2) {
        return CCIDScheme.lambda5(object2, Lit1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Object lambda5(Object arg1, Object arg2) {
        Object object2;
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(arg1, Lit15))) {
            object2 = _current_interface_;
            return object2;
        }
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(arg1, Lit13))) {
            object2 = Values.empty;
            return object2;
        }
        Object[] arrobject = new Object[2];
        arrobject[0] = "interface";
        Object object22 = Promise.force(arg2, Number.class);
        try {
            arrobject[1] = numbers.number$To$String((Number)object22);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, object22);
        }
        object2 = _current_interface_ = misc.string$To$Symbol(strings.stringAppend(arrobject));
        return object2;
    }

    public static Object parseDescriptor(Object d) {
        return CCIDScheme.callWithInputU8vector(CCIDScheme.list$To$U8vector(d), lambda$Fn6);
    }

    static Object lambda6(Object p) {
        public class Frame3
        extends ModuleBody {
            Object p;
            Procedure c;
            final ModuleMethod lambda$Fn8;

            public Frame3() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 5, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:178");
                this.lambda$Fn8 = moduleMethod;
            }

            static Object lambda7(Object A, Object B) {
                return append.append$V(new Object[]{A, LList.list1(B)});
            }

            Object lambda8(Object A, Object B) {
                Object[] arrobject = new Object[2];
                arrobject[0] = A;
                Object[] arrobject2 = new Object[2];
                Object[] arrobject3 = new Object[2];
                arrobject3[0] = "IAD";
                Object object2 = Promise.force(this.c.apply0(), Number.class);
                try {
                    arrobject3[1] = numbers.number$To$String((Number)object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "number->string", 1, object2);
                }
                arrobject2[0] = LList.list1(misc.string$To$Symbol(strings.stringAppend(arrobject3)));
                arrobject2[1] = B;
                arrobject[1] = LList.list1(append.append$V(arrobject2));
                return append.append$V(arrobject);
            }

            /*
             * Exception decompiling
             */
            public Object lambda9loop(Object IAD$Mncontainer, Object counter, Object interface$Mncontainer) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.Method.dump(Method.java:474)
                // org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:87)
                // org.benf.cfr.reader.entities.ClassFile.dumpAsInlineClass(ClassFile.java:1004)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredDefinition.dump(StructuredDefinition.java:45)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:543)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredSwitch.dump(StructuredSwitch.java:41)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:543)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:141)
                // org.benf.cfr.reader.util.output.TypeOverridingDumper.dump(TypeOverridingDumper.java:97)
                // org.benf.cfr.reader.entities.Method.dump(Method.java:493)
                // org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:87)
                // org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1000)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:134)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            static Object lambda10(Object p) {
                public class Frame4
                extends ModuleBody {
                    Object p;

                    public Frame4() {
                    }

                    public Object lambda11read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }

                    public Object lambda12read$Mn2() {
                        return CCIDScheme.buildWordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit16, this.p), new Object[]{CCIDScheme.Lit3, CCIDScheme.Lit4});
                    }
                }
                Frame4 $heapFrame = new Frame4();
                $heapFrame.p = p;
                return CCIDScheme.toList$V(LList.list2(CCIDScheme.Lit29, $heapFrame.lambda11read$Mn1()), new Object[]{LList.list2(CCIDScheme.Lit30, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit31, $heapFrame.lambda12read$Mn2()), LList.list2(CCIDScheme.Lit32, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit33, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit34, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit35, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit36, $heapFrame.lambda12read$Mn2()), LList.list2(CCIDScheme.Lit37, $heapFrame.lambda12read$Mn2()), LList.list2(CCIDScheme.Lit38, $heapFrame.lambda12read$Mn2()), LList.list2(CCIDScheme.Lit39, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit40, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit41, $heapFrame.lambda11read$Mn1()), LList.list2(CCIDScheme.Lit42, $heapFrame.lambda11read$Mn1())});
            }

            static Object lambda13(Object p) {
                public class Frame5
                extends ModuleBody {
                    Object p;

                    public Frame5() {
                    }

                    public Object lambda14read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }
                }
                Frame5 $heapFrame = new Frame5();
                $heapFrame.p = p;
                return CCIDScheme.toList$V(LList.list2(CCIDScheme.Lit29, $heapFrame.lambda14read$Mn1()), new Object[]{LList.list2(CCIDScheme.Lit30, $heapFrame.lambda14read$Mn1()), LList.list2(CCIDScheme.Lit44, CCIDScheme.buildWordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit16, $heapFrame.p), new Object[]{CCIDScheme.Lit3, CCIDScheme.Lit4})), LList.list2(CCIDScheme.Lit45, $heapFrame.lambda14read$Mn1()), LList.list2(CCIDScheme.Lit46, $heapFrame.lambda14read$Mn1()), LList.list2(CCIDScheme.Lit47, $heapFrame.lambda14read$Mn1()), LList.list2(CCIDScheme.Lit48, $heapFrame.lambda14read$Mn1()), LList.list2(CCIDScheme.Lit49, $heapFrame.lambda14read$Mn1())});
            }

            static Object lambda15(Object p) {
                public class Frame6
                extends ModuleBody {
                    Object p;

                    public Frame6() {
                    }

                    public Object lambda16read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }
                }
                Frame6 $heapFrame = new Frame6();
                $heapFrame.p = p;
                return CCIDScheme.toList$V(LList.list2(CCIDScheme.Lit29, $heapFrame.lambda16read$Mn1()), new Object[]{LList.list2(CCIDScheme.Lit30, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit51, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit52, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit53, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit54, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit55, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit56, $heapFrame.lambda16read$Mn1()), LList.list2(CCIDScheme.Lit57, $heapFrame.lambda16read$Mn1())});
            }

            static Object lambda17(Object p) {
                public class Frame7
                extends ModuleBody {
                    Object p;

                    public Frame7() {
                    }

                    public Object lambda18read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }
                }
                Frame7 $heapFrame = new Frame7();
                $heapFrame.p = p;
                Object _tmp = CCIDScheme.toList$V(LList.list2(CCIDScheme.Lit29, $heapFrame.lambda18read$Mn1()), new Object[]{LList.list2(CCIDScheme.Lit30, $heapFrame.lambda18read$Mn1()), LList.list2(CCIDScheme.Lit59, $heapFrame.lambda18read$Mn1()), LList.list2(CCIDScheme.Lit48, $heapFrame.lambda18read$Mn1()), LList.list2(CCIDScheme.Lit60, CCIDScheme.buildWordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit16, $heapFrame.p), new Object[]{CCIDScheme.Lit3, CCIDScheme.Lit4})), LList.list2(CCIDScheme.Lit61, $heapFrame.lambda18read$Mn1())});
                return KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(CCIDScheme.Lit48, _tmp), CCIDScheme.Lit62)) && KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(CCIDScheme.Lit59, _tmp)), CCIDScheme.Lit20), CCIDScheme.Lit20)) ? append.append$V(new Object[]{CCIDScheme.Lit63, _tmp}) : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(CCIDScheme.Lit48, _tmp), CCIDScheme.Lit64)) && KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(CCIDScheme.Lit59, _tmp)), CCIDScheme.Lit20), CCIDScheme.Lit20)) ? append.append$V(new Object[]{CCIDScheme.Lit65, _tmp}) : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(CCIDScheme.Lit48, _tmp), CCIDScheme.Lit64)) && KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(CCIDScheme.Lit59, _tmp)), CCIDScheme.Lit20), CCIDScheme.Lit1)) ? append.append$V(new Object[]{CCIDScheme.Lit66, _tmp}) : append.append$V(new Object[]{CCIDScheme.Lit67, _tmp})));
            }

            static Object lambda19(Object p) {
                public class Frame8
                extends ModuleBody {
                    Object p;

                    public Frame8() {
                    }

                    public Object lambda20read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }

                    public Object lambda21read$Mn2() {
                        return CCIDScheme.buildWordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit16, this.p), new Object[]{CCIDScheme.Lit3, CCIDScheme.Lit4});
                    }

                    public Object lambda22read$Mn4() {
                        return CCIDScheme.buildDwordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit18, this.p), new Object[]{CCIDScheme.Lit3, CCIDScheme.Lit4});
                    }
                }
                Frame8 $heapFrame = new Frame8();
                $heapFrame.p = p;
                return CCIDScheme.toList$V(LList.list2(CCIDScheme.Lit29, $heapFrame.lambda20read$Mn1()), new Object[]{LList.list2(CCIDScheme.Lit30, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit70, $heapFrame.lambda21read$Mn2()), LList.list2(CCIDScheme.Lit71, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit72, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit73, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit74, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit75, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit76, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit77, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit78, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit79, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit80, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit81, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit82, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit83, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit84, $heapFrame.lambda22read$Mn4()), LList.list2(CCIDScheme.Lit85, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit86, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit87, $heapFrame.lambda21read$Mn2()), LList.list2(CCIDScheme.Lit88, $heapFrame.lambda20read$Mn1()), LList.list2(CCIDScheme.Lit89, $heapFrame.lambda20read$Mn1())});
            }

            static Object lambda23(Object p) {
                public class Frame9
                extends ModuleBody {
                    Object p;

                    public Frame9() {
                    }

                    public Object lambda24read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }
                }
                Frame9 $heapFrame = new Frame9();
                $heapFrame.p = p;
                return CCIDScheme.toList$V(LList.list2(CCIDScheme.Lit29, $heapFrame.lambda24read$Mn1()), new Object[]{LList.list2(CCIDScheme.Lit30, $heapFrame.lambda24read$Mn1()), LList.list2(CCIDScheme.Lit91, $heapFrame.lambda24read$Mn1()), LList.list2(CCIDScheme.Lit92, $heapFrame.lambda24read$Mn1()), LList.list2(CCIDScheme.Lit93, $heapFrame.lambda24read$Mn1()), LList.list2(CCIDScheme.Lit94, $heapFrame.lambda24read$Mn1()), LList.list2(CCIDScheme.Lit95, $heapFrame.lambda24read$Mn1()), LList.list2(CCIDScheme.Lit96, $heapFrame.lambda24read$Mn1())});
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

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                if (moduleMethod.selector == 5) {
                    return this.lambda8(object2, object3);
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame3 $heapFrame = new Frame3();
        $heapFrame.p = p;
        Procedure counter = CCIDScheme.makeCounter();
        Procedure interface$Mncontainer = CCIDScheme.makeContainer(lambda$Fn7);
        $heapFrame.c = CCIDScheme.makeCounter();
        Procedure IAD$Mncontainer = CCIDScheme.makeContainer($heapFrame.lambda$Fn8);
        interface$Mncontainer.apply2(Lit13, LList.Empty);
        IAD$Mncontainer.apply2(Lit13, LList.Empty);
        return $heapFrame.lambda9loop(IAD$Mncontainer, counter, interface$Mncontainer);
    }

    public static IntNum getVoltageSupportFromDescriptor(Object desc) {
        Object dwFeatures;
        Object ccid_desc;
        Object object2 = Promise.force(lists.assoc(current_dev_interface.apply0(), desc), Pair.class);
        try {
            object2 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object2)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwFeatures);
        }
        try {
            ccid_desc = lists.cdr((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwFeatures);
        }
        dwFeatures = lists.cadr(lists.assoc(Lit83, ccid_desc));
        Object bVoltageSupport = lists.cadr(lists.assoc(Lit72, ccid_desc));
        return KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit7), Lit7)) ? Lit1 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(bVoltageSupport, Lit2), Lit2)) ? Lit2 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(bVoltageSupport, Lit16), Lit16)) ? Lit16 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(bVoltageSupport, Lit18), Lit18)) ? Lit99 : Lit1)));
    }

    public static Object getBSeq() {
        return CCIDScheme.getBSeq(Lit100);
    }

    public static Object getBSeq(Object op) {
        Object nextseq;
        return KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit100)) ? (_ccid_bSeq_ = NumberCompare.$Gr$Eq(nextseq = AddOp.apply2(1, _ccid_bSeq_, Lit2), Lit25) ? Lit1 : nextseq) : _ccid_bSeq_;
    }

    public static FString getBStatusBErrorErrorName(Object bStatus, Object bError) {
        boolean x;
        boolean x2;
        void bmICCStatus;
        void x3;
        Object object2 = ((Procedure)BitwiseOp.and).apply2(bStatus, Lit99);
        Object bmCommandStatus = ((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(bStatus, Lit101), Lit102);
        Object[] arrobject = new Object[10];
        arrobject[0] = "bmICCStatus=";
        Object object3 = Promise.force(bmICCStatus, Number.class);
        try {
            arrobject[1] = numbers.number$To$String((Number)object3, 10);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, (Object)x3);
        }
        arrobject[2] = " ";
        arrobject[3] = "bmCommandStatus=";
        object3 = Promise.force(bmCommandStatus, Number.class);
        try {
            arrobject[4] = numbers.number$To$String((Number)object3, 10);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, (Object)x3);
        }
        arrobject[5] = " ";
        arrobject[6] = "bError=";
        object3 = Promise.force(bError, Number.class);
        try {
            arrobject[7] = numbers.number$To$String((Number)object3, 16);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, (Object)x3);
        }
        arrobject[8] = " : ";
        arrobject[9] = NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit105) ? "bPowerselect error (not supported)" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit106) ? "parity error on ATR" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "ICC mute (Time out)" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit107) ? "Bad TS in ATR" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit108) ? "Bad TCK in ATR" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit109) ? "Protocol not managed" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit110) ? "ICC class not supported" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit9) ? "Command aborted by control pipe" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit105) ? "bPowerselect error (not supported)" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit106) ? "parity error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit113) ? "XFR_OVERRUN" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "ICC mute (Time out)" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit7) ? "Bad wLevelParameter" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit2) ? "Bad dwLength" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit9) ? "Command aborted by control pipe" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit105) ? "protocol invalid or not supported" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit114) ? "FI - DI pair invalid or not supported" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit90) ? "Invalid TCCKTS parameter" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit115) ? "Guard time not supported" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit116) ? "T=0 WI invalid or not supported / T=1 BWI or CWI invalid or not supported" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit117) ? "Clock stop support requested invalid or not supported" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit118) ? "IFSC size invalid or not supported" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit6) ? "NAD value invalid or not supported" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit9) ? "Command aborted by control pipe" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit113) ? "Protocol not managed" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit9) ? "Command aborted by control pipe" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit106) ? "parity error on ATR" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "ICC mute (Time out)" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit9) ? "Command aborted by control pipe" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit103) ? "No ICC present" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit112) ? "Automatic sequence on-going" : (NumberCompare.$Eq(bmICCStatus, Lit2) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit104) ? "Hardware error" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (((x2 = NumberCompare.$Eq(bmICCStatus, Lit1)) ? x2 : ((x = NumberCompare.$Eq(bmICCStatus, Lit2)) ? x : NumberCompare.$Eq(bmICCStatus, Lit16))) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit111) ? "CMD_SLOT_BUSY" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (NumberCompare.$Eq(bmICCStatus, Lit16) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit58) ? "bSlot does not exist" : (NumberCompare.$Eq(bmICCStatus, Lit1) && NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Eq(bError, Lit1) ? "Command Not Supported" : (NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Gr$Eq(bError, Lit119) && NumberCompare.$Ls$Eq(bError, Lit101) ? "User Defined" : (NumberCompare.$Eq(bmCommandStatus, Lit2) && NumberCompare.$Gr$Eq(bError, Lit2) && NumberCompare.$Ls$Eq(bError, Lit120) ? "Index of not supported / incorrect message parameter" : (NumberCompare.$Eq(bmCommandStatus, Lit2) ? "**Reserved for future use**" : (NumberCompare.$Eq(bmICCStatus, Lit2) ? "An ICC is present and inactive (not activated or shut down by hardware error)" : (NumberCompare.$Eq(bmICCStatus, Lit16) ? "No ICC is present" : "OK / Other")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
        return strings.stringAppend(arrobject);
    }

    public static Object PC_to_RDR_IccPowerOn(Object _bSlot, Object _bPowerSelect) {
        Object bSeq = CCIDScheme.getBSeq(Lit100);
        return append.append$V(new Object[]{LList.list1(Lit121), CCIDScheme.buildDwordInlst$V(Lit1, new Object[]{Lit3, Lit4}), LList.list3(_bSlot, bSeq, _bPowerSelect), CCIDScheme.buildWordInlst$V(Lit1, new Object[]{Lit3, Lit4})});
    }

    public static Object PC_to_RDR_XfrBlock(Object _bSlot, Object _bBWI, Object _wLevelParameter, Object _abData) {
        void dwLength;
        int n = Sequences.getSize(_abData);
        Object bSeq = CCIDScheme.getBSeq(Lit100);
        return append.append$V(new Object[]{LList.list1(Lit122), CCIDScheme.buildDwordInlst$V((int)dwLength, new Object[]{Lit3, Lit4}), LList.list3(_bSlot, bSeq, _bBWI), CCIDScheme.buildWordInlst$V(_wLevelParameter, new Object[]{Lit3, Lit4}), _abData});
    }

    public static Pair RDR_to_PC_DataBlock(Object data) {
        void bError;
        void bMessageType;
        void dwLength;
        void bSeq;
        void bSlot;
        void bChainParameter;
        void bStatus;
        Object object2 = lists.listRef(data, 0);
        Object object3 = CCIDScheme.buildDwordFromlst$V(CCIDScheme.subu8list(data, Lit2, Lit58), new Object[0]);
        Object object4 = lists.listRef(data, 5);
        Object object5 = lists.listRef(data, 6);
        Object object6 = lists.listRef(data, 7);
        Object object7 = lists.listRef(data, 8);
        Object object8 = lists.listRef(data, 9);
        Object abData = CCIDScheme.subu8list(data, Lit114, Sequences.getSize(data));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bSeq, CCIDScheme.getBSeq(Lit123)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSeq not equal");
            throw Special.reachedUnexpected;
        }
        if (!NumberCompare.$Eq(bStatus, Lit1) || !NumberCompare.$Eq(bError, Lit1)) {
            pp.apply1(CCIDScheme.getBStatusBErrorErrorName(bStatus, bError));
        }
        Pair pair = LList.list1(LList.list2(Lit124, bMessageType));
        LList.chain1(LList.chain4(pair, LList.list2(Lit125, dwLength), LList.list2(Lit126, bSlot), LList.list2(Lit127, bStatus), LList.list2(Lit128, bChainParameter)), LList.list2(Lit129, abData));
        return pair;
    }

    public static Object PC_to_RDR_IccPowerOff(Object _bSlot) {
        Object bSeq = CCIDScheme.getBSeq(Lit100);
        return append.append$V(new Object[]{LList.list1(Lit130), CCIDScheme.buildDwordInlst$V(Lit1, new Object[]{Lit3, Lit4}), LList.list2(_bSlot, bSeq), Lit131});
    }

    public static Pair RDR_to_PC_SlotStatus(Object data) {
        void bMessageType;
        void bError;
        void bSlot;
        void bStatus;
        void bSeq;
        Object object2 = lists.listRef(data, 0);
        CCIDScheme.buildDwordFromlst$V(CCIDScheme.subu8list(data, Lit2, Lit58), new Object[0]);
        Object object3 = lists.listRef(data, 5);
        Object object4 = lists.listRef(data, 6);
        Object object5 = lists.listRef(data, 7);
        Object object6 = lists.listRef(data, 8);
        Object bClockStatus = lists.listRef(data, 9);
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bSeq, CCIDScheme.getBSeq(Lit123)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSeq not equal");
            throw Special.reachedUnexpected;
        }
        if (!NumberCompare.$Eq(bStatus, Lit1) || !NumberCompare.$Eq(bError, Lit1)) {
            pp.apply1(CCIDScheme.getBStatusBErrorErrorName(bStatus, bError));
        }
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bClockStatus, Lit1))) {
            pp.apply1("bClockStatus: Clock running");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bClockStatus, Lit2))) {
            pp.apply1("bClockStatus: Clock stopped in state L");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bClockStatus, Lit16))) {
            pp.apply1("bClockStatus: Clock stopped in state H");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bClockStatus, Lit99))) {
            pp.apply1("bClockStatus: Clock stopped in an unknown state");
        } else {
            pp.apply1("bClockStatus: All other values are RFU");
        }
        return LList.list4(LList.list2(Lit124, bMessageType), LList.list2(Lit126, bSlot), LList.list2(Lit127, bStatus), LList.list2(Lit132, bClockStatus));
    }

    public static Object PC_to_RDR_SetParameters(Object _bSlot, Object _bProtocolNum, Object _pps) {
        void dwLength;
        int n = Sequences.getSize(_pps);
        Object bSeq = CCIDScheme.getBSeq(Lit100);
        return append.append$V(new Object[]{LList.list1(Lit133), CCIDScheme.buildDwordInlst$V((int)dwLength, new Object[]{Lit3, Lit4}), LList.list3(_bSlot, bSeq, _bProtocolNum), Lit134, _pps});
    }

    public static Pair RDR_to_PC_Parameters(Object data) {
        void bMessageType;
        void bStatus;
        void bSeq;
        void bError;
        void bProtocolNum;
        void bSlot;
        Object object2 = lists.listRef(data, 0);
        CCIDScheme.buildDwordFromlst$V(CCIDScheme.subu8list(data, Lit2, Lit58), new Object[0]);
        Object object3 = lists.listRef(data, 5);
        Object object4 = lists.listRef(data, 6);
        Object object5 = lists.listRef(data, 7);
        Object object6 = lists.listRef(data, 8);
        Object object7 = lists.listRef(data, 9);
        Object abProtocolDataStructure = CCIDScheme.subu8list(data, Lit114, Sequences.getSize(data));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bSeq, CCIDScheme.getBSeq(Lit123)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSeq not equal");
            throw Special.reachedUnexpected;
        }
        if (!NumberCompare.$Eq(bStatus, Lit1) || !NumberCompare.$Eq(bError, Lit1)) {
            pp.apply1(CCIDScheme.getBStatusBErrorErrorName(bStatus, bError));
        }
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bProtocolNum, Lit1))) {
            pp.apply1("Structure for protocol T=0");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bProtocolNum, Lit2))) {
            pp.apply1("Structure for protocol T=1");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bProtocolNum, Lit20))) {
            pp.apply1("Structure for 2-wire protocol");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bProtocolNum, Lit119))) {
            pp.apply1("Structure for 3-wire protocol");
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bProtocolNum, Lit135))) {
            pp.apply1("Structure for I2C protocol");
        } else {
            pp.apply1("bClockStatus: All other values are RFU");
        }
        return LList.list4(LList.list2(Lit124, bMessageType), LList.list2(Lit126, bSlot), LList.list2(Lit136, bProtocolNum), LList.list2(Lit137, abProtocolDataStructure));
    }

    public static Object PC_to_RDR_Escape(Object _bSlot, Object _abData) {
        void dwLength;
        int n = Sequences.getSize(_abData);
        Object bSeq = CCIDScheme.getBSeq(Lit100);
        return append.append$V(new Object[]{LList.list1(Lit138), CCIDScheme.buildDwordInlst$V((int)dwLength, new Object[]{Lit3, Lit4}), LList.list2(_bSlot, bSeq), Lit131, _abData});
    }

    public static Pair RDR_to_PC_Escape(Object data) {
        void bError;
        void bMessageType;
        void dwLength;
        void bSeq;
        void bSlot;
        void bRFU;
        void bStatus;
        Object object2 = lists.listRef(data, 0);
        Object object3 = CCIDScheme.buildDwordFromlst$V(CCIDScheme.subu8list(data, Lit2, Lit58), new Object[0]);
        Object object4 = lists.listRef(data, 5);
        Object object5 = lists.listRef(data, 6);
        Object object6 = lists.listRef(data, 7);
        Object object7 = lists.listRef(data, 8);
        Object object8 = lists.listRef(data, 9);
        Object abData = CCIDScheme.subu8list(data, Lit114, Sequences.getSize(data));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(bSeq, CCIDScheme.getBSeq(Lit123)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSeq not equal");
            throw Special.reachedUnexpected;
        }
        if (!NumberCompare.$Eq(bStatus, Lit1) || !NumberCompare.$Eq(bError, Lit1)) {
            pp.apply1(CCIDScheme.getBStatusBErrorErrorName(bStatus, bError));
        }
        Pair pair = LList.list1(LList.list2(Lit124, bMessageType));
        LList.chain1(LList.chain4(pair, LList.list2(Lit125, dwLength), LList.list2(Lit126, bSlot), LList.list2(Lit127, bStatus), LList.list2(Lit139, bRFU)), LList.list2(Lit129, abData));
        return pair;
    }

    public static Object PC_to_RDR_GetSlotStatus(Object _bSlot) {
        Object bSeq = CCIDScheme.getBSeq(Lit100);
        return append.append$V(new Object[]{LList.list1(Lit140), CCIDScheme.buildDwordInlst$V(Lit1, new Object[]{Lit3, Lit4}), LList.list2(_bSlot, bSeq), Lit131});
    }

    public static Object parseATR(Object atr) {
        public class Frame10
        extends ModuleBody {
            Object atr;
            final ModuleMethod lambda$Fn15;

            public Frame10() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 6, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:5");
                this.lambda$Fn15 = moduleMethod;
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            Object lambda25(Object p) {
                LList lList;
                Object T0;
                Object port;
                new Frame11().staticLink = this;
                public class Frame11
                extends ModuleBody {
                    Object p;
                    Frame10 staticLink;

                    public Frame11() {
                    }

                    public Object lambda26read$Mn1() {
                        Object object2 = Promise.force(CCIDScheme.readU8s(CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, object2);
                        }
                    }

                    public Object lambda27getAtrInterfaceInside(Object D, IntNum i) {
                        LList Dd;
                        gnu.lists.AbstractSequence abstractSequence;
                        Object newD = Boolean.FALSE;
                        Object[] arrobject = new Object[2];
                        Object[] arrobject2 = new Object[3];
                        arrobject2[0] = KawaConvert.isTrue(lists.listRef(Dd, 2)) ? LList.list2(CCIDScheme.Lit142, this.lambda26read$Mn1()) : Values.empty;
                        Object object2 = arrobject2[1] = KawaConvert.isTrue(lists.listRef(Dd, 1)) ? LList.list2(CCIDScheme.Lit143, this.lambda26read$Mn1()) : Values.empty;
                        if (KawaConvert.isTrue(lists.listRef(Dd, 0))) {
                            newD = this.lambda26read$Mn1();
                            abstractSequence = LList.list2(CCIDScheme.Lit144, newD);
                        } else {
                            abstractSequence = Values.empty;
                        }
                        arrobject2[2] = abstractSequence;
                        Dd = CCIDScheme.byte$To$Bit(D);
                        Object _tmp = CCIDScheme.filter(CCIDScheme.lambda$Fn16, CCIDScheme.toList$V(KawaConvert.isTrue(lists.listRef(Dd, 3)) ? LList.list2(CCIDScheme.Lit141, this.lambda26read$Mn1()) : Values.empty, arrobject2));
                        arrobject[0] = lists.isNull(_tmp) ? LList.Empty : LList.list1(append.append$V(new Object[]{LList.list1(misc.string$To$Symbol(strings.stringAppend("interface", numbers.number$To$String(i)))), _tmp}));
                        arrobject[1] = !KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Boolean.FALSE, newD)) ? this.lambda27getAtrInterfaceInside(newD, IntNum.add(i, 1)) : LList.Empty;
                        return append.append$V(arrobject);
                    }

                    static boolean lambda28(Object x) {
                        return !KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Values.empty, x));
                    }
                }
                Frame11 $heapFrame = new Frame11();
                $heapFrame.p = p;
                Object TS = $heapFrame.lambda26read$Mn1();
                Object _D = T0 = $heapFrame.lambda26read$Mn1();
                Object i = append.append$V(new Object[]{CCIDScheme.Lit50, $heapFrame.lambda27getAtrInterfaceInside(_D, CCIDScheme.Lit2)});
                Object object2 = $heapFrame.p;
                Object _D2 = T0;
                Object K = ((Procedure)DivideOp.remainder).apply2(_D2, CCIDScheme.Lit6);
                Pair h = LList.list2(CCIDScheme.Lit145, CCIDScheme.readU8s(K, port));
                Object TCK = CCIDScheme.readU8s(CCIDScheme.Lit2, $heapFrame.p);
                if (lists.isNull(TCK)) {
                    CCIDScheme.pp.apply1("no TCK");
                } else if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.listXor(CCIDScheme.subu8list(this.atr, CCIDScheme.Lit2, Sequences.getSize(this.atr))), CCIDScheme.Lit1))) {
                    CCIDScheme.pp.apply1("TCK not equal");
                }
                Object[] arrobject = new Object[2];
                arrobject[0] = LList.list4(LList.list2(CCIDScheme.Lit146, TS), LList.list2(CCIDScheme.Lit147, T0), i, h);
                if (lists.isNull(TCK)) {
                    lList = LList.Empty;
                } else {
                    port = Promise.force(TCK, Pair.class);
                    lList = LList.list1(LList.list2(CCIDScheme.Lit148, lists.car((Pair)port)));
                }
                arrobject[1] = lList;
                return append.append$V(arrobject);
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, port);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 6) {
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
                if (moduleMethod.selector == 6) {
                    return this.lambda25(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame10 $heapFrame = new Frame10();
        $heapFrame.atr = atr;
        return CCIDScheme.callWithInputU8vector(CCIDScheme.list$To$U8vector($heapFrame.atr), $heapFrame.lambda$Fn15);
    }

    public static Pair parseAtrTA1(Object ta1) {
        Pair pair;
        Object x = ((Procedure)Scheme.isEqual).apply2(ta1, Lit149);
        if (KawaConvert.isTrue(x) ? KawaConvert.isTrue(x) : KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(ta1, Boolean.FALSE))) {
            pair = Lit150;
        } else {
            void b8_5;
            Object object2 = ((Procedure)BitwiseOp.and).apply2(((Procedure)BitwiseOp.ashift).apply2(ta1, Lit151), Lit118);
            Object b4_1 = ((Procedure)BitwiseOp.and).apply2(ta1, Lit118);
            pair = LList.list3(LList.list2(Lit152, lists.cadr(lists.assoc(b8_5, Lit153))), LList.list2(Lit154, lists.cadr(lists.assoc(b4_1, Lit155))), LList.list2(Lit156, lists.cadr(lists.assoc(b8_5, Lit157))));
        }
        return pair;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getAtrSupportProtocol(Object atr) {
        SimpleSymbol simpleSymbol;
        Object object2;
        Pair pair;
        Iterator iterator;
        Object object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
        try {
            iterator = Sequences.getIterator(lists.cdr((Pair)object3));
            object3 = LList.Empty;
            pair = null;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        while (iterator.hasNext()) {
            Pair pair2;
            Object e = iterator.next();
            object2 = Promise.force(e, Pair.class);
            Object a = lists.assoc(Lit144, lists.cdr((Pair)object2));
            if (pair == null) {
                pair2 = new Pair(KawaConvert.isTrue(a) ? ((Procedure)BitwiseOp.and).apply2(lists.cadr(a), Lit118) : Boolean.FALSE, LList.Empty);
            } else {
                pair2 = object3;
                pair.setCdr(object3);
            }
            pair = pair2;
        }
        Object T = CCIDScheme.listRemoveDuplication(CCIDScheme.filter(lambda$Fn17, object3));
        if (KawaConvert.isTrue(CCIDScheme.isInList(Lit1, T)) && KawaConvert.isTrue(CCIDScheme.isInList(Lit2, T))) {
            simpleSymbol = Lit159;
            return simpleSymbol;
        }
        if (KawaConvert.isTrue(CCIDScheme.isInList(Lit1, T))) {
            simpleSymbol = Lit147;
            return simpleSymbol;
        }
        if (KawaConvert.isTrue(CCIDScheme.isInList(Lit2, T))) {
            simpleSymbol = Lit160;
            return simpleSymbol;
        }
        simpleSymbol = Lit147;
        return simpleSymbol;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    static Object lambda29(Object x) {
        return x;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Pair getAtrTATBForT15(Object atr) {
        SimpleSymbol i;
        Object a;
        Object object9;
        Object object32;
        Object object2;
        Object object3;
        Object object4;
        void ta15;
        Pair pair;
        Iterator iterator = Sequences.getIterator(CCIDScheme.assocEX(Lit158, atr));
        Object object42 = LList.Empty;
        Object object5 = null;
        while (iterator.hasNext()) {
            Pair pair2;
            Object object6;
            object32 = iterator.next();
            a = CCIDScheme.assocEX(Lit144, object32);
            if (KawaConvert.isTrue(a)) {
                block29 : {
                    object2 = Promise.force(a, Pair.class);
                    if (!NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(lists.car((Pair)object2), Lit118), Lit118)) break block29;
                    object2 = Promise.force(object32, Pair.class);
                    object6 = lists.car((Pair)object2);
                }
                object6 = Boolean.FALSE;
            } else {
                object6 = Boolean.FALSE;
            }
            if (object5 == null) {
                pair2 = new Pair(object6, LList.Empty);
            } else {
                pair2 = object42;
                ((Pair)object5).setCdr(object42);
            }
            object5 = pair2;
        }
        Object r = CCIDScheme.filter(lambda$Fn18, object42);
        if (lists.isNull(r)) {
            pair = Lit161;
            return pair;
        }
        object5 = Promise.force(r, Pair.class);
        try {
            object5 = Promise.force(lists.car((Pair)object5), Symbol.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)i);
        }
        try {
            object42 = Sequences.getIterator(strings.string$To$List(misc.symbol$To$String((Symbol)object5)));
            object5 = LList.Empty;
            object32 = null;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol->string", 1, (Object)i);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        while (object42.hasNext()) {
            Pair pair3;
            object9 = object42.next();
            if (object32 == null) {
                pair3 = new Pair(Char.castToCharacter(Promise.force(object9)), LList.Empty);
            } else {
                pair3 = object5;
                ((Pair)object32).setCdr(object5);
            }
            object32 = pair3;
        }
        Object s = object5;
        object5 = Sequences.getIterator(CCIDScheme.subu8list(s, Lit162, ((LList)s).size()));
        object32 = LList.Empty;
        object9 = null;
        while (object5.hasNext()) {
            Pair pair4;
            a = object5.next();
            if (object9 == null) {
                pair4 = new Pair(Char.make(((Number)Promise.force(a)).intValue()), LList.Empty);
            } else {
                pair4 = object32;
                ((Pair)object9).setCdr(object32);
            }
            object9 = pair4;
        }
        Object n = AddOp.apply2(1, numbers.string$To$Number(strings.list$To$String(object32)), Lit2);
        Object[] arrobject = new Object[2];
        arrobject[0] = "interface";
        object32 = Promise.force(n, Number.class);
        try {
            arrobject[1] = numbers.number$To$String((Number)object32);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, (Object)ta15);
        }
        i = misc.string$To$Symbol(strings.stringAppend(arrobject));
        object32 = CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(i, CCIDScheme.assocEX(Lit158, atr)));
        Object tb15 = CCIDScheme.assocEX(Lit142, CCIDScheme.assocEX(i, CCIDScheme.assocEX(Lit158, atr)));
        if (KawaConvert.isTrue(ta15)) {
            a = Promise.force(ta15, Pair.class);
            object3 = lists.car((Pair)a);
        }
        object3 = Boolean.FALSE;
        if (KawaConvert.isTrue(tb15)) {
            a = Promise.force(tb15, Pair.class);
            object4 = lists.car((Pair)a);
        } else {
            object4 = Boolean.FALSE;
        }
        pair = LList.list2(LList.list2(Lit163, object3), LList.list2(Lit164, object4));
        return pair;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, a);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, a);
        }
    }

    static Object lambda30(Object x) {
        return x;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getPps1(Object atr) {
        Object dwDefaultClock;
        Object dwMaxDataRate;
        Boolean bl;
        Pair Fi_Di_fmax;
        Object x;
        Boolean ta;
        Object object2;
        Object object3;
        Object object4 = Promise.force(lists.assoc(current_dev_interface.apply0(), descriptor$Mninfo), Pair.class);
        try {
            object4 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object4)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwMaxDataRate);
        }
        try {
            dwDefaultClock = lists.cadr(lists.assoc(Lit74, lists.cdr((Pair)object4)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwMaxDataRate);
        }
        Object object5 = Promise.force(lists.assoc(current_dev_interface.apply0(), descriptor$Mninfo), Pair.class);
        try {
            object5 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object5)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)Fi_Di_fmax);
        }
        try {
            dwMaxDataRate = lists.cadr(lists.assoc(Lit78, lists.cdr((Pair)object5)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)Fi_Di_fmax);
        }
        Object ta1 = CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr)));
        if (KawaConvert.isTrue(ta1)) {
            Object object6 = Promise.force(ta1, Pair.class);
            object2 = lists.car((Pair)object6);
        }
        object2 = Lit149;
        Fi_Di_fmax = CCIDScheme.parseAtrTA1(object2);
        Object Fi = lists.cadr(lists.assoc(Lit152, Fi_Di_fmax));
        Object Di = lists.cadr(lists.assoc(Lit154, Fi_Di_fmax));
        Object default_baudrate = ((Procedure)DivideOp.quotient).apply2(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(dwDefaultClock, Lit166), Lit2), Lit167);
        Object card_baudrate = ((Procedure)DivideOp.quotient).apply2(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(dwDefaultClock, Lit166), Di), Fi);
        Object _ta = CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr)));
        if (KawaConvert.isTrue(_ta)) {
            Object object7 = Promise.force(_ta, Pair.class);
            object3 = lists.car((Pair)object7);
        } else {
            object3 = ta = Boolean.FALSE;
        }
        if (NumberCompare.$Gr(card_baudrate, default_baudrate) && NumberCompare.$Ls$Eq(card_baudrate, dwMaxDataRate)) {
            x = ((Procedure)Scheme.isEqual).apply2(Boolean.FALSE, Boolean.FALSE);
            if (KawaConvert.isTrue(x) ? KawaConvert.isTrue(x) : KawaConvert.isTrue(CCIDScheme.isInList(card_baudrate, Boolean.FALSE))) {
                bl = ta;
                return bl;
            }
            if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit168, CCIDScheme.assocEX(Lit158, atr))))) {
                Type.NeverReturns neverReturns = exceptions.error("TA2 present -> specific mode: the card is supporting only the baud rate specified in TA1 but reader does not support this value. Reject the card.");
                throw Special.reachedUnexpected;
            }
            bl = Boolean.FALSE;
            return bl;
        }
        if (!KawaConvert.isTrue(ta) || !NumberCompare.$Gr(card_baudrate, AddOp.apply2(1, Lit16, dwMaxDataRate)) || NumberCompare.$Ls$Eq(ta, Lit169)) {
            // empty if block
        }
        bl = Boolean.FALSE;
        return bl;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, Di);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, x);
        }
    }

    public static Object generatePPSExchange(Object atr) {
        Object pps0;
        Object pps2;
        Object _pps1 = CCIDScheme.getPps1(atr);
        Object pps1 = KawaConvert.isTrue(_pps1) ? (KawaConvert.isTrue(CCIDScheme.assocEX("USE-DEFAULT-PPS-EXCHANGE", CCIDScheme.assocEX(Lit170, atr))) ? Lit171 : _pps1) : _pps1;
        Object object2 = Promise.force(CCIDScheme.assocEX(Lit164, CCIDScheme.getAtrTATBForT15(atr)), Pair.class);
        try {
            pps2 = lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, pps0);
        }
        pps0 = ((Procedure)BitwiseOp.ior).apply2(BitOps.ior(BitOps.ior(Lit1, KawaConvert.isTrue(pps2) ? Lit172 : Lit1), KawaConvert.isTrue(pps1) ? Lit6 : Lit1), KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit147)) ? Lit1 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit160)) ? Lit2 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit159)) ? Lit2 : Values.empty)));
        Pair pair = LList.list1(Lit9);
        LList.chain4(pair, pps0, pps1, pps2, Boolean.FALSE);
        Object P = CCIDScheme.filter(lambda$Fn19, pair);
        Object pck = CCIDScheme.listXor(P);
        return append.append$V(new Object[]{P, LList.list1(pck)});
    }

    static Object lambda31(Object x) {
        return x;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getAtrIFSC(Object atr) {
        Object object4;
        Object object9;
        Pair pair;
        Object object2;
        Object object6;
        Object object3;
        block44 : {
            Object object22;
            object6 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
            try {
                object4 = Sequences.getIterator(lists.cdr((Pair)object6));
                object6 = LList.Empty;
                pair = null;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, object6);
            }
            do {
                Iterator iterator;
                Externalizable externalizable;
                Values values;
                Pair pair2;
                LList lList;
                if (object4.hasNext()) {
                    block43 : {
                        Object e = object4.next();
                        Object object8 = Promise.force(e, Pair.class);
                        lists.car((Pair)object8);
                        object8 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(lists.assoc(Lit144, lists.cdr((Pair)object8)))) break block43;
                        object8 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Lit2, ((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(Lit144, lists.cdr((Pair)object8))), Lit118)))) break block43;
                        object22 = Promise.force(e, Pair.class);
                        object22 = Promise.force(lists.car((Pair)object22), Symbol.class);
                        iterator = Sequences.getIterator(strings.string$To$List(misc.symbol$To$String((Symbol)object22)));
                        object22 = LList.Empty;
                        lList = null;
                    }
                    externalizable = Values.empty;
                } else {
                    Object object7;
                    Object s;
                    object9 = Sequences.getIterator(CCIDScheme.filter(misc.symbol$Qu, object6));
                    object4 = LList.Empty;
                    object6 = null;
                    break block44;
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object22);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "symbol->string", 1, object22);
                    }
                    while (iterator.hasNext()) {
                        Pair pair3;
                        object7 = iterator.next();
                        if (lList == null) {
                            pair3 = new Pair(Char.castToCharacter(Promise.force(object7)), LList.Empty);
                        } else {
                            pair3 = object22;
                            ((Pair)lList).setCdr(object22);
                        }
                        lList = pair3;
                    }
                    s = object22;
                    object22 = Sequences.getIterator(CCIDScheme.subu8list(s, Lit162, ((LList)s).size()));
                    lList = LList.Empty;
                    object7 = null;
                    while (object22.hasNext()) {
                        Pair pair4;
                        Object e2 = object22.next();
                        if (object7 == null) {
                            pair4 = new Pair(Char.make(((Number)Promise.force(e2)).intValue()), LList.Empty);
                        } else {
                            pair4 = lList;
                            ((Pair)object7).setCdr(lList);
                        }
                        object7 = pair4;
                    }
                    Object n = AddOp.apply2(1, numbers.string$To$Number(strings.list$To$String(lList)), Lit2);
                    if (NumberCompare.$Gr$Eq(n, Lit99)) {
                        Object[] arrobject = new Object[2];
                        arrobject[0] = "interface";
                        object22 = Promise.force(n, Number.class);
                        arrobject[1] = numbers.number$To$String((Number)object22);
                        externalizable = misc.string$To$Symbol(strings.stringAppend(arrobject));
                    } else {
                        externalizable = values = Values.empty;
                    }
                }
                if (pair == null) {
                    pair2 = new Pair(values, LList.Empty);
                } else {
                    pair2 = object6;
                    pair.setCdr(object6);
                }
                pair = pair2;
            } while (true);
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "number->string", 1, object22);
            }
        }
        while (object9.hasNext()) {
            Object object5;
            Pair pair5;
            block45 : {
                pair = (Pair)object9.next();
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                if (!KawaConvert.isTrue(lists.assoc(pair, lists.cdr((Pair)object3)))) break block45;
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                object3 = Promise.force(lists.assoc(pair, lists.cdr((Pair)object3)), Pair.class);
                if (!KawaConvert.isTrue(lists.assoc(Lit141, lists.cdr((Pair)object3)))) break block45;
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                object3 = Promise.force(lists.assoc(pair, lists.cdr((Pair)object3)), Pair.class);
                object5 = lists.cadr(lists.assoc(Lit141, lists.cdr((Pair)object3)));
            }
            object5 = Values.empty;
            if (object6 == null) {
                pair5 = new Pair(object5, LList.Empty);
            } else {
                pair5 = object4;
                ((Pair)object6).setCdr(object4);
            }
            object6 = pair5;
        }
        Object ret = CCIDScheme.filter(numbers.number$Qu, object4);
        if (lists.isNull(ret)) {
            object2 = Lit172;
            return object2;
        }
        object9 = Promise.force(ret, Pair.class);
        try {
            object2 = lists.car((Pair)object9);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object9);
        }
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getAtrTCForT1(Object atr) {
        Object object4;
        Object object9;
        Pair pair;
        Object object2;
        Object object6;
        Object object3;
        block44 : {
            Object object22;
            object6 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
            try {
                object4 = Sequences.getIterator(lists.cdr((Pair)object6));
                object6 = LList.Empty;
                pair = null;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, object6);
            }
            do {
                Iterator iterator;
                Externalizable externalizable;
                Values values;
                Pair pair2;
                LList lList;
                if (object4.hasNext()) {
                    block43 : {
                        Object e = object4.next();
                        Object object8 = Promise.force(e, Pair.class);
                        lists.car((Pair)object8);
                        object8 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(lists.assoc(Lit144, lists.cdr((Pair)object8)))) break block43;
                        object8 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Lit2, ((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(Lit144, lists.cdr((Pair)object8))), Lit118)))) break block43;
                        object22 = Promise.force(e, Pair.class);
                        object22 = Promise.force(lists.car((Pair)object22), Symbol.class);
                        iterator = Sequences.getIterator(strings.string$To$List(misc.symbol$To$String((Symbol)object22)));
                        object22 = LList.Empty;
                        lList = null;
                    }
                    externalizable = Values.empty;
                } else {
                    Object object7;
                    Object s;
                    object9 = Sequences.getIterator(CCIDScheme.filter(misc.symbol$Qu, object6));
                    object4 = LList.Empty;
                    object6 = null;
                    break block44;
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object22);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "symbol->string", 1, object22);
                    }
                    while (iterator.hasNext()) {
                        Pair pair3;
                        object7 = iterator.next();
                        if (lList == null) {
                            pair3 = new Pair(Char.castToCharacter(Promise.force(object7)), LList.Empty);
                        } else {
                            pair3 = object22;
                            ((Pair)lList).setCdr(object22);
                        }
                        lList = pair3;
                    }
                    s = object22;
                    object22 = Sequences.getIterator(CCIDScheme.subu8list(s, Lit162, ((LList)s).size()));
                    lList = LList.Empty;
                    object7 = null;
                    while (object22.hasNext()) {
                        Pair pair4;
                        Object e2 = object22.next();
                        if (object7 == null) {
                            pair4 = new Pair(Char.make(((Number)Promise.force(e2)).intValue()), LList.Empty);
                        } else {
                            pair4 = lList;
                            ((Pair)object7).setCdr(lList);
                        }
                        object7 = pair4;
                    }
                    Object n = AddOp.apply2(1, numbers.string$To$Number(strings.list$To$String(lList)), Lit2);
                    if (NumberCompare.$Gr$Eq(n, Lit99)) {
                        Object[] arrobject = new Object[2];
                        arrobject[0] = "interface";
                        object22 = Promise.force(n, Number.class);
                        arrobject[1] = numbers.number$To$String((Number)object22);
                        externalizable = misc.string$To$Symbol(strings.stringAppend(arrobject));
                    } else {
                        externalizable = values = Values.empty;
                    }
                }
                if (pair == null) {
                    pair2 = new Pair(values, LList.Empty);
                } else {
                    pair2 = object6;
                    pair.setCdr(object6);
                }
                pair = pair2;
            } while (true);
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "number->string", 1, object22);
            }
        }
        while (object9.hasNext()) {
            Object object5;
            Pair pair5;
            block45 : {
                pair = (Pair)object9.next();
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                if (!KawaConvert.isTrue(lists.assoc(pair, lists.cdr((Pair)object3)))) break block45;
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                object3 = Promise.force(lists.assoc(pair, lists.cdr((Pair)object3)), Pair.class);
                if (!KawaConvert.isTrue(lists.assoc(Lit143, lists.cdr((Pair)object3)))) break block45;
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                object3 = Promise.force(lists.assoc(pair, lists.cdr((Pair)object3)), Pair.class);
                object5 = lists.cadr(lists.assoc(Lit143, lists.cdr((Pair)object3)));
            }
            object5 = Values.empty;
            if (object6 == null) {
                pair5 = new Pair(object5, LList.Empty);
            } else {
                pair5 = object4;
                ((Pair)object6).setCdr(object4);
            }
            object6 = pair5;
        }
        Object ret = CCIDScheme.filter(numbers.number$Qu, object4);
        if (lists.isNull(ret)) {
            object2 = Boolean.FALSE;
            return object2;
        }
        object9 = Promise.force(ret, Pair.class);
        try {
            object2 = lists.car((Pair)object9);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object9);
        }
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getAtrTBForT1(Object atr) {
        Object object4;
        Object object9;
        Pair pair;
        Object object2;
        Object object6;
        Object object3;
        block44 : {
            Object object22;
            object6 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
            try {
                object4 = Sequences.getIterator(lists.cdr((Pair)object6));
                object6 = LList.Empty;
                pair = null;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, object6);
            }
            do {
                Iterator iterator;
                Externalizable externalizable;
                Values values;
                Pair pair2;
                LList lList;
                if (object4.hasNext()) {
                    block43 : {
                        Object e = object4.next();
                        Object object8 = Promise.force(e, Pair.class);
                        lists.car((Pair)object8);
                        object8 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(lists.assoc(Lit144, lists.cdr((Pair)object8)))) break block43;
                        object8 = Promise.force(e, Pair.class);
                        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Lit2, ((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(Lit144, lists.cdr((Pair)object8))), Lit118)))) break block43;
                        object22 = Promise.force(e, Pair.class);
                        object22 = Promise.force(lists.car((Pair)object22), Symbol.class);
                        iterator = Sequences.getIterator(strings.string$To$List(misc.symbol$To$String((Symbol)object22)));
                        object22 = LList.Empty;
                        lList = null;
                    }
                    externalizable = Values.empty;
                } else {
                    Object object7;
                    Object s;
                    object9 = Sequences.getIterator(CCIDScheme.filter(misc.symbol$Qu, object6));
                    object4 = LList.Empty;
                    object6 = null;
                    break block44;
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, s);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object22);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "symbol->string", 1, object22);
                    }
                    while (iterator.hasNext()) {
                        Pair pair3;
                        object7 = iterator.next();
                        if (lList == null) {
                            pair3 = new Pair(Char.castToCharacter(Promise.force(object7)), LList.Empty);
                        } else {
                            pair3 = object22;
                            ((Pair)lList).setCdr(object22);
                        }
                        lList = pair3;
                    }
                    s = object22;
                    object22 = Sequences.getIterator(CCIDScheme.subu8list(s, Lit162, ((LList)s).size()));
                    lList = LList.Empty;
                    object7 = null;
                    while (object22.hasNext()) {
                        Pair pair4;
                        Object e2 = object22.next();
                        if (object7 == null) {
                            pair4 = new Pair(Char.make(((Number)Promise.force(e2)).intValue()), LList.Empty);
                        } else {
                            pair4 = lList;
                            ((Pair)object7).setCdr(lList);
                        }
                        object7 = pair4;
                    }
                    Object n = AddOp.apply2(1, numbers.string$To$Number(strings.list$To$String(lList)), Lit2);
                    if (NumberCompare.$Gr$Eq(n, Lit99)) {
                        Object[] arrobject = new Object[2];
                        arrobject[0] = "interface";
                        object22 = Promise.force(n, Number.class);
                        arrobject[1] = numbers.number$To$String((Number)object22);
                        externalizable = misc.string$To$Symbol(strings.stringAppend(arrobject));
                    } else {
                        externalizable = values = Values.empty;
                    }
                }
                if (pair == null) {
                    pair2 = new Pair(values, LList.Empty);
                } else {
                    pair2 = object6;
                    pair.setCdr(object6);
                }
                pair = pair2;
            } while (true);
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "number->string", 1, object22);
            }
        }
        while (object9.hasNext()) {
            Object object5;
            Pair pair5;
            block45 : {
                pair = (Pair)object9.next();
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                if (!KawaConvert.isTrue(lists.assoc(pair, lists.cdr((Pair)object3)))) break block45;
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                object3 = Promise.force(lists.assoc(pair, lists.cdr((Pair)object3)), Pair.class);
                if (!KawaConvert.isTrue(lists.assoc(Lit142, lists.cdr((Pair)object3)))) break block45;
                object3 = Promise.force(lists.assoc(Lit158, atr), Pair.class);
                object3 = Promise.force(lists.assoc(pair, lists.cdr((Pair)object3)), Pair.class);
                object5 = lists.cadr(lists.assoc(Lit142, lists.cdr((Pair)object3)));
            }
            object5 = Values.empty;
            if (object6 == null) {
                pair5 = new Pair(object5, LList.Empty);
            } else {
                pair5 = object4;
                ((Pair)object6).setCdr(object4);
            }
            object6 = pair5;
        }
        Object ret = CCIDScheme.filter(numbers.number$Qu, object4);
        if (lists.isNull(ret)) {
            object2 = Boolean.FALSE;
            return object2;
        }
        object9 = Promise.force(ret, Pair.class);
        try {
            object2 = lists.car((Pair)object9);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object9);
        }
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Pair generatePPSParametersT1(Object atr) {
        Object object2;
        Object pps = CCIDScheme.generatePPSExchange(atr);
        IntNum bmFindexDindex = KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.listRef(pps, 1), Lit6), Lit6)) ? lists.listRef(pps, 2) : Lit171;
        Object Tc = CCIDScheme.getAtrTCForT1(atr);
        IntNum bmTCCKST1 = BitOps.ior(BitOps.ior(Lit6, KawaConvert.isTrue(Tc) ? (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(Tc, Lit2), Lit2)) ? Lit16 : Lit1) : Lit1), KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.cadr(lists.assoc(Lit146, atr)), Lit173)) ? Lit1 : Lit2);
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object3 = Promise.force(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object2 = lists.car((Pair)object3);
        } else {
            object2 = Lit1;
        }
        IntNum bGuardTimeT1 = object2;
        Object bmWaitingIntegersT1 = KawaConvert.isTrue(CCIDScheme.getAtrTBForT1(atr)) ? CCIDScheme.getAtrTBForT1(atr) : Lit174;
        Object bIFSC = CCIDScheme.getAtrIFSC(atr);
        Pair pair = LList.list1(bmFindexDindex);
        LList.chain1(LList.chain1(LList.chain4(pair, bmTCCKST1, bGuardTimeT1, bmWaitingIntegersT1, Lit1), bIFSC), Lit1);
        return pair;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, bmWaitingIntegersT1);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Pair generatePPSParametersT0(Object atr) {
        Object object2;
        IntNum bGuardTimeT0;
        Object object3;
        Object object4;
        Object pps = CCIDScheme.generatePPSExchange(atr);
        IntNum bmFindexDindex = KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.listRef(pps, 1), Lit6), Lit6)) ? lists.listRef(pps, 2) : Lit171;
        IntNum bmTCCKST0 = BitOps.ior(Lit1, KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.cadr(lists.assoc(Lit146, atr)), Lit173)) ? Lit1 : Lit16);
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object5 = Promise.force(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object3 = lists.car((Pair)object5);
        }
        object3 = bGuardTimeT0 = Lit1;
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit168, CCIDScheme.assocEX(Lit158, atr))))) {
            object2 = Promise.force(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit168, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object4 = lists.car((Pair)object2);
        } else {
            object4 = Lit114;
        }
        IntNum bmWaitingIntegersT0 = object4;
        Pair pair = LList.list1(bmFindexDindex);
        LList.chain4(pair, bmTCCKST0, bGuardTimeT0, bmWaitingIntegersT0, Lit1);
        return pair;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)bmWaitingIntegersT0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static IntNum getCardTimeoutT1(Object atr) {
        void x222222222;
        IntNum intNum;
        boolean x;
        Object object2;
        Object object3;
        Object clock_frequency;
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object4 = Promise.force(CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object2 = lists.car((Pair)object4);
        }
        object2 = Boolean.FALSE;
        Pair f_d = CCIDScheme.parseAtrTA1(object2);
        Object f = lists.cadr(lists.assoc(Lit152, f_d));
        Object d = lists.cadr(lists.assoc(Lit154, f_d));
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object5 = Promise.force(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object3 = lists.car((Pair)object5);
        }
        object3 = Lit1;
        IntNum TC1 = object3;
        Object B_C = KawaConvert.isTrue(CCIDScheme.getAtrTBForT1(atr)) ? CCIDScheme.getAtrTBForT1(atr) : Lit174;
        Pair B_C2 = LList.list2(((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(B_C, Lit175), Lit151), ((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(B_C, Lit118), Lit1));
        Object BWI = lists.car(B_C2);
        Object CWI = lists.cadr(B_C2);
        Object object6 = Promise.force(lists.assoc(current_dev_interface.apply0(), descriptor$Mninfo), Pair.class);
        try {
            object6 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object6)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)x222222222);
        }
        try {
            clock_frequency = lists.cadr(lists.assoc(Lit74, lists.cdr((Pair)object6)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)x222222222);
        }
        boolean x222222222 = NumberCompare.$Eq(f, Lit1);
        if (x222222222 ? x222222222 : ((x = NumberCompare.$Eq(d, Lit1)) ? x : NumberCompare.$Eq(clock_frequency, Lit1))) {
            intNum = Lit176;
            return intNum;
        }
        Object etu = ((Procedure)DivideOp.$Sl).apply2(((Procedure)DivideOp.$Sl).apply2(f, d), clock_frequency);
        Object EGT = AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit115, etu), ((Procedure)DivideOp.$Sl).apply2(((Procedure)MultiplyOp.$St).apply2(((Procedure)DivideOp.$Sl).apply2(f, d), TC1), clock_frequency));
        Object BWT = AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit90, etu), ((Procedure)DivideOp.$Sl).apply2(IntNum.times(IntNum.times(IntNum.shift(Lit2, ((Number)Promise.force(BWI)).intValue()), 960), 372), clock_frequency));
        Object CWT = ((Procedure)MultiplyOp.$St).apply2(IntNum.add(IntNum.shift(Lit2, ((Number)Promise.force(CWI)).intValue()), 11), etu);
        intNum = IntNum.make(CCIDScheme.float$To$Integer(((Procedure)MultiplyOp.$St).apply2(AddOp.apply2(1, AddOp.apply2(1, AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit177, EGT), BWT), ((Procedure)MultiplyOp.$St).apply2(Lit177, CWT)), Lit166), Lit178)));
        return intNum;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, f);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)B_C2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static IntNum getCardTimeoutT0(Object atr) {
        void x222222222;
        IntNum intNum;
        boolean x;
        Object clock_frequency;
        Object object2;
        Object object3;
        Object object4;
        IntNum TC1;
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object5 = Promise.force(CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object2 = lists.car((Pair)object5);
        }
        object2 = Boolean.FALSE;
        Pair f_d = CCIDScheme.parseAtrTA1(object2);
        Object f = lists.cadr(lists.assoc(Lit152, f_d));
        Object d = lists.cadr(lists.assoc(Lit154, f_d));
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object6 = Promise.force(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit165, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object3 = lists.car((Pair)object6);
        }
        object3 = TC1 = Lit1;
        if (KawaConvert.isTrue(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit168, CCIDScheme.assocEX(Lit158, atr))))) {
            Object object7 = Promise.force(CCIDScheme.assocEX(Lit143, CCIDScheme.assocEX(Lit168, CCIDScheme.assocEX(Lit158, atr))), Pair.class);
            object4 = lists.car((Pair)object7);
        }
        object4 = Lit114;
        IntNum TC2 = object4;
        Object object8 = Promise.force(lists.assoc(current_dev_interface.apply0(), descriptor$Mninfo), Pair.class);
        try {
            object8 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object8)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)x222222222);
        }
        try {
            clock_frequency = lists.cadr(lists.assoc(Lit74, lists.cdr((Pair)object8)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)x222222222);
        }
        boolean x222222222 = NumberCompare.$Eq(f, Lit1);
        if (x222222222 ? x222222222 : ((x = NumberCompare.$Eq(d, Lit1)) ? x : NumberCompare.$Eq(clock_frequency, Lit1))) {
            intNum = Lit176;
            return intNum;
        }
        Object EGT = AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit115, ((Procedure)DivideOp.$Sl).apply2(((Procedure)DivideOp.$Sl).apply2(f, d), clock_frequency)), ((Procedure)DivideOp.$Sl).apply2(((Procedure)MultiplyOp.$St).apply2(((Procedure)DivideOp.$Sl).apply2(f, d), TC1), clock_frequency));
        Object WWT = ((Procedure)DivideOp.$Sl).apply2(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(Lit179, TC2), f), clock_frequency);
        Object t_in = AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit180, EGT), ((Procedure)MultiplyOp.$St).apply2(Lit21, WWT));
        Object t_out = AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit58, EGT), ((Procedure)MultiplyOp.$St).apply2(Lit177, WWT));
        intNum = IntNum.make(CCIDScheme.float$To$Integer(((Procedure)MultiplyOp.$St).apply2(NumberCompare.$Ls(t_in, Lit181) && NumberCompare.$Ls(t_out, Lit181) ? Lit181 : (NumberCompare.$Gr(t_in, t_out) ? t_in : t_out), Lit178)));
        return intNum;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, f);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)TC2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, clock_frequency);
        }
    }

    public static IntNum getCardTimeout(Object atr) {
        return KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit147)) ? Lit1 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit160)) ? Lit2 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit159)) ? Lit2 : Values.empty)), Lit1)) ? CCIDScheme.getCardTimeoutT0(atr) : CCIDScheme.getCardTimeoutT1(atr);
    }

    public static Object parseT1Block(Object object2) {
        return CCIDScheme.parseT1Block(object2, Boolean.TRUE);
    }

    public static Object parseT1Block(Object data, Object _debug) {
        Object NAD;
        Object object2;
        public class Frame12
        extends ModuleBody {
            Object info;

            public void lambda32setinfo$V(Object arg1, Object[] argsArray) {
                LList lList;
                LList arg2s = lList = LList.makeList(argsArray, 0);
                this.info = CCIDScheme.stringlst$To$String(lists.cons(this.info, lists.cons(arg1, arg2s)));
            }
        }
        Frame12 $heapFrame = new Frame12();
        $heapFrame.info = "";
        $heapFrame.lambda32setinfo$V("**********************************\n", new Object[0]);
        $heapFrame.lambda32setinfo$V("Data: ", new Object[]{CCIDScheme.u8list$To$String(data, "-"), "\n"});
        Object PF = CCIDScheme.slice(data, Lit1, Lit99);
        $heapFrame.lambda32setinfo$V("Prologue field: ", new Object[]{CCIDScheme.u8list$To$String(PF), "\n"});
        Object object3 = Promise.force(PF, Pair.class);
        try {
            NAD = lists.car((Pair)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object3);
        }
        $heapFrame.lambda32setinfo$V("    ", new Object[]{"NAD: ", CCIDScheme.toHexStr(NAD), "H", "\n"});
        $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "SAD: ", CCIDScheme.toBinStr(((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(NAD, Lit111), Lit182), Lit99), "B", "\n"});
        $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "DAD: ", CCIDScheme.toBinStr(((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(NAD, Lit183), Lit184), Lit99), "B", "\n"});
        Object PCB = lists.cadr(PF);
        $heapFrame.lambda32setinfo$V("    ", new Object[]{"PCB: ", CCIDScheme.toHexStr(PCB), "H", "\n"});
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit101), Lit101))) {
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "tpye: S-block\n"});
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "b6~1: ", CCIDScheme.toBinStr(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit21), "  ", KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit1)) ? "RESYNCH request" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit172)) ? "RESYNCH response" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit2)) ? "IFS request" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit68)) ? "IFS response" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit16)) ? "ABORT requset" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit186)) ? "ABORT response" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit99)) ? "WTX requset" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit185), Lit187)) ? "WTX response" : "reserved for future use"))))))), "\n"});
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit101), Lit20))) {
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "tpye: R-block\n"});
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "bit6~1: "});
            $heapFrame.lambda32setinfo$V("0-(", new Object[]{CCIDScheme.toBinStr(((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit6), Lit151), Lit2), ")-"});
            $heapFrame.lambda32setinfo$V(CCIDScheme.toBinStr(((Procedure)BitwiseOp.and).apply2(PCB, Lit118), Lit18), new Object[0]);
            $heapFrame.lambda32setinfo$V("  =>  ", new Object[]{KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit118), Lit1)) ? "an error-free acknowledgement" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit118), Lit2)) ? "a redundancy code error or a character parity error" : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit118), Lit16)) ? "other errors" : Values.empty)), "\n"});
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit20), Lit1))) {
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "tpye: I-block\n"});
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "N(S): ", CCIDScheme.toBinStr(((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit188), Lit102), Lit2), "\n"});
            $heapFrame.lambda32setinfo$V("    ", new Object[]{"    ", "M-bit: ", CCIDScheme.toBinStr(((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(PCB, Lit172), Lit182), Lit2), "\n"});
        }
        Object LEN = lists.caddr(PF);
        $heapFrame.lambda32setinfo$V("    ", new Object[]{"LEN: ", CCIDScheme.toHexStr(LEN), "H", "\n"});
        Object IF = CCIDScheme.slice(data, Lit99, Sequences.getSize(data) - 4);
        $heapFrame.lambda32setinfo$V("Information field: (", new Object[]{CCIDScheme.toHexStr(Sequences.getSize(IF)), ")\n"});
        LEN = Sequences.getIterator(CCIDScheme.groupList(IF, Lit6));
        object3 = LList.Empty;
        Pair pair = null;
        while (LEN.hasNext()) {
            Pair pair2;
            Object e = LEN.next();
            $heapFrame.lambda32setinfo$V("    ", new Object[]{CCIDScheme.u8list$To$String(e, " "), "\n"});
            if (pair == null) {
                pair2 = new Pair(Values.empty, LList.Empty);
            } else {
                pair2 = object3;
                pair.setCdr(object3);
            }
            pair = pair2;
        }
        Object EF = lists.listRef(data, Sequences.getSize(data) - 1);
        $heapFrame.lambda32setinfo$V("Epilogue field: ", new Object[]{CCIDScheme.toHexStr(EF), "\n"});
        $heapFrame.lambda32setinfo$V("    ", new Object[]{"LRC: ", CCIDScheme.toHexStr(CCIDScheme.listXor(CCIDScheme.slice(data, Lit1, Sequences.getSize(data) - 1))), "\n"});
        $heapFrame.lambda32setinfo$V("**********************************\n", new Object[0]);
        if (KawaConvert.isTrue(_debug)) {
            pp.apply1($heapFrame.info);
        }
        if (NumberCompare.$Eq(Lit1, CCIDScheme.listXor(data))) {
            PF = CCIDScheme.slice(data, Lit1, Lit99);
            Object IF2 = CCIDScheme.slice(data, Lit99, Sequences.getSize(data) - 4);
            lists.listRef(data, Sequences.getSize(data) - 1);
            object2 = NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit101), Lit101) ? LList.list3(Lit189, LList.list2(Lit190, KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit1)) ? Lit191 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit172)) ? Lit192 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit2)) ? Lit193 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit68)) ? Lit194 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit16)) ? Lit195 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit186)) ? Lit196 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit99)) ? Lit197 : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit185), Lit187)) ? Lit198 : Lit199)))))))), LList.list2(Lit200, IF2)) : (NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit101), Lit20) ? LList.list4(Lit201, LList.list2(Lit202, ((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit6), Lit151)), LList.list2(Lit203, ((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit118)), LList.list2(Lit200, IF2)) : (NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit20), Lit1) ? LList.list4(Lit204, LList.list2(Lit205, ((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit188), Lit102)), LList.list2(Lit206, ((Procedure)BitwiseOp.ashift).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(PF), Lit172), Lit182)), LList.list2(Lit200, IF2)) : Values.empty));
        } else {
            object2 = pp.apply1("LRC error");
        }
        return object2;
    }

    public static Object generateSBlockTPDUT1(Object cmd, Object data) {
        IntNum intNum;
        void PCB;
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit191))) {
            intNum = Lit101;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit192))) {
            intNum = Lit111;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit193))) {
            intNum = Lit207;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit194))) {
            intNum = Lit208;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit209))) {
            intNum = Lit210;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit196))) {
            intNum = Lit211;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit212))) {
            intNum = Lit213;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(cmd, Lit198))) {
            intNum = Lit214;
        } else {
            Type.NeverReturns neverReturns = exceptions.error("cmd not right!!!");
            throw Special.reachedUnexpected;
        }
        IntNum intNum2 = intNum;
        int LEN = Sequences.getSize(data);
        Object _t = append.append$V(new Object[]{LList.list3(Lit1, PCB, LEN), data});
        return append.append$V(new Object[]{_t, LList.list1(CCIDScheme.listXor(_t))});
    }

    public static Object generateIBlockTPDUT1(Object N_S, Object M$Mnbit, Object data) {
        Pair pf = LList.list3(Lit1, ((Procedure)BitwiseOp.xor).apply2(((Procedure)BitwiseOp.xor).apply2(Lit1, ((Procedure)BitwiseOp.ashift).apply2(N_S, Lit21)), ((Procedure)BitwiseOp.ashift).apply2(M$Mnbit, Lit58)), Sequences.getSize(data));
        Object pf_if = append.append$V(new Object[]{pf, data});
        return append.append$V(new Object[]{pf_if, LList.list1(CCIDScheme.listXor(pf_if))});
    }

    public static Object generateRBlockTPDUT1(Object N_R, Object op) {
        Pair pf = LList.list3(Lit1, ((Procedure)BitwiseOp.ior).apply2(((Procedure)BitwiseOp.ior).apply2(Lit20, ((Procedure)BitwiseOp.ashift).apply2(N_R, Lit18)), op), Lit1);
        return append.append$V(new Object[]{pf, LList.list1(CCIDScheme.listXor(pf))});
    }

    /*
     * Exception decompiling
     */
    public static Procedure makeGET_DEVICE_INFFunc(Object usb_control_in, Object descriptor$Mninfo) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Object doPPSExchange(Object usb_send_recv, Object slot, Object atr) {
        Object pps = CCIDScheme.generatePPSExchange(atr);
        Pair ret = CCIDScheme.RDR_to_PC_DataBlock(((Procedure)Scheme.applyToArgs).apply2(usb_send_recv, CCIDScheme.PC_to_RDR_XfrBlock(slot, Lit1, Lit1, pps)));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.cadr(lists.assoc(Lit126, ret)), slot))) {
            pp.apply1("slot not equal");
        }
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.cadr(lists.assoc(Lit129, ret)), pps))) {
            pp.apply1("pps not equal should try default");
            Type.NeverReturns neverReturns = exceptions.error("USE-DEFAULT-PPS-EXCHANGE");
            throw Special.reachedUnexpected;
        }
        return lists.cadr(lists.assoc(Lit129, ret));
    }

    public static Object doPPSSetParameters(Object usb_send_recv, Object slot, Object atr) {
        IntNum intNum;
        Pair pair;
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit147))) {
            intNum = Lit1;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit160))) {
            intNum = Lit2;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol(atr), Lit159))) {
            intNum = Lit2;
        } else {
            Type.NeverReturns neverReturns = exceptions.error("do-PPS-set-parameters error 1 should not happend");
            throw Special.reachedUnexpected;
        }
        IntNum protocol = intNum;
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol, Lit1))) {
            pair = CCIDScheme.generatePPSParametersT0(atr);
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol, Lit2))) {
            pair = CCIDScheme.generatePPSParametersT1(atr);
        } else {
            Type.NeverReturns neverReturns = exceptions.error("do-PPS-set-parameters error 2 should not happend");
            throw Special.reachedUnexpected;
        }
        Pair pps$Mnparameters = pair;
        Pair ret = CCIDScheme.RDR_to_PC_Parameters(((Procedure)Scheme.applyToArgs).apply2(usb_send_recv, CCIDScheme.PC_to_RDR_SetParameters(slot, protocol, pps$Mnparameters)));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.cadr(lists.assoc(Lit126, ret)), slot))) {
            pp.apply1("slot not equal");
        }
        return !KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.cadr(lists.assoc(Lit137, ret)), pps$Mnparameters)) ? pp.apply1("abProtocolDataStructure not equal") : lists.cadr(lists.assoc(Lit137, ret));
    }

    public static Object doPPS(Object usb_send_recv, Object slot, Object atr) {
        Object ccid_desc;
        Object dwFeatures;
        Object object2;
        Object object3 = Promise.force(lists.assoc(current_dev_interface.apply0(), descriptor$Mninfo), Pair.class);
        try {
            object3 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object3)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwFeatures);
        }
        try {
            ccid_desc = lists.cdr((Pair)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwFeatures);
        }
        dwFeatures = lists.cadr(lists.assoc(Lit83, ccid_desc));
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit9), Lit229))) {
            pp.apply1("do pps exchange");
            pp.apply1(CCIDScheme.doPPSExchange(usb_send_recv, slot, atr));
            pp.apply1("do pps");
            object2 = CCIDScheme.doPPSSetParameters(usb_send_recv, slot, atr);
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit9), Lit230))) {
            pp.apply1("do not do pps exchange");
            pp.apply1("do pps");
            object2 = CCIDScheme.doPPSSetParameters(usb_send_recv, slot, atr);
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit9), Lit230))) {
            pp.apply1("do not do pps exchange");
            object2 = pp.apply1("do not pps");
        } else if (NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit188), Lit188)) {
            object2 = pp.apply1("do not do pps");
        } else {
            boolean x = NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit20), Lit20);
            if (x ? x : KawaConvert.isTrue(CCIDScheme.assocEX(Lit141, CCIDScheme.assocEX(Lit168, CCIDScheme.assocEX(Lit158, atr))))) {
                pp.apply1("do not do pps exchange");
            } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Lit160, CCIDScheme.getAtrSupportProtocol(atr)))) {
                pp.apply1("do pps exchange but not execute");
            } else {
                pp.apply1("do pps exchange");
                pp.apply1(CCIDScheme.doPPSExchange(usb_send_recv, slot, atr));
            }
            if (NumberCompare.$Eq(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit16), Lit16)) {
                object2 = pp.apply1("do not pps");
            } else {
                pp.apply1("do pps");
                object2 = CCIDScheme.doPPSSetParameters(usb_send_recv, slot, atr);
            }
        }
        return object2;
    }

    public static SimpleSymbol getCcidExchangeLevel(Object desc) {
        SimpleSymbol simpleSymbol;
        Object dwFeatures;
        Object ccid_desc;
        Object object2 = Promise.force(lists.assoc(current_dev_interface.apply0(), desc), Pair.class);
        try {
            object2 = Promise.force(lists.assoc(Lit98, lists.cdr((Pair)object2)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwFeatures);
        }
        try {
            ccid_desc = lists.cdr((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, dwFeatures);
        }
        dwFeatures = lists.cadr(lists.assoc(Lit83, ccid_desc));
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit231), Lit232))) {
            pp.apply1("TPDU level exchanges with CCID");
            simpleSymbol = Lit233;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit231), Lit234))) {
            pp.apply1("Short APDU level exchange with CCID");
            simpleSymbol = Lit235;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(dwFeatures, Lit231), Lit236))) {
            pp.apply1("Short and Extended APDU level exchange with CCID");
            simpleSymbol = Lit237;
        } else {
            pp.apply1("the level of exchange is character");
            simpleSymbol = Lit238;
        }
        return simpleSymbol;
    }

    public static Object doXfrBlockTPDUT0Protocol(Object usb_send, Object usb_recv, Object slot, Object data) {
        Pair ret;
        ((Procedure)Scheme.applyToArgs).apply2(usb_send, CCIDScheme.PC_to_RDR_XfrBlock(slot, Lit1, Lit1, data));
        do {
            if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(Lit126, ret = CCIDScheme.RDR_to_PC_DataBlock(((Procedure)Scheme.applyToArgs).apply1(usb_recv))), LList.list2(Lit126, slot)))) {
                Type.NeverReturns neverReturns = exceptions.error("bSlot not equal");
                throw Special.reachedUnexpected;
            }
            if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(Lit125, ret), LList.list2(Lit125, Sequences.getSize(lists.cadr(lists.assoc(Lit129, ret))))))) continue;
            Type.NeverReturns neverReturns = exceptions.error("dwLength not equal");
            throw Special.reachedUnexpected;
        } while (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(Lit127, ret)), Lit20), Lit20)));
        return lists.cadr(lists.assoc(Lit129, ret));
    }

    /*
     * Exception decompiling
     */
    public static Object doXfrBlockAPDUExtendedProtocol(Object usb_send, Object usb_recv, Object slot, Object data) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    static Object lambda36(Object object2) {
        return CCIDScheme.lambda36(object2, Lit1);
    }

    static Object lambda36(Object op, Object arg1) {
        Object object2;
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit244))) {
            ns = Lit1;
            object2 = Values.empty;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit15))) {
            Object ns_tmp = ns;
            ns = ((Procedure)DivideOp.remainder).apply2(AddOp.apply2(1, ns, Lit2), Lit16);
            object2 = ns_tmp;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit13))) {
            ns = arg1;
            object2 = Values.empty;
        } else {
            object2 = Values.empty;
        }
        return object2;
    }

    static Object lambda37(Object object2) {
        return CCIDScheme.lambda37(object2, Lit1);
    }

    static Object lambda37(Object op, Object arg1) {
        Object object2;
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit244))) {
            nr = Lit1;
            object2 = Values.empty;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit15))) {
            Object nr_tmp = nr;
            nr = ((Procedure)DivideOp.remainder).apply2(AddOp.apply2(1, nr, Lit2), Lit16);
            object2 = nr_tmp;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(op, Lit13))) {
            nr = arg1;
            object2 = Values.empty;
        } else {
            object2 = Values.empty;
        }
        return object2;
    }

    public static Object IFSRequestTPDUT1(Object usb_send, Object usb_recv, Object slot, Object atr) {
        Object object2;
        T1$MnTPDU$MnIblock$MnN_S.apply1(Lit244);
        T1$MnTPDU$MnRblock$MnN_R.apply1(Lit244);
        ((Procedure)Scheme.applyToArgs).apply2(usb_send, CCIDScheme.PC_to_RDR_XfrBlock(slot, Lit1, Lit1, CCIDScheme.generateSBlockTPDUT1(Lit193, LList.list1(CCIDScheme.getAtrIFSC(atr)))));
        Pair ret = CCIDScheme.RDR_to_PC_DataBlock(((Procedure)Scheme.applyToArgs).apply1(usb_recv));
        Object abData = lists.cadr(lists.assoc(Lit129, ret));
        if (!lists.isNull(abData)) {
            object2 = CCIDScheme.parseT1Block(abData, CCID$MnDEBUG.apply0());
        } else {
            Object sd_ = CCIDScheme.generateRBlockTPDUT1(Lit1, Lit16);
            ((Procedure)Scheme.applyToArgs).apply2(usb_send, CCIDScheme.PC_to_RDR_XfrBlock(slot, Lit1, Lit1, sd_));
            Pair ret_ = CCIDScheme.RDR_to_PC_DataBlock(((Procedure)Scheme.applyToArgs).apply1(usb_recv));
            Object abData_ = lists.cadr(lists.assoc(Lit129, ret_));
            object2 = lists.isNull(abData_) ? pp.apply1("error!!!!!! abData null!!!") : CCIDScheme.parseT1Block(abData_, CCID$MnDEBUG.apply0());
        }
        return object2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object doXfrBlockTPDUT1Protocol(Object usb_send, Object usb_recv, Object slot, Object data, Object atr) {
        Comparable<Boolean> ret;
        Object object5;
        Object object2;
        Object sds;
        Object retBlock;
        Object object3;
        IntNum intNum;
        public class Frame14
        extends ModuleBody {
            Object usb_recv;
            Object slot;
            Object usb_send;

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public Object lambda38loop2(Object _rB_) {
                block15 : {
                    block14 : {
                        block13 : {
                            do {
                                var2_2 = Promise.force(_rB_, Pair.class);
                                if (KawaConvert.isTrue(Scheme.isEqual.apply2(CCIDScheme.Lit204, lists.car((Pair)var2_2)))) break block13;
                                var2_2 = Promise.force(_rB_, Pair.class);
                                ** try [egrp 1[TRYBLOCK] [1 : 43->46)] { 
lbl7: // 1 sources:
                                if (!KawaConvert.isTrue(Scheme.isEqual.apply2(CCIDScheme.Lit189, lists.car((Pair)var2_2))) || !KawaConvert.isTrue(Scheme.isEqual.apply2(CCIDScheme.Lit246, lists.cadr(_rB_)))) break;
                                _ret_ = Boolean.FALSE;
                                var3_3 = Promise.force(_rB_, Pair.class);
                                Scheme.applyToArgs.apply2(this.usb_send, CCIDScheme.PC_to_RDR_XfrBlock(this.slot, CCIDScheme.Lit1, CCIDScheme.Lit1, CCIDScheme.generateSBlockTPDUT1(CCIDScheme.Lit198, lists.cadr(lists.assoc(CCIDScheme.Lit200, lists.cdr((Pair)var3_3))))));
                                _ret_ = CCIDScheme.RDR_to_PC_DataBlock(Scheme.applyToArgs.apply1(this.usb_recv));
                                if (lists.isNull(lists.cadr(lists.assoc(CCIDScheme.Lit129, _ret_)))) {
                                    v0 = exceptions.error(new Object[]{"this is error:2"});
                                    throw Special.reachedUnexpected;
                                }
                                _rB_ = CCIDScheme.parseT1Block(lists.cadr(lists.assoc(CCIDScheme.Lit129, _ret_)), CCIDScheme.CCID$MnDEBUG.apply0());
                            } while (true);
                            v1 = exceptions.error(new Object[]{"the result should be I-block"});
                            throw Special.reachedUnexpected;
                        }
                        v2 = new Object[2];
                        _ret_ = Promise.force(_rB_, Pair.class);
                        try {
                            v2[0] = lists.cadr(lists.assoc(CCIDScheme.Lit200, lists.cdr((Pair)_ret_)));
                        }
                        catch (ClassCastException v3) {
                            throw new WrongType(v3, "cdr", 1, _ret_);
                        }
                        _ret_ = Promise.force(_rB_, Pair.class);
                        try {
                            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(CCIDScheme.Lit247, lists.assoc(CCIDScheme.Lit206, lists.cdr((Pair)_ret_))))) break block14;
                        }
                        catch (ClassCastException v4) {
                            throw new WrongType(v4, "cdr", 1, _ret_);
                        }
                        CCIDScheme.T1$MnTPDU$MnRblock$MnN_R.apply1(CCIDScheme.Lit15);
                        v5 = LList.Empty;
                        break block15;
                    }
                    _ret_ = Boolean.FALSE;
                    Scheme.applyToArgs.apply2(this.usb_send, CCIDScheme.PC_to_RDR_XfrBlock(this.slot, CCIDScheme.Lit1, CCIDScheme.Lit1, CCIDScheme.generateRBlockTPDUT1(CCIDScheme.T1$MnTPDU$MnRblock$MnN_R.apply1(CCIDScheme.Lit15), CCIDScheme.Lit1)));
                    _ret_ = CCIDScheme.RDR_to_PC_DataBlock(Scheme.applyToArgs.apply1(this.usb_recv));
                    if (lists.isNull(lists.cadr(lists.assoc(CCIDScheme.Lit129, _ret_)))) {
                        v6 = exceptions.error(new Object[]{"this is error:2"});
                        throw Special.reachedUnexpected;
                    }
                    v5 = this.lambda38loop2(CCIDScheme.parseT1Block(lists.cadr(lists.assoc(CCIDScheme.Lit129, _ret_)), CCIDScheme.CCID$MnDEBUG.apply0()));
                }
                v2[1] = v5;
                return append.append$V(v2);
                catch (ClassCastException v7) {
                    throw new WrongType(v7, "car", 1, _ret_);
                }
lbl48: // 1 sources:
                catch (ClassCastException v8) {
                    throw new WrongType(v8, "car", 1, _ret_);
                }
                catch (ClassCastException v9) {
                    throw new WrongType(v9, "cdr", 1, var3_3);
                }
            }
        }
        Frame14 $heapFrame = new Frame14();
        $heapFrame.usb_send = usb_send;
        $heapFrame.usb_recv = usb_recv;
        $heapFrame.slot = slot;
        Object object4 = CCIDScheme.groupList(data, CCIDScheme.getAtrIFSC(atr));
        do {
            if (lists.isNull(sds = object4)) {
                object2 = Values.empty;
                return object2;
            }
            ret = Boolean.FALSE;
            object5 = Promise.force(sds, Pair.class);
            intNum = lists.isNull(lists.cdr((Pair)object5)) ? Lit1 : Lit2;
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, retBlock);
        }
        {
            block19 : {
                Object[] arrobject;
                block18 : {
                    block17 : {
                        object5 = Promise.force(sds, Pair.class);
                        ((Procedure)Scheme.applyToArgs).apply2($heapFrame.usb_send, CCIDScheme.PC_to_RDR_XfrBlock($heapFrame.slot, Lit1, Lit1, CCIDScheme.generateIBlockTPDUT1(T1$MnTPDU$MnIblock$MnN_S.apply1(Lit15), intNum, lists.car((Pair)object5))));
                        ret = CCIDScheme.RDR_to_PC_DataBlock(((Procedure)Scheme.applyToArgs).apply1($heapFrame.usb_recv));
                        if (lists.isNull(lists.cadr(lists.assoc(Lit129, ret)))) {
                            Type.NeverReturns neverReturns = exceptions.error("this is error");
                            throw Special.reachedUnexpected;
                        }
                        retBlock = CCIDScheme.parseT1Block(lists.cadr(lists.assoc(Lit129, ret)), CCID$MnDEBUG.apply0());
                        object3 = Promise.force(sds, Pair.class);
                        if (!lists.isNull(lists.cdr((Pair)object3))) break block17;
                        object2 = $heapFrame.lambda38loop2(retBlock);
                        return object2;
                    }
                    object3 = Promise.force(retBlock, Pair.class);
                    if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Lit201, lists.car((Pair)object3)))) break block18;
                    Type.NeverReturns neverReturns = exceptions.error("this should not happened because send-data not send completely");
                    throw Special.reachedUnexpected;
                }
                object3 = Promise.force(retBlock, Pair.class);
                if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(Lit245, lists.assoc(Lit203, lists.cdr((Pair)object3))))) break block19;
                Object object6 = retBlock;
                if (object6 instanceof Object[]) {
                    arrobject = (Object[])object6;
                } else {
                    Object[] arrobject2 = new Object[1];
                    arrobject = arrobject2;
                    arrobject2[0] = object6;
                }
                Type.NeverReturns neverReturns = exceptions.error(arrobject);
                throw Special.reachedUnexpected;
            }
            object3 = Promise.force(sds, Pair.class);
            object4 = lists.cdr((Pair)object3);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, retBlock);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    static Object lambda39() {
        return CCIDScheme.lambda39(Lit15);
    }

    static Object lambda39(Object arg1) {
        Serializable serializable = KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(arg1, Lit15)) ? (_debug_ ? Boolean.TRUE : Boolean.FALSE) : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(arg1, Lit248)) ? ((_debug_ = true) ? Boolean.TRUE : Boolean.FALSE) : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(arg1, Lit249)) ? ((_debug_ = false) ? Boolean.TRUE : Boolean.FALSE) : Values.empty));
        return serializable;
    }

    public static Procedure doInitDescriptorInf(Object usb_control_in) {
        descriptor$Mninfo = append.append$V(new Object[]{CCIDScheme.parseDescriptor(CCIDScheme.getDeviceDescriptor(usb_control_in)), CCIDScheme.parseDescriptor(CCIDScheme.getConfigurationDescriptor(usb_control_in))});
        return CCIDScheme.makeGET_DEVICE_INFFunc(usb_control_in, descriptor$Mninfo);
    }

    public static void doPowerOff(Object object2) {
        CCIDScheme.doPowerOff(object2, Lit1);
    }

    public static void doPowerOff(Object usb_send_recv, Object slot) {
        Pair ret = CCIDScheme.RDR_to_PC_SlotStatus(((Procedure)Scheme.applyToArgs).apply2(usb_send_recv, CCIDScheme.PC_to_RDR_IccPowerOff(slot)));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(Lit126, ret), LList.list2(Lit126, slot)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSlot not equal");
            throw Special.reachedUnexpected;
        }
    }

    public static Pair doPowerOn(Object object2, Object object3) {
        return CCIDScheme.doPowerOn(object2, object3, Lit1, Lit1);
    }

    public static Pair doPowerOn(Object object2, Object object3, Object object4) {
        return CCIDScheme.doPowerOn(object2, object3, object4, Lit1);
    }

    public static Pair doPowerOn(Object usb_send, Object usb_recv, Object index, Object slot) {
        void protocol_c;
        IntNum intNum;
        ModuleMethod moduleMethod;
        public class Frame15
        extends ModuleBody {
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

            public Frame15() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 10, "usb_send_recv", 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:418");
                this.usb_send_recv$Fn24 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 11, null, 8193);
                moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:452");
                this.lambda$Fn25 = moduleMethod2;
                ModuleMethod moduleMethod3 = new ModuleMethod(this, 13, null, 8193);
                moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:455");
                this.lambda$Fn26 = moduleMethod3;
                ModuleMethod moduleMethod4 = new ModuleMethod(this, 15, null, 8193);
                moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:458");
                this.lambda$Fn27 = moduleMethod4;
                ModuleMethod moduleMethod5 = new ModuleMethod(this, 17, null, 8193);
                moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:461");
                this.lambda$Fn28 = moduleMethod5;
            }

            public Object lambda40usb_send_recv(Object data) {
                ((Procedure)Scheme.applyToArgs).apply2(this.usb_send, data);
                return ((Procedure)Scheme.applyToArgs).apply1(this.usb_recv);
            }

            public static Object lambda41doPowerOnInside(Object usb_send_recv, Object slot) {
                Pair ret = CCIDScheme.RDR_to_PC_DataBlock(((Procedure)Scheme.applyToArgs).apply2(usb_send_recv, CCIDScheme.PC_to_RDR_IccPowerOn(slot, CCIDScheme.getVoltageSupportFromDescriptor(CCIDScheme.descriptor$Mninfo))));
                if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(CCIDScheme.Lit126, ret), LList.list2(CCIDScheme.Lit126, slot)))) {
                    Type.NeverReturns neverReturns = exceptions.error("bSlot not equal");
                    throw Special.reachedUnexpected;
                }
                return lists.cadr(lists.assoc(CCIDScheme.Lit129, ret));
            }

            Object lambda42(Object object2) {
                return this.lambda42(object2, CCIDScheme.Lit1);
            }

            Object lambda42(Object data, Object slot) {
                CCIDScheme.current_dev_interface.apply2(CCIDScheme.Lit13, this.index);
                return CCIDScheme.doXfrBlockAPDUExtendedProtocol(this.usb_send, this.usb_recv, slot, data);
            }

            Object lambda43(Object object2) {
                return this.lambda43(object2, CCIDScheme.Lit1);
            }

            Object lambda43(Object data, Object slot) {
                return CCIDScheme.doXfrBlockTPDUT0Protocol(this.usb_send, this.usb_recv, slot, data);
            }

            Object lambda44(Object object2) {
                return this.lambda44(object2, CCIDScheme.Lit1);
            }

            Object lambda44(Object data, Object slot) {
                return CCIDScheme.doXfrBlockTPDUT0Protocol(this.usb_send, this.usb_recv, slot, data);
            }

            Object lambda45(Object object2) {
                return this.lambda45(object2, CCIDScheme.Lit1);
            }

            Object lambda45(Object data, Object slot) {
                if (this._isFirstTime_) {
                    this._isFirstTime_ = false;
                    CCIDScheme.pp.apply1("is first time");
                    CCIDScheme.IFSRequestTPDUT1(this.usb_send, this.usb_recv, slot, this.atr);
                }
                return CCIDScheme.doXfrBlockTPDUT1Protocol(this.usb_send, this.usb_recv, slot, data, this.atr);
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 17: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    case 15: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    case 13: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    case 11: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    case 10: {
                        callContext.value1 = object2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 17: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 15: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 13: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 11: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                }
                return super.match2(moduleMethod, object2, object3, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                switch (moduleMethod.selector) {
                    case 10: {
                        return this.lambda40usb_send_recv(object2);
                    }
                    case 11: {
                        return this.lambda42(object2);
                    }
                    case 13: {
                        return this.lambda43(object2);
                    }
                    case 15: {
                        return this.lambda44(object2);
                    }
                    case 17: {
                        return this.lambda45(object2);
                    }
                }
                return super.apply1(moduleMethod, object2);
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                switch (moduleMethod.selector) {
                    case 11: {
                        return this.lambda42(object2, object3);
                    }
                    case 13: {
                        return this.lambda43(object2, object3);
                    }
                    case 15: {
                        return this.lambda44(object2, object3);
                    }
                    case 17: {
                        return this.lambda45(object2, object3);
                    }
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame15 $heapFrame = new Frame15();
        $heapFrame.usb_send = usb_send;
        $heapFrame.usb_recv = usb_recv;
        $heapFrame.index = index;
        current_dev_interface.apply2(Lit13, $heapFrame.index);
        ModuleMethod usb_send_recv = $heapFrame.usb_send_recv$Fn24;
        Object atr_data = Frame15.lambda41doPowerOnInside($heapFrame.usb_send_recv$Fn24, Lit1);
        $heapFrame.atr = CCIDScheme.parseATR(atr_data);
        $heapFrame._isFirstTime_ = true;
        pp.apply1(strings.stringAppend("ATR: ", CCIDScheme.u8list$To$String(atr_data, " ")));
        USB_TIMEOUT = CCIDScheme.getCardTimeout($heapFrame.atr);
        try {
            CCIDScheme.doPPS($heapFrame.usb_send_recv$Fn24, Lit1, $heapFrame.atr);
        }
        catch (Exception e) {
            pp.apply1("try default pps");
            pp.apply1("power off");
            Pair ret = CCIDScheme.RDR_to_PC_SlotStatus($heapFrame.lambda40usb_send_recv(CCIDScheme.PC_to_RDR_IccPowerOff(Lit1)));
            if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(Lit126, ret), LList.list2(Lit126, Lit1)))) {
                Type.NeverReturns neverReturns = exceptions.error("bSlot not equal");
                throw Special.reachedUnexpected;
            }
            pp.apply1("power on");
            atr_data = Frame15.lambda41doPowerOnInside($heapFrame.usb_send_recv$Fn24, Lit1);
            $heapFrame.atr = CCIDScheme.parseATR(atr_data);
            CCIDScheme.doPPS($heapFrame.usb_send_recv$Fn24, Lit1, append.append$V(new Object[]{$heapFrame.atr, Lit250}));
        }
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol($heapFrame.atr), Lit147))) {
            intNum = Lit1;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol($heapFrame.atr), Lit160))) {
            intNum = Lit2;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(CCIDScheme.getAtrSupportProtocol($heapFrame.atr), Lit159))) {
            intNum = Lit2;
        } else {
            Type.NeverReturns neverReturns = exceptions.error("do-PowerOn error 1 should not happend");
            throw Special.reachedUnexpected;
        }
        IntNum e = intNum;
        SimpleSymbol protocol_r = CCIDScheme.getCcidExchangeLevel(descriptor$Mninfo);
        if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol_r, Lit237))) {
            moduleMethod = $heapFrame.lambda$Fn25;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol_r, Lit235))) {
            moduleMethod = $heapFrame.lambda$Fn26;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol_r, Lit233)) && KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol_c, Lit1))) {
            moduleMethod = $heapFrame.lambda$Fn27;
        } else if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol_r, Lit233)) && KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(protocol_c, Lit2))) {
            moduleMethod = $heapFrame.lambda$Fn28;
        } else {
            Type.NeverReturns neverReturns = exceptions.error("do-PowerOn error 2 should not happend");
            throw Special.reachedUnexpected;
        }
        ModuleMethod xfrBlock = moduleMethod;
        return LList.list2(LList.list2(Lit251, atr_data), LList.list2(Lit252, xfrBlock));
    }

    public static Object doEscape(Object object2, Object object3) {
        return CCIDScheme.doEscape(object2, object3, Lit1);
    }

    public static Object doEscape(Object usb_send_recv, Object data, Object slot) {
        Pair ret = CCIDScheme.RDR_to_PC_Escape(((Procedure)Scheme.applyToArgs).apply2(usb_send_recv, CCIDScheme.PC_to_RDR_Escape(slot, data)));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(Lit126, ret), LList.list2(Lit126, slot)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSlot not equal");
            throw Special.reachedUnexpected;
        }
        return lists.cadr(lists.assoc(Lit129, ret));
    }

    public static Object doSlotStatus(Object object2) {
        return CCIDScheme.doSlotStatus(object2, Lit1);
    }

    public static Object doSlotStatus(Object usb_send_recv, Object slot) {
        Pair ret = CCIDScheme.RDR_to_PC_SlotStatus(((Procedure)Scheme.applyToArgs).apply2(usb_send_recv, CCIDScheme.PC_to_RDR_GetSlotStatus(slot)));
        if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(lists.assoc(Lit126, ret), LList.list2(Lit126, slot)))) {
            Type.NeverReturns neverReturns = exceptions.error("bSlot not equal");
            throw Special.reachedUnexpected;
        }
        return ((Procedure)BitwiseOp.and).apply2(lists.cadr(lists.assoc(Lit127, ret)), Lit99);
    }

    public static void threadSleep$Ex(Object t) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(t, Lit166));
        try {
            Thread.sleep(((Number)object2).longValue());
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Thread.sleep(long)", 1, object2);
        }
    }

    public static 0 makeThread(Object func) {
        public class Frame16
        extends ModuleBody {
            Object func;
        }
        Frame16 $heapFrame = new Frame16();
        $heapFrame.func = func;
        public class Com_ftsafe_CCIDScheme$0
        extends Thread {
            Frame16 this$0;

            public void run() {
                ((Procedure)Scheme.applyToArgs).apply1(this.this$0.func);
            }

            public Com_ftsafe_CCIDScheme$0(Frame16 frame162) {
                this.this$0 = frame162;
            }
        }
        return new Com_ftsafe_CCIDScheme$0($heapFrame);
    }

    public static void threadStart$Ex(Object thread2) {
        ((Thread)Promise.force(thread2, Thread.class)).start();
    }

    public static Type.NeverReturns GET_DEVICES_INF_default$V(Object[] argsArray) {
        Type.NeverReturns neverReturns = exceptions.error("GET_DEVICES_INF not define");
        throw Special.reachedUnexpected;
    }

    static Type.NeverReturns lambda46$V(Object[] argsArray) {
        Type.NeverReturns neverReturns = exceptions.error("USB_CONTROL_IN not define");
        throw Special.reachedUnexpected;
    }

    static Type.NeverReturns lambda47$V(Object[] argsArray) {
        Type.NeverReturns neverReturns = exceptions.error("USB_SEND not define");
        throw Special.reachedUnexpected;
    }

    static Type.NeverReturns lambda48$V(Object[] argsArray) {
        Type.NeverReturns neverReturns = exceptions.error("USB_RECV not define");
        throw Special.reachedUnexpected;
    }

    static Type.NeverReturns lambda49$V(Object[] argsArray) {
        Type.NeverReturns neverReturns = exceptions.error("USB_SEND_RECV not define");
        throw Special.reachedUnexpected;
    }

    static Type.NeverReturns lambda50$V(Object[] argsArray) {
        Type.NeverReturns neverReturns = exceptions.error("USB_INTERRUPT_RECV not define");
        throw Special.reachedUnexpected;
    }

    /*
     * Exception decompiling
     */
    static LList lambda51(frame17 $closureEnv, Object requestType, Object request, Object value, Object index, Object length) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 5 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    static void lambda52(frame17 $closureEnv, Object index, Object data) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    static LList lambda53(frame17 $closureEnv, Object index) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    static Object lambda54(Object index, Object data) {
        USB_SEND.apply2(index, data);
        return USB_RECV.apply1(index);
    }

    /*
     * Exception decompiling
     */
    static LList lambda55(frame17 $closureEnv, Object index) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    static Object lambda56(frame17 $closureEnv, Object obj) {
        return $closureEnv.$this$.showLog(CCIDScheme.object$To$String(obj));
    }

    static Object lambda57(frame19 $closureEnv) {
        do {
            block11 : {
                try {
                    Object object2;
                    Object ret = USB_INTERRUPT_RECV.apply1($closureEnv.index);
                    if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(ret, Lit253))) {
                        object2 = Promise.force(AddOp.apply2(1, DK.CARD_IN_MASK, $closureEnv.index));
                        try {
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "android.os.Handler.obtainMessage(int,java.lang.Object)", 2, object2);
                        }
                        {
                            $closureEnv.staticLink.$this$.mHandler.sendMessage($closureEnv.staticLink.$this$.mHandler.obtainMessage(((Number)object2).intValue(), (Object)""));
                        }
                        break block11;
                    }
                    if (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(ret, Lit254))) {
                        object2 = Promise.force(AddOp.apply2(1, DK.CARD_OUT_MASK, $closureEnv.index));
                        try {
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "android.os.Handler.obtainMessage(int,java.lang.Object)", 2, object2);
                        }
                        {
                            $closureEnv.staticLink.$this$.mHandler.sendMessage($closureEnv.staticLink.$this$.mHandler.obtainMessage(((Number)object2).intValue(), (Object)""));
                        }
                        break block11;
                    }
                    pp.apply1(strings.stringAppend("interrupt read loop error : this should not happend", CCIDScheme.object$To$String(ret)));
                }
                catch (Exception e) {
                    // empty catch block
                }
            }
            CCIDScheme.threadSleep$Ex(Lit2);
        } while (KawaConvert.isTrue($closureEnv.staticLink.$this$.mFTReaderInf.isFtExist()));
        Object[] arrobject = new Object[3];
        arrobject[0] = "slot";
        Object e = Promise.force($closureEnv.index, Number.class);
        try {
            arrobject[1] = numbers.number$To$String((Number)e);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, e);
        }
        arrobject[2] = ":interrupt_read loop exit";
        return pp.apply1(strings.stringAppend(arrobject));
    }

    public static Object lambda58loop(IntNum i) {
        return NumberCompare.$Ls(i, ((Procedure)Scheme.applyToArgs).apply2(GET_DEVICES_INF, Lit228)) ? lists.cons(i, CCIDScheme.lambda58loop(IntNum.add(i, 1))) : LList.Empty;
    }

    static Object lambda59(frame20 $closureEnv, Object data) {
        return USB_SEND.apply2($closureEnv.index, data);
    }

    static Object lambda60(frame20 $closureEnv) {
        return USB_RECV.apply1($closureEnv.index);
    }

    static Object lambda61(frame21 $closureEnv, Object data) {
        return USB_SEND_RECV.apply2($closureEnv.index, data);
    }

    static Object lambda62(frame22 $closureEnv, Object data) {
        return USB_SEND_RECV.apply2($closureEnv.index, data);
    }

    static Object lambda63(frame23 $closureEnv, Object data) {
        return USB_SEND_RECV.apply2($closureEnv.index, data);
    }

    public static {
        Lit7 = IntNum.valueOf(8);
        Lit268 = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("RFU"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274498), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274498), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274497);
        Lit278 = PairWithPosition.make(Lit7, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278549);
        Lit105 = IntNum.valueOf(7);
        Lit277 = PairWithPosition.make(Lit105, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274489);
        Lit167 = IntNum.valueOf(372);
        Lit276 = PairWithPosition.make(Lit167, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253979);
        Lit117 = IntNum.valueOf(14);
        Lit118 = IntNum.valueOf(15);
        Lit275 = PairWithPosition.make(PairWithPosition.make(Lit117, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282669), PairWithPosition.make(PairWithPosition.make(Lit118, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282683), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282683), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282669);
        Lit115 = IntNum.valueOf(12);
        Lit274 = PairWithPosition.make(Lit115, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274461);
        Lit58 = IntNum.valueOf(5);
        Lit6 = IntNum.valueOf(16);
        Lit267 = PairWithPosition.make(Lit6, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 942140);
        Lit273 = PairWithPosition.make(Lit58, Lit267, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274465);
        Lit272 = PairWithPosition.make(Lit7, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270398);
        Lit18 = IntNum.valueOf(4);
        Lit271 = PairWithPosition.make(Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270365);
        Lit270 = PairWithPosition.make(IntNum.valueOf(20), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274485);
        Lit269 = PairWithPosition.make(Lit58, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270376);
        Lit266 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466963);
        Lit2 = IntNum.valueOf(1);
        Lit265 = PairWithPosition.make(Lit2, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 999470);
        Lit16 = IntNum.valueOf(2);
        Lit264 = PairWithPosition.make(Lit16, LList.Empty, "ccid_7816/CCIDScheme.scm", 430130);
        Lit99 = IntNum.valueOf(3);
        Lit263 = PairWithPosition.make(Lit99, LList.Empty, "ccid_7816/CCIDScheme.scm", 421938);
        Lit1 = IntNum.valueOf(0);
        Lit262 = PairWithPosition.make(Lit1, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1380404);
        Lit261 = IntNum.valueOf(80);
        Lit260 = Symbol.valueOf("Thread");
        Lit259 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\u0011\u00184\b\r\u000b", new Object[]{Symbol.valueOf("as"), Lit260, Symbol.valueOf("object"), PairWithPosition.make(Lit260, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm", 40986), PairWithPosition.make(Symbol.valueOf("run"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm", 40996), Symbol.valueOf("::"), Symbol.valueOf("void")}, 1);
        Lit258 = new SyntaxPattern("\f\u0007\r\u000f\b\b\b", new Object[0], 2, "Thread.scm:9");
        Lit257 = Symbol.valueOf("simple-thread");
        Lit256 = Symbol.valueOf("filter");
        Lit255 = ArrayType.make(Type.tostring_type);
        Lit254 = PairWithPosition.make(Lit261, Lit264, "ccid_7816/CCIDScheme.scm", 430124);
        Lit253 = PairWithPosition.make(Lit261, Lit263, "ccid_7816/CCIDScheme.scm", 421932);
        Lit252 = Symbol.valueOf("xfrBlock");
        Lit251 = Symbol.valueOf("atr");
        Lit170 = Symbol.valueOf("optionals");
        Lit250 = PairWithPosition.make(PairWithPosition.make(Lit170, PairWithPosition.make(PairWithPosition.make("USE-DEFAULT-PPS-EXCHANGE", PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802314), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802286), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802286), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802275), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802274);
        Lit249 = Symbol.valueOf("off");
        Lit248 = Symbol.valueOf("on");
        Lit206 = Symbol.valueOf("M-bit");
        Lit247 = PairWithPosition.make(Lit206, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1380397);
        Lit190 = Symbol.valueOf("type");
        Lit197 = Symbol.valueOf("WTX_requset");
        Lit246 = PairWithPosition.make(Lit190, PairWithPosition.make(Lit197, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1331248), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1331242);
        Lit203 = Symbol.valueOf("ERRCode");
        Lit245 = PairWithPosition.make(Lit203, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1441831);
        Lit244 = Symbol.valueOf("reset");
        Lit128 = Symbol.valueOf("bChainParameter");
        Lit243 = PairWithPosition.make(Lit128, Lit263, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1048605);
        Lit242 = PairWithPosition.make(Lit128, Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1028125);
        Lit241 = PairWithPosition.make(Lit128, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 999453);
        Lit240 = PairWithPosition.make(Lit128, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 983069);
        Lit239 = PairWithPosition.make(Lit128, Lit267, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 942123);
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
        Lit92 = Symbol.valueOf("bInterfaceCount");
        Lit220 = PairWithPosition.make(Lit92, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 266320);
        Lit96 = Symbol.valueOf("iFunction");
        Lit219 = PairWithPosition.make(Lit96, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 213066);
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
        Lit161 = PairWithPosition.make(PairWithPosition.make(Lit163, Lit266, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466957), PairWithPosition.make(PairWithPosition.make(Lit164, Lit266, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466966), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466966), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466956);
        Lit160 = Symbol.valueOf("T1");
        Lit159 = Symbol.valueOf("T0_T1");
        Lit158 = Symbol.valueOf("interface");
        Lit21 = IntNum.valueOf(6);
        Lit114 = IntNum.valueOf(10);
        Lit90 = IntNum.valueOf(11);
        Lit116 = IntNum.valueOf(13);
        Lit157 = PairWithPosition.make(PairWithPosition.make(Lit1, Lit271, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270357), PairWithPosition.make(PairWithPosition.make(Lit2, Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270368), PairWithPosition.make(PairWithPosition.make(Lit16, PairWithPosition.make(Lit21, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270387), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270379), PairWithPosition.make(PairWithPosition.make(Lit99, Lit272, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270390), PairWithPosition.make(PairWithPosition.make(Lit18, Lit274, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274453), PairWithPosition.make(Lit273, PairWithPosition.make(PairWithPosition.make(Lit21, Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274477), PairWithPosition.make(Lit277, PairWithPosition.make(Lit278, PairWithPosition.make(PairWithPosition.make(Lit162, Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278563), PairWithPosition.make(PairWithPosition.make(Lit114, PairWithPosition.make(DFloNum.valueOf(7.5), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278582), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278574), PairWithPosition.make(PairWithPosition.make(Lit90, PairWithPosition.make(Lit114, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278595), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278587), PairWithPosition.make(PairWithPosition.make(Lit115, PairWithPosition.make(Lit118, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282653), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282645), PairWithPosition.make(PairWithPosition.make(Lit116, Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282657), Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282657), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282645), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278587), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278574), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278563), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278549), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274489), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274477), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274465), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274453), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270390), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270379), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270368), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270356);
        Lit156 = Symbol.valueOf("fmax");
        Lit155 = PairWithPosition.make(PairWithPosition.make(Lit1, PairWithPosition.make(Symbol.valueOf("\u2018RFU"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286747), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286739), PairWithPosition.make(PairWithPosition.make(Lit2, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286753), PairWithPosition.make(PairWithPosition.make(Lit16, Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286764), PairWithPosition.make(PairWithPosition.make(Lit99, Lit271, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286775), PairWithPosition.make(PairWithPosition.make(Lit18, Lit272, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290835), PairWithPosition.make(Lit273, PairWithPosition.make(PairWithPosition.make(Lit21, PairWithPosition.make(Lit172, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290866), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290858), PairWithPosition.make(PairWithPosition.make(Lit105, PairWithPosition.make(Lit188, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290878), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290870), PairWithPosition.make(PairWithPosition.make(Lit7, Lit274, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294931), PairWithPosition.make(PairWithPosition.make(Lit162, Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294943), PairWithPosition.make(PairWithPosition.make(Lit114, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294955), PairWithPosition.make(PairWithPosition.make(Lit90, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294969), PairWithPosition.make(PairWithPosition.make(Lit115, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299027), PairWithPosition.make(PairWithPosition.make(Lit116, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299041), Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299041), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299027), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294969), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294955), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294943), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294931), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290870), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290858), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290846), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290835), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286775), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286764), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286753), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286738);
        Lit154 = Symbol.valueOf("Di");
        Lit22 = IntNum.valueOf(512);
        Lit23 = IntNum.valueOf(768);
        Lit153 = PairWithPosition.make(PairWithPosition.make(Lit1, Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253971), PairWithPosition.make(PairWithPosition.make(Lit2, Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253985), PairWithPosition.make(PairWithPosition.make(Lit16, PairWithPosition.make(IntNum.valueOf(558), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254007), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253999), PairWithPosition.make(PairWithPosition.make(Lit99, PairWithPosition.make(IntNum.valueOf(774), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254021), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254013), PairWithPosition.make(PairWithPosition.make(Lit18, PairWithPosition.make(IntNum.valueOf(1116), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258075), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258067), PairWithPosition.make(PairWithPosition.make(Lit58, PairWithPosition.make(IntNum.valueOf(1488), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258089), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258081), PairWithPosition.make(PairWithPosition.make(Lit21, PairWithPosition.make(IntNum.valueOf(1860), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258103), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258095), PairWithPosition.make(Lit277, PairWithPosition.make(Lit278, PairWithPosition.make(PairWithPosition.make(Lit162, PairWithPosition.make(Lit22, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262185), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262177), PairWithPosition.make(PairWithPosition.make(Lit114, PairWithPosition.make(Lit23, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262199), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262191), PairWithPosition.make(PairWithPosition.make(Lit90, PairWithPosition.make(IntNum.valueOf(1024), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262213), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262205), PairWithPosition.make(PairWithPosition.make(Lit115, PairWithPosition.make(IntNum.valueOf(1536), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266267), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266259), PairWithPosition.make(PairWithPosition.make(Lit116, PairWithPosition.make(IntNum.valueOf(2048), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266281), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266273), Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266273), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266259), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262205), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262191), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262177), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262163), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258109), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258095), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258081), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258067), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254013), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253999), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253985), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253970);
        Lit152 = Symbol.valueOf("Fi");
        Lit151 = IntNum.valueOf(-4);
        Lit150 = PairWithPosition.make(PairWithPosition.make(Lit152, Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311307), PairWithPosition.make(PairWithPosition.make(Lit154, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311316), PairWithPosition.make(PairWithPosition.make(Lit156, Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311323), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311323), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311316), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311306);
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
        Lit134 = PairWithPosition.make(Lit1, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm", 1908755);
        Lit133 = IntNum.valueOf(97);
        Lit132 = Symbol.valueOf("bClockStatus");
        Lit131 = PairWithPosition.make(Lit1, Lit134, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm", 1757203);
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
        Lit97 = PairWithPosition.make(Lit217, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 905257);
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
        Lit69 = PairWithPosition.make(Lit98, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 835672);
        Lit68 = IntNum.valueOf(33);
        Lit67 = PairWithPosition.make(Symbol.valueOf("endpoint"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 331814);
        Lit66 = PairWithPosition.make(Lit222, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 327713);
        Lit65 = PairWithPosition.make(Lit224, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 315425);
        Lit48 = Symbol.valueOf("bmAttributes");
        Lit64 = PairWithPosition.make(Lit48, Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 307265);
        Lit63 = PairWithPosition.make(Lit225, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 303137);
        Lit62 = PairWithPosition.make(Lit48, Lit263, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 294977);
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
        Lit50 = PairWithPosition.make(Lit158, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 811095);
        Lit49 = Symbol.valueOf("bMaxPower");
        Lit47 = Symbol.valueOf("iConfiguration");
        Lit46 = Symbol.valueOf("bConfigurationValue");
        Lit45 = Symbol.valueOf("bNumInterfaces");
        Lit44 = Symbol.valueOf("wTotalLength");
        Lit43 = PairWithPosition.make(Lit215, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 782400);
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
        Lit28 = PairWithPosition.make(Lit216, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 778304);
        Lit27 = Symbol.valueOf("interface0");
        Lit26 = IntNum.valueOf(18);
        Lit25 = IntNum.valueOf(256);
        Lit24 = IntNum.valueOf(1033);
        Lit20 = IntNum.valueOf(128);
        Lit19 = PairWithPosition.make(Lit105, PairWithPosition.make(Lit21, PairWithPosition.make(Lit58, PairWithPosition.make(Lit18, PairWithPosition.make(Lit99, PairWithPosition.make(Lit16, PairWithPosition.make(Lit2, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905240), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905238), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905236), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905234), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905232), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905230), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905227);
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
        CCIDScheme$frame cCIDScheme$frame = CCIDScheme$frame.$instance = new CCIDScheme$frame();
        ModuleMethod moduleMethod = new ModuleMethod(cCIDScheme$frame, 30, "list->u8vector", 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:2");
        list$Mn$Gru8vector = moduleMethod;
        ModuleMethod moduleMethod2 = new ModuleMethod(cCIDScheme$frame, 31, "u8vector->list", 4097);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:9");
        u8vector$Mn$Grlist = moduleMethod2;
        ModuleMethod moduleMethod3 = new ModuleMethod(cCIDScheme$frame, 32, "make-u8vector", 8193);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:11");
        make$Mnu8vector = moduleMethod3;
        ModuleMethod moduleMethod4 = new ModuleMethod(cCIDScheme$frame, 34, "object->string", 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:4");
        object$Mn$Grstring = moduleMethod4;
        ModuleMethod moduleMethod5 = new ModuleMethod(cCIDScheme$frame, 35, "slice", 12291);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:8");
        slice = moduleMethod5;
        ModuleMethod moduleMethod6 = new ModuleMethod(cCIDScheme$frame, 36, "build-dword-fromlst", -4095);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:17");
        build$Mndword$Mnfromlst = moduleMethod6;
        ModuleMethod moduleMethod7 = new ModuleMethod(cCIDScheme$frame, 37, "build-dword-inlst", -4095);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:36");
        build$Mndword$Mninlst = moduleMethod7;
        ModuleMethod moduleMethod8 = new ModuleMethod(cCIDScheme$frame, 38, "build-word-fromlst", -4095);
        moduleMethod8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:54");
        build$Mnword$Mnfromlst = moduleMethod8;
        ModuleMethod moduleMethod9 = new ModuleMethod(cCIDScheme$frame, 39, "build-word-inlst", -4095);
        moduleMethod9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:68");
        build$Mnword$Mninlst = moduleMethod9;
        ModuleMethod moduleMethod10 = new ModuleMethod(cCIDScheme$frame, 40, "make-counter", 8192);
        moduleMethod10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:82");
        make$Mncounter = moduleMethod10;
        ModuleMethod moduleMethod11 = new ModuleMethod(cCIDScheme$frame, 43, "make-container", 4097);
        moduleMethod11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:90");
        make$Mncontainer = moduleMethod11;
        ModuleMethod moduleMethod12 = new ModuleMethod(cCIDScheme$frame, 44, "to-list", -4095);
        moduleMethod12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:99");
        to$Mnlist = moduleMethod12;
        ModuleMethod moduleMethod13 = new ModuleMethod(cCIDScheme$frame, 45, "read-u8s", 8194);
        moduleMethod13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:103");
        read$Mnu8s = moduleMethod13;
        ModuleMethod moduleMethod14 = new ModuleMethod(cCIDScheme$frame, 46, "call-with-input-u8vector", 8194);
        moduleMethod14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:114");
        call$Mnwith$Mninput$Mnu8vector = moduleMethod14;
        ModuleMethod moduleMethod15 = new ModuleMethod(cCIDScheme$frame, 47, null, 4097);
        moduleMethod15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:122");
        lambda$Fn3 = moduleMethod15;
        ModuleMethod moduleMethod16 = new ModuleMethod(cCIDScheme$frame, 48, "subu8list", 12291);
        moduleMethod16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:128");
        subu8list = moduleMethod16;
        ModuleMethod moduleMethod17 = new ModuleMethod(cCIDScheme$frame, 49, "group-list", 8194);
        moduleMethod17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:134");
        group$Mnlist = moduleMethod17;
        filter = new ModuleMethod(cCIDScheme$frame, 50, Lit256, 8194);
        ModuleMethod moduleMethod18 = new ModuleMethod(cCIDScheme$frame, 51, "assoc-EX", 8194);
        moduleMethod18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:150");
        assoc$MnEX = moduleMethod18;
        ModuleMethod moduleMethod19 = new ModuleMethod(cCIDScheme$frame, 52, "list-xor", 4097);
        moduleMethod19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:159");
        list$Mnxor = moduleMethod19;
        ModuleMethod moduleMethod20 = new ModuleMethod(cCIDScheme$frame, 53, "to-hexStr", 8193);
        moduleMethod20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:165");
        to$MnhexStr = moduleMethod20;
        ModuleMethod moduleMethod21 = new ModuleMethod(cCIDScheme$frame, 55, "to-octStr", 8193);
        moduleMethod21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:177");
        to$MnoctStr = moduleMethod21;
        ModuleMethod moduleMethod22 = new ModuleMethod(cCIDScheme$frame, 57, "to-binStr", 8193);
        moduleMethod22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:189");
        to$MnbinStr = moduleMethod22;
        ModuleMethod moduleMethod23 = new ModuleMethod(cCIDScheme$frame, 59, "u8list->string", 8193);
        moduleMethod23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:202");
        u8list$Mn$Grstring = moduleMethod23;
        ModuleMethod moduleMethod24 = new ModuleMethod(cCIDScheme$frame, 61, "in-list?", 8194);
        moduleMethod24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:210");
        in$Mnlist$Qu = moduleMethod24;
        ModuleMethod moduleMethod25 = new ModuleMethod(cCIDScheme$frame, 62, "byte->bit", 4097);
        moduleMethod25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:219");
        byte$Mn$Grbit = moduleMethod25;
        ModuleMethod moduleMethod26 = new ModuleMethod(cCIDScheme$frame, 63, "list-remove-duplication", 4097);
        moduleMethod26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:225");
        list$Mnremove$Mnduplication = moduleMethod26;
        ModuleMethod moduleMethod27 = new ModuleMethod(cCIDScheme$frame, 64, "float->integer", 4097);
        moduleMethod27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:232");
        float$Mn$Grinteger = moduleMethod27;
        ModuleMethod moduleMethod28 = new ModuleMethod(cCIDScheme$frame, 65, "stringlst->string", 8193);
        moduleMethod28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:237");
        stringlst$Mn$Grstring = moduleMethod28;
        ModuleMethod moduleMethod29 = new ModuleMethod(cCIDScheme$frame, 67, "alist->list", 4097);
        moduleMethod29.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:244");
        alist$Mn$Grlist = moduleMethod29;
        ModuleMethod moduleMethod30 = new ModuleMethod(cCIDScheme$frame, 68, "get-configuration-descriptor", 4097);
        moduleMethod30.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:3");
        get$Mnconfiguration$Mndescriptor = moduleMethod30;
        ModuleMethod moduleMethod31 = new ModuleMethod(cCIDScheme$frame, 69, "get-string-descriptor", 8194);
        moduleMethod31.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:11");
        get$Mnstring$Mndescriptor = moduleMethod31;
        ModuleMethod moduleMethod32 = new ModuleMethod(cCIDScheme$frame, 70, "get-device-descriptor", 4097);
        moduleMethod32.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:20");
        get$Mndevice$Mndescriptor = moduleMethod32;
        ModuleMethod moduleMethod33 = new ModuleMethod(cCIDScheme$frame, 71, null, 8192);
        moduleMethod33.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:6");
        lambda$Fn5 = moduleMethod33;
        ModuleMethod moduleMethod34 = new ModuleMethod(cCIDScheme$frame, 74, null, 8194);
        moduleMethod34.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:172");
        lambda$Fn7 = moduleMethod34;
        ModuleMethod moduleMethod35 = new ModuleMethod(cCIDScheme$frame, 75, null, 4097);
        moduleMethod35.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:124");
        lambda$Fn9 = moduleMethod35;
        ModuleMethod moduleMethod36 = new ModuleMethod(cCIDScheme$frame, 76, null, 4097);
        moduleMethod36.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:107");
        lambda$Fn10 = moduleMethod36;
        ModuleMethod moduleMethod37 = new ModuleMethod(cCIDScheme$frame, 77, null, 4097);
        moduleMethod37.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:89");
        lambda$Fn11 = moduleMethod37;
        ModuleMethod moduleMethod38 = new ModuleMethod(cCIDScheme$frame, 78, null, 4097);
        moduleMethod38.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:62");
        lambda$Fn12 = moduleMethod38;
        ModuleMethod moduleMethod39 = new ModuleMethod(cCIDScheme$frame, 79, null, 4097);
        moduleMethod39.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:31");
        lambda$Fn13 = moduleMethod39;
        ModuleMethod moduleMethod40 = new ModuleMethod(cCIDScheme$frame, 80, null, 4097);
        moduleMethod40.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:146");
        lambda$Fn14 = moduleMethod40;
        ModuleMethod moduleMethod41 = new ModuleMethod(cCIDScheme$frame, 81, null, 4097);
        moduleMethod41.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:17");
        lambda$Fn6 = moduleMethod41;
        ModuleMethod moduleMethod42 = new ModuleMethod(cCIDScheme$frame, 82, "parse-descriptor", 4097);
        moduleMethod42.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:14");
        parse$Mndescriptor = moduleMethod42;
        ModuleMethod moduleMethod43 = new ModuleMethod(cCIDScheme$frame, 83, "get-voltageSupport-from-descriptor", 4097);
        moduleMethod43.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:226");
        get$MnvoltageSupport$Mnfrom$Mndescriptor = moduleMethod43;
        ModuleMethod moduleMethod44 = new ModuleMethod(cCIDScheme$frame, 84, "get-bSeq", 4096);
        moduleMethod44.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:3");
        get$MnbSeq = moduleMethod44;
        ModuleMethod moduleMethod45 = new ModuleMethod(cCIDScheme$frame, 86, "get-bStatus-bError-errorName", 8194);
        moduleMethod45.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:13");
        get$MnbStatus$MnbError$MnerrorName = moduleMethod45;
        ModuleMethod moduleMethod46 = new ModuleMethod(cCIDScheme$frame, 87, "PC_to_RDR_IccPowerOn", 8194);
        moduleMethod46.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:369");
        PC_to_RDR_IccPowerOn = moduleMethod46;
        ModuleMethod moduleMethod47 = new ModuleMethod(cCIDScheme$frame, 88, "PC_to_RDR_XfrBlock", 16388);
        moduleMethod47.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:384");
        PC_to_RDR_XfrBlock = moduleMethod47;
        ModuleMethod moduleMethod48 = new ModuleMethod(cCIDScheme$frame, 89, "RDR_to_PC_DataBlock", 4097);
        moduleMethod48.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:403");
        RDR_to_PC_DataBlock = moduleMethod48;
        ModuleMethod moduleMethod49 = new ModuleMethod(cCIDScheme$frame, 90, "PC_to_RDR_IccPowerOff", 4097);
        moduleMethod49.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:424");
        PC_to_RDR_IccPowerOff = moduleMethod49;
        ModuleMethod moduleMethod50 = new ModuleMethod(cCIDScheme$frame, 91, "RDR_to_PC_SlotStatus", 4097);
        moduleMethod50.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:437");
        RDR_to_PC_SlotStatus = moduleMethod50;
        ModuleMethod moduleMethod51 = new ModuleMethod(cCIDScheme$frame, 92, "PC_to_RDR_SetParameters", 12291);
        moduleMethod51.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:460");
        PC_to_RDR_SetParameters = moduleMethod51;
        ModuleMethod moduleMethod52 = new ModuleMethod(cCIDScheme$frame, 93, "RDR_to_PC_Parameters", 4097);
        moduleMethod52.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:476");
        RDR_to_PC_Parameters = moduleMethod52;
        ModuleMethod moduleMethod53 = new ModuleMethod(cCIDScheme$frame, 94, "PC_to_RDR_Escape", 8194);
        moduleMethod53.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:503");
        PC_to_RDR_Escape = moduleMethod53;
        ModuleMethod moduleMethod54 = new ModuleMethod(cCIDScheme$frame, 95, "RDR_to_PC_Escape", 4097);
        moduleMethod54.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:516");
        RDR_to_PC_Escape = moduleMethod54;
        ModuleMethod moduleMethod55 = new ModuleMethod(cCIDScheme$frame, 96, "PC_to_RDR_GetSlotStatus", 4097);
        moduleMethod55.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:538");
        PC_to_RDR_GetSlotStatus = moduleMethod55;
        ModuleMethod moduleMethod56 = new ModuleMethod(cCIDScheme$frame, 97, null, 4097);
        moduleMethod56.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:13");
        lambda$Fn16 = moduleMethod56;
        ModuleMethod moduleMethod57 = new ModuleMethod(cCIDScheme$frame, 98, "parse-ATR", 4097);
        moduleMethod57.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:2");
        parse$MnATR = moduleMethod57;
        ModuleMethod moduleMethod58 = new ModuleMethod(cCIDScheme$frame, 99, "parse-atrTA1", 4097);
        moduleMethod58.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:61");
        parse$MnatrTA1 = moduleMethod58;
        ModuleMethod moduleMethod59 = new ModuleMethod(cCIDScheme$frame, 100, null, 4097);
        moduleMethod59.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:89");
        lambda$Fn17 = moduleMethod59;
        ModuleMethod moduleMethod60 = new ModuleMethod(cCIDScheme$frame, 101, "get-atrSupportProtocol", 4097);
        moduleMethod60.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:87");
        get$MnatrSupportProtocol = moduleMethod60;
        ModuleMethod moduleMethod61 = new ModuleMethod(cCIDScheme$frame, 102, null, 4097);
        moduleMethod61.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:106");
        lambda$Fn18 = moduleMethod61;
        ModuleMethod moduleMethod62 = new ModuleMethod(cCIDScheme$frame, 103, "get-atrTATB-for-T15", 4097);
        moduleMethod62.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:104");
        get$MnatrTATB$Mnfor$MnT15 = moduleMethod62;
        ModuleMethod moduleMethod63 = new ModuleMethod(cCIDScheme$frame, 104, "get-pps1", 4097);
        moduleMethod63.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:126");
        get$Mnpps1 = moduleMethod63;
        ModuleMethod moduleMethod64 = new ModuleMethod(cCIDScheme$frame, 105, null, 4097);
        moduleMethod64.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:187");
        lambda$Fn19 = moduleMethod64;
        ModuleMethod moduleMethod65 = new ModuleMethod(cCIDScheme$frame, 106, "generate-PPS-exchange", 4097);
        moduleMethod65.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:167");
        generate$MnPPS$Mnexchange = moduleMethod65;
        ModuleMethod moduleMethod66 = new ModuleMethod(cCIDScheme$frame, 107, "get-atrIFSC", 4097);
        moduleMethod66.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:194");
        get$MnatrIFSC = moduleMethod66;
        ModuleMethod moduleMethod67 = new ModuleMethod(cCIDScheme$frame, 108, "get-atrTC-for-T1", 4097);
        moduleMethod67.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:222");
        get$MnatrTC$Mnfor$MnT1 = moduleMethod67;
        ModuleMethod moduleMethod68 = new ModuleMethod(cCIDScheme$frame, 109, "get-atrTB-for-T1", 4097);
        moduleMethod68.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:251");
        get$MnatrTB$Mnfor$MnT1 = moduleMethod68;
        ModuleMethod moduleMethod69 = new ModuleMethod(cCIDScheme$frame, 110, "generate-PPS-parameters-T1", 4097);
        moduleMethod69.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:279");
        generate$MnPPS$Mnparameters$MnT1 = moduleMethod69;
        ModuleMethod moduleMethod70 = new ModuleMethod(cCIDScheme$frame, 111, "generate-PPS-parameters-T0", 4097);
        moduleMethod70.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:316");
        generate$MnPPS$Mnparameters$MnT0 = moduleMethod70;
        ModuleMethod moduleMethod71 = new ModuleMethod(cCIDScheme$frame, 112, "get-Card-Timeout-T1", 4097);
        moduleMethod71.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:339");
        get$MnCard$MnTimeout$MnT1 = moduleMethod71;
        ModuleMethod moduleMethod72 = new ModuleMethod(cCIDScheme$frame, 113, "get-Card-Timeout-T0", 4097);
        moduleMethod72.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:370");
        get$MnCard$MnTimeout$MnT0 = moduleMethod72;
        ModuleMethod moduleMethod73 = new ModuleMethod(cCIDScheme$frame, 114, "get-Card-Timeout", 4097);
        moduleMethod73.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:399");
        get$MnCard$MnTimeout = moduleMethod73;
        ModuleMethod moduleMethod74 = new ModuleMethod(cCIDScheme$frame, 115, "parse-T1Block", 8193);
        moduleMethod74.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:410");
        parse$MnT1Block = moduleMethod74;
        ModuleMethod moduleMethod75 = new ModuleMethod(cCIDScheme$frame, 117, "generate-S-block-TPDU-T1", 8194);
        moduleMethod75.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:495");
        generate$MnS$Mnblock$MnTPDU$MnT1 = moduleMethod75;
        ModuleMethod moduleMethod76 = new ModuleMethod(cCIDScheme$frame, 118, "generate-I-block-TPDU-T1", 12291);
        moduleMethod76.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:512");
        generate$MnI$Mnblock$MnTPDU$MnT1 = moduleMethod76;
        ModuleMethod moduleMethod77 = new ModuleMethod(cCIDScheme$frame, 119, "generate-R-block-TPDU-T1", 8194);
        moduleMethod77.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:522");
        generate$MnR$Mnblock$MnTPDU$MnT1 = moduleMethod77;
        ModuleMethod moduleMethod78 = new ModuleMethod(cCIDScheme$frame, 120, "make-GET_DEVICE_INF-func", 8194);
        moduleMethod78.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:18");
        make$MnGET_DEVICE_INF$Mnfunc = moduleMethod78;
        ModuleMethod moduleMethod79 = new ModuleMethod(cCIDScheme$frame, 121, "do-PPS-exchange", 12291);
        moduleMethod79.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:98");
        do$MnPPS$Mnexchange = moduleMethod79;
        ModuleMethod moduleMethod80 = new ModuleMethod(cCIDScheme$frame, 122, "do-PPS-set-parameters", 12291);
        moduleMethod80.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:110");
        do$MnPPS$Mnset$Mnparameters = moduleMethod80;
        ModuleMethod moduleMethod81 = new ModuleMethod(cCIDScheme$frame, 123, "do-PPS", 12291);
        moduleMethod81.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:129");
        do$MnPPS = moduleMethod81;
        ModuleMethod moduleMethod82 = new ModuleMethod(cCIDScheme$frame, 124, "get-ccid-exchange-level", 4097);
        moduleMethod82.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:169");
        get$Mnccid$Mnexchange$Mnlevel = moduleMethod82;
        ModuleMethod moduleMethod83 = new ModuleMethod(cCIDScheme$frame, 125, "do-XfrBlock-TPDU-T0-Protocol", 16388);
        moduleMethod83.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:187");
        do$MnXfrBlock$MnTPDU$MnT0$MnProtocol = moduleMethod83;
        ModuleMethod moduleMethod84 = new ModuleMethod(cCIDScheme$frame, 126, "do-XfrBlock-APDU-Extended-Protocol", 16388);
        moduleMethod84.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:204");
        do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol = moduleMethod84;
        ModuleMethod moduleMethod85 = new ModuleMethod(cCIDScheme$frame, 127, null, 8193);
        moduleMethod85.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:266");
        lambda$Fn21 = moduleMethod85;
        ModuleMethod moduleMethod86 = new ModuleMethod(cCIDScheme$frame, 129, null, 8193);
        moduleMethod86.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:276");
        lambda$Fn22 = moduleMethod86;
        ModuleMethod moduleMethod87 = new ModuleMethod(cCIDScheme$frame, 131, "IFS-request-TPDU-T1", 16388);
        moduleMethod87.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:284");
        IFS$Mnrequest$MnTPDU$MnT1 = moduleMethod87;
        ModuleMethod moduleMethod88 = new ModuleMethod(cCIDScheme$frame, 132, "do-XfrBlock-TPDU-T1-Protocol", 20485);
        moduleMethod88.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:307");
        do$MnXfrBlock$MnTPDU$MnT1$MnProtocol = moduleMethod88;
        ModuleMethod moduleMethod89 = new ModuleMethod(cCIDScheme$frame, 133, null, 4096);
        moduleMethod89.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:377");
        lambda$Fn23 = moduleMethod89;
        ModuleMethod moduleMethod90 = new ModuleMethod(cCIDScheme$frame, 135, "do-InitDescriptorInf", 4097);
        moduleMethod90.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:385");
        do$MnInitDescriptorInf = moduleMethod90;
        ModuleMethod moduleMethod91 = new ModuleMethod(cCIDScheme$frame, 136, "do-PowerOff", 8193);
        moduleMethod91.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:394");
        do$MnPowerOff = moduleMethod91;
        ModuleMethod moduleMethod92 = new ModuleMethod(cCIDScheme$frame, 138, "do-PowerOn", 16386);
        moduleMethod92.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:403");
        do$MnPowerOn = moduleMethod92;
        ModuleMethod moduleMethod93 = new ModuleMethod(cCIDScheme$frame, 141, "do-Escape", 12290);
        moduleMethod93.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:485");
        do$MnEscape = moduleMethod93;
        ModuleMethod moduleMethod94 = new ModuleMethod(cCIDScheme$frame, 143, "do-SlotStatus", 8193);
        moduleMethod94.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:493");
        do$MnSlotStatus = moduleMethod94;
        CCIDScheme$frame cCIDScheme$frame2 = CCIDScheme$frame.$instance;
        ModuleMethod moduleMethod95 = new ModuleMethod(cCIDScheme$frame2, 145, null, 4097);
        moduleMethod95.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:7");
        simple$Mnthread = Macro.make(Lit257, moduleMethod95, "com.ftsafe.CCIDScheme");
        ModuleMethod moduleMethod96 = new ModuleMethod(cCIDScheme$frame, 146, "thread-sleep!", 4097);
        moduleMethod96.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:16");
        thread$Mnsleep$Ex = moduleMethod96;
        ModuleMethod moduleMethod97 = new ModuleMethod(cCIDScheme$frame, 147, "make-thread", 4097);
        moduleMethod97.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:20");
        make$Mnthread = moduleMethod97;
        ModuleMethod moduleMethod98 = new ModuleMethod(cCIDScheme$frame, 148, "thread-start!", 4097);
        moduleMethod98.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:25");
        thread$Mnstart$Ex = moduleMethod98;
        Object = Log;
        FTReaderInf = Log;
        Context = Log;
        Handler = Log;
        ModuleMethod moduleMethod99 = new ModuleMethod(cCIDScheme$frame, 149, "GET_DEVICES_INF_default", -4096);
        moduleMethod99.setProperty("source-location", "ccid_7816/CCIDScheme.scm:21");
        GET_DEVICES_INF_default = moduleMethod99;
        ModuleMethod moduleMethod100 = new ModuleMethod(cCIDScheme$frame, 150, null, -4096);
        moduleMethod100.setProperty("source-location", "ccid_7816/CCIDScheme.scm:23");
        lambda$Fn29 = moduleMethod100;
        ModuleMethod moduleMethod101 = new ModuleMethod(cCIDScheme$frame, 151, null, -4096);
        moduleMethod101.setProperty("source-location", "ccid_7816/CCIDScheme.scm:24");
        lambda$Fn30 = moduleMethod101;
        ModuleMethod moduleMethod102 = new ModuleMethod(cCIDScheme$frame, 152, null, -4096);
        moduleMethod102.setProperty("source-location", "ccid_7816/CCIDScheme.scm:25");
        lambda$Fn31 = moduleMethod102;
        ModuleMethod moduleMethod103 = new ModuleMethod(cCIDScheme$frame, 153, null, -4096);
        moduleMethod103.setProperty("source-location", "ccid_7816/CCIDScheme.scm:26");
        lambda$Fn32 = moduleMethod103;
        ModuleMethod moduleMethod104 = new ModuleMethod(cCIDScheme$frame, 154, null, -4096);
        moduleMethod104.setProperty("source-location", "ccid_7816/CCIDScheme.scm:27");
        lambda$Fn33 = moduleMethod104;
        CCIDScheme = CCIDScheme.class;
        ModuleMethod moduleMethod105 = new ModuleMethod(cCIDScheme$frame, 155, null, 8194);
        moduleMethod105.setProperty("source-location", "ccid_7816/CCIDScheme.scm:68");
        lambda$Fn37 = moduleMethod105;
        CCIDScheme.$runBody$();
    }

    static Object lambda64(Object x) {
        Object object2;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit258).match(x, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit259.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

}

