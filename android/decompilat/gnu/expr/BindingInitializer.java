// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Variable;
import gnu.bytecode.Method;
import gnu.text.SourceMessages;
import gnu.bytecode.CodeAttr;
import gnu.mapping.Symbol;
import gnu.bytecode.Type;
import gnu.mapping.Namespace;
import gnu.mapping.EnvironmentKey;
import gnu.text.SourceLocator;
import gnu.bytecode.ClassType;

public class BindingInitializer extends Initializer
{
    Declaration decl;
    Expression value;
    static final ClassType typeThreadLocation;
    static final ClassType typeDynamicLocation;
    
    public static void create(final Declaration decl, final Expression value, final Compilation comp) {
        final BindingInitializer init = new BindingInitializer(decl, value);
        Label_0053: {
            if (decl.field != null) {
                if (!decl.field.getStaticFlag()) {
                    break Label_0053;
                }
            }
            else if (!decl.isStatic()) {
                break Label_0053;
            }
            init.next = comp.clinitChain;
            comp.clinitChain = init;
            return;
        }
        final ModuleExp mod = comp.getModule();
        init.next = mod.initChain;
        mod.initChain = init;
    }
    
    public BindingInitializer(final Declaration decl, final Expression value) {
        this.decl = decl;
        this.value = value;
        this.field = decl.field;
    }
    
    @Override
    public void emit(final Compilation comp) {
        if (this.decl.ignorable()) {
            if (this.value != null) {
                this.value.compile(comp, Target.Ignore);
            }
            return;
        }
        final CodeAttr code = comp.getCode();
        if (this.value instanceof QuoteExp) {
            final Object val = ((QuoteExp)this.value).getValue();
            if (val != null && !(val instanceof String)) {
                final Literal lit = comp.litTable.findLiteral(val);
                if (lit.field == this.field) {
                    return;
                }
            }
        }
        final int line = this.decl.getLineNumber();
        final SourceMessages messages = comp.getMessages();
        final SourceLocator saveLoc = messages.swapSourceLocator(this.decl);
        if (line > 0) {
            code.putLineNumber(this.decl.getFileName(), line);
        }
        if (this.field != null && !this.field.getStaticFlag()) {
            code.emitPushThis();
        }
        if (this.value == null) {
            final boolean func = comp.getLanguage().hasSeparateFunctionNamespace();
            final Object property = (func && this.decl.isProcedureDecl()) ? EnvironmentKey.FUNCTION : null;
            Object name = this.decl.getSymbol();
            if (this.decl.getFlag(268500992L)) {
                if (name instanceof String) {
                    name = Namespace.EmptyNamespace.getSymbol((String)name);
                }
                comp.compileConstant(name, Target.pushObject);
                if (property == null) {
                    code.emitPushNull();
                }
                else {
                    comp.compileConstant(property, Target.pushObject);
                }
                code.emitInvokeStatic(BindingInitializer.typeDynamicLocation.getDeclaredMethod("getInstance", 2));
            }
            else if (this.decl.isFluid()) {
                final Type[] atypes = { (name instanceof Symbol) ? Compilation.typeSymbol : Type.toStringType };
                comp.compileConstant(name, Target.pushObject);
                final Method m = BindingInitializer.typeThreadLocation.getDeclaredMethod("makeAnonymous", atypes);
                code.emitInvokeStatic(m);
            }
            else {
                if (name instanceof String) {
                    name = Namespace.EmptyNamespace.getSymbol(((String)name).intern());
                }
                comp.compileConstant(name, Target.pushObject);
                code.emitInvokeStatic(Compilation.typeLocation.getDeclaredMethod("define", 1));
            }
        }
        else {
            final Type type = (this.field == null) ? this.decl.getType() : this.field.getType();
            this.value.compileWithPosition(comp, StackTarget.getInstance(type));
        }
        if (this.field == null) {
            Variable var = this.decl.getVariable();
            if (var == null) {
                var = this.decl.allocateVariable(code, true);
            }
            code.emitStore(var);
        }
        else if (this.field.getStaticFlag()) {
            code.emitPutStatic(this.field);
        }
        else {
            code.emitPutField(this.field);
        }
        messages.swapSourceLocator(saveLoc);
    }
    
    public static Method makeLocationMethod(final Object name) {
        final Type[] atypes = { null };
        if (name instanceof Symbol) {
            atypes[0] = Compilation.typeSymbol;
        }
        else {
            atypes[0] = Type.javalangStringType;
        }
        return Compilation.typeLocation.getDeclaredMethod("make", atypes);
    }
    
    static {
        typeThreadLocation = ClassType.make("gnu.mapping.ThreadLocation");
        typeDynamicLocation = ClassType.make("gnu.mapping.DynamicLocation");
    }
}
