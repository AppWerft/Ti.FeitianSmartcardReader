/*
 * Decompiled with CFR 0.139.
 */
package gnu.q2.lang;

import gnu.expr.Declaration;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import kawa.lang.Syntax;
import kawa.standard.begin;

public class Operator
extends Syntax {
    int lprio;
    int rprio;
    Object function;
    int flags;
    static final int RHS_NEEDED = 2;
    static final int ASSIGN_OP = 4;
    public static final Operator FENCE = new Operator("<fence>", 0, -1, 0, null);
    public static final Operator SEMI = new Operator(";", 1, 1, 0, null);
    public static final Operator PLUS = new Operator("+", 5, 5, 2, new StaticFieldLocation("gnu.kawa.functions.AddOp", "$Pl"));
    public static final Operator MINUS = new Operator("-", 5, 5, 2, new StaticFieldLocation("gnu.kawa.functions.AddOp", "$Mn"));
    public static final Operator STAR = new Operator("*", 6, 6, 2, new StaticFieldLocation("gnu.kawa.functions.MultiplyOp", "$St"));
    public static final Operator SLASH = new Operator("/", 6, 6, 2, new StaticFieldLocation("gnu.kawa.functions.DivideOp", "$Sl"));
    public static final Operator LT = new Operator("<", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numLss"));
    public static final Operator GT = new Operator(">", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numGrt"));
    public static final Operator LE = new Operator("<=", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numLEq"));
    public static final Operator GE = new Operator(">=", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numGEq"));
    public static final Operator EQ = new Operator("==", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numEqu"));
    public static final Operator ASSIGN = new Operator(":=", 2, 2, 6, null);
    public static final Operator IF_THEN = new Operator("?>", 2, 2, 2, new StaticFieldLocation("kawa.lib.prim_syntax", "if"));

    public Operator(String name, int lprio, int rprio, int flags, Object function2) {
        super(name);
        this.lprio = lprio;
        this.rprio = rprio;
        this.flags = flags;
        this.function = function2;
    }

    public Object combine(Object largs, Object rargs, PairWithPosition op) {
        Object funop = null;
        if ((this.flags & 4) != 0) {
            Pair args;
            funop = Symbol.valueOf("set!");
            if (largs instanceof Pair && ((Pair)largs).getCdr() == LList.Empty) {
                ((Pair)largs).setCdrBackdoor(LList.list1(rargs));
                args = (Pair)largs;
            } else {
                args = LList.list2(largs, rargs);
            }
            return new PairWithPosition(op, funop, args);
        }
        if (this == SEMI) {
            funop = begin.begin;
        } else if (this.function instanceof FieldLocation) {
            funop = new ReferenceExp(Symbol.valueOf(this.getName()), ((FieldLocation)this.function).getDeclaration());
        }
        if (largs == LList.Empty && rargs == LList.Empty) {
            return this == SEMI ? QuoteExp.voidExp : funop;
        }
        Pair args = largs == LList.Empty ? LList.list1(rargs) : (rargs == LList.Empty ? LList.list1(largs) : LList.list2(largs, rargs));
        return new PairWithPosition(op, funop, args);
    }

    public String toString() {
        return "Operator[" + this.getName() + "]";
    }
}

