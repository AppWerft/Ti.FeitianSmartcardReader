/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.kawa.functions.ObjectFormat;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import java.io.IOException;
import java.io.PrintWriter;

public class TracedProcedure
extends ProcedureN {
    public Procedure proc;
    boolean enabled;
    static int indentationStep = 2;
    static Symbol curIndentSym = Symbol.makeUninterned("current-indentation");

    public TracedProcedure(Procedure proc, boolean enable) {
        this.proc = proc;
        this.enabled = enable;
        String name = proc.getName();
        if (name != null) {
            this.setName(name);
        }
    }

    static void put(Object value, PrintWriter out) {
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

    static void indent(int i, PrintWriter out) {
        while (--i >= 0) {
            out.print(' ');
        }
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (this.enabled) {
            String name;
            int curIndent;
            Object result;
            OutPort out;
            Environment env = Environment.getCurrent();
            Location curIndentLoc = env.getLocation(curIndentSym);
            Object oldIndent = curIndentLoc.get(null);
            if (!(oldIndent instanceof IntNum)) {
                curIndent = 0;
                curIndentLoc.set(IntNum.zero());
            } else {
                curIndent = ((IntNum)oldIndent).intValue();
            }
            out = OutPort.errDefault();
            name = this.getName();
            if (name == null) {
                name = "??";
            }
            TracedProcedure.indent(curIndent, out);
            ((PrintWriter)out).print("call to ");
            ((PrintWriter)out).print(name);
            int len = args.length;
            ((PrintWriter)out).print(" (");
            for (int i = 0; i < len; ++i) {
                if (i > 0) {
                    out.print(' ');
                }
                TracedProcedure.put(args[i], out);
            }
            out.println(")");
            IntNum newIndentation = IntNum.make(curIndent + indentationStep);
            Object save = curIndentLoc.setWithSave(newIndentation);
            try {
                result = this.proc.applyN(args);
            }
            catch (RuntimeException e) {
                TracedProcedure.indent(curIndent, out);
                out.println("procedure " + name + " throws exception " + e);
                throw e;
            }
            finally {
                curIndentLoc.setRestore(save);
            }
            TracedProcedure.indent(curIndent, out);
            ((PrintWriter)out).print("return from ");
            ((PrintWriter)out).print(name);
            ((PrintWriter)out).print(" => ");
            TracedProcedure.put(result, out);
            out.println();
            return result;
        }
        return this.proc.applyN(args);
    }

    public static Procedure doTrace(Procedure proc, boolean enable) {
        if (proc instanceof TracedProcedure) {
            ((TracedProcedure)proc).enabled = enable;
            return proc;
        }
        return new TracedProcedure(proc, enable);
    }

    public void print(PrintWriter ps) {
        ps.print("#<procedure ");
        String n = this.getName();
        if (n == null) {
            ps.print("<unnamed>");
        } else {
            ps.print(n);
        }
        ps.print(this.enabled ? ", traced>" : ">");
    }
}

