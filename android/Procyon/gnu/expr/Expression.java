// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.util.IdentityHashTable;
import gnu.bytecode.CodeAttr;
import gnu.kawa.io.CharArrayOutPort;
import java.io.Writer;
import java.io.PrintWriter;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.mapping.Environment;
import gnu.mapping.CallContext;
import gnu.bytecode.Type;
import gnu.text.SourceLocator;
import gnu.kawa.format.Printable;
import gnu.mapping.Procedure0;

public abstract class Expression extends Procedure0 implements Printable, SourceLocator
{
    String filename;
    int position;
    public static final Expression[] noExpressions;
    protected Type type;
    protected int flags;
    public static final int VALIDATED = 1;
    protected static final int NEXT_AVAIL_FLAG = 2;
    
    public final Object eval(final CallContext ctx) throws Throwable {
        final int start = ctx.startFromContext();
        try {
            this.match0(ctx);
            return ctx.getFromContext(start);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(start);
            throw ex;
        }
    }
    
    public final Object eval(final Environment env) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        final Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            return this.eval(ctx);
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
    }
    
    protected abstract boolean mustCompile();
    
    @Override
    public final int match0(final CallContext ctx) {
        ctx.proc = this;
        return ctx.pc = 0;
    }
    
    @Override
    public final Object apply0() throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.check0(ctx);
        return ctx.runUntilValue();
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        throw new RuntimeException("internal error - " + this.getClass() + ".eval called");
    }
    
    @Override
    public final void print(final Consumer out) {
        if (out instanceof OutPort) {
            this.print((OutPort)out);
        }
        else if (out instanceof PrintWriter) {
            final OutPort port = new OutPort((Writer)out);
            this.print(port);
            port.close();
        }
        else {
            final CharArrayOutPort port2 = new CharArrayOutPort();
            this.print(port2);
            port2.close();
            port2.writeTo(out);
        }
    }
    
    public abstract void print(final OutPort p0);
    
    public void printLineColumn(final OutPort out) {
        final int line = this.getLineNumber();
        if (line > 0) {
            out.print("line:");
            out.print(line);
            final int column = this.getColumnNumber();
            if (column > 0) {
                out.print(':');
                out.print(column);
            }
            out.writeSpaceFill();
        }
    }
    
    public abstract void compile(final Compilation p0, final Target p1);
    
    public final void compileWithPosition(final Compilation comp, final Target target) {
        this.compileWithPosition(comp, target, this);
    }
    
    public final void compileWithPosition(final Compilation comp, final Target target, final Expression position) {
        final CodeAttr code = comp.getCode();
        if (!code.reachableHere()) {
            return;
        }
        final int line = position.getLineNumber();
        if (line > 0) {
            code.putLineNumber(position.getFileName(), line);
            final String saveFilename = comp.getFileName();
            final int saveLine = comp.getLineNumber();
            final int saveColumn = comp.getColumnNumber();
            comp.setLine(position);
            this.compile(comp, target);
            comp.setLine(saveFilename, saveLine, saveColumn);
        }
        else {
            this.compile(comp, target);
        }
    }
    
    public final void compile(final Compilation comp, final Type type) {
        this.compile(comp, StackTarget.getInstance(type));
    }
    
    public final void compile(final Compilation comp, final Declaration lhs) {
        this.compile(comp, CheckedTarget.getInstance(lhs));
    }
    
    public static Expression deepCopy(final Expression exp, final IdentityHashTable mapper) {
        if (exp == null) {
            return null;
        }
        final Object tr = mapper.get(exp);
        if (tr != null) {
            return (Expression)tr;
        }
        final Expression copy = exp.deepCopy(mapper);
        mapper.put(exp, copy);
        return copy;
    }
    
    public static Expression[] deepCopy(final Expression[] exps, final IdentityHashTable mapper) {
        if (exps == null) {
            return null;
        }
        final int nargs = exps.length;
        final Expression[] a = new Expression[nargs];
        for (int i = 0; i < nargs; ++i) {
            final Expression ei = exps[i];
            final Expression ai = deepCopy(ei, mapper);
            if (ai == null && ei != null) {
                return null;
            }
            a[i] = ai;
        }
        return a;
    }
    
    protected static Expression deepCopy(final Expression exp) {
        return deepCopy(exp, new IdentityHashTable());
    }
    
    protected Expression deepCopy(final IdentityHashTable mapper) {
        return null;
    }
    
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitExpression(this, d);
    }
    
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
    }
    
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Declaration decl) {
        exp.args = ((ExpVisitor<R, D>)visitor).visitExps(exp.args, null);
        return exp;
    }
    
    public static Expression makeWhile(final Object cond, final Object body, final Compilation parser) {
        parser.loopStart();
        parser.loopEnter();
        parser.loopCond(parser.parse(cond));
        parser.loopBody(parser.parse(body));
        return parser.loopRepeatDone(new Expression[0]);
    }
    
    public final void setLocation(final SourceLocator location) {
        this.filename = location.getFileName();
        this.setLine(location.getLineNumber(), location.getColumnNumber());
    }
    
    public final Expression setLine(final Expression old) {
        this.setLocation(old);
        return this;
    }
    
    public final Expression maybeSetLine(final Expression old) {
        if (this.position == 0 && old != null && old.position != 0) {
            this.setLocation(old);
        }
        return this;
    }
    
    public final void setFile(final String filename) {
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
    
    public final void setLine(final int lineno) {
        this.setLine(lineno, 0);
    }
    
    @Override
    public final String getFileName() {
        return this.filename;
    }
    
    public void setLine(final Compilation comp) {
        final int line = comp.getLineNumber();
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
        final int line = this.position >> 12;
        return (line == 0) ? -1 : line;
    }
    
    @Override
    public final int getColumnNumber() {
        final int column = this.position & 0xFFF;
        return (column == 0) ? -1 : column;
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
    
    public void setType(final Type type) {
        this.type = type;
    }
    
    public boolean neverReturns() {
        return this.getType() == Type.neverReturnsType;
    }
    
    public Keyword checkLiteralKeyword() {
        if (this instanceof QuoteExp) {
            final Object val = ((QuoteExp)this).getValue();
            if (val instanceof Keyword) {
                return (Keyword)val;
            }
        }
        return null;
    }
    
    public boolean isSingleValue() {
        return OccurrenceType.itemCountIsOne(this.getType());
    }
    
    public Object valueIfConstant() {
        return null;
    }
    
    public void setFlag(final boolean setting, final int flag) {
        if (setting) {
            this.flags |= flag;
        }
        else {
            this.flags &= ~flag;
        }
    }
    
    public void setFlag(final int flag) {
        this.flags |= flag;
    }
    
    public int getFlags() {
        return this.flags;
    }
    
    public boolean getFlag(final int flag) {
        return (this.flags & flag) != 0x0;
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
    
    static {
        noExpressions = new Expression[0];
    }
}
