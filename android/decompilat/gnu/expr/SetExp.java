// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.math.IntNum;
import gnu.kawa.functions.AddOp;
import gnu.text.SourceLocator;
import gnu.bytecode.Field;
import gnu.bytecode.Variable;
import gnu.bytecode.Method;
import gnu.bytecode.CodeAttr;
import gnu.mapping.Values;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.mapping.Location;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;
import gnu.mapping.CallContext;

public class SetExp extends AccessExp
{
    Expression new_value;
    int valueIndex;
    public static final int DEFINING_FLAG = 4;
    public static final int GLOBAL_FLAG = 8;
    public static final int PROCEDURE = 16;
    public static final int SET_IF_UNBOUND = 32;
    public static final int HAS_VALUE = 64;
    public static final int BAD_SHORT = 65536;
    
    public SetExp(final Object symbol, final Expression val) {
        this.symbol = symbol;
        this.new_value = val;
    }
    
    public SetExp(final Declaration decl, final Expression val) {
        this.setBinding(decl);
        this.new_value = val;
    }
    
    public static SetExp makeDefinition(final Object symbol, final Expression val) {
        final SetExp sexp = new SetExp(symbol, val);
        sexp.setDefining(true);
        return sexp;
    }
    
    public static SetExp makeDefinition(final Declaration decl, final Expression val) {
        final SetExp sexp = new SetExp(decl, val);
        sexp.setDefining(true);
        return sexp;
    }
    
    public final Expression getNewValue() {
        return this.new_value;
    }
    
    public void setNewValue(final Expression newValue) {
        this.new_value = newValue;
    }
    
    public final boolean isDefining() {
        return (this.flags & 0x4) != 0x0;
    }
    
    public final void setDefining(final boolean value) {
        if (value) {
            this.flags |= 0x4;
        }
        else {
            this.flags &= 0xFFFFFFFB;
        }
    }
    
    public final boolean getHasValue() {
        return (this.flags & 0x40) != 0x0;
    }
    
    public final void setHasValue(final boolean value) {
        if (value) {
            this.flags |= 0x40;
        }
        else {
            this.flags &= 0xFFFFFFBF;
        }
    }
    
    public final boolean isFuncDef() {
        return (this.flags & 0x10) != 0x0;
    }
    
    public final void setFuncDef(final boolean value) {
        if (value) {
            this.flags |= 0x10;
        }
        else {
            this.flags &= 0xFFFFFFEF;
        }
    }
    
    public final boolean isSetIfUnbound() {
        return (this.flags & 0x20) != 0x0;
    }
    
    public final void setSetIfUnbound(final boolean value) {
        if (value) {
            this.flags |= 0x20;
        }
        else {
            this.flags &= 0xFFFFFFDF;
        }
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Environment env = Environment.getCurrent();
        final Symbol sym = (Symbol)((this.symbol instanceof Symbol || this.symbol == null) ? this.symbol : env.getSymbol(this.symbol.toString()));
        Object property = null;
        final Language language = Language.getDefaultLanguage();
        if (this.isFuncDef() && language.hasSeparateFunctionNamespace()) {
            property = EnvironmentKey.FUNCTION;
        }
        if (this.isSetIfUnbound()) {
            final Location loc = env.getLocation(sym, property);
            if (!loc.isBound()) {
                loc.set(this.new_value.eval(env));
            }
            if (this.getHasValue()) {
                ctx.writeValue(loc);
            }
            return;
        }
        final Object new_val = this.new_value.eval(env);
        if (this.binding != null && !(this.binding.context instanceof ModuleExp)) {
            final Object[] evalFrame = ctx.evalFrames[ScopeExp.nesting(this.binding.context)];
            if (this.binding.isIndirectBinding()) {
                if (this.isDefining()) {
                    evalFrame[this.binding.evalIndex] = Location.make(sym);
                }
                final Location loc2 = (Location)evalFrame[this.binding.evalIndex];
                loc2.set(this.new_value);
            }
            else {
                evalFrame[this.binding.evalIndex] = new_val;
            }
        }
        else if (this.isDefining()) {
            env.define(sym, property, new_val);
        }
        else {
            env.put(sym, property, new_val);
        }
        if (this.getHasValue()) {
            ctx.writeValue(new_val);
        }
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        if (this.new_value instanceof LambdaExp && target instanceof IgnoreTarget && ((LambdaExp)this.new_value).getInlineOnly()) {
            return;
        }
        final CodeAttr code = comp.getCode();
        final boolean needValue = this.getHasValue() && !(target instanceof IgnoreTarget);
        boolean valuePushed = false;
        Declaration decl = this.binding;
        Expression declValue = decl.getValue();
        if (declValue instanceof LambdaExp && decl.context instanceof ModuleExp && !decl.ignorable() && ((LambdaExp)declValue).getName() != null && declValue == this.new_value) {
            ((LambdaExp)this.new_value).compileSetField(comp);
        }
        else if ((decl.shouldEarlyInit() || decl.isAlias()) && decl.context instanceof ModuleExp && this.isDefining() && !decl.ignorable()) {
            if (decl.shouldEarlyInit() && decl.field != null && !decl.field.hasConstantValueAttr()) {
                BindingInitializer.create(decl, this.new_value, comp);
            }
            if (needValue) {
                decl.load(this, 0, comp, Target.pushObject);
                valuePushed = true;
            }
        }
        else {
            AccessExp access = this;
            Declaration owner = this.contextDecl();
            if (!this.isDefining()) {
                while (decl != null && decl.isAlias()) {
                    declValue = decl.getValue();
                    if (!(declValue instanceof ReferenceExp)) {
                        break;
                    }
                    final ReferenceExp rexp = (ReferenceExp)declValue;
                    final Declaration orig = rexp.binding;
                    if (orig == null) {
                        break;
                    }
                    if (owner != null && orig.needsContext()) {
                        break;
                    }
                    owner = rexp.contextDecl();
                    access = rexp;
                    decl = orig;
                }
            }
            if (decl.ignorable()) {
                this.new_value.compile(comp, Target.Ignore);
            }
            else if (decl.isAlias() && this.isDefining()) {
                decl.load(this, 4, comp, Target.pushObject);
                final ClassType locType = ClassType.make("gnu.mapping.IndirectableLocation");
                code.emitCheckcast(locType);
                this.new_value.compile(comp, Target.pushObject);
                final Method meth = locType.getDeclaredMethod("setAlias", 1);
                code.emitInvokeVirtual(meth);
            }
            else if (decl.isIndirectBinding()) {
                decl.load(access, 4, comp, Target.pushObject);
                if (this.isSetIfUnbound()) {
                    if (needValue) {
                        code.emitDup();
                        valuePushed = true;
                    }
                    code.pushScope();
                    code.emitDup();
                    final Variable symLoc = code.addLocal(Compilation.typeLocation);
                    code.emitStore(symLoc);
                    code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("isBound", 0));
                    code.emitIfIntEqZero();
                    code.emitLoad(symLoc);
                }
                this.new_value.compile(comp, Target.pushObject);
                if (needValue && !this.isSetIfUnbound()) {
                    code.emitDupX();
                    valuePushed = true;
                }
                final String setterName = "set";
                code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod(setterName, 1));
                if (this.isSetIfUnbound()) {
                    code.emitFi();
                    code.popScope();
                }
            }
            else if (decl.isSimple()) {
                final Type type = decl.getType();
                Variable var = decl.getVariable();
                if (var == null) {
                    var = decl.allocateVariable(code, true);
                }
                final int delta = canUseInc(this.new_value, decl);
                if (delta != 65536) {
                    comp.getCode().emitInc(var, (short)delta);
                    if (needValue) {
                        code.emitLoad(var);
                        valuePushed = true;
                    }
                }
                else {
                    this.new_value.compile(comp, decl);
                    if (!this.checkReachable(comp)) {
                        return;
                    }
                    if (needValue) {
                        code.emitDup(type);
                        valuePushed = true;
                    }
                    code.emitStore(var);
                }
            }
            else {
                final Field field = decl.field;
                final boolean isStatic = field != null && field.getStaticFlag();
                Method setter;
                if (field == null) {
                    final String setName = ClassExp.slotToMethodName("set", decl.getName());
                    final ClassExp cl = (ClassExp)decl.context;
                    setter = cl.compiledType.getDeclaredMethod(setName, 1);
                    comp.usedClass(setter.getDeclaringClass());
                }
                else {
                    setter = null;
                    comp.usedClass(field.getDeclaringClass());
                }
                if (!isStatic) {
                    decl.loadOwningObject(owner, comp);
                }
                this.new_value.compile(comp, decl);
                if (!this.checkReachable(comp)) {
                    return;
                }
                if (isStatic) {
                    if (needValue) {
                        code.emitDup();
                        valuePushed = true;
                    }
                    code.emitPutStatic(field);
                }
                else {
                    if (needValue) {
                        code.emitDupX();
                        valuePushed = true;
                    }
                    if (field != null) {
                        code.emitPutField(field);
                    }
                    else {
                        code.emitInvoke(setter);
                    }
                }
            }
        }
        if (needValue && !valuePushed) {
            throw new Error("SetExp.compile: not implemented - return value");
        }
        if (needValue) {
            target.compileFromStack(comp, this.getType());
        }
        else {
            comp.compileConstant(Values.empty, target);
        }
    }
    
    boolean checkReachable(final Compilation comp) {
        final boolean reachable = comp.getCode().reachableHere();
        if (!reachable) {
            comp.error('w', "'" + this.getSymbol() + "' can never be set because expression never finishes", this.new_value);
        }
        return reachable;
    }
    
    public static int canUseInc(final Expression rhs, final Declaration target) {
        final Variable var = target.getVariable();
        if (target.isSimple() && rhs instanceof ReferenceExp) {
            final ReferenceExp rexp = (ReferenceExp)rhs;
            if (rexp.binding == target && !rexp.getDontDereference()) {
                return 0;
            }
        }
        final ApplyExp aexp;
        if (target.isSimple() && var.getType().getImplementationType().promote() == Type.intType && rhs instanceof ApplyExp && (aexp = (ApplyExp)rhs).getArgCount() == 2) {
            final Expression funcExp = aexp.getFunction();
            final Object func = funcExp.valueIfConstant();
            int sign;
            if (func == AddOp.$Pl) {
                sign = 1;
            }
            else {
                if (func != AddOp.$Mn) {
                    return 65536;
                }
                sign = -1;
            }
            Expression arg0 = aexp.getArg(0);
            Expression arg2 = aexp.getArg(1);
            if (arg0 instanceof QuoteExp && sign > 0) {
                final Expression tmp = arg2;
                arg2 = arg0;
                arg0 = tmp;
            }
            if (arg0 instanceof ReferenceExp) {
                final ReferenceExp ref0 = (ReferenceExp)arg0;
                if (ref0.getBinding() == target) {
                    if (!ref0.getDontDereference()) {
                        final Object value1 = arg2.valueIfConstant();
                        if (value1 instanceof Integer) {
                            int val1 = (int)value1;
                            if (sign < 0) {
                                val1 = -val1;
                            }
                            if ((short)val1 == val1) {
                                return val1;
                            }
                        }
                        else if (value1 instanceof IntNum) {
                            final IntNum int1 = (IntNum)value1;
                            int hi = 32767;
                            int lo = -hi;
                            if (sign > 0) {
                                --lo;
                            }
                            else {
                                ++hi;
                            }
                            if (IntNum.compare(int1, lo) >= 0 && IntNum.compare(int1, hi) <= 0) {
                                return sign * int1.intValue();
                            }
                        }
                    }
                }
            }
        }
        return 65536;
    }
    
    @Override
    protected final Type calculateType() {
        return this.getHasValue() ? ((this.binding == null) ? Type.pointer_type : this.binding.getType()) : Type.voidType;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitSetExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.new_value = visitor.visitAndUpdate(this.new_value, d);
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock(this.isDefining() ? "(Define" : "(Set", ")", 2);
        out.writeSpaceFill();
        this.printLineColumn(out);
        if (this.symbol != null && (this.binding == null || this.symbol.toString() != this.binding.getName())) {
            out.print('/');
            out.print(this.symbol);
        }
        if (this.binding != null) {
            out.print('/');
            out.print(this.binding);
        }
        out.writeSpaceLinear();
        this.new_value.print(out);
        out.endLogicalBlock(")");
    }
    
    @Override
    public String toString() {
        return "SetExp[" + this.symbol + ":=" + this.new_value + ']';
    }
}
