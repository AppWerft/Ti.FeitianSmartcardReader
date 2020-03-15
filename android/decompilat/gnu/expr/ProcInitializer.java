// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.text.SourceLocator;
import gnu.bytecode.Method;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.bytecode.Type;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;
import gnu.bytecode.Field;

public class ProcInitializer extends Initializer
{
    LambdaExp proc;
    
    public ProcInitializer(final LambdaExp lexp, final Compilation comp, final Field field) {
        this.field = field;
        this.proc = lexp;
        final LambdaExp heapLambda = field.getStaticFlag() ? comp.getModule() : lexp.getOwningLambda();
        if (heapLambda instanceof ModuleExp && comp.isStatic()) {
            this.next = comp.clinitChain;
            comp.clinitChain = this;
        }
        else {
            this.next = heapLambda.initChain;
            heapLambda.initChain = this;
        }
    }
    
    public static void emitLoadModuleMethod(final LambdaExp proc, final Compilation comp) {
        final Declaration pdecl = proc.nameDecl;
        final Object pname = (pdecl == null) ? proc.getName() : pdecl.getSymbol();
        ModuleMethod oldproc = null;
        if (comp.isInteractive() && pname != null && pdecl != null && pdecl.context instanceof ModuleExp) {
            final ModuleInfo minfo = comp.getMinfo();
            final Class oldClass = minfo.getOldModuleClass();
            if (oldClass != null && pdecl.field != null) {
                try {
                    final Object oldpval = oldClass.getField(pdecl.field.getName()).get(null);
                    if (oldpval instanceof ModuleMethod) {
                        oldproc = (ModuleMethod)oldpval;
                    }
                }
                catch (Throwable t) {}
            }
            if (oldproc == null) {
                final Environment env = Environment.getCurrent();
                final Symbol sym = (Symbol)((pname instanceof Symbol) ? pname : Symbol.make("", pname.toString().intern()));
                final Object property = comp.getLanguage().getEnvPropertyFor(proc.nameDecl);
                final Object old = env.get(sym, property, null);
                if (old instanceof ModuleMethod) {
                    final String moduleName = ((ModuleMethod)old).module.getClass().getName();
                    if (moduleName.startsWith("atInteractiveLevel-") || moduleName.equals(comp.moduleClass.getName())) {
                        oldproc = (ModuleMethod)old;
                    }
                }
            }
        }
        final CodeAttr code = comp.getCode();
        final ClassType procClass = proc.usingCallContext() ? Compilation.typeModuleMethodWithContext : Compilation.typeModuleMethod;
        Method initModuleMethod;
        if (oldproc == null) {
            code.emitNew(procClass);
            code.emitDup(1);
            initModuleMethod = procClass.getDeclaredMethod("<init>", 4);
        }
        else {
            comp.compileConstant(oldproc, Target.pushValue(procClass));
            initModuleMethod = Compilation.typeModuleMethod.getDeclaredMethod("init", 4);
        }
        final LambdaExp owning = proc.getNeedsClosureEnv() ? proc.getOwningLambda() : comp.getModule();
        if (owning instanceof ClassExp && owning.staticLinkField != null) {
            code.emitLoad(code.getCurrentScope().getVariable(1));
        }
        else if (!(owning instanceof ModuleExp)) {
            owning.loadHeapFrame(comp);
        }
        else if (comp.moduleClass == comp.mainClass && !comp.method.getStaticFlag()) {
            code.emitPushThis();
        }
        else {
            if (comp.moduleInstanceVar == null || comp.moduleInstanceVar.dead()) {
                comp.moduleInstanceVar = code.locals.current_scope.addVariable(code, comp.moduleClass, "$instance");
                if (comp.moduleClass != comp.mainClass && !comp.isStatic()) {
                    code.emitNew(comp.moduleClass);
                    code.emitDup(comp.moduleClass);
                    code.emitInvokeSpecial(comp.moduleClass.constructor);
                    if (comp.moduleInstanceMainField == null) {
                        comp.moduleInstanceMainField = comp.moduleClass.addField("$main", comp.mainClass, 0);
                    }
                    code.emitDup(comp.moduleClass);
                    code.emitPushThis();
                    code.emitPutField(comp.moduleInstanceMainField);
                }
                else {
                    code.emitGetStatic(comp.moduleInstanceMainField);
                }
                code.emitStore(comp.moduleInstanceVar);
            }
            code.emitLoad(comp.moduleInstanceVar);
        }
        code.emitPushInt(proc.getSelectorValue(comp));
        comp.compileConstant(proc.getProperty(PropertySet.nameKey, pname), Target.pushObject);
        code.emitPushInt(proc.min_args | ((proc.keywords == null) ? proc.max_args : -1) << 12);
        code.emitInvoke(initModuleMethod);
        if (proc.properties != null) {
            for (int len = proc.properties.length, i = 0; i < len; i += 2) {
                final Object key = proc.properties[i];
                if (key != null && key != PropertySet.nameKey) {
                    final Object val = proc.properties[i + 1];
                    code.emitDup(1);
                    Field pfld = null;
                    if (key == Procedure.validateApplyKey) {
                        pfld = Compilation.typeProcedure.getDeclaredField("validateApplyKey");
                    }
                    else if (key == Procedure.validateXApplyKey) {
                        pfld = Compilation.typeProcedure.getDeclaredField("validateXApplyKey");
                    }
                    else if (key == Procedure.compilerXKey) {
                        pfld = Compilation.typeProcedure.getDeclaredField("compilerXKey");
                    }
                    if (pfld != null) {
                        code.emitGetStatic(pfld);
                    }
                    else {
                        comp.compileConstant(key);
                    }
                    final Target target = Target.pushObject;
                    if (val instanceof Expression) {
                        ((Expression)val).compile(comp, target);
                    }
                    else {
                        comp.compileConstant(val, target);
                    }
                    final Method m = ClassType.make("gnu.mapping.PropertySet").getDeclaredMethod("setProperty", 2);
                    code.emitInvokeVirtual(m);
                }
            }
        }
    }
    
    @Override
    public void emit(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (!this.field.getStaticFlag()) {
            code.emitPushThis();
        }
        emitLoadModuleMethod(this.proc, comp);
        if (this.field.getStaticFlag()) {
            code.emitPutStatic(this.field);
        }
        else {
            code.emitPutField(this.field);
        }
    }
    
    @Override
    public void reportError(final String message, final Compilation comp) {
        final String saveFile = comp.getFileName();
        final int saveLine = comp.getLineNumber();
        final int saveColumn = comp.getColumnNumber();
        comp.setLocation(this.proc);
        final String name = this.proc.getName();
        final StringBuffer sbuf = new StringBuffer(message);
        if (name == null) {
            sbuf.append("unnamed procedure");
        }
        else {
            sbuf.append("procedure ");
            sbuf.append(name);
        }
        comp.error('e', sbuf.toString());
        comp.setLine(saveFile, saveLine, saveColumn);
    }
}
