// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.ConditionalTarget;
import gnu.expr.Declaration;
import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.bytecode.Variable;
import gnu.expr.TypeValue;
import gnu.text.SourceLocator;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.bytecode.PrimType;
import gnu.mapping.Procedure;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Language;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure2;

public class InstanceOf extends Procedure2 implements Inlineable
{
    protected Language language;
    static ClassType typeType;
    static Method instanceMethod;
    
    public InstanceOf(final Language language) {
        this.language = language;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyInstanceOf");
    }
    
    public InstanceOf(final Language language, final String name) {
        this(language);
        this.setName(name);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        Type type = this.language.asType(arg2);
        if (type instanceof PrimType) {
            type = ((PrimType)type).boxedType();
        }
        return this.language.booleanObject(type.isInstance(arg1));
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final CodeAttr code = comp.getCode();
        Type type = null;
        final Expression typeArg = args[1];
        if (typeArg instanceof QuoteExp) {
            try {
                type = this.language.asType(((QuoteExp)typeArg).getValue());
            }
            catch (Exception ex) {
                comp.error('w', "unknown type spec: " + type, typeArg);
            }
        }
        else {
            type = this.language.getTypeFor(typeArg);
        }
        if (type != null) {
            if (type instanceof PrimType) {
                type = ((PrimType)type).boxedType();
            }
            args[0].compile(comp, Target.pushObject);
            if (type instanceof TypeValue) {
                ((TypeValue)type).emitIsInstance(null, comp, target);
                return;
            }
            type.getImplementationType().emitIsInstance(code);
            comp.usedClass(type);
        }
        else {
            if (InstanceOf.typeType == null) {
                InstanceOf.typeType = ClassType.make("gnu.bytecode.Type");
                InstanceOf.instanceMethod = InstanceOf.typeType.addMethod("isInstance", Compilation.apply1args, Type.boolean_type, 1);
            }
            args[1].compile(comp, InstanceOf.typeType);
            args[0].compile(comp, Target.pushObject);
            code.emitInvokeVirtual(InstanceOf.instanceMethod);
        }
        target.compileFromStack(comp, this.language.getTypeFor(Boolean.TYPE));
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return this.language.getTypeFor(Boolean.TYPE);
    }
    
    public static void emitIsInstance(final TypeValue type, final Variable incoming, final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        type.emitTestIf(null, null, comp);
        ConditionalTarget cond = null;
        if (target instanceof ConditionalTarget) {
            cond = (ConditionalTarget)target;
            code.emitGoto(cond.ifTrue);
        }
        else {
            code.emitPushInt(1);
        }
        code.emitElse();
        if (cond != null) {
            code.emitGoto(cond.ifFalse);
        }
        else {
            code.emitPushInt(0);
        }
        code.emitFi();
        if (cond == null) {
            target.compileFromStack(comp, comp.getLanguage().getTypeFor(Boolean.TYPE));
        }
    }
}
