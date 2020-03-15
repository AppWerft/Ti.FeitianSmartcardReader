// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Namespace;
import java.net.URL;
import gnu.mapping.WrappedException;
import gnu.text.ResourceStreamHandler;
import gnu.mapping.Procedure;
import gnu.expr.QuoteExp;
import gnu.kawa.io.URLPath;
import gnu.kawa.io.Path;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.bytecode.ObjectType;
import gnu.expr.BindingInitializer;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.Symbol;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.ProcedureN;

public class GetModuleClass extends ProcedureN implements Inlineable
{
    public static final GetModuleClass getModuleClass;
    public static final GetModuleClass getModuleUri;
    public static final GetModuleClass getModuleUriDummy;
    static final ClassType typeURLPath;
    static final Method maker;
    private static Symbol CLASS_RESOURCE_NAME;
    
    @Override
    public Object applyN(final Object[] args) {
        throw new Error("get-module-class must be inlined");
    }
    
    @Override
    public int numArgs() {
        return (this == GetModuleClass.getModuleUriDummy) ? 4097 : 0;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        if (this == GetModuleClass.getModuleUriDummy) {
            final ReferenceExp ref = (ReferenceExp)exp.getArgs()[0];
            ref.compile(comp, target);
            final Declaration decl = ref.getBinding();
            final Expression init = decl.getValue();
            if (init != null) {
                BindingInitializer.create(decl, init, comp);
                decl.noteValueUnknown();
            }
        }
        else {
            comp.loadClassRef(comp.mainClass);
            if (this == GetModuleClass.getModuleUri) {
                comp.getCode().emitInvoke(GetModuleClass.maker);
            }
            target.compileFromStack(comp, exp.getType());
        }
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return (this == GetModuleClass.getModuleClass) ? Type.javalangClassType : GetModuleClass.typeURLPath;
    }
    
    public static Expression getModuleClassURI(final Compilation comp) {
        Declaration decl = comp.mainLambda.lookup(GetModuleClass.CLASS_RESOURCE_NAME);
        if (decl == null) {
            decl = new Declaration(GetModuleClass.CLASS_RESOURCE_NAME, GetModuleClass.typeURLPath);
            decl.setFlag(536889344L);
            Expression value;
            if (comp.immediate) {
                Path path = comp.getMinfo().getSourceAbsPath();
                if (path == null) {
                    path = Path.currentPath();
                }
                if (!(path instanceof URLPath)) {
                    path = URLPath.valueOf(path.toURL());
                }
                value = QuoteExp.getInstance(path);
            }
            else {
                final Expression clas = new ApplyExp(GetModuleClass.getModuleClass, Expression.noExpressions);
                value = new ApplyExp(GetModuleClass.maker, new Expression[] { clas });
            }
            decl.setValue(value);
            comp.mainLambda.add(null, decl);
        }
        final ReferenceExp ref = new ReferenceExp(decl);
        if (comp.immediate) {
            return ref;
        }
        return new ApplyExp(GetModuleClass.getModuleUriDummy, new Expression[] { ref });
    }
    
    public static URLPath classResourcePath(final Class clas) {
        URL url;
        try {
            try {
                url = ResourceStreamHandler.makeURL(clas);
            }
            catch (SecurityException ex2) {
                final String classFileName = clas.getName().replace('.', '/') + ".class";
                url = clas.getClassLoader().getResource(classFileName);
            }
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
        return URLPath.valueOf(url);
    }
    
    static {
        getModuleClass = new GetModuleClass();
        getModuleUri = new GetModuleClass();
        getModuleUriDummy = new GetModuleClass();
        typeURLPath = ClassType.make("gnu.kawa.io.URLPath");
        maker = ClassType.make("gnu.kawa.functions.GetModuleClass").getDeclaredMethod("classResourcePath", 1);
        GetModuleClass.CLASS_RESOURCE_NAME = Namespace.getDefaultSymbol("$class_resource_URL$");
    }
}
