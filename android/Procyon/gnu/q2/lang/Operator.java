// 
// Decompiled by Procyon v0.5.36
// 

package gnu.q2.lang;

import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.FieldLocation;
import kawa.standard.begin;
import gnu.text.SourceLocator;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import gnu.lists.PairWithPosition;
import kawa.lang.Syntax;

public class Operator extends Syntax
{
    int lprio;
    int rprio;
    Object function;
    int flags;
    static final int RHS_NEEDED = 2;
    static final int ASSIGN_OP = 4;
    public static final Operator FENCE;
    public static final Operator SEMI;
    public static final Operator PLUS;
    public static final Operator MINUS;
    public static final Operator STAR;
    public static final Operator SLASH;
    public static final Operator LT;
    public static final Operator GT;
    public static final Operator LE;
    public static final Operator GE;
    public static final Operator EQ;
    public static final Operator ASSIGN;
    public static final Operator IF_THEN;
    
    public Operator(final String name, final int lprio, final int rprio, final int flags, final Object function) {
        super(name);
        this.lprio = lprio;
        this.rprio = rprio;
        this.flags = flags;
        this.function = function;
    }
    
    public Object combine(final Object largs, final Object rargs, final PairWithPosition op) {
        Object funop = null;
        if ((this.flags & 0x4) != 0x0) {
            funop = Symbol.valueOf("set!");
            LList args;
            if (largs instanceof Pair && ((Pair)largs).getCdr() == LList.Empty) {
                ((Pair)largs).setCdrBackdoor(LList.list1(rargs));
                args = (Pair)largs;
            }
            else {
                args = LList.list2(largs, rargs);
            }
            return new PairWithPosition(op, funop, args);
        }
        if (this == Operator.SEMI) {
            funop = begin.begin;
        }
        else if (this.function instanceof FieldLocation) {
            funop = new ReferenceExp(Symbol.valueOf(this.getName()), ((FieldLocation)this.function).getDeclaration());
        }
        if (largs == LList.Empty && rargs == LList.Empty) {
            return (this == Operator.SEMI) ? QuoteExp.voidExp : funop;
        }
        LList args;
        if (largs == LList.Empty) {
            args = LList.list1(rargs);
        }
        else if (rargs == LList.Empty) {
            args = LList.list1(largs);
        }
        else {
            args = LList.list2(largs, rargs);
        }
        return new PairWithPosition(op, funop, args);
    }
    
    @Override
    public String toString() {
        return "Operator[" + this.getName() + "]";
    }
    
    static {
        FENCE = new Operator("<fence>", 0, -1, 0, null);
        SEMI = new Operator(";", 1, 1, 0, null);
        PLUS = new Operator("+", 5, 5, 2, new StaticFieldLocation("gnu.kawa.functions.AddOp", "$Pl"));
        MINUS = new Operator("-", 5, 5, 2, new StaticFieldLocation("gnu.kawa.functions.AddOp", "$Mn"));
        STAR = new Operator("*", 6, 6, 2, new StaticFieldLocation("gnu.kawa.functions.MultiplyOp", "$St"));
        SLASH = new Operator("/", 6, 6, 2, new StaticFieldLocation("gnu.kawa.functions.DivideOp", "$Sl"));
        LT = new Operator("<", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numLss"));
        GT = new Operator(">", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numGrt"));
        LE = new Operator("<=", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numLEq"));
        GE = new Operator(">=", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numGEq"));
        EQ = new Operator("==", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numEqu"));
        ASSIGN = new Operator(":=", 2, 2, 6, null);
        IF_THEN = new Operator("?>", 2, 2, 2, new StaticFieldLocation("kawa.lib.prim_syntax", "if"));
    }
}
