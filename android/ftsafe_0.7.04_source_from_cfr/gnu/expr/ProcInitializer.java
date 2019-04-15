/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Initializer;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.ScopeExp;
import gnu.expr.Target;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.lang.reflect.Field;

public class ProcInitializer
extends Initializer {
    LambdaExp proc;

    public ProcInitializer(LambdaExp lexp, Compilation comp, gnu.bytecode.Field field) {
        LambdaExp heapLambda;
        this.field = field;
        this.proc = lexp;
        LambdaExp lambdaExp = heapLambda = field.getStaticFlag() ? comp.getModule() : lexp.getOwningLambda();
        if (heapLambda instanceof ModuleExp && comp.isStatic()) {
            this.next = comp.clinitChain;
            comp.clinitChain = this;
        } else {
            this.next = heapLambda.initChain;
            heapLambda.initChain = this;
        }
    }

    public static void emitLoadModuleMethod(LambdaExp proc, Compilation comp) {
        LambdaExp owning;
        ClassType procClass;
        Method initModuleMethod;
        Declaration pdecl = proc.nameDecl;
        Object pname = pdecl == null ? proc.getName() : pdecl.getSymbol();
        ModuleMethod oldproc = null;
        if (comp.isInteractive() && pname != null && pdecl != null && pdecl.context instanceof ModuleExp) {
            Object property;
            Symbol sym;
            String moduleName;
            Object old;
            Environment env;
            ModuleInfo minfo = comp.getMinfo();
            Class oldClass = minfo.getOldModuleClass();
            if (oldClass != null && pdecl.field != null) {
                try {
                    Object oldpval = oldClass.getField(pdecl.field.getName()).get(null);
                    if (oldpval instanceof ModuleMethod) {
                        oldproc = (ModuleMethod)oldpval;
                    }
                }
                catch (Throwable ex) {
                    // empty catch block
                }
            }
            if (oldproc == null && (old = (env = Environment.getCurrent()).get(sym = pname instanceof Symbol ? (Symbol)pname : Symbol.make("", pname.toString().intern()), property = comp.getLanguage().getEnvPropertyFor(proc.nameDecl), null)) instanceof ModuleMethod && ((moduleName = ((ModuleMethod)old).module.getClass().getName()).startsWith("atInteractiveLevel-") || moduleName.equals(comp.moduleClass.getName()))) {
                oldproc = (ModuleMethod)old;
            }
        }
        CodeAttr code = comp.getCode();
        ClassType classType = procClass = proc.usingCallContext() ? Compilation.typeModuleMethodWithContext : Compilation.typeModuleMethod;
        if (oldproc == null) {
            code.emitNew(procClass);
            code.emitDup(1);
            initModuleMethod = procClass.getDeclaredMethod("<init>", 4);
        } else {
            comp.compileConstant(oldproc, Target.pushValue(procClass));
            initModuleMethod = Compilation.typeModuleMethod.getDeclaredMethod("init", 4);
        }
        LambdaExp lambdaExp = owning = proc.getNeedsClosureEnv() ? proc.getOwningLambda() : comp.getModule();
        if (owning instanceof ClassExp && owning.staticLinkField != null) {
            code.emitLoad(code.getCurrentScope().getVariable(1));
        } else if (!(owning instanceof ModuleExp)) {
            owning.loadHeapFrame(comp);
        } else if (comp.moduleClass == comp.mainClass && !comp.method.getStaticFlag()) {
            code.emitPushThis();
        } else {
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
                } else {
                    code.emitGetStatic(comp.moduleInstanceMainField);
                }
                code.emitStore(comp.moduleInstanceVar);
            }
            code.emitLoad(comp.moduleInstanceVar);
        }
        code.emitPushInt(proc.getSelectorValue(comp));
        comp.compileConstant(proc.getProperty(PropertySet.nameKey, pname), Target.pushObject);
        code.emitPushInt(proc.min_args | (proc.keywords == null ? proc.max_args : -1) << 12);
        code.emitInvoke(initModuleMethod);
        if (proc.properties != null) {
            int len = proc.properties.length;
            for (int i = 0; i < len; i += 2) {
                Object key = proc.properties[i];
                if (key == null || key == PropertySet.nameKey) continue;
                Object val = proc.properties[i + 1];
                code.emitDup(1);
                gnu.bytecode.Field pfld = null;
                if (key == Procedure.validateApplyKey) {
                    pfld = Compilation.typeProcedure.getDeclaredField("validateApplyKey");
                } else if (key == Procedure.validateXApplyKey) {
                    pfld = Compilation.typeProcedure.getDeclaredField("validateXApplyKey");
                } else if (key == Procedure.compilerXKey) {
                    pfld = Compilation.typeProcedure.getDeclaredField("compilerXKey");
                }
                if (pfld != null) {
                    code.emitGetStatic(pfld);
                } else {
                    comp.compileConstant(key);
                }
                Target target = Target.pushObject;
                if (val instanceof Expression) {
                    ((Expression)val).compile(comp, target);
                } else {
                    comp.compileConstant(val, target);
                }
                Method m = ClassType.make("gnu.mapping.PropertySet").getDeclaredMethod("setProperty", 2);
                code.emitInvokeVirtual(m);
            }
        }
    }

    @Override
    public void emit(Compilation comp) {
        CodeAttr code = comp.getCode();
        if (!this.field.getStaticFlag()) {
            code.emitPushThis();
        }
        ProcInitializer.emitLoadModuleMethod(this.proc, comp);
        if (this.field.getStaticFlag()) {
            code.emitPutStatic(this.field);
        } else {
            code.emitPutField(this.field);
        }
    }

    @Override
    public void reportError(String message, Compilation comp) {
        String saveFile = comp.getFileName();
        int saveLine = comp.getLineNumber();
        int saveColumn = comp.getColumnNumber();
        comp.setLocation(this.proc);
        String name = this.proc.getName();
        StringBuffer sbuf = new StringBuffer(message);
        if (name == null) {
            sbuf.append("unnamed procedure");
        } else {
            sbuf.append("procedure ");
            sbuf.append(name);
        }
        comp.error('e', sbuf.toString());
        comp.setLine(saveFile, saveLine, saveColumn);
    }
}

