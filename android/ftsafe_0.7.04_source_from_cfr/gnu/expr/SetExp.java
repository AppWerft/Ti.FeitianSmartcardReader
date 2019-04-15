/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.AccessExp;
import gnu.expr.ApplyExp;
import gnu.expr.BindingInitializer;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Target;
import gnu.kawa.functions.AddOp;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.text.SourceLocator;

public class SetExp
extends AccessExp {
    Expression new_value;
    int valueIndex;
    public static final int DEFINING_FLAG = 4;
    public static final int GLOBAL_FLAG = 8;
    public static final int PROCEDURE = 16;
    public static final int SET_IF_UNBOUND = 32;
    public static final int HAS_VALUE = 64;
    public static final int BAD_SHORT = 65536;

    public SetExp(Object symbol, Expression val) {
        this.symbol = symbol;
        this.new_value = val;
    }

    public SetExp(Declaration decl, Expression val) {
        this.setBinding(decl);
        this.new_value = val;
    }

    public static SetExp makeDefinition(Object symbol, Expression val) {
        SetExp sexp = new SetExp(symbol, val);
        sexp.setDefining(true);
        return sexp;
    }

    public static SetExp makeDefinition(Declaration decl, Expression val) {
        SetExp sexp = new SetExp(decl, val);
        sexp.setDefining(true);
        return sexp;
    }

    public final Expression getNewValue() {
        return this.new_value;
    }

    public void setNewValue(Expression newValue) {
        this.new_value = newValue;
    }

    public final boolean isDefining() {
        return (this.flags & 4) != 0;
    }

    public final void setDefining(boolean value) {
        this.flags = value ? (this.flags |= 4) : (this.flags &= -5);
    }

    public final boolean getHasValue() {
        return (this.flags & 64) != 0;
    }

    public final void setHasValue(boolean value) {
        this.flags = value ? (this.flags |= 64) : (this.flags &= -65);
    }

    public final boolean isFuncDef() {
        return (this.flags & 16) != 0;
    }

    public final void setFuncDef(boolean value) {
        this.flags = value ? (this.flags |= 16) : (this.flags &= -17);
    }

    public final boolean isSetIfUnbound() {
        return (this.flags & 32) != 0;
    }

    public final void setSetIfUnbound(boolean value) {
        this.flags = value ? (this.flags |= 32) : (this.flags &= -33);
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Environment env = Environment.getCurrent();
        Symbol sym = this.symbol instanceof Symbol || this.symbol == null ? (Symbol)this.symbol : env.getSymbol(this.symbol.toString());
        Object property = null;
        Language language = Language.getDefaultLanguage();
        if (this.isFuncDef() && language.hasSeparateFunctionNamespace()) {
            property = EnvironmentKey.FUNCTION;
        }
        if (this.isSetIfUnbound()) {
            Location loc = env.getLocation(sym, property);
            if (!loc.isBound()) {
                loc.set(this.new_value.eval(env));
            }
            if (this.getHasValue()) {
                ctx.writeValue(loc);
            }
            return;
        }
        Object new_val = this.new_value.eval(env);
        if (this.binding != null && !(this.binding.context instanceof ModuleExp)) {
            Object[] evalFrame = ctx.evalFrames[ScopeExp.nesting(this.binding.context)];
            if (this.binding.isIndirectBinding()) {
                if (this.isDefining()) {
                    evalFrame[this.binding.evalIndex] = Location.make(sym);
                }
                Location loc = (Location)evalFrame[this.binding.evalIndex];
                loc.set(this.new_value);
            } else {
                evalFrame[this.binding.evalIndex] = new_val;
            }
        } else if (this.isDefining()) {
            env.define(sym, property, new_val);
        } else {
            env.put(sym, property, new_val);
        }
        if (this.getHasValue()) {
            ctx.writeValue(new_val);
        }
    }

    @Override
    public void compile(Compilation comp, Target target) {
        if (this.new_value instanceof LambdaExp && target instanceof IgnoreTarget && ((LambdaExp)this.new_value).getInlineOnly()) {
            return;
        }
        CodeAttr code = comp.getCode();
        boolean needValue = this.getHasValue() && !(target instanceof IgnoreTarget);
        boolean valuePushed = false;
        Declaration decl = this.binding;
        Expression declValue = decl.getValue();
        if (declValue instanceof LambdaExp && decl.context instanceof ModuleExp && !decl.ignorable() && ((LambdaExp)declValue).getName() != null && declValue == this.new_value) {
            ((LambdaExp)this.new_value).compileSetField(comp);
        } else if ((decl.shouldEarlyInit() || decl.isAlias()) && decl.context instanceof ModuleExp && this.isDefining() && !decl.ignorable()) {
            if (decl.shouldEarlyInit() && decl.field != null && !decl.field.hasConstantValueAttr()) {
                BindingInitializer.create(decl, this.new_value, comp);
            }
            if (needValue) {
                decl.load(this, 0, comp, Target.pushObject);
                valuePushed = true;
            }
        } else {
            AccessExp access = this;
            Declaration owner = this.contextDecl();
            if (!this.isDefining()) {
                while (decl != null && decl.isAlias() && (declValue = decl.getValue()) instanceof ReferenceExp) {
                    ReferenceExp rexp = (ReferenceExp)declValue;
                    Declaration orig = rexp.binding;
                    if (orig == null || owner != null && orig.needsContext()) break;
                    owner = rexp.contextDecl();
                    access = rexp;
                    decl = orig;
                }
            }
            if (decl.ignorable()) {
                this.new_value.compile(comp, Target.Ignore);
            } else if (decl.isAlias() && this.isDefining()) {
                decl.load(this, 4, comp, Target.pushObject);
                ClassType locType = ClassType.make("gnu.mapping.IndirectableLocation");
                code.emitCheckcast(locType);
                this.new_value.compile(comp, Target.pushObject);
                Method meth = locType.getDeclaredMethod("setAlias", 1);
                code.emitInvokeVirtual(meth);
            } else if (decl.isIndirectBinding()) {
                decl.load(access, 4, comp, Target.pushObject);
                if (this.isSetIfUnbound()) {
                    if (needValue) {
                        code.emitDup();
                        valuePushed = true;
                    }
                    code.pushScope();
                    code.emitDup();
                    Variable symLoc = code.addLocal(Compilation.typeLocation);
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
                String setterName = "set";
                code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod(setterName, 1));
                if (this.isSetIfUnbound()) {
                    code.emitFi();
                    code.popScope();
                }
            } else if (decl.isSimple()) {
                int delta;
                Type type = decl.getType();
                Variable var = decl.getVariable();
                if (var == null) {
                    var = decl.allocateVariable(code, true);
                }
                if ((delta = SetExp.canUseInc(this.new_value, decl)) != 65536) {
                    comp.getCode().emitInc(var, (short)delta);
                    if (needValue) {
                        code.emitLoad(var);
                        valuePushed = true;
                    }
                } else {
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
            } else {
                boolean isStatic;
                Method setter;
                Field field = decl.field;
                boolean bl = isStatic = field != null && field.getStaticFlag();
                if (field == null) {
                    String setName = ClassExp.slotToMethodName("set", decl.getName());
                    ClassExp cl = (ClassExp)decl.context;
                    setter = cl.compiledType.getDeclaredMethod(setName, 1);
                    comp.usedClass(setter.getDeclaringClass());
                } else {
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
                } else {
                    if (needValue) {
                        code.emitDupX();
                        valuePushed = true;
                    }
                    if (field != null) {
                        code.emitPutField(field);
                    } else {
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
        } else {
            comp.compileConstant(Values.empty, target);
        }
    }

    boolean checkReachable(Compilation comp) {
        boolean reachable = comp.getCode().reachableHere();
        if (!reachable) {
            comp.error('w', "'" + this.getSymbol() + "' can never be set because expression never finishes", this.new_value);
        }
        return reachable;
    }

    public static int canUseInc(Expression rhs, Declaration target) {
        block15 : {
            ReferenceExp ref0;
            ApplyExp aexp;
            int sign;
            block17 : {
                Object func;
                block16 : {
                    Variable var = target.getVariable();
                    if (target.isSimple() && rhs instanceof ReferenceExp) {
                        ReferenceExp rexp = (ReferenceExp)rhs;
                        if (rexp.binding == target && !rexp.getDontDereference()) {
                            return 0;
                        }
                    }
                    if (!target.isSimple() || var.getType().getImplementationType().promote() != Type.intType || !(rhs instanceof ApplyExp) || (aexp = (ApplyExp)rhs).getArgCount() != 2) break block15;
                    Expression funcExp = aexp.getFunction();
                    func = funcExp.valueIfConstant();
                    if (func != AddOp.$Pl) break block16;
                    sign = 1;
                    break block17;
                }
                if (func != AddOp.$Mn) break block15;
                sign = -1;
            }
            Expression arg0 = aexp.getArg(0);
            Expression arg1 = aexp.getArg(1);
            if (arg0 instanceof QuoteExp && sign > 0) {
                Expression tmp = arg1;
                arg1 = arg0;
                arg0 = tmp;
            }
            if (arg0 instanceof ReferenceExp && (ref0 = (ReferenceExp)arg0).getBinding() == target && !ref0.getDontDereference()) {
                Object value1 = arg1.valueIfConstant();
                if (value1 instanceof Integer) {
                    int val1 = (Integer)value1;
                    if (sign < 0) {
                        val1 = -val1;
                    }
                    if ((short)val1 == val1) {
                        return val1;
                    }
                } else if (value1 instanceof IntNum) {
                    IntNum int1 = (IntNum)value1;
                    int hi = 32767;
                    int lo = -hi;
                    if (sign > 0) {
                        --lo;
                    } else {
                        ++hi;
                    }
                    if (IntNum.compare(int1, lo) >= 0 && IntNum.compare(int1, hi) <= 0) {
                        return sign * int1.intValue();
                    }
                }
            }
        }
        return 65536;
    }

    @Override
    protected final Type calculateType() {
        return !this.getHasValue() ? Type.voidType : (this.binding == null ? Type.pointer_type : this.binding.getType());
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitSetExp(this, d);
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.new_value = visitor.visitAndUpdate(this.new_value, d);
    }

    @Override
    public void print(OutPort out) {
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

