// 
// Decompiled by Procyon v0.5.36
// 

package gnu.ecmascript;

import gnu.mapping.Procedure;

public class Reserved
{
    String name;
    int prio;
    Procedure proc;
    public static final int VAR_TOKEN = 30;
    public static final int IF_TOKEN = 31;
    public static final int WHILE_TOKEN = 32;
    public static final int FOR_TOKEN = 33;
    public static final int CONTINUE_TOKEN = 34;
    public static final int BREAK_TOKEN = 35;
    public static final int RETURN_TOKEN = 36;
    public static final int WITH_TOKEN = 37;
    public static final int ELSE_TOKEN = 38;
    public static final int NEW_TOKEN = 39;
    public static final int THIS_TOKEN = 40;
    public static final int FUNCTION_TOKEN = 41;
    public static final int PLUS_OP = 1;
    public static final int MINUS_OP = 2;
    public static final int TIMES_OP = 3;
    public static final int LSHIFT_OP = 4;
    public static final int LESS_OP = 5;
    static final Reserved opBoolOr;
    static final Reserved opBoolAnd;
    static final Reserved opBitOr;
    static final Reserved opBitXor;
    static final Reserved opBitAnd;
    static final Reserved opEqual;
    static final Reserved opNotEqual;
    static final Reserved opLess;
    static final Reserved opGreater;
    static final Reserved opLessEqual;
    static final Reserved opGreaterEqual;
    static final Reserved opLshift;
    static final Reserved opRshiftSigned;
    static final Reserved opRshiftUnsigned;
    static final Reserved opPlus;
    static final Reserved opMinus;
    static final Reserved opTimes;
    static final Reserved opDivide;
    static final Reserved opRemainder;
    static Reserved opPlusPlus;
    static Reserved opMinusMinus;
    
    public Reserved(final String name, final int prio, final Procedure proc) {
        this.name = name;
        this.prio = prio;
        this.proc = proc;
    }
    
    public Reserved(final String name, final int prio) {
        this.name = name;
        this.prio = prio;
    }
    
    public Reserved(final String name, final int prio, final int op) {
        this.name = name;
        this.prio = prio;
        this.proc = new BinaryOp(name, op);
    }
    
    @Override
    public String toString() {
        return "[Reserved \"" + this.name + "\" prio:" + this.prio + "]";
    }
    
    public boolean isAssignmentOp() {
        return false;
    }
    
    static {
        opBoolOr = new Reserved("||", 1, 0);
        opBoolAnd = new Reserved("&&", 2, 0);
        opBitOr = new Reserved("|", 3, 0);
        opBitXor = new Reserved("^", 4, 0);
        opBitAnd = new Reserved("&", 5, 0);
        opEqual = new Reserved("=", 6, 0);
        opNotEqual = new Reserved("!=", 6, 0);
        opLess = new Reserved("<", 7, 5);
        opGreater = new Reserved(">", 7, 0);
        opLessEqual = new Reserved("<=", 7, 0);
        opGreaterEqual = new Reserved(">=", 7, 0);
        opLshift = new Reserved("<<", 8, 4);
        opRshiftSigned = new Reserved(">>", 8, 0);
        opRshiftUnsigned = new Reserved(">>>", 8, 0);
        opPlus = new Reserved("+", 9, 1);
        opMinus = new Reserved("-", 9, 2);
        opTimes = new Reserved("*", 10, 3);
        opDivide = new Reserved("/", 10, 0);
        opRemainder = new Reserved("%", 10, 0);
    }
}
