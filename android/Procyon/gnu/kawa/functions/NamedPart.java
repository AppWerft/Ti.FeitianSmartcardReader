// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Setter;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.kawa.reflect.SlotSet;
import gnu.bytecode.Type;
import gnu.kawa.reflect.SlotGet;
import gnu.bytecode.ClassType;
import gnu.kawa.reflect.Invoke;
import kawa.standard.Scheme;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.MethodProc;
import java.io.Externalizable;
import gnu.mapping.HasSetter;
import gnu.mapping.ProcedureN;

class NamedPart extends ProcedureN implements HasSetter, Externalizable
{
    Object container;
    Object member;
    char kind;
    MethodProc methods;
    
    public NamedPart(final Object container, final Object member, final char kind) {
        this.container = container;
        this.member = member;
        this.kind = kind;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPart");
    }
    
    public NamedPart(final Object container, final String mname, final char kind, final MethodProc methods) {
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
    public void apply(final CallContext ctx) throws Throwable {
        this.apply(ctx.getArgs(), ctx);
    }
    
    public void apply(final Object[] args, final CallContext ctx) throws Throwable {
        if (this.kind == 'S') {
            this.methods.checkN(args, ctx);
        }
        else if (this.kind == 'M') {
            final int nargs = args.length;
            final Object[] xargs = new Object[nargs + 1];
            xargs[0] = this.container;
            System.arraycopy(args, 0, xargs, 1, nargs);
            this.methods.checkN(xargs, ctx);
        }
        else {
            ctx.writeValue(this.applyN(args));
        }
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        switch (this.kind) {
            case 'I': {
                return Scheme.instanceOf.apply2(args[0], this.container);
            }
            case 'C': {
                return Convert.cast.apply2(this.container, args[0]);
            }
            case 'N': {
                final Object[] xargs = new Object[args.length + 1];
                xargs[0] = this.container;
                System.arraycopy(args, 0, xargs, 1, args.length);
                return Invoke.make.applyN(xargs);
            }
            case 'S': {
                return this.methods.applyN(args);
            }
            case 'M': {
                final Object[] xargs = new Object[args.length + 1];
                xargs[0] = this.container;
                System.arraycopy(args, 0, xargs, 1, args.length);
                return this.methods.applyN(xargs);
            }
            case 'D': {
                final String fname = this.member.toString().substring(1);
                if (args.length == 0) {
                    return SlotGet.staticField(this.container, fname);
                }
                return SlotGet.field(((Type)this.container).coerceFromObject(args[0]), fname);
            }
            default: {
                throw new Error("unknown part " + this.member + " in " + this.container);
            }
        }
    }
    
    @Override
    public Procedure getSetter() {
        if (this.kind == 'D') {
            return new Setter(this);
        }
        throw new RuntimeException("procedure '" + this.getName() + "' has no setter");
    }
    
    @Override
    public void set0(final Object value) throws Throwable {
        switch (this.kind) {
            case 'D': {
                final String fname = this.member.toString().substring(1);
                SlotSet.setStaticField(this.container, fname, value);
            }
            default: {
                throw new Error("invalid setter for " + this);
            }
        }
    }
    
    @Override
    public void set1(Object object, final Object value) throws Throwable {
        switch (this.kind) {
            case 'D': {
                final String fname = this.member.toString().substring(1);
                object = ((Type)this.container).coerceFromObject(object);
                SlotSet.setField(object, fname, value);
            }
            default: {
                throw new Error("invalid setter for " + this);
            }
        }
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.container);
        out.writeObject(this.member);
        out.writeChar(this.kind);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.kind = in.readChar();
        this.container = in.readObject();
        this.member = in.readObject();
    }
    
    public static class Setter extends gnu.mapping.Setter implements Externalizable
    {
        public Setter(final NamedPart getter) {
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
        public void writeExternal(final ObjectOutput out) throws IOException {
            out.writeObject(this.getter);
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            this.getter = (Procedure)in.readObject();
        }
    }
}
