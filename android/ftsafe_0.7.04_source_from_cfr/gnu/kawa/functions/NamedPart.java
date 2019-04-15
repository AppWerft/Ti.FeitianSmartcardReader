/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.CallContext;
import gnu.mapping.HasSetter;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.standard.Scheme;

class NamedPart
extends ProcedureN
implements HasSetter,
Externalizable {
    Object container;
    Object member;
    char kind;
    MethodProc methods;

    public NamedPart(Object container, Object member, char kind) {
        this.container = container;
        this.member = member;
        this.kind = kind;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPart");
    }

    public NamedPart(Object container, String mname, char kind, MethodProc methods) {
        this(container, mname, kind);
        this.methods = methods;
    }

    @Override
    public int numArgs() {
        if (this.kind == 'I' || this.kind == 'C') {
            return 4097;
        }
        if (this.kind == 'D') {
            return 4096;
        }
        return -4096;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        this.apply(ctx.getArgs(), ctx);
    }

    public void apply(Object[] args, CallContext ctx) throws Throwable {
        if (this.kind == 'S') {
            this.methods.checkN(args, ctx);
        } else if (this.kind == 'M') {
            int nargs = args.length;
            Object[] xargs = new Object[nargs + 1];
            xargs[0] = this.container;
            System.arraycopy(args, 0, xargs, 1, nargs);
            this.methods.checkN(xargs, ctx);
        } else {
            ctx.writeValue(this.applyN(args));
        }
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        switch (this.kind) {
            case 'I': {
                return Scheme.instanceOf.apply2(args[0], this.container);
            }
            case 'C': {
                return Convert.cast.apply2(this.container, args[0]);
            }
            case 'N': {
                Object[] xargs = new Object[args.length + 1];
                xargs[0] = this.container;
                System.arraycopy(args, 0, xargs, 1, args.length);
                return Invoke.make.applyN(xargs);
            }
            case 'S': {
                return this.methods.applyN(args);
            }
            case 'M': {
                Object[] xargs = new Object[args.length + 1];
                xargs[0] = this.container;
                System.arraycopy(args, 0, xargs, 1, args.length);
                return this.methods.applyN(xargs);
            }
            case 'D': {
                String fname = this.member.toString().substring(1);
                if (args.length == 0) {
                    return SlotGet.staticField((ClassType)this.container, fname);
                }
                return SlotGet.field(((Type)this.container).coerceFromObject(args[0]), fname);
            }
        }
        throw new Error("unknown part " + this.member + " in " + this.container);
    }

    @Override
    public Procedure getSetter() {
        if (this.kind == 'D') {
            return new Setter(this);
        }
        throw new RuntimeException("procedure '" + this.getName() + "' has no setter");
    }

    @Override
    public void set0(Object value) throws Throwable {
        switch (this.kind) {
            case 'D': {
                String fname = this.member.toString().substring(1);
                SlotSet.setStaticField((ClassType)this.container, fname, value);
                return;
            }
        }
        throw new Error("invalid setter for " + this);
    }

    @Override
    public void set1(Object object2, Object value) throws Throwable {
        switch (this.kind) {
            case 'D': {
                String fname = this.member.toString().substring(1);
                object2 = ((Type)this.container).coerceFromObject(object2);
                SlotSet.setField(object2, fname, value);
                return;
            }
        }
        throw new Error("invalid setter for " + this);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.container);
        out.writeObject(this.member);
        out.writeChar(this.kind);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.kind = in.readChar();
        this.container = (Procedure)in.readObject();
        this.member = (Procedure)in.readObject();
    }

    public static class Setter
    extends gnu.mapping.Setter
    implements Externalizable {
        public Setter(NamedPart getter) {
            super(getter);
            this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPartSetter");
        }

        @Override
        public int numArgs() {
            if (((NamedPart)this.getter).kind == 'D') {
                return 8193;
            }
            return -4096;
        }

        Procedure getGetter() {
            return this.getter;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.getter);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.getter = (Procedure)in.readObject();
        }
    }

}

