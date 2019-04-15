/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.Invoke;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.text.Char;
import java.lang.reflect.Array;
import java.util.Arrays;
import kawa.SourceMethodType;
import kawa.lang.Quote;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class srfi14
extends ModuleBody {
    public static final ModuleMethod char$Mnset$Eq;
    public static final ModuleMethod char$Mnset$Ls$Eq;
    public static final ModuleMethod char$Mnset$Mnhash;
    public static final ModuleMethod char$Mnset$Mncursor;
    public static final ModuleMethod char$Mnset$Mnref;
    public static final ModuleMethod char$Mnset$Mncursor$Mnnext;
    public static final ModuleMethod end$Mnof$Mnchar$Mnset$Qu;
    public static final ModuleMethod char$Mnset$Mnfold;
    public static final ModuleMethod char$Mnset$Mnunfold;
    public static final ModuleMethod char$Mnset$Mnunfold$Ex;
    public static final ModuleMethod char$Mnset$Mnfor$Mneach;
    public static final ModuleMethod char$Mnset$Mnmap;
    public static final ModuleMethod char$Mnset$Mncopy;
    public static final Class char$Mnset;
    public static final ModuleMethod list$Mn$Grchar$Mnset;
    public static final ModuleMethod string$Mn$Grchar$Mnset;
    public static final ModuleMethod list$Mn$Grchar$Mnset$Ex;
    public static final ModuleMethod string$Mn$Grchar$Mnset$Ex;
    public static final ModuleMethod char$Mnset$Mnfilter;
    public static final ModuleMethod ucs$Mnrange$Mn$Grchar$Mnset;
    public static final ModuleMethod char$Mnset$Mnfilter$Ex;
    public static final ModuleMethod ucs$Mnrange$Mn$Grchar$Mnset$Ex;
    public static final ModuleMethod $Mn$Grchar$Mnset;
    public static final ModuleMethod char$Mnset$Mn$Grlist;
    public static final ModuleMethod char$Mnset$Mn$Grstring;
    public static final ModuleMethod char$Mnset$Mnsize;
    public static final ModuleMethod char$Mnset$Mncount;
    public static final ModuleMethod char$Mnset$Mncontains$Qu;
    public static final ModuleMethod char$Mnset$Mnevery;
    public static final ModuleMethod char$Mnset$Mnany;
    public static final ModuleMethod char$Mnset$Mnadjoin;
    public static final ModuleMethod char$Mnset$Mndelete;
    public static final ModuleMethod char$Mnset$Mnadjoin$Ex;
    public static final ModuleMethod char$Mnset$Mndelete$Ex;
    public static final ModuleMethod char$Mnset$Mncomplement;
    public static final ModuleMethod char$Mnset$Mnunion;
    public static final ModuleMethod char$Mnset$Mnintersection;
    public static final ModuleMethod char$Mnset$Mncomplement$Ex;
    public static final ModuleMethod char$Mnset$Mnunion$Ex;
    public static final ModuleMethod char$Mnset$Mnintersection$Ex;
    public static final ModuleMethod char$Mnset$Mndifference;
    public static final ModuleMethod char$Mnset$Mnxor;
    public static final ModuleMethod char$Mnset$Mndiff$Plintersection;
    public static final ModuleMethod char$Mnset$Mndifference$Ex;
    public static final ModuleMethod char$Mnset$Mnxor$Ex;
    public static Procedure char$Mnset$Mndiff$Plintersection$Ex;
    public static final Class $Prvt$reflectArray;
    public static final Class $Prvt$Arrays;
    static final int[] $Pctitle$Mncase;
    static final int[] $Pcwhitespace;
    static final int[] $Pcblank;
    static final int[] $Pclower$Mncase;
    static final int[] $Pcupper$Mncase;
    static final int[] $Pcletter;
    static final int[] $Pcdigit;
    static final int[] $Pcpunctuation;
    static final int[] $Pcsymbol;
    static final int[] $Pcletter$Pldigit;
    static final int[] $Pcgraphic;
    static final int[] $Pcprinting;
    static final ModuleMethod $Pcboundary$Mnpairs$Mnintersection;
    static final ModuleMethod $Pcboundary$Mnpairs$Mnunion;
    static final ModuleMethod $Pcboundary$Mnpairs$Mnxor;
    static final SimpleSymbol Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final ClassType Lit3;
    static final Integer Lit4;
    public static srfi14 $instance;
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
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        char$Mnset$Mndiff$Plintersection$Ex = char$Mnset$Mndiff$Plintersection;
    }

    public static /* varargs */ boolean charSet$Eq(CharSet ... csets) {
        boolean bl;
        block4 : {
            boolean x;
            boolean bl2 = x = csets.length < 2;
            if (x) {
                bl = x;
            } else {
                int i = 1;
                do {
                    boolean x2;
                    boolean bl3 = x2 = i == csets.length;
                    if (x2) {
                        bl = x2;
                        break block4;
                    }
                    if (!KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(csets[0], csets[i]))) break;
                    ++i;
                } while (true);
                bl = false;
            }
        }
        return bl;
    }

    public static /* varargs */ boolean charSet$Ls$Eq(CharSet ... csets) {
        boolean bl;
        block4 : {
            boolean x;
            boolean bl2 = x = csets.length < 2;
            if (x) {
                bl = x;
            } else {
                int i = 1;
                do {
                    boolean x2;
                    boolean bl3 = x2 = i == csets.length;
                    if (x2) {
                        bl = x2;
                        break block4;
                    }
                    if (!csets[i - 1].isSubsetOf(csets[i])) break;
                    ++i;
                } while (true);
                bl = false;
            }
        }
        return bl;
    }

    public static int charSetHash(CharSet charSet) {
        return srfi14.charSetHash(charSet, 0);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static int charSetHash(CharSet cs, int bound) {
        boolean x;
        int n;
        int natural$Mnhash = cs.hashCode();
        if (natural$Mnhash < 0) {
            Object object2 = Promise.force(((Procedure)DivideOp.modulo).apply2(natural$Mnhash, Integer.MAX_VALUE));
            natural$Mnhash = ((Number)object2).intValue();
        }
        boolean bl = x = bound == 0;
        if (x ? x : natural$Mnhash < bound) {
            n = natural$Mnhash;
            return n;
        }
        n = natural$Mnhash % bound;
        return n;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "natural-hash", -2, (Object)x);
        }
    }

    public static int charSetCursor(CharSet cset) {
        return cset.getCursor();
    }

    @SourceMethodType(value={"character"})
    public static int charSetRef(CharSet cset, int cursor) {
        return cursor;
    }

    public static int charSetCursorNext(CharSet cset, int cursor) {
        return cset.cursorNext(cursor);
    }

    public static boolean isEndOfCharSet(int cursor) {
        return cursor > 1114111;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object charSetFold(Procedure kons, Object knil, CharSet cs) {
        v0 = srfi14.charSetCursor(cs);
        v1 = knil;
        do {
            object4 = v1;
            cursor = v0;
            object2 = Promise.force(cursor);
            if (!srfi14.isEndOfCharSet(((Number)object2).intValue())) ** break block7
            return answer;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "end-of-char-set?", 0, object2);
        }
        {
            
            object2 = Promise.force(cursor);
            v0 = srfi14.charSetCursorNext(cs, ((Number)object2).intValue());
            object2 = Promise.force(cursor);
            v1 = kons.apply2(Char.make(srfi14.charSetRef(cs, ((Number)object2).intValue())), answer);
            continue;
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "char-set-cursor-next", 1, object2);
        }
        catch (ClassCastException v4) {
            throw new WrongType(v4, "char-set-ref", 1, object2);
        }
    }

    public static CharSet charSetUnfold(Procedure procedure, Procedure procedure2, Procedure procedure3, Object object2) {
        return srfi14.charSetUnfold(procedure, procedure2, procedure3, object2, CharSet.empty);
    }

    public static CharSet charSetUnfold(Procedure p, Procedure f, Procedure g, Object seed, CharSet base$Mncs) {
        return srfi14.charSetUnfold$Ex(p, f, g, seed, srfi14.charSetCopy(base$Mncs));
    }

    public static CharSet charSetUnfold$Ex(Procedure p, Procedure f, Procedure g, Object seed, CharSet base$Mncs) {
        Object seed2;
        void cs;
        CharSet charSet;
        Object object2 = seed;
        CharSet charSet2 = charSet = base$Mncs;
        while (!KawaConvert.isTrue(p.apply1(seed2 = object2))) {
            int[] arrn;
            object2 = g.apply1(seed2);
            Object object3 = f.apply1(seed2);
            if (object3 instanceof int[]) {
                arrn = (int[])object3;
            } else {
                int[] arrn2 = new int[1];
                arrn = arrn2;
                arrn2[0] = Char.castToCharacter(object3);
            }
            charSet2 = srfi14.charSetAdjoin$Ex((CharSet)cs, arrn);
        }
        return cs;
    }

    public static CharSet charSetCopy(CharSet cs) {
        return cs.clone();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SourceMethodType(value={"", "", "character[]"})
    public static /* varargs */ CharSet charSetAdjoin$Ex(CharSet cs, int ... chars) {
        CharSet charSet;
        int tmp = chars.length;
        switch (tmp) {
            case 0: {
                charSet = cs;
                return charSet;
            }
            case 1: {
                charSet = cs.adjoin$Ex(chars[0]);
                return charSet;
            }
        }
        int n = 1;
        int[] arrn = chars;
        int n2 = MakeSplice.count(arrn);
        n = n2 + n;
        Object[] arrobject = new Object[n];
        arrobject[0] = CharSet.class;
        int n3 = 1;
        MakeSplice.copyTo(arrobject, n3, n2, arrn);
        n3 += n2;
        Object object2 = Promise.force(((Procedure)Invoke.make).applyN(arrobject), CharSet.class);
        try {
            charSet = cs.union$Ex((CharSet)object2);
            return charSet;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.slib.srfi14$CharSet.union$Ex(gnu.kawa.slib.srfi14$CharSet)", 2, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object charSetForEach(Procedure proc, CharSet cs) {
        Object object2;
        Integer cursor;
        Integer n = srfi14.charSetCursor(cs);
        do {
            cursor = n;
            object2 = Promise.force(cursor);
            if (srfi14.isEndOfCharSet(((Number)object2).intValue())) return Lit0;
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "end-of-char-set?", 0, object2);
        }
        {
            object2 = Promise.force(cursor);
            proc.apply1(Char.make(srfi14.charSetRef(cs, ((Number)object2).intValue())));
            object2 = Promise.force(cursor);
            n = srfi14.charSetCursorNext(cs, ((Number)object2).intValue());
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-ref", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-cursor-next", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSet charSetMap(Procedure proc, CharSet cs) {
        v0 = srfi14.charSetCursor(cs);
        v1 = srfi14.charSetCopy(CharSet.empty);
        do lbl-1000: // 2 sources:
        {
            result$Mncs = v1;
            cursor = v0;
            var4_4 = Promise.force(cursor);
            if (srfi14.isEndOfCharSet(((Number)var4_4).intValue()) != false) return (CharSet)Promise.force(result$Mncs, CharSet.class);
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "end-of-char-set?", 0, var4_4);
        }
        {
            block9 : {
                var4_4 = Promise.force(cursor);
                v0 = srfi14.charSetCursorNext(cs, ((Number)var4_4).intValue());
                v3 = Promise.force(result$Mncs, CharSet.class);
                var4_4 = v3;
                var4_4 = Promise.force(cursor);
                v4 = proc.apply1(Char.make(srfi14.charSetRef(cs, ((Number)var4_4).intValue())));
                if (!(v4 instanceof int[])) break block9;
                v5 = (int[])v4;
                ** GOTO lbl-1000
            }
            v6 = new int[1];
            v5 = v6;
            v6[0] = Char.castToCharacter(v4);
lbl-1000: // 2 sources:
            {
                v1 = srfi14.charSetAdjoin$Ex((CharSet)v3, v5);
            }
            ** while (true)
        }
        catch (ClassCastException v7) {
            throw new WrongType(v7, "char-set-cursor-next", 1, var4_4);
        }
        catch (ClassCastException v8) {
            throw new WrongType(v8, "char-set-ref", 1, var4_4);
        }
    }

    public static CharSet list$To$CharSet(LList lList) {
        return srfi14.list$To$CharSet(lList, CharSet.empty);
    }

    public static CharSet list$To$CharSet(LList char$Mnlist, CharSet base$Mncs) {
        CharSet res$Mncs;
        int n = 1;
        LList lList = char$Mnlist;
        int n2 = MakeSplice.count(lList);
        n = n2 + n;
        Object[] arrobject = new Object[n];
        arrobject[0] = CharSet.class;
        int n3 = 1;
        MakeSplice.copyTo(arrobject, n3, n2, lList);
        n3 += n2;
        Object object2 = Promise.force(((Procedure)Invoke.make).applyN(arrobject), CharSet.class);
        try {
            res$Mncs = (CharSet)object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "res-cs", -2, object2);
        }
        return srfi14.charSetUnion$Ex(res$Mncs, base$Mncs);
    }

    public static /* varargs */ CharSet charSetUnion$Ex(CharSet ... csets) {
        CharSet charSet;
        int tmp = csets.length;
        switch (tmp) {
            case 0: {
                charSet = CharSet.empty;
                break;
            }
            case 1: {
                charSet = csets[0];
                break;
            }
            default: {
                for (int i = 1; i != csets.length; ++i) {
                    csets[0].union$Ex(csets[i]);
                }
                charSet = csets[0];
                break;
            }
        }
        return charSet;
    }

    public static CharSet list$To$CharSet$Ex(LList char$Mnlist, CharSet base$Mncs) {
        int n = 0;
        LList lList = char$Mnlist;
        int n2 = MakeSplice.count(lList);
        n = n2 + n;
        int[] arrn = new int[n];
        int n3 = 0;
        MakeSplice.copyTo(arrn, n3, n2, lList, LangPrimType.characterType);
        n3 += n2;
        return srfi14.charSetAdjoin$Ex(base$Mncs, arrn);
    }

    public static CharSet string$To$CharSet(String string) {
        return srfi14.string$To$CharSet(string, CharSet.empty);
    }

    public static CharSet string$To$CharSet(String s, CharSet base$Mncs) {
        return srfi14.list$To$CharSet(strings.string$To$List(s), base$Mncs);
    }

    public static CharSet string$To$CharSet$Ex(String s, CharSet base$Mncs) {
        return srfi14.list$To$CharSet$Ex(strings.string$To$List(s), base$Mncs);
    }

    public static CharSet charSetFilter(Procedure procedure, CharSet charSet) {
        return srfi14.charSetFilter(procedure, charSet, CharSet.empty);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSet charSetFilter(Procedure pred, CharSet cs, CharSet base$Mncs) {
        v0 = srfi14.charSetCursor(cs);
        v1 = srfi14.charSetCopy(base$Mncs);
        do lbl-1000: // 3 sources:
        {
            charSet2 = v1;
            cursor = v0;
            object3 = Promise.force(cursor);
            if (srfi14.isEndOfCharSet(((Number)object3).intValue()) != false) return (CharSet)Promise.force(result$Mncs, CharSet.class);
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "end-of-char-set?", 0, (Object)c22222);
        }
        {
            object3 = Promise.force(cursor);
            v0 = srfi14.charSetCursorNext(cs, ((Number)object3).intValue());
            object2 = Promise.force(cursor);
            c22222 = srfi14.charSetRef(cs, ((Number)object2).intValue());
            if (KawaConvert.isTrue(pred.apply1(Char.make(c22222)))) {
                object2 = Promise.force(result$Mncs, CharSet.class);
                {
                    v1 = srfi14.charSetAdjoin$Ex((CharSet)object2, new int[]{c22222});
                }
                continue;
            }
            v1 = result$Mncs;
            ** while (true)
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "char-set-cursor-next", 1, (Object)c22222);
        }
        catch (ClassCastException v4) {
            throw new WrongType(v4, "char-set-ref", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static CharSet charSetFilter$Ex(Procedure pred, CharSet cs, CharSet base$Mncs) {
        void base$Mncs2;
        Object object2;
        Integer n = srfi14.charSetCursor(cs);
        CharSet charSet = base$Mncs;
        block10 : do {
            CharSet charSet2 = charSet;
            Integer cursor = n;
            do {
                Object object3 = Promise.force(cursor);
                if (srfi14.isEndOfCharSet(((Number)object3).intValue())) break block10;
                object2 = Promise.force(cursor);
                int c = srfi14.charSetRef(cs, ((Number)object2).intValue());
                if (KawaConvert.isTrue(pred.apply1(Char.make(c)))) {
                    object2 = Promise.force(cursor);
                    n = srfi14.charSetCursorNext(cs, ((Number)object2).intValue());
                    object2 = Promise.force(base$Mncs2, CharSet.class);
                    {
                        charSet = srfi14.charSetAdjoin$Ex((CharSet)object2, c);
                    }
                    continue block10;
                }
                object2 = Promise.force(cursor);
                cursor = srfi14.charSetCursorNext(cs, ((Number)object2).intValue());
                continue;
                break;
            } while (true);
            break;
        } while (true);
        return (CharSet)Promise.force(base$Mncs2, CharSet.class);
        catch (ClassCastException classCastException) {
            void c;
            throw new WrongType(classCastException, "end-of-char-set?", 0, (Object)c);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-ref", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-cursor-next", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-cursor-next", 1, object2);
        }
    }

    public static CharSet ucsRange$To$CharSet(int n, int n2) {
        return srfi14.ucsRange$To$CharSet(n, n2, false);
    }

    public static CharSet ucsRange$To$CharSet(int n, int n2, boolean bl) {
        return srfi14.ucsRange$To$CharSet(n, n2, bl, CharSet.empty);
    }

    public static CharSet ucsRange$To$CharSet(int lower, int upper, boolean error$Qu, CharSet base$Mncs) {
        new CharSet(new int[0]).inversion$Mnlist = new int[]{upper, lower};
        new CharSet(new int[0]).inversion$Mnlist$Mnsize = 2;
        CharSet res$Mncs = new CharSet(new int[0]);
        return srfi14.charSetUnion$Ex(res$Mncs, base$Mncs);
    }

    public static CharSet ucsRange$To$CharSet$Ex(int lower, int upper, boolean error$Qu, CharSet base$Mncs) {
        return base$Mncs.union$Ex(new int[]{upper, lower}, 2);
    }

    public static CharSet $To$CharSet(Object x) {
        CharSet charSet;
        if (strings.isString(x)) {
            Object object2 = Promise.force(x, String.class);
            charSet = srfi14.string$To$CharSet((String)(object2 == null ? null : object2.toString()));
        } else if (x instanceof Char) {
            int[] arrn;
            charSet = new CharSet(arrn);
            Object object3 = x;
            if (object3 instanceof int[]) {
                arrn = (int[])object3;
            } else {
                int[] arrn2 = new int[1];
                arrn = arrn2;
                arrn2[0] = Char.castToCharacter(object3);
            }
        } else if (x instanceof CharSet) {
            charSet = (CharSet)Promise.force(x, CharSet.class);
        } else {
            throw new ClassCastException("not converible to char-set");
        }
        return charSet;
    }

    public static int charSetSize(CharSet cs) {
        return cs.size();
    }

    public static int charSetCount(Procedure pred, CharSet cs) {
        public class Frame
        extends ModuleBody {
            Procedure pred;
            final ModuleMethod lambda$Fn1;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi14.scm:737");
                this.lambda$Fn1 = moduleMethod;
            }

            Object lambda1(Object x, Object sum) {
                return KawaConvert.isTrue(this.pred.apply1(x)) ? AddOp.apply2(1, sum, srfi14.Lit1) : sum;
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

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                if (moduleMethod.selector == 1) {
                    return this.lambda1(object2, object3);
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.pred = pred;
        return ((Number)Promise.force(srfi14.charSetFold($heapFrame.lambda$Fn1, Lit2, cs))).intValue();
    }

    public static LList charSet$To$List(CharSet cs) {
        return cs.toList();
    }

    public static String charSet$To$String(CharSet cs) {
        CharSequence charSequence = strings.list$To$String(srfi14.charSet$To$List(cs));
        return charSequence == null ? null : ((Object)charSequence).toString();
    }

    @SourceMethodType(value={"", "", "character"})
    public static boolean isCharSetContains(CharSet cs, int n) {
        return cs.isContains(n);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean charSetEvery(Procedure pred, CharSet cs) {
        v0 = srfi14.charSetCursor(cs);
        do {
            cursor = v0;
            object2 = Promise.force(cursor);
            x = srfi14.isEndOfCharSet(((Number)object2).intValue());
            if (!x) ** break block7
            v1 = x;
            return v1;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "end-of-char-set?", 0, object2);
        }
        {
            
            object2 = Promise.force(cursor);
            if (KawaConvert.isTrue(pred.apply1(Char.make(srfi14.charSetRef(cs, ((Number)object2).intValue())))) == false) return false;
            object2 = Promise.force(cursor);
            v0 = srfi14.charSetCursorNext(cs, ((Number)object2).intValue());
            continue;
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "char-set-ref", 1, object2);
        }
        catch (ClassCastException v4) {
            throw new WrongType(v4, "char-set-cursor-next", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object charSetAny(Procedure pred, CharSet cs) {
        v0 = srfi14.charSetCursor(cs);
        do {
            cursor = v0;
            object4 = Promise.force(cursor);
            if (!srfi14.isEndOfCharSet(((Number)object4).intValue())) ** break block8
            v1 = Boolean.FALSE;
            return v1;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "end-of-char-set?", 0, temp);
        }
        {
            
            object2 = Promise.force(cursor);
            temp = pred.apply1(Char.make(srfi14.charSetRef(cs, ((Number)object2).intValue())));
            if (KawaConvert.isTrue(temp)) {
                v1 = temp;
                return v1;
            }
            object2 = Promise.force(cursor);
            v0 = srfi14.charSetCursorNext(cs, ((Number)object2).intValue());
            continue;
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "char-set-ref", 1, object2);
        }
        catch (ClassCastException v4) {
            throw new WrongType(v4, "char-set-cursor-next", 1, object2);
        }
    }

    @SourceMethodType(value={"", "", "character[]"})
    public static /* varargs */ CharSet charSetAdjoin(CharSet cs, int ... chars) {
        return srfi14.charSetAdjoin$Ex(srfi14.charSetCopy(cs), chars);
    }

    @SourceMethodType(value={"", "", "character[]"})
    public static /* varargs */ CharSet charSetDelete(CharSet cs, int ... chars) {
        return srfi14.charSetDelete$Ex(srfi14.charSetCopy(cs), chars);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SourceMethodType(value={"", "", "character[]"})
    public static /* varargs */ CharSet charSetDelete$Ex(CharSet cs, int ... chars) {
        CharSet to$Mnremove;
        CharSet charSet;
        int tmp = chars.length;
        switch (tmp) {
            case 0: {
                charSet = cs;
                return charSet;
            }
            case 1: {
                charSet = cs.delete$Ex(chars[0]);
                return charSet;
            }
        }
        int n = 1;
        int[] arrn = chars;
        int n2 = MakeSplice.count(arrn);
        n = n2 + n;
        Object[] arrobject = new Object[n];
        arrobject[0] = CharSet.class;
        int n3 = 1;
        MakeSplice.copyTo(arrobject, n3, n2, arrn);
        n3 += n2;
        Object object2 = Promise.force(((Procedure)Invoke.make).applyN(arrobject), CharSet.class);
        try {
            to$Mnremove = (CharSet)object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "to-remove", -2, object2);
        }
        charSet = cs.intersection$Ex(to$Mnremove.complement$Ex());
        return charSet;
    }

    public static CharSet charSetComplement(CharSet cs) {
        return srfi14.charSetComplement$Ex(srfi14.charSetCopy(cs));
    }

    public static CharSet charSetComplement$Ex(CharSet cs) {
        return cs.complement$Ex();
    }

    public static /* varargs */ CharSet charSetUnion(CharSet ... csets) {
        CharSet charSet;
        int tmp = csets.length;
        switch (tmp) {
            case 0: {
                charSet = CharSet.empty;
                break;
            }
            case 1: {
                charSet = csets[0];
                break;
            }
            default: {
                CharSet cs = srfi14.charSetCopy(csets[0]);
                for (int i = 1; i != csets.length; ++i) {
                    cs.union$Ex(csets[i]);
                }
                charSet = cs;
                break;
            }
        }
        return charSet;
    }

    public static /* varargs */ CharSet charSetIntersection(CharSet ... csets) {
        CharSet charSet;
        int tmp = csets.length;
        switch (tmp) {
            case 0: {
                charSet = CharSet.full;
                break;
            }
            case 1: {
                charSet = csets[0];
                break;
            }
            default: {
                CharSet cs = srfi14.charSetCopy(csets[0]);
                for (int i = 1; i != csets.length; ++i) {
                    cs.intersection$Ex(csets[i]);
                }
                charSet = cs;
                break;
            }
        }
        return charSet;
    }

    public static /* varargs */ CharSet charSetDifference(CharSet cs1, CharSet ... csets) {
        CharSet charSet;
        if (csets.length == 0) {
            charSet = cs1;
        } else {
            CharSet rest = srfi14.charSetUnion(csets);
            charSet = srfi14.charSetIntersection(cs1, srfi14.charSetComplement(rest));
        }
        return charSet;
    }

    public static /* varargs */ CharSet charSetXor(CharSet ... csets) {
        CharSet charSet;
        int tmp = csets.length;
        switch (tmp) {
            case 0: {
                charSet = CharSet.empty;
                break;
            }
            case 1: {
                charSet = csets[0];
                break;
            }
            default: {
                CharSet cs = srfi14.charSetCopy(csets[0]);
                for (int i = 1; i != csets.length; ++i) {
                    cs.xor$Ex(csets[i]);
                }
                charSet = cs;
                break;
            }
        }
        return charSet;
    }

    public static /* varargs */ Values charSetDiff$PlIntersection(CharSet cs1, CharSet cs2, CharSet ... csets) {
        int n = 1;
        CharSet[] arrcharSet = csets;
        int n2 = MakeSplice.count(arrcharSet);
        n = n2 + n;
        CharSet[] arrcharSet2 = new CharSet[n];
        arrcharSet2[0] = cs2;
        int n3 = 1;
        MakeSplice.copyTo(arrcharSet2, n3, n2, arrcharSet, Lit3);
        n3 += n2;
        CharSet union = srfi14.charSetUnion(arrcharSet2);
        return Values.values2(srfi14.charSetIntersection(cs1, srfi14.charSetComplement(union)), srfi14.charSetIntersection(cs1, union));
    }

    public static /* varargs */ CharSet charSetIntersection$Ex(CharSet ... csets) {
        CharSet charSet;
        int tmp = csets.length;
        switch (tmp) {
            case 0: {
                charSet = CharSet.full;
                break;
            }
            case 1: {
                charSet = csets[0];
                break;
            }
            default: {
                for (int i = 1; i != csets.length; ++i) {
                    csets[0].intersection$Ex(csets[i]);
                }
                charSet = csets[0];
                break;
            }
        }
        return charSet;
    }

    public static /* varargs */ CharSet charSetDifference$Ex(CharSet cs1, CharSet ... csets) {
        CharSet charSet;
        if (csets.length == 0) {
            charSet = cs1;
        } else {
            CharSet rest = srfi14.charSetUnion(csets);
            charSet = srfi14.charSetIntersection$Ex(cs1, srfi14.charSetComplement(rest));
        }
        return charSet;
    }

    public static /* varargs */ CharSet charSetXor$Ex(CharSet ... csets) {
        CharSet charSet;
        int tmp = csets.length;
        switch (tmp) {
            case 0: {
                charSet = CharSet.empty;
                break;
            }
            case 1: {
                charSet = csets[0];
                break;
            }
            default: {
                for (int i = 1; i != csets.length; ++i) {
                    csets[0].xor$Ex(csets[i]);
                }
                charSet = csets[0];
                break;
            }
        }
        return charSet;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static LList $PcBoundaryPairsIntersection(LList l1, LList l2) {
        int l2b2222;
        void l1a22222222;
        void l2a2222;
        void l1b2222;
        LList lList;
        boolean x = lists.isNull(l1);
        if (x ? x : lists.isNull(l2)) {
            lList = LList.Empty;
            return lList;
        }
        if (NumberCompare.$Gr(lists.caar(l1), lists.cdar(l2))) {
            Object object3 = l1;
            object3 = Promise.force(lists.cdr((Pair)object3), LList.class);
            lList = srfi14.$PcBoundaryPairsIntersection((LList)object3, l2);
            return lList;
        }
        if (NumberCompare.$Gr(lists.caar(l2), lists.cdar(l1))) {
            Object object4 = l2;
            object4 = Promise.force(lists.cdr((Pair)object4), LList.class);
            lList = srfi14.$PcBoundaryPairsIntersection(l1, (LList)object4);
            return lList;
        }
        Object object5 = Promise.force(lists.caar(l1));
        try {
            int n = ((Number)object5).intValue();
        }
        catch (ClassCastException classCastException) {
            void l1b2222;
            throw new WrongType(classCastException, "l1a", -2, (Object)l1b2222);
        }
        Object object6 = Promise.force(lists.cdar(l1));
        try {
            int n2 = ((Number)object6).intValue();
        }
        catch (ClassCastException classCastException) {
            void l2a2222;
            throw new WrongType(classCastException, "l1b", -2, (Object)l2a2222);
        }
        Object object7 = Promise.force(lists.caar(l2));
        try {
            int n3 = ((Number)object7).intValue();
        }
        catch (ClassCastException classCastException) {
            void l2b2222;
            throw new WrongType(classCastException, "l2a", -2, (Object)l2b2222);
        }
        Object object2 = Promise.force(lists.cdar(l2));
        try {
            l2b2222 = ((Number)object2).intValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "l2b", -2, object2);
        }
        if (NumberCompare.$Ls$Eq$V((int)l1a22222222, (int)l2a2222, (int)l1b2222, new Object[]{l2b2222})) {
            Object[] arrobject = new Object[2];
            Object[] arrobject2 = new Object[2];
            object2 = l1;
            arrobject2[0] = lists.cdr((Pair)object2);
            arrobject2[1] = LList.Empty;
            object2 = l2;
            object2 = Promise.force(lists.cdr((Pair)object2), LList.class);
            arrobject[0] = srfi14.$PcBoundaryPairsIntersection(Pair.make(Quote.consX$V(new Object[]{(int)l1a22222222, (int)(l2a2222 - true)}), Quote.append$V(arrobject2)), (LList)object2);
            arrobject[1] = LList.Empty;
            lList = Pair.make(Quote.consX$V(new Object[]{(int)l2a2222, (int)l1b2222}), Quote.append$V(arrobject));
            return lList;
        }
        if (!NumberCompare.$Ls$Eq$V((int)l1a22222222, (int)l2a2222, l2b2222, new Object[]{(int)l1b2222})) {
            lList = srfi14.$PcBoundaryPairsIntersection(l2, l1);
            return lList;
        }
        Object[] arrobject = new Object[2];
        object2 = l2;
        try {
            arrobject[0] = lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        Object[] arrobject3 = new Object[2];
        Object[] arrobject4 = new Object[2];
        object2 = l1;
        try {
            arrobject4[0] = lists.cdr((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        arrobject4[1] = LList.Empty;
        object2 = l2;
        try {
            object2 = Promise.force(lists.cdr((Pair)object2), LList.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        try {
            arrobject3[0] = srfi14.$PcBoundaryPairsIntersection(Pair.make(Quote.consX$V(new Object[]{(int)l1a22222222, (int)(l2a2222 - true)}), Quote.append$V(arrobject4)), (LList)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%boundary-pairs-intersection", 1, object2);
        }
        arrobject3[1] = LList.Empty;
        arrobject[1] = Quote.append$V(arrobject3);
        lList = (LList)Promise.force(Quote.consX$V(arrobject), LList.class);
        return lList;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)l1a22222222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%boundary-pairs-intersection", 0, (Object)l1a22222222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)l1a22222222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%boundary-pairs-intersection", 1, (Object)l1a22222222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%boundary-pairs-intersection", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    static LList $PcBoundaryPairsUnion(LList l1, LList l2) {
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
     * Exception decompiling
     */
    static LList $PcBoundaryPairsXor(LList l1, LList l2) {
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

    static CharSet $PcMakeBuiltin(Object nm, int[] arr) {
        new CharSet(new int[0]).inversion$Mnlist = arr;
        new CharSet(new int[0]).inversion$Mnlist$Mnsize = arr.length;
        Object object2 = Promise.force(nm, String.class);
        new CharSet(new int[0]).name = object2 == null ? null : object2.toString();
        new CharSet(new int[0]).immutable$Qu = true;
        return new CharSet(new int[0]);
    }

    static LList $PcMakeBoundaryPairs(int[] arr, int len) {
        public class Frame0
        extends ModuleBody {
            int[] arr;
            int len;

            public LList lambda2makePairs(int i) {
                return i == this.len ? LList.Empty : lists.cons(lists.cons(this.arr[1 + i], this.arr[i] - 1), this.lambda2makePairs(i + 2));
            }
        }
        Frame0 $heapFrame = new Frame0();
        $heapFrame.arr = arr;
        $heapFrame.len = len;
        return $heapFrame.len == 0 ? LList.Empty : (1 - ($heapFrame.len & 1) != 0 ? $heapFrame.lambda2makePairs(0) : lists.cons(lists.cons($heapFrame.arr[0], Lit4), $heapFrame.lambda2makePairs(1)));
    }

    static int $PcBoundaryPairsLength(LList l) {
        int size = 0;
        LList l2 = l;
        while (!lists.isNull(l2)) {
            LList lList;
            if (NumberCompare.$Eq(Lit4, lists.cdar(l2))) {
                lList = l2;
                ++size;
                {
                    l2 = (LList)Promise.force(lists.cdr((Pair)lList), LList.class);
                }
                continue;
            }
            lList = l2;
            size += 2;
            {
                l2 = (LList)Promise.force(lists.cdr((Pair)lList), LList.class);
            }
        }
        return size;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object $PcWriteInversionList(int[] arr, LList l, int len) {
        block9 : {
            if (len <= 0) {
                v0 = Values.empty;
                return v0;
            }
            if (NumberCompare.$Eq(srfi14.Lit4, lists.cdar(l))) {
                arr[0] = ((Number)Promise.force(lists.caar(l))).intValue();
                v1 = 1;
                var3_3 = l;
                v2 = (LList)Promise.force(lists.cdr((Pair)var3_3), LList.class);
                ** GOTO lbl16
            } else {
                v1 = 0;
                v2 = l;
            }
            break block9;
            catch (ClassCastException v3) {
                throw new WrongType(v3, "cdr", 1, (Object)i);
            }
        }
        var4_5 = v2;
        i = v1;
        do {
            if (i >= len) {
                v0 = Values.empty;
                return v0;
            }
            arr[i] = ((Number)Promise.force(AddOp.apply2(1, srfi14.Lit1, lists.cdar(l)))).intValue();
            arr[i + 1] = ((Number)Promise.force(lists.caar(l))).intValue();
            var5_6 = l;
            try {
                l = (LList)Promise.force(lists.cdr((Pair)var5_6), LList.class);
                i += 2;
            }
            catch (ClassCastException v4) {
                throw new WrongType(v4, "cdr", 1, (Object)var5_6);
            }
        } while (true);
    }

    /*
     * Opcode count of 30992 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    public static {
        Lit51 = Symbol.valueOf("%boundary-pairs-xor");
        Lit50 = Symbol.valueOf("%boundary-pairs-union");
        Lit49 = Symbol.valueOf("%boundary-pairs-intersection");
        Lit48 = Symbol.valueOf("char-set-xor!");
        Lit47 = Symbol.valueOf("char-set-difference!");
        Lit46 = Symbol.valueOf("char-set-intersection!");
        Lit45 = Symbol.valueOf("char-set-union!");
        Lit44 = Symbol.valueOf("char-set-complement!");
        Lit43 = Symbol.valueOf("char-set-diff+intersection");
        Lit42 = Symbol.valueOf("char-set-xor");
        Lit41 = Symbol.valueOf("char-set-difference");
        Lit40 = Symbol.valueOf("char-set-intersection");
        Lit39 = Symbol.valueOf("char-set-union");
        Lit38 = Symbol.valueOf("char-set-complement");
        Lit37 = Symbol.valueOf("char-set-delete!");
        Lit36 = Symbol.valueOf("char-set-adjoin!");
        Lit35 = Symbol.valueOf("char-set-delete");
        Lit34 = Symbol.valueOf("char-set-adjoin");
        Lit33 = Symbol.valueOf("char-set-any");
        Lit32 = Symbol.valueOf("char-set-every");
        Lit31 = Symbol.valueOf("char-set-contains?");
        Lit30 = Symbol.valueOf("char-set->string");
        Lit29 = Symbol.valueOf("char-set->list");
        Lit28 = Symbol.valueOf("char-set-count");
        Lit27 = Symbol.valueOf("char-set-size");
        Lit26 = Symbol.valueOf("->char-set");
        Lit25 = Symbol.valueOf("ucs-range->char-set!");
        Lit24 = Symbol.valueOf("ucs-range->char-set");
        Lit23 = Symbol.valueOf("char-set-filter!");
        Lit22 = Symbol.valueOf("char-set-filter");
        Lit21 = Symbol.valueOf("string->char-set!");
        Lit20 = Symbol.valueOf("string->char-set");
        Lit19 = Symbol.valueOf("list->char-set!");
        Lit18 = Symbol.valueOf("list->char-set");
        Lit17 = Symbol.valueOf("char-set-copy");
        Lit16 = Symbol.valueOf("char-set-map");
        Lit15 = Symbol.valueOf("char-set-for-each");
        Lit14 = Symbol.valueOf("char-set-unfold!");
        Lit13 = Symbol.valueOf("char-set-unfold");
        Lit12 = Symbol.valueOf("char-set-fold");
        Lit11 = Symbol.valueOf("end-of-char-set?");
        Lit10 = Symbol.valueOf("char-set-cursor-next");
        Lit9 = Symbol.valueOf("char-set-ref");
        Lit8 = Symbol.valueOf("char-set-cursor");
        Lit7 = Symbol.valueOf("char-set-hash");
        Lit6 = Symbol.valueOf("char-set<=");
        Lit5 = Symbol.valueOf("char-set=");
        Lit4 = 1114111;
        Lit3 = (ClassType)Type.make(CharSet.class);
        Lit2 = IntNum.valueOf(0);
        Lit1 = IntNum.valueOf(1);
        Lit0 = Symbol.valueOf("done");
        $Prvt$Arrays = Arrays.class;
        $Prvt$reflectArray = Array.class;
        $instance = new srfi14();
        $Pctitle$Mncase = new int[]{8189, 8188, 8141, 8140, 8125, 8124, 8112, 8104, 8096, 8088, 8080, 8072, 499, 498, 460, 459, 457, 456, 454, 453};
        $Pcwhitespace = new int[]{12289, 12288, 8288, 8287, 8240, 8239, 8234, 8232, 8203, 8192, 6159, 6158, 5761, 5760, 161, 160, 33, 32, 14, 9};
        $Pcblank = new int[]{12289, 12288, 8288, 8287, 8240, 8239, 8203, 8192, 6159, 6158, 5761, 5760, 161, 160, 33, 32, 10, 9};
        $Pclower$Mncase = new int[]{120780, 120779, 120778, 120772, 120771, 120746, 120720, 120714, 120713, 120688, 120662, 120656, 120655, 120630, 120604, 120598, 120597, 120572, 120546, 120540, 120539, 120514, 120486, 120458, 120432, 120406, 120380, 120354, 120328, 120302, 120276, 120250, 120224, 120198, 120172, 120146, 120120, 120094, 120068, 120042, 120016, 120005, 120004, 119997, 119996, 119995, 119994, 119990, 119964, 119938, 119912, 119894, 119893, 119886, 119860, 119834, 66640, 66600, 65371, 65345, 64280, 64275, 64263, 64256, 43003, 43000, 42922, 42921, 42920, 42919, 42918, 42917, 42916, 42915, 42914, 42913, 42900, 42899, 42898, 42897, 42895, 42894, 42893, 42892, 42888, 42887, 42886, 42885, 42884, 42883, 42882, 42881, 42880, 42879, 42877, 42876, 42875, 42874, 42873, 42863, 42862, 42861, 42860, 42859, 42858, 42857, 42856, 42855, 42854, 42853, 42852, 42851, 42850, 42849, 42848, 42847, 42846, 42845, 42844, 42843, 42842, 42841, 42840, 42839, 42838, 42837, 42836, 42835, 42834, 42833, 42832, 42831, 42830, 42829, 42828, 42827, 42826, 42825, 42824, 42823, 42822, 42821, 42820, 42819, 42818, 42817, 42816, 42815, 42814, 42813, 42812, 42811, 42810, 42809, 42808, 42807, 42806, 42805, 42804, 42803, 42802, 42799, 42798, 42797, 42796, 42795, 42794, 42793, 42792, 42791, 42790, 42789, 42788, 42787, 42648, 42647, 42646, 42645, 42644, 42643, 42642, 42641, 42640, 42639, 42638, 42637, 42636, 42635, 42634, 42633, 42632, 42631, 42630, 42629, 42628, 42627, 42626, 42625, 42606, 42605, 42604, 42603, 42602, 42601, 42600, 42599, 42598, 42597, 42596, 42595, 42594, 42593, 42592, 42591, 42590, 42589, 42588, 42587, 42586, 42585, 42584, 42583, 42582, 42581, 42580, 42579, 42578, 42577, 42576, 42575, 42574, 42573, 42572, 42571, 42570, 42569, 42568, 42567, 42566, 42565, 42564, 42563, 42562, 42561, 11566, 11565, 11560, 11559, 11558, 11520, 11508, 11507, 11503, 11502, 11501, 11500, 11493, 11491, 11490, 11489, 11488, 11487, 11486, 11485, 11484, 11483, 11482, 11481, 11480, 11479, 11478, 11477, 11476, 11475, 11474, 11473, 11472, 11471, 11470, 11469, 11468, 11467, 11466, 11465, 11464, 11463, 11462, 11461, 11460, 11459, 11458, 11457, 11456, 11455, 11454, 11453, 11452, 11451, 11450, 11449, 11448, 11447, 11446, 11445, 11444, 11443, 11442, 11441, 11440, 11439, 11438, 11437, 11436, 11435, 11434, 11433, 11432, 11431, 11430, 11429, 11428, 11427, 11426, 11425, 11424, 11423, 11422, 11421, 11420, 11419, 11418, 11417, 11416, 11415, 11414, 11413, 11412, 11411, 11410, 11409, 11408, 11407, 11406, 11405, 11404, 11403, 11402, 11401, 11400, 11399, 11398, 11397, 11396, 11395, 11394, 11393, 11390, 11382, 11381, 11379, 11378, 11377, 11373, 11372, 11371, 11370, 11369, 11368, 11367, 11365, 11362, 11361, 11359, 11312, 9450, 9424, 8581, 8580, 8576, 8560, 8527, 8526, 8522, 8518, 8510, 8508, 8506, 8505, 8501, 8500, 8496, 8495, 8468, 8467, 8464, 8462, 8459, 8458, 8349, 8336, 8320, 8319, 8306, 8305, 8184, 8182, 8181, 8178, 8168, 8160, 8152, 8150, 8148, 8144, 8136, 8134, 8133, 8130, 8127, 8126, 8120, 8118, 8117, 8112, 8104, 8096, 8088, 8080, 8072, 8064, 8062, 8048, 8040, 8032, 8024, 8016, 8006, 8000, 7992, 7984, 7976, 7968, 7958, 7952, 7944, 7935, 7934, 7933, 7932, 7931, 7930, 7929, 7928, 7927, 7926, 7925, 7924, 7923, 7922, 7921, 7920, 7919, 7918, 7917, 7916, 7915, 7914, 7913, 7912, 7911, 7910, 7909, 7908, 7907, 7906, 7905, 7904, 7903, 7902, 7901, 7900, 7899, 7898, 7897, 7896, 7895, 7894, 7893, 7892, 7891, 7890, 7889, 7888, 7887, 7886, 7885, 7884, 7883, 7882, 7881, 7880, 7879, 7878, 7877, 7876, 7875, 7874, 7873, 7872, 7871, 7870, 7869, 7868, 7867, 7866, 7865, 7864, 7863, 7862, 7861, 7860, 7859, 7858, 7857, 7856, 7855, 7854, 7853, 7852, 7851, 7850, 7849, 7848, 7847, 7846, 7845, 7844, 7843, 7842, 7841, 7840, 7839, 7838, 7829, 7828, 7827, 7826, 7825, 7824, 7823, 7822, 7821, 7820, 7819, 7818, 7817, 7816, 7815, 7814, 7813, 7812, 7811, 7810, 7809, 7808, 7807, 7806, 7805, 7804, 7803, 7802, 7801, 7800, 7799, 7798, 7797, 7796, 7795, 7794, 7793, 7792, 7791, 7790, 7789, 7788, 7787, 7786, 7785, 7784, 7783, 7782, 7781, 7780, 7779, 7778, 7777, 7776, 7775, 7774, 7773, 7772, 7771, 7770, 7769, 7768, 7767, 7766, 7765, 7764, 7763, 7762, 7761, 7760, 7759, 7758, 7757, 7756, 7755, 7754, 7753, 7752, 7751, 7750, 7749, 7748, 7747, 7746, 7745, 7744, 7743, 7742, 7741, 7740, 7739, 7738, 7737, 7736, 7735, 7734, 7733, 7732, 7731, 7730, 7729, 7728, 7727, 7726, 7725, 7724, 7723, 7722, 7721, 7720, 7719, 7718, 7717, 7716, 7715, 7714, 7713, 7712, 7711, 7710, 7709, 7708, 7707, 7706, 7705, 7704, 7703, 7702, 7701, 7700, 7699, 7698, 7697, 7696, 7695, 7694, 7693, 7692, 7691, 7690, 7689, 7688, 7687, 7686, 7685, 7684, 7683, 7682, 7681, 7616, 7424, 1416, 1377, 1320, 1319, 1318, 1317, 1316, 1315, 1314, 1313, 1312, 1311, 1310, 1309, 1308, 1307, 1306, 1305, 1304, 1303, 1302, 1301, 1300, 1299, 1298, 1297, 1296, 1295, 1294, 1293, 1292, 1291, 1290, 1289, 1288, 1287, 1286, 1285, 1284, 1283, 1282, 1281, 1280, 1279, 1278, 1277, 1276, 1275, 1274, 1273, 1272, 1271, 1270, 1269, 1268, 1267, 1266, 1265, 1264, 1263, 1262, 1261, 1260, 1259, 1258, 1257, 1256, 1255, 1254, 1253, 1252, 1251, 1250, 1249, 1248, 1247, 1246, 1245, 1244, 1243, 1242, 1241, 1240, 1239, 1238, 1237, 1236, 1235, 1234, 1233, 1232, 1230, 1229, 1228, 1227, 1226, 1225, 1224, 1223, 1222, 1221, 1220, 1219, 1218, 1216, 1215, 1214, 1213, 1212, 1211, 1210, 1209, 1208, 1207, 1206, 1205, 1204, 1203, 1202, 1201, 1200, 1199, 1198, 1197, 1196, 1195, 1194, 1193, 1192, 1191, 1190, 1189, 1188, 1187, 1186, 1185, 1184, 1183, 1182, 1181, 1180, 1179, 1178, 1177, 1176, 1175, 1174, 1173, 1172, 1171, 1170, 1169, 1168, 1167, 1166, 1165, 1164, 1163, 1154, 1153, 1152, 1151, 1150, 1149, 1148, 1147, 1146, 1145, 1144, 1143, 1142, 1141, 1140, 1139, 1138, 1137, 1136, 1135, 1134, 1133, 1132, 1131, 1130, 1129, 1128, 1127, 1126, 1125, 1124, 1123, 1122, 1121, 1120, 1072, 1021, 1019, 1017, 1016, 1014, 1013, 1012, 1007, 1006, 1005, 1004, 1003, 1002, 1001, 1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 981, 978, 976, 975, 940, 913, 912, 894, 890, 888, 887, 884, 883, 882, 881, 838, 837, 741, 736, 706, 704, 697, 661, 660, 591, 590, 589, 588, 587, 586, 585, 584, 583, 579, 578, 577, 575, 573, 572, 570, 563, 562, 561, 560, 559, 558, 557, 556, 555, 554, 553, 552, 551, 550, 549, 548, 547, 546, 545, 544, 543, 542, 541, 540, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 529, 528, 527, 526, 525, 524, 523, 522, 521, 520, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 509, 508, 507, 506, 505, 502, 501, 500, 499, 497, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 483, 482, 481, 480, 479, 478, 476, 475, 474, 473, 472, 471, 470, 469, 468, 467, 466, 465, 464, 463, 462, 461, 460, 458, 457, 455, 454, 448, 445, 443, 441, 439, 438, 437, 436, 433, 432, 430, 429, 428, 426, 425, 424, 422, 421, 420, 419, 418, 417, 415, 414, 412, 409, 406, 405, 403, 402, 398, 396, 393, 392, 390, 389, 388, 387, 385, 382, 381, 380, 379, 378, 376, 375, 374, 373, 372, 371, 370, 369, 368, 367, 366, 365, 364, 363, 362, 361, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 350, 349, 348, 347, 346, 345, 344, 343, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318, 317, 316, 315, 314, 313, 311, 310, 309, 308, 307, 306, 305, 304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292, 291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279, 278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 248, 247, 223, 187, 186, 182, 181, 171, 170, 123, 97};
        $Pcupper$Mncase = new int[]{120779, 120778, 120745, 120720, 120687, 120662, 120629, 120604, 120571, 120546, 120513, 120488, 120458, 120432, 120406, 120380, 120354, 120328, 120302, 120276, 120250, 120224, 120198, 120172, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120120, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120068, 120042, 120016, 119990, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119964, 119938, 119912, 119886, 119860, 119834, 119808, 66600, 66560, 65339, 65313, 42923, 42922, 42921, 42920, 42919, 42918, 42917, 42916, 42915, 42914, 42913, 42912, 42899, 42898, 42897, 42896, 42894, 42893, 42892, 42891, 42887, 42886, 42885, 42884, 42883, 42882, 42881, 42880, 42879, 42877, 42876, 42875, 42874, 42873, 42863, 42862, 42861, 42860, 42859, 42858, 42857, 42856, 42855, 42854, 42853, 42852, 42851, 42850, 42849, 42848, 42847, 42846, 42845, 42844, 42843, 42842, 42841, 42840, 42839, 42838, 42837, 42836, 42835, 42834, 42833, 42832, 42831, 42830, 42829, 42828, 42827, 42826, 42825, 42824, 42823, 42822, 42821, 42820, 42819, 42818, 42817, 42816, 42815, 42814, 42813, 42812, 42811, 42810, 42809, 42808, 42807, 42806, 42805, 42804, 42803, 42802, 42799, 42798, 42797, 42796, 42795, 42794, 42793, 42792, 42791, 42790, 42789, 42788, 42787, 42786, 42647, 42646, 42645, 42644, 42643, 42642, 42641, 42640, 42639, 42638, 42637, 42636, 42635, 42634, 42633, 42632, 42631, 42630, 42629, 42628, 42627, 42626, 42625, 42624, 42605, 42604, 42603, 42602, 42601, 42600, 42599, 42598, 42597, 42596, 42595, 42594, 42593, 42592, 42591, 42590, 42589, 42588, 42587, 42586, 42585, 42584, 42583, 42582, 42581, 42580, 42579, 42578, 42577, 42576, 42575, 42574, 42573, 42572, 42571, 42570, 42569, 42568, 42567, 42566, 42565, 42564, 42563, 42562, 42561, 42560, 11507, 11506, 11502, 11501, 11500, 11499, 11491, 11490, 11489, 11488, 11487, 11486, 11485, 11484, 11483, 11482, 11481, 11480, 11479, 11478, 11477, 11476, 11475, 11474, 11473, 11472, 11471, 11470, 11469, 11468, 11467, 11466, 11465, 11464, 11463, 11462, 11461, 11460, 11459, 11458, 11457, 11456, 11455, 11454, 11453, 11452, 11451, 11450, 11449, 11448, 11447, 11446, 11445, 11444, 11443, 11442, 11441, 11440, 11439, 11438, 11437, 11436, 11435, 11434, 11433, 11432, 11431, 11430, 11429, 11428, 11427, 11426, 11425, 11424, 11423, 11422, 11421, 11420, 11419, 11418, 11417, 11416, 11415, 11414, 11413, 11412, 11411, 11410, 11409, 11408, 11407, 11406, 11405, 11404, 11403, 11402, 11401, 11400, 11399, 11398, 11397, 11396, 11395, 11394, 11393, 11390, 11382, 11381, 11379, 11378, 11377, 11373, 11372, 11371, 11370, 11369, 11368, 11367, 11365, 11362, 11361, 11360, 11311, 11264, 9424, 9398, 8580, 8579, 8560, 8544, 8518, 8517, 8512, 8510, 8500, 8496, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8467, 8464, 8462, 8459, 8456, 8455, 8451, 8450, 8188, 8184, 8173, 8168, 8156, 8152, 8140, 8136, 8124, 8120, 8048, 8040, 8032, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8014, 8008, 8000, 7992, 7984, 7976, 7966, 7960, 7952, 7944, 7935, 7934, 7933, 7932, 7931, 7930, 7929, 7928, 7927, 7926, 7925, 7924, 7923, 7922, 7921, 7920, 7919, 7918, 7917, 7916, 7915, 7914, 7913, 7912, 7911, 7910, 7909, 7908, 7907, 7906, 7905, 7904, 7903, 7902, 7901, 7900, 7899, 7898, 7897, 7896, 7895, 7894, 7893, 7892, 7891, 7890, 7889, 7888, 7887, 7886, 7885, 7884, 7883, 7882, 7881, 7880, 7879, 7878, 7877, 7876, 7875, 7874, 7873, 7872, 7871, 7870, 7869, 7868, 7867, 7866, 7865, 7864, 7863, 7862, 7861, 7860, 7859, 7858, 7857, 7856, 7855, 7854, 7853, 7852, 7851, 7850, 7849, 7848, 7847, 7846, 7845, 7844, 7843, 7842, 7841, 7840, 7839, 7838, 7829, 7828, 7827, 7826, 7825, 7824, 7823, 7822, 7821, 7820, 7819, 7818, 7817, 7816, 7815, 7814, 7813, 7812, 7811, 7810, 7809, 7808, 7807, 7806, 7805, 7804, 7803, 7802, 7801, 7800, 7799, 7798, 7797, 7796, 7795, 7794, 7793, 7792, 7791, 7790, 7789, 7788, 7787, 7786, 7785, 7784, 7783, 7782, 7781, 7780, 7779, 7778, 7777, 7776, 7775, 7774, 7773, 7772, 7771, 7770, 7769, 7768, 7767, 7766, 7765, 7764, 7763, 7762, 7761, 7760, 7759, 7758, 7757, 7756, 7755, 7754, 7753, 7752, 7751, 7750, 7749, 7748, 7747, 7746, 7745, 7744, 7743, 7742, 7741, 7740, 7739, 7738, 7737, 7736, 7735, 7734, 7733, 7732, 7731, 7730, 7729, 7728, 7727, 7726, 7725, 7724, 7723, 7722, 7721, 7720, 7719, 7718, 7717, 7716, 7715, 7714, 7713, 7712, 7711, 7710, 7709, 7708, 7707, 7706, 7705, 7704, 7703, 7702, 7701, 7700, 7699, 7698, 7697, 7696, 7695, 7694, 7693, 7692, 7691, 7690, 7689, 7688, 7687, 7686, 7685, 7684, 7683, 7682, 7681, 7680, 4302, 4301, 4296, 4295, 4294, 4256, 1367, 1329, 1319, 1318, 1317, 1316, 1315, 1314, 1313, 1312, 1311, 1310, 1309, 1308, 1307, 1306, 1305, 1304, 1303, 1302, 1301, 1300, 1299, 1298, 1297, 1296, 1295, 1294, 1293, 1292, 1291, 1290, 1289, 1288, 1287, 1286, 1285, 1284, 1283, 1282, 1281, 1280, 1279, 1278, 1277, 1276, 1275, 1274, 1273, 1272, 1271, 1270, 1269, 1268, 1267, 1266, 1265, 1264, 1263, 1262, 1261, 1260, 1259, 1258, 1257, 1256, 1255, 1254, 1253, 1252, 1251, 1250, 1249, 1248, 1247, 1246, 1245, 1244, 1243, 1242, 1241, 1240, 1239, 1238, 1237, 1236, 1235, 1234, 1233, 1232, 1230, 1229, 1228, 1227, 1226, 1225, 1224, 1223, 1222, 1221, 1220, 1219, 1218, 1216, 1215, 1214, 1213, 1212, 1211, 1210, 1209, 1208, 1207, 1206, 1205, 1204, 1203, 1202, 1201, 1200, 1199, 1198, 1197, 1196, 1195, 1194, 1193, 1192, 1191, 1190, 1189, 1188, 1187, 1186, 1185, 1184, 1183, 1182, 1181, 1180, 1179, 1178, 1177, 1176, 1175, 1174, 1173, 1172, 1171, 1170, 1169, 1168, 1167, 1166, 1165, 1164, 1163, 1162, 1153, 1152, 1151, 1150, 1149, 1148, 1147, 1146, 1145, 1144, 1143, 1142, 1141, 1140, 1139, 1138, 1137, 1136, 1135, 1134, 1133, 1132, 1131, 1130, 1129, 1128, 1127, 1126, 1125, 1124, 1123, 1122, 1121, 1120, 1072, 1021, 1019, 1017, 1016, 1015, 1013, 1012, 1007, 1006, 1005, 1004, 1003, 1002, 1001, 1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 981, 978, 976, 975, 940, 931, 930, 913, 912, 910, 909, 908, 907, 904, 903, 902, 887, 886, 883, 882, 881, 880, 591, 590, 589, 588, 587, 586, 585, 584, 583, 579, 578, 577, 575, 573, 572, 570, 563, 562, 561, 560, 559, 558, 557, 556, 555, 554, 553, 552, 551, 550, 549, 548, 547, 546, 545, 544, 543, 542, 541, 540, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 529, 528, 527, 526, 525, 524, 523, 522, 521, 520, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 509, 508, 507, 506, 505, 502, 501, 500, 498, 497, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 483, 482, 481, 480, 479, 478, 476, 475, 474, 473, 472, 471, 470, 469, 468, 467, 466, 465, 464, 463, 462, 461, 459, 458, 456, 455, 453, 452, 445, 444, 441, 439, 438, 437, 436, 433, 432, 430, 429, 428, 426, 425, 424, 422, 421, 420, 419, 418, 417, 415, 414, 412, 409, 406, 405, 403, 402, 398, 396, 393, 392, 390, 389, 388, 387, 385, 382, 381, 380, 379, 378, 376, 375, 374, 373, 372, 371, 370, 369, 368, 367, 366, 365, 364, 363, 362, 361, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 350, 349, 348, 347, 346, 345, 344, 343, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318, 317, 316, 315, 314, 313, 311, 310, 309, 308, 307, 306, 305, 304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292, 291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279, 278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 223, 216, 215, 192, 91, 65};
        $Pcletter = new int[]{195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120780, 120772, 120771, 120746, 120745, 120714, 120713, 120688, 120687, 120656, 120655, 120630, 120629, 120598, 120597, 120572, 120571, 120540, 120539, 120514, 120513, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74607, 73728, 71339, 71296, 70085, 70081, 70067, 70019, 69927, 69891, 69865, 69840, 69808, 69763, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68416, 68406, 68352, 68221, 68192, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67898, 67872, 67862, 67840, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66718, 66560, 66512, 66504, 66500, 66464, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65382, 65371, 65345, 65339, 65313, 65277, 65142, 65141, 65136, 65020, 65008, 64968, 64914, 64912, 64848, 64830, 64467, 64434, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64298, 64297, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43762, 43755, 43744, 43742, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43642, 43639, 43616, 43596, 43588, 43587, 43584, 43561, 43520, 43472, 43471, 43443, 43396, 43389, 43360, 43335, 43312, 43302, 43274, 43260, 43259, 43256, 43250, 43188, 43138, 43124, 43072, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42891, 42889, 42786, 42784, 42775, 42726, 42656, 42648, 42623, 42607, 42560, 42540, 42538, 42528, 42512, 42509, 42240, 42238, 42192, 42125, 40960, 40909, 19968, 19894, 13312, 12800, 12784, 12731, 12704, 12687, 12593, 12590, 12549, 12544, 12540, 12539, 12449, 12448, 12445, 12439, 12353, 12349, 12347, 12342, 12337, 12295, 12293, 11824, 11823, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11632, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11520, 11508, 11506, 11503, 11499, 11493, 11360, 11359, 11312, 11311, 11264, 8581, 8579, 8527, 8526, 8522, 8517, 8512, 8508, 8506, 8495, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8468, 8458, 8456, 8455, 8451, 8450, 8349, 8336, 8320, 8319, 8306, 8305, 8189, 8182, 8181, 8178, 8173, 8160, 8156, 8150, 8148, 8144, 8141, 8134, 8133, 8130, 8127, 8126, 8125, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7294, 7258, 7248, 7245, 7204, 7168, 7142, 7098, 7088, 7086, 7073, 7043, 6988, 6981, 6964, 6917, 6824, 6823, 6741, 6688, 6679, 6656, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6480, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6109, 6108, 6104, 6103, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5938, 5920, 5906, 5902, 5901, 5888, 5867, 5792, 5787, 5761, 5760, 5743, 5741, 5121, 5109, 5024, 5008, 4992, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4348, 4347, 4304, 4302, 4301, 4296, 4295, 4294, 4256, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4176, 4160, 4159, 4139, 4096, 3981, 3976, 3949, 3913, 3912, 3904, 3841, 3840, 3808, 3804, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3655, 3648, 3636, 3634, 3633, 3585, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3450, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2929, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2546, 2544, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2417, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2137, 2112, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2042, 2038, 2036, 2027, 1994, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1792, 1791, 1789, 1786, 1776, 1774, 1767, 1765, 1750, 1749, 1748, 1649, 1648, 1646, 1611, 1568, 1523, 1520, 1515, 1488, 1416, 1377, 1370, 1369, 1367, 1329, 1320, 1162, 1154, 1015, 1014, 931, 930, 910, 909, 908, 907, 904, 903, 902, 894, 890, 888, 886, 885, 880, 751, 750, 749, 748, 741, 736, 722, 710, 706, 248, 247, 216, 215, 192, 187, 186, 182, 181, 171, 170, 123, 97, 91, 65};
        $Pcdigit = new int[]{120832, 120782, 71370, 71360, 70106, 70096, 69952, 69942, 69882, 69872, 69744, 69734, 66730, 66720, 65306, 65296, 44026, 44016, 43610, 43600, 43482, 43472, 43274, 43264, 43226, 43216, 42538, 42528, 7258, 7248, 7242, 7232, 7098, 7088, 7002, 6992, 6810, 6800, 6794, 6784, 6618, 6608, 6480, 6470, 6170, 6160, 6122, 6112, 4250, 4240, 4170, 4160, 3882, 3872, 3802, 3792, 3674, 3664, 3440, 3430, 3312, 3302, 3184, 3174, 3056, 3046, 2928, 2918, 2800, 2790, 2672, 2662, 2544, 2534, 2416, 2406, 1994, 1984, 1786, 1776, 1642, 1632, 58, 48};
        $Pcpunctuation = new int[]{74868, 74864, 70089, 70085, 69956, 69952, 69826, 69822, 69821, 69819, 69710, 69703, 68416, 68409, 68224, 68223, 68185, 68176, 67904, 67903, 67872, 67871, 67672, 67671, 66513, 66512, 66464, 66463, 65795, 65792, 65382, 65375, 65374, 65373, 65372, 65371, 65344, 65343, 65342, 65339, 65313, 65311, 65308, 65306, 65296, 65292, 65291, 65285, 65284, 65281, 65132, 65130, 65129, 65128, 65124, 65123, 65122, 65108, 65107, 65072, 65050, 65040, 64832, 64830, 44012, 44011, 43762, 43760, 43744, 43742, 43616, 43612, 43488, 43486, 43470, 43457, 43360, 43359, 43312, 43310, 43259, 43256, 43216, 43214, 43128, 43124, 42744, 42738, 42623, 42622, 42612, 42611, 42512, 42509, 42240, 42238, 12540, 12539, 12449, 12448, 12350, 12349, 12337, 12336, 12320, 12308, 12306, 12296, 12292, 12289, 11836, 11824, 11823, 11776, 11633, 11632, 11520, 11518, 11517, 11513, 10750, 10748, 10716, 10712, 10649, 10627, 10224, 10214, 10183, 10181, 10102, 10088, 9003, 9001, 8335, 8333, 8319, 8317, 8287, 8275, 8274, 8261, 8260, 8240, 8232, 8208, 7380, 7379, 7368, 7360, 7296, 7294, 7232, 7227, 7168, 7164, 7009, 7002, 6830, 6824, 6823, 6816, 6688, 6686, 6470, 6468, 6155, 6144, 6107, 6104, 6103, 6100, 5943, 5941, 5870, 5867, 5789, 5787, 5743, 5741, 5121, 5120, 4969, 4960, 4348, 4347, 4176, 4170, 4059, 4057, 4053, 4048, 3974, 3973, 3902, 3898, 3861, 3860, 3859, 3844, 3676, 3674, 3664, 3663, 3573, 3572, 2801, 2800, 2417, 2416, 2406, 2404, 2143, 2142, 2111, 2096, 2042, 2039, 1806, 1792, 1749, 1748, 1646, 1642, 1568, 1566, 1564, 1563, 1550, 1548, 1547, 1545, 1525, 1523, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1419, 1417, 1376, 1370, 904, 903, 895, 894, 192, 191, 188, 187, 184, 182, 172, 171, 168, 167, 162, 161, 126, 125, 124, 123, 96, 95, 94, 91, 65, 63, 60, 58, 48, 44, 43, 37, 36, 33};
        $Pcsymbol = new int[]{128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 120772, 120771, 120746, 120745, 120714, 120713, 120688, 120687, 120656, 120655, 120630, 120629, 120598, 120597, 120572, 120571, 120540, 120539, 120514, 120513, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65534, 65532, 65519, 65512, 65511, 65504, 65375, 65374, 65373, 65372, 65345, 65344, 65343, 65342, 65311, 65308, 65292, 65291, 65285, 65284, 65130, 65129, 65127, 65124, 65123, 65122, 65022, 65020, 64450, 64434, 64298, 64297, 43642, 43639, 43066, 43062, 43052, 43048, 42891, 42889, 42786, 42784, 42775, 42752, 42183, 42128, 19968, 19904, 13312, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12800, 12772, 12736, 12704, 12694, 12690, 12688, 12445, 12443, 12352, 12350, 12344, 12342, 12321, 12320, 12308, 12306, 12293, 12292, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11499, 11493, 11098, 11088, 11085, 10750, 10748, 10716, 10712, 10649, 10627, 10224, 10214, 10183, 10181, 10132, 10088, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 9003, 9001, 8592, 8528, 8527, 8526, 8522, 8517, 8512, 8508, 8506, 8495, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8468, 8458, 8456, 8455, 8451, 8450, 8448, 8379, 8352, 8333, 8330, 8317, 8314, 8275, 8274, 8261, 8260, 8191, 8189, 8176, 8173, 8160, 8157, 8144, 8141, 8130, 8127, 8126, 8125, 7037, 7028, 7019, 7009, 6656, 6622, 6465, 6464, 6108, 6107, 5018, 5008, 4256, 4254, 4057, 4053, 4048, 4046, 4045, 4039, 4038, 4030, 3897, 3896, 3895, 3894, 3893, 3892, 3872, 3866, 3864, 3861, 3860, 3859, 3844, 3841, 3648, 3647, 3450, 3449, 3200, 3199, 3067, 3059, 2929, 2928, 2802, 2801, 2556, 2554, 2548, 2546, 2039, 2038, 1791, 1789, 1770, 1769, 1759, 1758, 1552, 1550, 1548, 1547, 1545, 1542, 1424, 1423, 1155, 1154, 1015, 1014, 902, 900, 886, 885, 768, 751, 750, 749, 748, 741, 736, 722, 710, 706, 248, 247, 216, 215, 185, 184, 181, 180, 178, 174, 173, 172, 170, 168, 167, 162, 127, 126, 125, 124, 97, 96, 95, 94, 63, 60, 44, 43, 37, 36};
        $Pcletter$Pldigit = new int[]{195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120772, 120771, 120746, 120745, 120714, 120713, 120688, 120687, 120656, 120655, 120630, 120629, 120598, 120597, 120572, 120571, 120540, 120539, 120514, 120513, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70085, 70081, 70067, 70019, 69952, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69808, 69763, 69744, 69734, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68416, 68406, 68352, 68221, 68192, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67898, 67872, 67862, 67840, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66512, 66504, 66500, 66464, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65382, 65371, 65345, 65339, 65313, 65306, 65296, 65277, 65142, 65141, 65136, 65020, 65008, 64968, 64914, 64912, 64848, 64830, 64467, 64434, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64298, 64297, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43762, 43755, 43744, 43742, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43642, 43639, 43616, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43482, 43471, 43443, 43396, 43389, 43360, 43335, 43312, 43302, 43264, 43260, 43259, 43256, 43250, 43226, 43216, 43188, 43138, 43124, 43072, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42891, 42889, 42786, 42784, 42775, 42726, 42656, 42648, 42623, 42607, 42560, 42540, 42512, 42509, 42240, 42238, 42192, 42125, 40960, 40909, 19968, 19894, 13312, 12800, 12784, 12731, 12704, 12687, 12593, 12590, 12549, 12544, 12540, 12539, 12449, 12448, 12445, 12439, 12353, 12349, 12347, 12342, 12337, 12295, 12293, 11824, 11823, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11632, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11520, 11508, 11506, 11503, 11499, 11493, 11360, 11359, 11312, 11311, 11264, 8581, 8579, 8527, 8526, 8522, 8517, 8512, 8508, 8506, 8495, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8468, 8458, 8456, 8455, 8451, 8450, 8349, 8336, 8320, 8319, 8306, 8305, 8189, 8182, 8181, 8178, 8173, 8160, 8156, 8150, 8148, 8144, 8141, 8134, 8133, 8130, 8127, 8126, 8125, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7294, 7245, 7242, 7232, 7204, 7168, 7142, 7086, 7073, 7043, 7002, 6992, 6988, 6981, 6964, 6917, 6824, 6823, 6810, 6800, 6794, 6784, 6741, 6688, 6679, 6656, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6470, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6122, 6112, 6109, 6108, 6104, 6103, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5938, 5920, 5906, 5902, 5901, 5888, 5867, 5792, 5787, 5761, 5760, 5743, 5741, 5121, 5109, 5024, 5008, 4992, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4348, 4347, 4304, 4302, 4301, 4296, 4295, 4294, 4256, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4176, 4170, 4159, 4139, 4096, 3981, 3976, 3949, 3913, 3912, 3904, 3882, 3872, 3841, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3674, 3664, 3655, 3648, 3636, 3634, 3633, 3585, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3450, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2929, 2928, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2800, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2546, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2417, 2416, 2406, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2137, 2112, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2042, 2038, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1792, 1791, 1789, 1774, 1767, 1765, 1750, 1749, 1748, 1649, 1648, 1646, 1642, 1632, 1611, 1568, 1523, 1520, 1515, 1488, 1416, 1377, 1370, 1369, 1367, 1329, 1320, 1162, 1154, 1015, 1014, 931, 930, 910, 909, 908, 907, 904, 903, 902, 894, 890, 888, 886, 885, 880, 751, 750, 749, 748, 741, 736, 722, 710, 706, 248, 247, 216, 215, 192, 187, 186, 182, 181, 171, 170, 123, 97, 91, 65, 58, 48};
        $Pcgraphic = new int[]{195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74868, 74864, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70089, 70081, 70067, 70019, 69956, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69826, 69822, 69821, 69819, 69808, 69763, 69744, 69734, 69710, 69703, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68409, 68406, 68352, 68224, 68223, 68221, 68192, 68185, 68176, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67904, 67903, 67898, 67871, 67862, 67840, 67672, 67671, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66513, 66504, 66500, 66463, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65795, 65792, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65534, 65532, 65519, 65512, 65511, 65504, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65281, 65277, 65142, 65141, 65136, 65132, 65128, 65127, 65108, 65107, 65072, 65050, 65040, 65022, 65008, 64968, 64914, 64912, 64848, 64832, 64467, 64450, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44012, 44011, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43760, 43755, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43612, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43488, 43486, 43482, 43471, 43470, 43457, 43443, 43396, 43389, 43359, 43335, 43310, 43302, 43264, 43260, 43250, 43226, 43214, 43188, 43138, 43128, 43072, 43066, 43062, 43052, 43048, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42752, 42744, 42738, 42726, 42656, 42648, 42622, 42612, 42611, 42607, 42560, 42540, 42192, 42183, 42128, 42125, 40960, 40909, 19904, 19894, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12784, 12772, 12736, 12731, 12694, 12690, 12688, 12687, 12593, 12590, 12549, 12544, 12443, 12439, 12353, 12352, 12347, 12344, 12336, 12321, 12296, 12295, 12289, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11836, 11776, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11633, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11518, 11517, 11513, 11508, 11506, 11503, 11360, 11359, 11312, 11311, 11264, 11098, 11088, 11085, 10132, 10102, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 8592, 8581, 8579, 8528, 8448, 8379, 8352, 8349, 8336, 8335, 8330, 8320, 8314, 8306, 8305, 8287, 8240, 8232, 8208, 8191, 8182, 8181, 8178, 8176, 8157, 8156, 8150, 8148, 8134, 8133, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7380, 7379, 7368, 7360, 7296, 7245, 7242, 7227, 7204, 7164, 7142, 7086, 7073, 7043, 7037, 7028, 7019, 6992, 6988, 6981, 6964, 6917, 6830, 6816, 6810, 6800, 6794, 6784, 6741, 6686, 6679, 6622, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6468, 6465, 6464, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6155, 6144, 6122, 6112, 6109, 6100, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5943, 5941, 5938, 5920, 5906, 5902, 5901, 5888, 5870, 5792, 5789, 5761, 5760, 5120, 5109, 5024, 5018, 4992, 4969, 4960, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4304, 4302, 4301, 4296, 4295, 4294, 4254, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4159, 4139, 4096, 4059, 4046, 4045, 4039, 4038, 4030, 3981, 3976, 3974, 3973, 3949, 3913, 3912, 3904, 3902, 3898, 3897, 3896, 3895, 3894, 3893, 3892, 3882, 3866, 3864, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3676, 3663, 3655, 3647, 3636, 3634, 3633, 3585, 3573, 3572, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3449, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3200, 3199, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3067, 3059, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2802, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2556, 2554, 2548, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2404, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2143, 2142, 2137, 2112, 2111, 2096, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1806, 1774, 1770, 1769, 1767, 1765, 1759, 1758, 1750, 1649, 1648, 1632, 1611, 1566, 1564, 1563, 1552, 1542, 1525, 1520, 1515, 1488, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1424, 1423, 1419, 1417, 1416, 1377, 1376, 1369, 1367, 1329, 1320, 1162, 1155, 931, 930, 910, 909, 908, 907, 900, 895, 890, 888, 880, 768, 191, 188, 186, 185, 180, 178, 174, 173, 161, 127, 33};
        $Pcprinting = new int[]{195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74868, 74864, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70089, 70081, 70067, 70019, 69956, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69826, 69822, 69821, 69819, 69808, 69763, 69744, 69734, 69710, 69703, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68409, 68406, 68352, 68224, 68223, 68221, 68192, 68185, 68176, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67904, 67903, 67898, 67871, 67862, 67840, 67672, 67671, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66513, 66504, 66500, 66463, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65795, 65792, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65534, 65532, 65519, 65512, 65511, 65504, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65281, 65277, 65142, 65141, 65136, 65132, 65128, 65127, 65108, 65107, 65072, 65050, 65040, 65022, 65008, 64968, 64914, 64912, 64848, 64832, 64467, 64450, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44012, 44011, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43760, 43755, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43612, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43488, 43486, 43482, 43471, 43470, 43457, 43443, 43396, 43389, 43359, 43335, 43310, 43302, 43264, 43260, 43250, 43226, 43214, 43188, 43138, 43128, 43072, 43066, 43062, 43052, 43048, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42752, 42744, 42738, 42726, 42656, 42648, 42622, 42612, 42611, 42607, 42560, 42540, 42192, 42183, 42128, 42125, 40960, 40909, 19904, 19894, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12784, 12772, 12736, 12731, 12694, 12690, 12688, 12687, 12593, 12590, 12549, 12544, 12443, 12439, 12353, 12352, 12347, 12344, 12336, 12321, 12296, 12295, 12288, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11836, 11776, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11633, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11518, 11517, 11513, 11508, 11506, 11503, 11360, 11359, 11312, 11311, 11264, 11098, 11088, 11085, 10132, 10102, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 8592, 8581, 8579, 8528, 8448, 8379, 8352, 8349, 8336, 8335, 8330, 8320, 8314, 8306, 8305, 8288, 8239, 8234, 8208, 8203, 8192, 8191, 8182, 8181, 8178, 8176, 8157, 8156, 8150, 8148, 8134, 8133, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7380, 7379, 7368, 7360, 7296, 7245, 7242, 7227, 7204, 7164, 7142, 7086, 7073, 7043, 7037, 7028, 7019, 6992, 6988, 6981, 6964, 6917, 6830, 6816, 6810, 6800, 6794, 6784, 6741, 6686, 6679, 6622, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6468, 6465, 6464, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6159, 6158, 6155, 6144, 6122, 6112, 6109, 6100, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5943, 5941, 5938, 5920, 5906, 5902, 5901, 5888, 5870, 5792, 5789, 5120, 5109, 5024, 5018, 4992, 4969, 4960, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4304, 4302, 4301, 4296, 4295, 4294, 4254, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4159, 4139, 4096, 4059, 4046, 4045, 4039, 4038, 4030, 3981, 3976, 3974, 3973, 3949, 3913, 3912, 3904, 3902, 3898, 3897, 3896, 3895, 3894, 3893, 3892, 3882, 3866, 3864, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3676, 3663, 3655, 3647, 3636, 3634, 3633, 3585, 3573, 3572, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3449, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3200, 3199, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3067, 3059, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2802, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2556, 2554, 2548, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2404, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2143, 2142, 2137, 2112, 2111, 2096, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1806, 1774, 1770, 1769, 1767, 1765, 1759, 1758, 1750, 1649, 1648, 1632, 1611, 1566, 1564, 1563, 1552, 1542, 1525, 1520, 1515, 1488, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1424, 1423, 1419, 1417, 1416, 1377, 1376, 1369, 1367, 1329, 1320, 1162, 1155, 931, 930, 910, 909, 908, 907, 900, 895, 890, 888, 880, 768, 191, 188, 186, 185, 180, 178, 174, 173, 160, 127, 32, 14, 9};
        srfi14 srfi142 = $instance;
        char$Mnset$Eq = new ModuleMethod(srfi142, 2, Lit5, -4096);
        char$Mnset$Ls$Eq = new ModuleMethod(srfi142, 3, Lit6, -4096);
        char$Mnset$Mnhash = new ModuleMethod(srfi142, 4, Lit7, 8193);
        char$Mnset$Mncursor = new ModuleMethod(srfi142, 6, Lit8, 4097);
        char$Mnset$Mnref = new ModuleMethod(srfi142, 7, Lit9, 8194);
        char$Mnset$Mncursor$Mnnext = new ModuleMethod(srfi142, 8, Lit10, 8194);
        end$Mnof$Mnchar$Mnset$Qu = new ModuleMethod(srfi142, 9, Lit11, 4097);
        char$Mnset$Mnfold = new ModuleMethod(srfi142, 10, Lit12, 12291);
        char$Mnset$Mnunfold = new ModuleMethod(srfi142, 11, Lit13, 20484);
        char$Mnset$Mnunfold$Ex = new ModuleMethod(srfi142, 13, Lit14, 20485);
        char$Mnset$Mnfor$Mneach = new ModuleMethod(srfi142, 14, Lit15, 8194);
        char$Mnset$Mnmap = new ModuleMethod(srfi142, 15, Lit16, 8194);
        char$Mnset$Mncopy = new ModuleMethod(srfi142, 16, Lit17, 4097);
        char$Mnset = CharSet.class;
        list$Mn$Grchar$Mnset = new ModuleMethod(srfi142, 17, Lit18, 8193);
        list$Mn$Grchar$Mnset$Ex = new ModuleMethod(srfi142, 19, Lit19, 8194);
        string$Mn$Grchar$Mnset = new ModuleMethod(srfi142, 20, Lit20, 8193);
        string$Mn$Grchar$Mnset$Ex = new ModuleMethod(srfi142, 22, Lit21, 8194);
        char$Mnset$Mnfilter = new ModuleMethod(srfi142, 23, Lit22, 12290);
        char$Mnset$Mnfilter$Ex = new ModuleMethod(srfi142, 25, Lit23, 12291);
        ucs$Mnrange$Mn$Grchar$Mnset = new ModuleMethod(srfi142, 26, Lit24, 16386);
        ucs$Mnrange$Mn$Grchar$Mnset$Ex = new ModuleMethod(srfi142, 29, Lit25, 16388);
        $Mn$Grchar$Mnset = new ModuleMethod(srfi142, 30, Lit26, 4097);
        char$Mnset$Mnsize = new ModuleMethod(srfi142, 31, Lit27, 4097);
        char$Mnset$Mncount = new ModuleMethod(srfi142, 32, Lit28, 8194);
        char$Mnset$Mn$Grlist = new ModuleMethod(srfi142, 33, Lit29, 4097);
        char$Mnset$Mn$Grstring = new ModuleMethod(srfi142, 34, Lit30, 4097);
        char$Mnset$Mncontains$Qu = new ModuleMethod(srfi142, 35, Lit31, 8194);
        char$Mnset$Mnevery = new ModuleMethod(srfi142, 36, Lit32, 8194);
        char$Mnset$Mnany = new ModuleMethod(srfi142, 37, Lit33, 8194);
        char$Mnset$Mnadjoin = new ModuleMethod(srfi142, 38, Lit34, -4095);
        char$Mnset$Mndelete = new ModuleMethod(srfi142, 39, Lit35, -4095);
        char$Mnset$Mnadjoin$Ex = new ModuleMethod(srfi142, 40, Lit36, -4095);
        char$Mnset$Mndelete$Ex = new ModuleMethod(srfi142, 41, Lit37, -4095);
        char$Mnset$Mncomplement = new ModuleMethod(srfi142, 42, Lit38, 4097);
        char$Mnset$Mnunion = new ModuleMethod(srfi142, 43, Lit39, -4096);
        char$Mnset$Mnintersection = new ModuleMethod(srfi142, 44, Lit40, -4096);
        char$Mnset$Mndifference = new ModuleMethod(srfi142, 45, Lit41, -4095);
        char$Mnset$Mnxor = new ModuleMethod(srfi142, 46, Lit42, -4096);
        char$Mnset$Mndiff$Plintersection = new ModuleMethod(srfi142, 47, Lit43, -4094);
        char$Mnset$Mncomplement$Ex = new ModuleMethod(srfi142, 48, Lit44, 4097);
        char$Mnset$Mnunion$Ex = new ModuleMethod(srfi142, 49, Lit45, -4096);
        char$Mnset$Mnintersection$Ex = new ModuleMethod(srfi142, 50, Lit46, -4096);
        char$Mnset$Mndifference$Ex = new ModuleMethod(srfi142, 51, Lit47, -4095);
        char$Mnset$Mnxor$Ex = new ModuleMethod(srfi142, 52, Lit48, -4096);
        $Pcboundary$Mnpairs$Mnintersection = new ModuleMethod(srfi142, 53, Lit49, 8194);
        $Pcboundary$Mnpairs$Mnunion = new ModuleMethod(srfi142, 54, Lit50, 8194);
        $Pcboundary$Mnpairs$Mnxor = new ModuleMethod(srfi142, 55, Lit51, 8194);
        srfi14.$runBody$();
    }

    public srfi14() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 48: {
                Object object3 = Promise.force(object2, CharSet.class);
                if (!(object3 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 42: {
                Object object4 = Promise.force(object2, CharSet.class);
                if (!(object4 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 34: {
                Object object5 = Promise.force(object2, CharSet.class);
                if (!(object5 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 33: {
                Object object6 = Promise.force(object2, CharSet.class);
                if (!(object6 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                Object object7 = Promise.force(object2, CharSet.class);
                if (!(object7 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                callContext.value1 = Promise.force(object2, String.class);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object8 = Promise.force(object2, LList.class);
                if (!(object8 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object9 = Promise.force(object2, CharSet.class);
                if (!(object9 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object10 = Promise.force(object2, CharSet.class);
                if (!(object10 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object11 = Promise.force(object2, CharSet.class);
                if (!(object11 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 55: {
                Object object4 = Promise.force(object2, LList.class);
                if (!(object4 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, LList.class);
                if (!(object5 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 54: {
                Object object6 = Promise.force(object2, LList.class);
                if (!(object6 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, LList.class);
                if (!(object7 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 53: {
                Object object8 = Promise.force(object2, LList.class);
                if (!(object8 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, LList.class);
                if (!(object9 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 37: {
                Object object10 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3, CharSet.class);
                if (!(object11 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 36: {
                Object object12 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                Object object13 = Promise.force(object3, CharSet.class);
                if (!(object13 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 35: {
                Object object14 = Promise.force(object2, CharSet.class);
                if (!(object14 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object14;
                Object object15 = Promise.force(object3);
                if (Char.checkCharOrEof(object15) < 0) {
                    return -786430;
                }
                callContext.value2 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 32: {
                Object object16 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object16) == null) {
                    return -786431;
                }
                callContext.value1 = object16;
                Object object17 = Promise.force(object3, CharSet.class);
                if (!(object17 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 26: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 23: {
                Object object18 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object18) == null) {
                    return -786431;
                }
                callContext.value1 = object18;
                Object object19 = Promise.force(object3, CharSet.class);
                if (!(object19 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 22: {
                callContext.value1 = Promise.force(object2, String.class);
                Object object20 = Promise.force(object3, CharSet.class);
                if (!(object20 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                callContext.value1 = Promise.force(object2, String.class);
                Object object21 = Promise.force(object3, CharSet.class);
                if (!(object21 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 19: {
                Object object22 = Promise.force(object2, LList.class);
                if (!(object22 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object22;
                Object object23 = Promise.force(object3, CharSet.class);
                if (!(object23 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 17: {
                Object object24 = Promise.force(object2, LList.class);
                if (!(object24 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object24;
                Object object25 = Promise.force(object3, CharSet.class);
                if (!(object25 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                Object object26 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object26) == null) {
                    return -786431;
                }
                callContext.value1 = object26;
                Object object27 = Promise.force(object3, CharSet.class);
                if (!(object27 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object27;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object28 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object28) == null) {
                    return -786431;
                }
                callContext.value1 = object28;
                Object object29 = Promise.force(object3, CharSet.class);
                if (!(object29 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object29;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 8: {
                Object object30 = Promise.force(object2, CharSet.class);
                if (!(object30 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object30;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object31 = Promise.force(object2, CharSet.class);
                if (!(object31 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object31;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 4: {
                Object object32 = Promise.force(object2, CharSet.class);
                if (!(object32 instanceof CharSet)) {
                    return -786431;
                }
                callContext.value1 = object32;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 26: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                Object object5 = Promise.force(object4);
                if (!(object5 instanceof Boolean)) {
                    return -786429;
                }
                callContext.value3 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 25: {
                Object object6 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, CharSet.class);
                if (!(object7 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object7;
                Object object8 = Promise.force(object4, CharSet.class);
                if (!(object8 instanceof CharSet)) {
                    return -786429;
                }
                callContext.value3 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 23: {
                Object object9 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object9) == null) {
                    return -786431;
                }
                callContext.value1 = object9;
                Object object10 = Promise.force(object3, CharSet.class);
                if (!(object10 instanceof CharSet)) {
                    return -786430;
                }
                callContext.value2 = object10;
                Object object11 = Promise.force(object4, CharSet.class);
                if (!(object11 instanceof CharSet)) {
                    return -786429;
                }
                callContext.value3 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 10: {
                Object object12 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = object3;
                Object object13 = Promise.force(object4, CharSet.class);
                if (!(object13 instanceof CharSet)) {
                    return -786429;
                }
                callContext.value3 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 29: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                Object object6 = Promise.force(object4);
                if (!(object6 instanceof Boolean)) {
                    return -786429;
                }
                callContext.value3 = object6;
                Object object7 = Promise.force(object5, CharSet.class);
                if (!(object7 instanceof CharSet)) {
                    return -786428;
                }
                callContext.value4 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 26: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                Object object8 = Promise.force(object4);
                if (!(object8 instanceof Boolean)) {
                    return -786429;
                }
                callContext.value3 = object8;
                Object object9 = Promise.force(object5, CharSet.class);
                if (!(object9 instanceof CharSet)) {
                    return -786428;
                }
                callContext.value4 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 11: {
                Object object10 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object11) == null) {
                    return -786430;
                }
                callContext.value2 = object11;
                Object object12 = Promise.force(object4, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object12) == null) {
                    return -786429;
                }
                callContext.value3 = object12;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 52: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 51: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 50: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 49: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 47: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 46: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 45: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 44: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 43: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 41: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 40: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 39: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 38: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 13: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 11: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 3: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 2: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 4: {
                return srfi14.charSetHash((CharSet)Promise.force(object2, CharSet.class));
            }
            case 6: {
                return srfi14.charSetCursor((CharSet)Promise.force(object2, CharSet.class));
            }
            case 9: {
                Boolean bl;
                if (srfi14.isEndOfCharSet(((Number)Promise.force(object2)).intValue())) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 16: {
                return srfi14.charSetCopy((CharSet)Promise.force(object2, CharSet.class));
            }
            case 17: {
                return srfi14.list$To$CharSet((LList)Promise.force(object2, LList.class));
            }
            case 20: {
                String string;
                Object object3 = Promise.force(object2, String.class);
                if (object3 == null) {
                    string = null;
                    return srfi14.string$To$CharSet(string);
                }
                string = object3.toString();
                return srfi14.string$To$CharSet(string);
            }
            case 30: {
                return srfi14.$To$CharSet(object2);
            }
            case 31: {
                return srfi14.charSetSize((CharSet)Promise.force(object2, CharSet.class));
            }
            case 33: {
                return srfi14.charSet$To$List((CharSet)Promise.force(object2, CharSet.class));
            }
            case 34: {
                return srfi14.charSet$To$String((CharSet)Promise.force(object2, CharSet.class));
            }
            case 42: {
                return srfi14.charSetComplement((CharSet)Promise.force(object2, CharSet.class));
            }
            case 48: {
                return srfi14.charSetComplement$Ex((CharSet)Promise.force(object2, CharSet.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-hash", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-cursor", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "end-of-char-set?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-copy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->char-set", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-size", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set->string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-complement", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-set-complement!", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
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
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
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
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
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
    public Object applyN(ModuleMethod var1_1, Object[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    public class CharSet
    implements Cloneable {
        public static CharSet empty;
        public static CharSet full;
        public static CharSet ascii;
        public static CharSet title$Mncase;
        public static CharSet whitespace;
        public static CharSet blank;
        public static CharSet lower$Mncase;
        public static CharSet upper$Mncase;
        public static CharSet letter;
        public static CharSet digit;
        public static CharSet punctuation;
        public static CharSet symbol;
        public static CharSet letter$Pldigit;
        public static CharSet graphic;
        public static CharSet printing;
        public static CharSet hex$Mndigit;
        public static CharSet iso$Mncontrol;
        public int[] inversion$Mnlist;
        public int inversion$Mnlist$Mnsize;
        public boolean immutable$Qu;
        public String name;

        public static {
            new CharSet(new int[0]).name = "char-set:empty";
            new CharSet(new int[0]).immutable$Qu = true;
            empty = new CharSet(new int[0]);
            new CharSet(new int[0]).inversion$Mnlist = new int[]{0};
            new CharSet(new int[0]).inversion$Mnlist$Mnsize = 1;
            new CharSet(new int[0]).name = "char-set:full";
            new CharSet(new int[0]).immutable$Qu = true;
            full = new CharSet(new int[0]);
            new CharSet(new int[0]).inversion$Mnlist = new int[]{128, 0};
            new CharSet(new int[0]).inversion$Mnlist$Mnsize = 2;
            new CharSet(new int[0]).name = "char-set:ascii";
            new CharSet(new int[0]).immutable$Qu = true;
            ascii = new CharSet(new int[0]);
            title$Mncase = srfi14.$PcMakeBuiltin("char-set:title-case", srfi14.$Pctitle$Mncase);
            whitespace = srfi14.$PcMakeBuiltin("char-set:whitespace", srfi14.$Pcwhitespace);
            blank = srfi14.$PcMakeBuiltin("char-set:blank", srfi14.$Pcblank);
            lower$Mncase = srfi14.$PcMakeBuiltin("char-set:lower-case", srfi14.$Pclower$Mncase);
            upper$Mncase = srfi14.$PcMakeBuiltin("char-set:upper-case", srfi14.$Pcupper$Mncase);
            letter = srfi14.$PcMakeBuiltin("char-set:letter", srfi14.$Pcletter);
            digit = srfi14.$PcMakeBuiltin("char-set:digit", srfi14.$Pcdigit);
            punctuation = srfi14.$PcMakeBuiltin("char-set:punctuation", srfi14.$Pcpunctuation);
            symbol = srfi14.$PcMakeBuiltin("char-set:symbol", srfi14.$Pcsymbol);
            letter$Pldigit = srfi14.$PcMakeBuiltin("char-set:letter+digit", srfi14.$Pcletter$Pldigit);
            graphic = srfi14.$PcMakeBuiltin("char-set:graphic", srfi14.$Pcgraphic);
            printing = srfi14.$PcMakeBuiltin("char-set:printing", srfi14.$Pcprinting);
            new CharSet(new int[0]).inversion$Mnlist = new int[]{103, 97, 71, 65, 58, 48, 0};
            new CharSet(new int[0]).inversion$Mnlist$Mnsize = 6;
            new CharSet(new int[0]).name = "char-set:hex-digit";
            new CharSet(new int[0]).immutable$Qu = true;
            hex$Mndigit = new CharSet(new int[0]);
            new CharSet(new int[0]).inversion$Mnlist = new int[]{160, 127, 32, 0};
            new CharSet(new int[0]).inversion$Mnlist$Mnsize = 4;
            new CharSet(new int[0]).name = "char-set:iso-control";
            new CharSet(new int[0]).immutable$Qu = true;
            iso$Mncontrol = new CharSet(new int[0]);
        }

        private void $finit$() {
            this.inversion$Mnlist = new int[]{0};
            this.inversion$Mnlist$Mnsize = 0;
            this.immutable$Qu = false;
            this.name = null;
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @SourceMethodType(value={"", "character[]"})
        public /* varargs */ CharSet(int ... arrn) {
            Pair inv$Mnls;
            void var10_10;
            void characters2;
            this.$finit$();
            if (((void)characters2).length <= 0) return;
            int[] chars = Arrays.copyOf((int[])characters2, ((void)characters2).length);
            Arrays.sort(chars);
            int first$Mnpt = chars[0];
            LList lList = (LList)Promise.force(Quote.consX$V(new Object[]{first$Mnpt, LList.Empty}), LList.class);
            int n = 1 + first$Mnpt;
            int index = 1;
            do {
                int pt;
                if (index == chars.length) {
                    if (pt != 1114111) {
                        inv$Mnls = lists.cons(pt, inv$Mnls);
                    }
                    break;
                }
                int next$Mnchar$Mnpt = chars[index];
                if (pt < next$Mnchar$Mnpt) {
                    inv$Mnls = lists.cons(next$Mnchar$Mnpt, lists.cons(pt, inv$Mnls));
                    pt = 1 + next$Mnchar$Mnpt;
                    ++index;
                    continue;
                }
                if (pt == next$Mnchar$Mnpt) {
                    ++pt;
                    ++index;
                    continue;
                }
                if (pt <= next$Mnchar$Mnpt) return;
                ++index;
            } while (true);
            int len = ((LList)inv$Mnls).size();
            this.inversion$Mnlist = new int[1 + len];
            this.inversion$Mnlist$Mnsize = len;
            Pair pair = inv$Mnls;
            int i = 0;
            while (i != len) {
                LList inv$Mnls2;
                var10_10 = inv$Mnls2;
                this.inversion$Mnlist[i] = ((Number)Promise.force(lists.car((Pair)var10_10))).intValue();
                var10_10 = inv$Mnls2;
                inv$Mnls2 = (LList)Promise.force(lists.cdr((Pair)var10_10), LList.class);
                ++i;
            }
            return;
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, (Object)var10_10);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, (Object)var10_10);
            }
        }

        public CharSet clone() {
            CharSet copy;
            Object object2 = Promise.force(super.clone(), CharSet.class);
            try {
                copy = (CharSet)object2;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "copy", -2, object2);
            }
            copy.inversion$Mnlist = Arrays.copyOf(this.inversion$Mnlist, this.inversion$Mnlist$Mnsize);
            copy.immutable$Qu = false;
            copy.name = null;
            return copy;
        }

        public int hashCode() {
            int hash = 1;
            for (int i = this.inversion$Mnlist$Mnsize - 1; i != -1; --i) {
                hash = 31 * hash + this.inversion$Mnlist[i];
            }
            return hash;
        }

        public String toString() {
            String string;
            String s = super.toString();
            if (this.name == null) {
                string = s;
            } else {
                FString fString = strings.stringAppend(s, ": (", this.name, ")");
                string = fString == null ? null : ((Object)fString).toString();
            }
            return string;
        }

        public boolean equals(Object o) {
            boolean bl;
            block6 : {
                if (o instanceof CharSet) {
                    CharSet other = (CharSet)Promise.force(o, CharSet.class);
                    if (other.inversion$Mnlist$Mnsize == this.inversion$Mnlist$Mnsize) {
                        int i = 0;
                        do {
                            boolean x;
                            boolean bl2 = x = i == this.inversion$Mnlist$Mnsize;
                            if (x) {
                                bl = x;
                                break block6;
                            }
                            if (other.inversion$Mnlist[i] != this.inversion$Mnlist[i]) break;
                            ++i;
                        } while (true);
                        bl = false;
                    } else {
                        bl = false;
                    }
                } else {
                    bl = false;
                }
            }
            return bl;
        }

        public boolean isSubsetOf(CharSet cs) {
            boolean bl;
            block8 : {
                int bi = cs.inversion$Mnlist$Mnsize - 1;
                int ai = this.inversion$Mnlist$Mnsize - 1;
                do {
                    if (ai == -1) {
                        bl = true;
                        break block8;
                    }
                    if (bi == -1) {
                        bl = false;
                        break block8;
                    }
                    if (this.inversion$Mnlist[ai] < cs.inversion$Mnlist[bi]) {
                        bl = false;
                        break block8;
                    }
                    if (bi == 0) {
                        bl = true;
                        break block8;
                    }
                    if (ai == 0) {
                        bl = false;
                        break block8;
                    }
                    if (this.inversion$Mnlist[ai - 1] < cs.inversion$Mnlist[bi - 1]) {
                        ai -= 2;
                        continue;
                    }
                    if (this.inversion$Mnlist[ai - 1] == cs.inversion$Mnlist[bi - 1]) {
                        bi -= 2;
                        ai -= 2;
                        continue;
                    }
                    if (this.inversion$Mnlist[ai] <= cs.inversion$Mnlist[bi - 1]) break;
                    bi -= 2;
                } while (true);
                bl = false;
            }
            return bl;
        }

        @SourceMethodType(value={"", "character"})
        public boolean isContains(int n) {
            int n2;
            block5 : {
                if (this.inversion$Mnlist$Mnsize != 0) {
                    int high;
                    int mid;
                    int charnum = n;
                    int n3 = this.inversion$Mnlist$Mnsize;
                    int low = 0;
                    do {
                        mid = BitOps.shift(low + high, -1);
                        if (low == high) {
                            n2 = 0;
                            break block5;
                        }
                        if (charnum < this.inversion$Mnlist[mid] && mid < this.inversion$Mnlist$Mnsize - 1) {
                            low = mid;
                            continue;
                        }
                        if (mid <= 0 || charnum < this.inversion$Mnlist[mid - 1]) break;
                        high = mid;
                    } while (true);
                    n2 = high == this.inversion$Mnlist$Mnsize && mid == this.inversion$Mnlist$Mnsize - 1 ? (charnum >= this.inversion$Mnlist[mid] ? 1 : 0) : this.inversion$Mnlist$Mnsize - mid & 1;
                } else {
                    n2 = 0;
                }
            }
            return (boolean)n2;
        }

        public int size() {
            int n;
            int num = 0;
            int i = this.inversion$Mnlist$Mnsize - 1;
            do {
                if (i == -1) {
                    n = num;
                    break;
                }
                if (i == 0) {
                    n = num + (1114111 - this.inversion$Mnlist[i]) + 1;
                    break;
                }
                num += this.inversion$Mnlist[i - 1] - this.inversion$Mnlist[i];
                i -= 2;
            } while (true);
            return n;
        }

        public LList toList() {
            return (LList)Promise.force(srfi14.charSetFold(lists.cons, LList.Empty, this), LList.class);
        }

        public int getCursor() {
            return this.inversion$Mnlist$Mnsize == 0 ? 1114112 : this.inversion$Mnlist[this.inversion$Mnlist$Mnsize - 1];
        }

        public int cursorNext(int cursor) {
            int n;
            block5 : {
                boolean x;
                boolean bl = x = this.inversion$Mnlist$Mnsize == 0;
                if (x ? x : 1 - (this.inversion$Mnlist$Mnsize & 1) != 0 && cursor + 1 >= this.inversion$Mnlist[0]) {
                    n = 1114112;
                } else {
                    int mid;
                    int cursor2 = cursor + 1;
                    int n2 = this.inversion$Mnlist$Mnsize;
                    int low = 0;
                    do {
                        int high;
                        mid = BitOps.shift(low + high, -1);
                        if (low == high) {
                            n = this.inversion$Mnlist[low];
                            break block5;
                        }
                        if (cursor2 < this.inversion$Mnlist[mid]) {
                            low = mid;
                            continue;
                        }
                        if (mid <= 0 || cursor2 < this.inversion$Mnlist[mid - 1]) break;
                        high = mid;
                    } while (true);
                    n = (this.inversion$Mnlist$Mnsize - mid & 1) != 0 ? cursor2 : this.inversion$Mnlist[mid - 1];
                }
            }
            return n;
        }

        public CharSet complement$Ex() {
            if (this.immutable$Qu) {
                Type.NeverReturns neverReturns = exceptions.error("attempted to modify an immutable char-set", this);
                throw Special.reachedUnexpected;
            }
            if (this.inversion$Mnlist$Mnsize > 0 && this.inversion$Mnlist[this.inversion$Mnlist$Mnsize - 1] == 0) {
                --this.inversion$Mnlist$Mnsize;
            } else if (this.inversion$Mnlist$Mnsize < this.inversion$Mnlist.length) {
                this.inversion$Mnlist[this.inversion$Mnlist$Mnsize] = 0;
                this.inversion$Mnlist$Mnsize = 1 + this.inversion$Mnlist$Mnsize;
            } else {
                this.inversion$Mnlist = Arrays.copyOf(this.inversion$Mnlist, 1 + this.inversion$Mnlist$Mnsize * 2);
                this.inversion$Mnlist$Mnsize = 1 + this.inversion$Mnlist$Mnsize;
            }
            return this;
        }

        @SourceMethodType(value={"", "character"})
        public CharSet adjoin$Ex(int c) {
            int i = c;
            return this.union$Ex(new int[]{i + 1, i}, 2);
        }

        @SourceMethodType(value={"", "character"})
        public CharSet delete$Ex(int c) {
            int i = c;
            return this.intersection$Ex(new int[]{i + 1, i, 0}, 3);
        }

        private CharSet combine$Ex(int[] arr, int arr$Mnsize, Procedure proc) {
            boolean x;
            LList combo$Mnpairs;
            if (this.immutable$Qu) {
                Type.NeverReturns neverReturns = exceptions.error("attempted to modify an immutable char-set", this);
                throw Special.reachedUnexpected;
            }
            LList l1 = srfi14.$PcMakeBoundaryPairs(this.inversion$Mnlist, this.inversion$Mnlist$Mnsize);
            LList l2 = srfi14.$PcMakeBoundaryPairs(arr, arr$Mnsize);
            Object object2 = Promise.force(proc.apply2(l1, l2), LList.class);
            try {
                combo$Mnpairs = (LList)object2;
            }
            catch (ClassCastException classCastException) {
                void new$Mnlength;
                throw new WrongType(classCastException, "combo-pairs", -2, (Object)new$Mnlength);
            }
            int new$Mnlength = srfi14.$PcBoundaryPairsLength(combo$Mnpairs);
            boolean bl = x = new$Mnlength > this.inversion$Mnlist.length;
            if (x ? x : (double)new$Mnlength < ((Number)RatNum.make(IntNum.make(this.inversion$Mnlist.length), IntNum.make(2))).doubleValue()) {
                this.inversion$Mnlist = new int[new$Mnlength * 2];
            }
            srfi14.$PcWriteInversionList(this.inversion$Mnlist, combo$Mnpairs, new$Mnlength);
            this.inversion$Mnlist$Mnsize = new$Mnlength;
            return this;
        }

        public CharSet intersection$Ex(CharSet cs) {
            return this.intersection$Ex(cs.inversion$Mnlist, cs.inversion$Mnlist$Mnsize);
        }

        public CharSet intersection$Ex(int[] arr, int arr$Mnsize) {
            return this.combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnintersection);
        }

        public CharSet union$Ex(CharSet cs) {
            return this.union$Ex(cs.inversion$Mnlist, cs.inversion$Mnlist$Mnsize);
        }

        public CharSet union$Ex(int[] arr, int arr$Mnsize) {
            return this.combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnunion);
        }

        public CharSet xor$Ex(CharSet cs) {
            return this.xor$Ex(cs.inversion$Mnlist, cs.inversion$Mnlist$Mnsize);
        }

        public CharSet xor$Ex(int[] arr, int arr$Mnsize) {
            return this.combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnxor);
        }
    }

}

