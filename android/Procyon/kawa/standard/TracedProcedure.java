// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.Location;
import gnu.kawa.io.OutPort;
import gnu.math.IntNum;
import gnu.mapping.Environment;
import java.io.IOException;
import gnu.kawa.functions.ObjectFormat;
import java.io.PrintWriter;
import gnu.mapping.Symbol;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;

public class TracedProcedure extends ProcedureN
{
    public Procedure proc;
    boolean enabled;
    static int indentationStep;
    static Symbol curIndentSym;
    
    public TracedProcedure(final Procedure proc, final boolean enable) {
        this.proc = proc;
        this.enabled = enable;
        final String name = proc.getName();
        if (name != null) {
            this.setName(name);
        }
    }
    
    static void put(final Object value, final PrintWriter out) {
        try {
            if (!ObjectFormat.format(value, out, 50, true)) {
                out.print("...");
            }
        }
        catch (IOException ex) {
            out.print("<caught ");
            out.print(ex);
            out.print('>');
        }
    }
    
    static void indent(int i, final PrintWriter out) {
        while (--i >= 0) {
            out.print(' ');
        }
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (this.enabled) {
            final Environment env = Environment.getCurrent();
            final Location curIndentLoc = env.getLocation(TracedProcedure.curIndentSym);
            final Object oldIndent = curIndentLoc.get(null);
            int curIndent;
            if (!(oldIndent instanceof IntNum)) {
                curIndent = 0;
                curIndentLoc.set(IntNum.zero());
            }
            else {
                curIndent = ((IntNum)oldIndent).intValue();
            }
            final PrintWriter out = OutPort.errDefault();
            String name = this.getName();
            if (name == null) {
                name = "??";
            }
            indent(curIndent, out);
            out.print("call to ");
            out.print(name);
            final int len = args.length;
            out.print(" (");
            for (int i = 0; i < len; ++i) {
                if (i > 0) {
                    out.print(' ');
                }
                put(args[i], out);
            }
            out.println(")");
            final IntNum newIndentation = IntNum.make(curIndent + TracedProcedure.indentationStep);
            final Object save = curIndentLoc.setWithSave(newIndentation);
            Object result;
            try {
                result = this.proc.applyN(args);
            }
            catch (RuntimeException e) {
                indent(curIndent, out);
                out.println("procedure " + name + " throws exception " + e);
                throw e;
            }
            finally {
                curIndentLoc.setRestore(save);
            }
            indent(curIndent, out);
            out.print("return from ");
            out.print(name);
            out.print(" => ");
            put(result, out);
            out.println();
            return result;
        }
        return this.proc.applyN(args);
    }
    
    public static Procedure doTrace(final Procedure proc, final boolean enable) {
        if (proc instanceof TracedProcedure) {
            ((TracedProcedure)proc).enabled = enable;
            return proc;
        }
        return new TracedProcedure(proc, enable);
    }
    
    public void print(final PrintWriter ps) {
        ps.print("#<procedure ");
        final String n = this.getName();
        if (n == null) {
            ps.print("<unnamed>");
        }
        else {
            ps.print(n);
        }
        ps.print(this.enabled ? ", traced>" : ">");
    }
    
    static {
        TracedProcedure.indentationStep = 2;
        TracedProcedure.curIndentSym = Symbol.makeUninterned("current-indentation");
    }
}
