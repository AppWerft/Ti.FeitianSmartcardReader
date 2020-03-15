// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import kawa.lang.ListPat;
import gnu.expr.QuoteExp;
import gnu.bytecode.ClassType;
import gnu.expr.PrimProcedure;
import gnu.lists.Pair;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Pattern;
import kawa.lang.Syntax;

public class prim_method extends Syntax
{
    public static final prim_method virtual_method;
    public static final prim_method static_method;
    public static final prim_method interface_method;
    public static final prim_method op1;
    private static Pattern pattern3;
    private static Pattern pattern4;
    int op_code;
    
    int opcode() {
        return this.op_code;
    }
    
    public prim_method(final int opcode) {
        this.op_code = opcode;
    }
    
    public prim_method() {
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        final Object[] match = new Object[4];
        Label_0083: {
            if (this.op_code == 0) {
                if (prim_method.pattern3.match(obj, match, 1)) {
                    break Label_0083;
                }
            }
            else if (prim_method.pattern4.match(obj, match, 0)) {
                break Label_0083;
            }
            return tr.syntaxError("wrong number of arguments to " + this.getName() + "(opcode:" + this.op_code + ")");
        }
        if (!(match[3] instanceof LList)) {
            return tr.syntaxError("missing/invalid parameter list in " + this.getName());
        }
        LList argp = (LList)match[3];
        final int narg = argp.size();
        final Type[] args = new Type[narg];
        for (int i = 0; i < narg; ++i) {
            final Pair p = (Pair)argp;
            args[i] = tr.exp2Type(p);
            argp = (LList)p.getCdr();
        }
        final Type rtype = tr.exp2Type(new Pair(match[2], null));
        PrimProcedure proc;
        if (this.op_code == 0) {
            final int opcode = ((Number)match[1]).intValue();
            proc = new PrimProcedure(opcode, rtype, args);
        }
        else {
            ClassType cl = null;
            Type ctype = tr.exp2Type((Pair)obj);
            if (ctype != null) {
                ctype = ctype.getImplementationType();
            }
            try {
                cl = (ClassType)ctype;
                cl.getReflectClass();
            }
            catch (Exception ex) {
                char code;
                if (cl == null) {
                    code = 'e';
                }
                else {
                    code = 'w';
                    cl.setExisting(false);
                }
                tr.error(code, "unknown class: " + match[0]);
            }
            final Pair p2;
            if (match[1] instanceof Pair && (p2 = (Pair)match[1]).getCar() == "quote") {
                match[1] = ((Pair)p2.getCdr()).getCar();
            }
            proc = new PrimProcedure(this.op_code, cl, match[1].toString(), rtype, args);
        }
        return new QuoteExp(proc);
    }
    
    static {
        (virtual_method = new prim_method(182)).setName("primitive-virtual-method");
        (static_method = new prim_method(184)).setName("primitive-static-method");
        (interface_method = new prim_method(185)).setName("primitive-interface-method");
        (op1 = new prim_method()).setName("primitive-op1");
        prim_method.pattern3 = new ListPat(3);
        prim_method.pattern4 = new ListPat(4);
    }
}
