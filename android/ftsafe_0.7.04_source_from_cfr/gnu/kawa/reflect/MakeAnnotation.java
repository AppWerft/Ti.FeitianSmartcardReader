/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.lang.reflect.Proxy;

public class MakeAnnotation
extends ProcedureN {
    public static final MakeAnnotation instance = new MakeAnnotation(null);
    ClassType annotationType;
    static final Method makeMethod = ClassType.make("gnu.kawa.reflect.MakeAnnotation").getDeclaredMethod("make", 1);
    public static final Procedure makeMethodProc = new PrimProcedure(makeMethod);
    public static final QuoteExp makeMethodExp = QuoteExp.getInstance(makeMethodProc);

    public MakeAnnotation(ClassType annotationType) {
        this.annotationType = annotationType;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.MakeAnnotation:validate");
    }

    public static MakeAnnotation make(Object annotationType) {
        ClassType annotationCType = annotationType instanceof ClassType ? (ClassType)annotationType : (annotationType instanceof Class ? (ClassType)Type.make((Class)annotationType) : ClassType.make(annotationType.toString()));
        return new MakeAnnotation(annotationCType);
    }

    public static ApplyExp makeAnnotationMaker(Expression classRef) {
        ApplyExp aexp = new ApplyExp(makeMethodExp, classRef);
        aexp.setFlag(4);
        return aexp;
    }

    @Override
    public String getName() {
        return this.annotationType == null ? "make-annotation" : "@" + this.annotationType.getName();
    }

    public static Expression validate(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Compilation comp = visitor.getCompilation();
        Language language = visitor.getLanguage();
        SourceMessages messages = visitor.getMessages();
        boolean mustBeConstant = visitor.processingAnnotations();
        MakeAnnotation aproc = (MakeAnnotation)proc;
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        int i = 0;
        ClassType annotationType = aproc.annotationType;
        if (annotationType == null) {
            args[0] = visitor.visit(args[0], null);
            ++i;
            Type t = visitor.getLanguage().getTypeFor(args[0], true);
            if (t instanceof ClassType) {
                annotationType = (ClassType)t;
            }
        }
        int istart = i;
        AnnotationEntry aentry = null;
        if (annotationType != null) {
            if (annotationType.implementsInterface(Type.javalangannotationAnnotationType)) {
                aentry = new AnnotationEntry(annotationType);
            } else {
                messages.error('e', annotationType.getName() + " is not an annotation type");
            }
        } else if (mustBeConstant) {
            messages.error('e', "annotation type is not a known class");
        }
        boolean warnedMissingName = false;
        while (i < nargs) {
            String name;
            int ikey = i;
            if (i == istart && nargs == istart + 1) {
                name = "value";
            } else {
                args[i] = visitor.visit(args[i], null);
                Object keyword = args[i].valueIfConstant();
                if (i == nargs || !(keyword instanceof Keyword)) {
                    if (!warnedMissingName) {
                        messages.error(mustBeConstant ? (char)'e' : 'w', "missing keyword in annotation arguments");
                    }
                    warnedMissingName = false;
                    aentry = null;
                    name = null;
                } else {
                    ++i;
                    name = ((Keyword)keyword).getName();
                }
            }
            Type eltype = null;
            if (annotationType != null && name != null) {
                Method method = annotationType.getDeclaredMethod(name, Type.typeArray0);
                if (method == null) {
                    comp.error('e', "no annotation element named '" + name + '\'', args[ikey]);
                    aentry = null;
                } else {
                    eltype = comp.getLanguage().getLangTypeFor(method.getReturnType());
                }
            }
            int ecount = messages.getErrorCount();
            args[i] = visitor.visit(args[i], eltype);
            Object arg = args[i].valueIfConstant();
            if (messages.getErrorCount() > ecount) {
                eltype = null;
                aentry = null;
            } else if (arg == null && mustBeConstant) {
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
                    comp.error(mustBeConstant ? (char)'e' : 'w', "bad annotation value", args[i]);
                }
            }
            ++i;
        }
        if (aentry != null) {
            Class aclass = annotationType.getReflectClass();
            return new QuoteExp(Proxy.newProxyInstance(aclass.getClassLoader(), new Class[]{aclass}, aentry), annotationType);
        }
        return exp;
    }

    @Override
    public Object applyN(Object[] args) {
        return this.applyN(args, null);
    }

    public Object applyN(Object[] args, SourceMessages messages) {
        Class aclass;
        int nargs = args.length;
        int i = 0;
        ClassType annotationType = this.annotationType;
        if (annotationType == null) {
            aclass = (Class)args[i++];
            annotationType = (ClassType)Type.make(aclass);
        } else {
            aclass = annotationType.getReflectClass();
        }
        int istart = i;
        AnnotationEntry aentry = new AnnotationEntry(annotationType);
        while (i < nargs) {
            String name;
            if (i == istart && nargs == istart + 1) {
                name = "value";
            } else {
                Object keyword = args[i];
                if (++i == nargs || !(keyword instanceof Keyword)) {
                    throw new IllegalArgumentException("missing keyword in annotation arguments");
                }
                name = ((Keyword)keyword).getName();
            }
            Object arg = args[i];
            Method method = annotationType.getDeclaredMethod(name, Type.typeArray0);
            if (method == null) {
                throw new IllegalArgumentException("no annotation element named '" + name + '\'');
            }
            Type eltype = method.getReturnType();
            aentry.addMember(name, AnnotationEntry.asAnnotationValue(arg, eltype));
            ++i;
        }
        return Proxy.newProxyInstance(aclass.getClassLoader(), new Class[]{aclass}, aentry);
    }
}

