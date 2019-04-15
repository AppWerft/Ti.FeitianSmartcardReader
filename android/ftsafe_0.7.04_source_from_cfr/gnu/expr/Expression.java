/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.format.Printable;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure0;
import gnu.text.SourceLocator;
import java.io.PrintWriter;
import java.io.Writer;

public abstract class Expression
extends Procedure0
implements Printable,
SourceLocator {
    String filename;
    int position;
    public static final Expression[] noExpressions = new Expression[0];
    protected Type type;
    protected int flags;
    public static final int VALIDATED = 1;
    protected static final int NEXT_AVAIL_FLAG = 2;

    public final Object eval(CallContext ctx) throws Throwable {
        int start = ctx.startFromContext();
        try {
            this.match0(ctx);
            return ctx.getFromContext(start);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(start);
            throw ex;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final Object eval(Environment env) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            Object object2 = this.eval(ctx);
            return object2;
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
    }

    protected abstract boolean mustCompile();

    @Override
    public final int match0(CallContext ctx) {
        ctx.proc = this;
        ctx.pc = 0;
        return 0;
    }

    @Override
    public final Object apply0() throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.check0(ctx);
        return ctx.runUntilValue();
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        throw new RuntimeException("internal error - " + this.getClass() + ".eval called");
    }

    @Override
    public final void print(Consumer out) {
        if (out instanceof OutPort) {
            this.print((OutPort)out);
        } else if (out instanceof PrintWriter) {
            OutPort port = new OutPort((PrintWriter)((Object)out));
            this.print(port);
            port.close();
        } else {
            CharArrayOutPort port = new CharArrayOutPort();
            this.print(port);
            port.close();
            port.writeTo(out);
        }
    }

    public abstract void print(OutPort var1);

    public void printLineColumn(OutPort out) {
        int line = this.getLineNumber();
        if (line > 0) {
            out.print("line:");
            out.print(line);
            int column = this.getColumnNumber();
            if (column > 0) {
                out.print(':');
                out.print(column);
            }
            out.writeSpaceFill();
        }
    }

    public abstract void compile(Compilation var1, Target var2);

    public final void compileWithPosition(Compilation comp, Target target) {
        this.compileWithPosition(comp, target, this);
    }

    public final void compileWithPosition(Compilation comp, Target target, Expression position) {
        CodeAttr code = comp.getCode();
        if (!code.reachableHere()) {
            return;
        }
        int line = position.getLineNumber();
        if (line > 0) {
            code.putLineNumber(position.getFileName(), line);
            String saveFilename = comp.getFileName();
            int saveLine = comp.getLineNumber();
            int saveColumn = comp.getColumnNumber();
            comp.setLine(position);
            this.compile(comp, target);
            comp.setLine(saveFilename, saveLine, saveColumn);
        } else {
            this.compile(comp, target);
        }
    }

    public final void compile(Compilation comp, Type type) {
        this.compile(comp, StackTarget.getInstance(type));
    }

    public final void compile(Compilation comp, Declaration lhs) {
        this.compile(comp, CheckedTarget.getInstance(lhs));
    }

    public static Expression deepCopy(Expression exp, IdentityHashTable mapper) {
        if (exp == null) {
            return null;
        }
        V tr = mapper.get(exp);
        if (tr != null) {
            return (Expression)tr;
        }
        Expression copy = exp.deepCopy(mapper);
        mapper.put(exp, copy);
        return copy;
    }

    public static Expression[] deepCopy(Expression[] exps, IdentityHashTable mapper) {
        if (exps == null) {
            return null;
        }
        int nargs = exps.length;
        Expression[] a = new Expression[nargs];
        for (int i = 0; i < nargs; ++i) {
            Expression ei = exps[i];
            Expression ai = Expression.deepCopy(ei, mapper);
            if (ai == null && ei != null) {
                return null;
            }
            a[i] = ai;
        }
        return a;
    }

    protected static Expression deepCopy(Expression exp) {
        return Expression.deepCopy(exp, new IdentityHashTable<K, V>());
    }

    protected Expression deepCopy(IdentityHashTable mapper) {
        return null;
    }

    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitExpression(this, d);
    }

    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
    }

    public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl) {
        exp.args = visitor.visitExps(exp.args, null);
        return exp;
    }

    public static Expression makeWhile(Object cond, Object body, Compilation parser) {
        parser.loopStart();
        parser.loopEnter();
        parser.loopCond(parser.parse(cond));
        parser.loopBody(parser.parse(body));
        return parser.loopRepeatDone(new Expression[0]);
    }

    public final void setLocation(SourceLocator location2) {
        this.filename = location2.getFileName();
        this.setLine(location2.getLineNumber(), location2.getColumnNumber());
    }

    public final Expression setLine(Expression old) {
        this.setLocation(old);
        return this;
    }

    public final Expression maybeSetLine(Expression old) {
        if (this.position == 0 && old != null && old.position != 0) {
            this.setLocation(old);
        }
        return this;
    }

    public final void setFile(String filename) {
        this.filename = filename;
    }

    public final void setLine(int lineno, int colno) {
        if (lineno < 0) {
            lineno = 0;
        }
        if (colno < 0) {
            colno = 0;
        }
        this.position = (lineno << 12) + colno;
    }

    public final void setLine(int lineno) {
        this.setLine(lineno, 0);
    }

    @Override
    public final String getFileName() {
        return this.filename;
    }

    public void setLine(Compilation comp) {
        int line = comp.getLineNumber();
        if (line > 0) {
            this.setFile(comp.getFileName());
            this.setLine(line, comp.getColumnNumber());
        }
    }

    @Override
    public String getPublicId() {
        return null;
    }

    @Override
    public String getSystemId() {
        return this.filename;
    }

    @Override
    public final int getLineNumber() {
        int line = this.position >> 12;
        return line == 0 ? -1 : line;
    }

    @Override
    public final int getColumnNumber() {
        int column = this.position & 4095;
        return column == 0 ? -1 : column;
    }

    @Override
    public boolean isStableSourceLocation() {
        return true;
    }

    public final Type getType() {
        if (this.type == null) {
            this.type = Type.objectType;
            this.type = this.calculateType();
        }
        return this.type;
    }

    protected Type calculateType() {
        return Type.pointer_type;
    }

    public final Type getTypeRaw() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean neverReturns() {
        return this.getType() == Type.neverReturnsType;
    }

    public Keyword checkLiteralKeyword() {
        Object val;
        if (this instanceof QuoteExp && (val = ((QuoteExp)this).getValue()) instanceof Keyword) {
            return (Keyword)val;
        }
        return null;
    }

    public boolean isSingleValue() {
        return OccurrenceType.itemCountIsOne(this.getType());
    }

    public Object valueIfConstant() {
        return null;
    }

    public void setFlag(boolean setting, int flag) {
        this.flags = setting ? (this.flags |= flag) : (this.flags &= ~flag);
    }

    public void setFlag(int flag) {
        this.flags |= flag;
    }

    public int getFlags() {
        return this.flags;
    }

    public boolean getFlag(int flag) {
        return (this.flags & flag) != 0;
    }

    public boolean side_effects() {
        return true;
    }

    @Override
    public String toString() {
        String tname = this.getClass().getName();
        if (tname.startsWith("gnu.expr.")) {
            tname = tname.substring(9);
        }
        return tname + "@" + Integer.toHexString(this.hashCode());
    }
}

