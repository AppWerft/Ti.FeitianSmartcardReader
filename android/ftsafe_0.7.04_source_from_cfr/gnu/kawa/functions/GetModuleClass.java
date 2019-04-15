/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BindingInitializer;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.kawa.io.Path;
import gnu.kawa.io.URLPath;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.text.ResourceStreamHandler;
import java.net.URL;

public class GetModuleClass
extends ProcedureN
implements Inlineable {
    public static final GetModuleClass getModuleClass = new GetModuleClass();
    public static final GetModuleClass getModuleUri = new GetModuleClass();
    public static final GetModuleClass getModuleUriDummy = new GetModuleClass();
    static final ClassType typeURLPath = ClassType.make("gnu.kawa.io.URLPath");
    static final Method maker = ClassType.make("gnu.kawa.functions.GetModuleClass").getDeclaredMethod("classResourcePath", 1);
    private static Symbol CLASS_RESOURCE_NAME = Namespace.getDefaultSymbol("$class_resource_URL$");

    @Override
    public Object applyN(Object[] args) {
        throw new Error("get-module-class must be inlined");
    }

    @Override
    public int numArgs() {
        return this == getModuleUriDummy ? 4097 : 0;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        if (this == getModuleUriDummy) {
            ReferenceExp ref = (ReferenceExp)exp.getArgs()[0];
            ref.compile(comp, target);
            Declaration decl = ref.getBinding();
            Expression init = decl.getValue();
            if (init != null) {
                BindingInitializer.create(decl, init, comp);
                decl.noteValueUnknown();
            }
        } else {
            comp.loadClassRef(comp.mainClass);
            if (this == getModuleUri) {
                comp.getCode().emitInvoke(maker);
            }
            target.compileFromStack(comp, exp.getType());
        }
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return this == getModuleClass ? Type.javalangClassType : typeURLPath;
    }

    public static Expression getModuleClassURI(Compilation comp) {
        Declaration decl = comp.mainLambda.lookup(CLASS_RESOURCE_NAME);
        if (decl == null) {
            Expression value;
            decl = new Declaration((Object)CLASS_RESOURCE_NAME, typeURLPath);
            decl.setFlag(536889344L);
            if (comp.immediate) {
                Path path = comp.getMinfo().getSourceAbsPath();
                if (path == null) {
                    path = Path.currentPath();
                }
                if (!(path instanceof URLPath)) {
                    path = URLPath.valueOf(path.toURL());
                }
                value = QuoteExp.getInstance(path);
            } else {
                ApplyExp clas = new ApplyExp(getModuleClass, Expression.noExpressions);
                value = new ApplyExp(maker, clas);
            }
            decl.setValue(value);
            comp.mainLambda.add(null, decl);
        }
        ReferenceExp ref = new ReferenceExp(decl);
        if (comp.immediate) {
            return ref;
        }
        return new ApplyExp(getModuleUriDummy, ref);
    }

    public static URLPath classResourcePath(Class clas) {
        URL url;
        try {
            try {
                url = ResourceStreamHandler.makeURL(clas);
            }
            catch (SecurityException ex) {
                String classFileName = clas.getName().replace('.', '/') + ".class";
                url = clas.getClassLoader().getResource(classFileName);
            }
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
        return URLPath.valueOf(url);
    }
}

