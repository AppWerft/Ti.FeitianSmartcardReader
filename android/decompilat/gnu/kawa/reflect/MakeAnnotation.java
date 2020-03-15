// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.PrimProcedure;
import gnu.text.SourceMessages;
import gnu.expr.Language;
import gnu.expr.Compilation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import gnu.text.SourceLocator;
import gnu.expr.Keyword;
import gnu.bytecode.AnnotationEntry;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.bytecode.Type;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.mapping.ProcedureN;

public class MakeAnnotation extends ProcedureN
{
    public static final MakeAnnotation instance;
    ClassType annotationType;
    static final Method makeMethod;
    public static final Procedure makeMethodProc;
    public static final QuoteExp makeMethodExp;
    
    public MakeAnnotation(final ClassType annotationType) {
        this.annotationType = annotationType;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.MakeAnnotation:validate");
    }
    
    public static MakeAnnotation make(final Object annotationType) {
        ClassType annotationCType;
        if (annotationType instanceof ClassType) {
            annotationCType = (ClassType)annotationType;
        }
        else if (annotationType instanceof Class) {
            annotationCType = (ClassType)Type.make((Class)annotationType);
        }
        else {
            annotationCType = ClassType.make(annotationType.toString());
        }
        return new MakeAnnotation(annotationCType);
    }
    
    public static ApplyExp makeAnnotationMaker(final Expression classRef) {
        final ApplyExp aexp = new ApplyExp(MakeAnnotation.makeMethodExp, new Expression[] { classRef });
        aexp.setFlag(4);
        return aexp;
    }
    
    @Override
    public String getName() {
        return (this.annotationType == null) ? "make-annotation" : ("@" + this.annotationType.getName());
    }
    
    public static Expression validate(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Compilation comp = visitor.getCompilation();
        final Language language = visitor.getLanguage();
        final SourceMessages messages = visitor.getMessages();
        final boolean mustBeConstant = visitor.processingAnnotations();
        final MakeAnnotation aproc = (MakeAnnotation)proc;
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        int i = 0;
        ClassType annotationType = aproc.annotationType;
        if (annotationType == null) {
            args[0] = visitor.visit(args[0], (Type)null);
            ++i;
            final Type t = visitor.getLanguage().getTypeFor(args[0], true);
            if (t instanceof ClassType) {
                annotationType = (ClassType)t;
            }
        }
        final int istart = i;
        AnnotationEntry aentry = null;
        if (annotationType != null) {
            if (annotationType.implementsInterface(Type.javalangannotationAnnotationType)) {
                aentry = new AnnotationEntry(annotationType);
            }
            else {
                messages.error('e', annotationType.getName() + " is not an annotation type");
            }
        }
        else if (mustBeConstant) {
            messages.error('e', "annotation type is not a known class");
        }
        boolean warnedMissingName = false;
        while (i < nargs) {
            final int ikey = i;
            String name;
            if (i == istart && nargs == istart + 1) {
                name = "value";
            }
            else {
                args[i] = visitor.visit(args[i], (Type)null);
                final Object keyword = args[i].valueIfConstant();
                if (i == nargs || !(keyword instanceof Keyword)) {
                    if (!warnedMissingName) {
                        messages.error(mustBeConstant ? 'e' : 'w', "missing keyword in annotation arguments");
                    }
                    warnedMissingName = false;
                    aentry = null;
                    name = null;
                }
                else {
                    ++i;
                    name = ((Keyword)keyword).getName();
                }
            }
            Type eltype = null;
            if (annotationType != null && name != null) {
                final Method method = annotationType.getDeclaredMethod(name, Type.typeArray0);
                if (method == null) {
                    comp.error('e', "no annotation element named '" + name + '\'', args[ikey]);
                    aentry = null;
                }
                else {
                    eltype = comp.getLanguage().getLangTypeFor(method.getReturnType());
                }
            }
            final int ecount = messages.getErrorCount();
            args[i] = visitor.visit(args[i], eltype);
            final Object arg = args[i].valueIfConstant();
            if (messages.getErrorCount() > ecount) {
                eltype = null;
                aentry = null;
            }
            else if (arg == null && mustBeConstant) {
                comp.error('e', "annotation value must be constant", args[i]);
                eltype = null;
                aentry = null;
            }
            if (aentry != null) {
                try {
                    aentry.addMember(name, arg, eltype);
                }
                catch (Exception ex) {
                    aentry = null;
                    comp.error(mustBeConstant ? 'e' : 'w', "bad annotation value", args[i]);
                }
            }
            ++i;
        }
        if (aentry != null) {
            final Class aclass = annotationType.getReflectClass();
            return new QuoteExp(Proxy.newProxyInstance(aclass.getClassLoader(), new Class[] { aclass }, aentry), annotationType);
        }
        return exp;
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return this.applyN(args, null);
    }
    
    public Object applyN(final Object[] args, final SourceMessages messages) {
        final int nargs = args.length;
        int i = 0;
        ClassType annotationType = this.annotationType;
        Class aclass;
        if (annotationType == null) {
            aclass = (Class)args[i++];
            annotationType = (ClassType)Type.make(aclass);
        }
        else {
            aclass = annotationType.getReflectClass();
        }
        final int istart = i;
        final AnnotationEntry aentry = new AnnotationEntry(annotationType);
        while (i < nargs) {
            String name;
            if (i == istart && nargs == istart + 1) {
                name = "value";
            }
            else {
                final Object keyword = args[i];
                if (++i == nargs || !(keyword instanceof Keyword)) {
                    throw new IllegalArgumentException("missing keyword in annotation arguments");
                }
                name = ((Keyword)keyword).getName();
            }
            final Object arg = args[i];
            final Method method = annotationType.getDeclaredMethod(name, Type.typeArray0);
            if (method == null) {
                throw new IllegalArgumentException("no annotation element named '" + name + '\'');
            }
            final Type eltype = method.getReturnType();
            aentry.addMember(name, AnnotationEntry.asAnnotationValue(arg, eltype));
            ++i;
        }
        return Proxy.newProxyInstance(aclass.getClassLoader(), new Class[] { aclass }, aentry);
    }
    
    static {
        instance = new MakeAnnotation((ClassType)null);
        makeMethod = ClassType.make("gnu.kawa.reflect.MakeAnnotation").getDeclaredMethod("make", 1);
        makeMethodProc = new PrimProcedure(MakeAnnotation.makeMethod);
        makeMethodExp = QuoteExp.getInstance(MakeAnnotation.makeMethodProc);
    }
}
