/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.ClassInitializer;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Initializer;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LitTable;
import gnu.expr.Literal;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ObjectExp;
import gnu.expr.PairClassType;
import gnu.expr.ScopeExp;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.text.SourceLocator;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Hashtable;

public class ClassExp
extends LambdaExp {
    int state;
    static final int PARTS_PREDECLARED = 1;
    static final int TYPES_SET = 2;
    static final int PARTS_DECLARED = 3;
    private boolean simple;
    public static final int IS_ABSTRACT = 32768;
    public static final int INTERFACE_SPECIFIED = 65536;
    public static final int CLASS_SPECIFIED = 131072;
    public static final int HAS_SUBCLASS = 262144;
    public static final int IS_PACKAGE_MEMBER = 524288;
    boolean explicitInit;
    ClassType instanceType;
    public String classNameSpecifier;
    public Expression[] supers;
    public int superClassIndex = -1;
    public LambdaExp initMethod;
    public LambdaExp clinitMethod;

    public boolean isSimple() {
        return this.simple;
    }

    @Override
    public final boolean isAbstract() {
        return this.getFlag(32768);
    }

    public boolean isMakingClassPair() {
        return this.compiledType != this.instanceType;
    }

    @Override
    protected Type calculateType() {
        return this.simple ? Compilation.typeClass : Compilation.typeClassType;
    }

    @Override
    public ClassType getClassType() {
        return this.compiledType;
    }

    public void setClassType(ClassType type) {
        this.compiledType = type;
        this.instanceType = type;
    }

    public ClassExp(boolean simple, ClassType type) {
        this.simple = simple;
        this.setClassType(type);
    }

    @Override
    protected boolean mustCompile() {
        return true;
    }

    @Override
    public void compile(Compilation comp, Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        this.compilePushClass(comp, target);
    }

    public void compilePushClass(Compilation comp, Target target) {
        ClassType typeType;
        ClassType new_class = this.compiledType;
        CodeAttr code = comp.getCode();
        ClassType typeClass = Type.javalangClassType;
        boolean needsLink = this.getNeedsClosureEnv();
        comp.loadClassRef(new_class);
        if (this.isSimple() && !needsLink) {
            typeType = typeClass;
        } else {
            int nargs;
            if (this.isMakingClassPair() || needsLink) {
                if (new_class == this.instanceType) {
                    code.emitDup(this.instanceType);
                } else {
                    comp.loadClassRef(this.instanceType);
                }
                typeType = ClassType.make("gnu.expr.PairClassType");
                nargs = needsLink ? 3 : 2;
            } else {
                typeType = Compilation.typeType;
                nargs = 1;
            }
            Type[] argsClass = new Type[nargs];
            if (needsLink) {
                this.getOwningLambda().loadHeapFrame(comp);
                argsClass[--nargs] = Type.objectType;
            }
            while (--nargs >= 0) {
                argsClass[nargs] = typeClass;
            }
            Method makeMethod = typeType.addMethod("make", argsClass, typeType, 9);
            code.emitInvokeStatic(makeMethod);
        }
        target.compileFromStack(comp, typeType);
    }

    @Override
    protected ClassType getCompiledClassType(Compilation comp) {
        return this.compiledType;
    }

    public void createFields(Compilation comp) {
        if (this.state >= 1) {
            return;
        }
        this.state = 1;
        Hashtable<String, Declaration> seenFields = new Hashtable<String, Declaration>();
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (!decl.getCanRead()) continue;
            int flags = decl.getAccessFlags((short)1);
            if (decl.getFlag(2048L)) {
                flags |= 8;
            }
            String fname = Mangling.mangleNameIfNeeded(decl.getName());
            decl.field = this.instanceType.addField(fname, null, flags);
            Declaration old = (Declaration)seenFields.get(fname);
            if (old != null) {
                ClassExp.duplicateDeclarationError(old, decl, comp);
            }
            seenFields.put(fname, decl);
        }
    }

    public void setTypes(Compilation comp) {
        ClassType[] interfaces;
        if (this.state >= 2) {
            return;
        }
        this.createFields(comp);
        this.state = 2;
        int nsupers = this.supers == null ? 0 : this.supers.length;
        ClassType[] superTypes = new ClassType[nsupers];
        ClassType superType = null;
        int j = 0;
        for (int i = 0; i < nsupers; ++i) {
            ClassType t;
            int modifiers;
            block21 : {
                Type st = Language.getDefaultLanguage().getTypeFor(this.supers[i]);
                if (st instanceof ClassType) {
                    t = (ClassType)st;
                } else if (st instanceof ParameterizedType) {
                    t = ((ParameterizedType)st).getRawType();
                } else {
                    comp.setLine(this.supers[i]);
                    comp.error('e', "invalid super type");
                    continue;
                }
                try {
                    modifiers = t.getModifiers();
                }
                catch (RuntimeException ex) {
                    modifiers = 0;
                    if (comp == null) break block21;
                    comp.error('e', "unknown super-type " + t.getName());
                }
            }
            if ((modifiers & 512) == 0) {
                if (j < i) {
                    comp.error('e', "duplicate superclass for " + this);
                }
                superType = t;
                this.superClassIndex = i;
                continue;
            }
            superTypes[j++] = t;
        }
        if (superType != null && (this.flags & 65536) != 0) {
            comp.error('e', "cannot be interface since has superclass");
        }
        if (!this.simple && superType == null && (this.flags & 131072) == 0 && (this.getFlag(262144) || this.nameDecl != null && this.nameDecl.isPublic())) {
            PairClassType ptype = new PairClassType();
            this.compiledType = ptype;
            ptype.setInterface(true);
            ptype.instanceType = this.instanceType;
            ClassType[] interfaces2 = new ClassType[]{this.compiledType};
            this.instanceType.setSuper(Type.pointer_type);
            this.instanceType.setInterfaces(interfaces2);
        } else if (this.getFlag(65536)) {
            this.instanceType.setInterface(true);
        }
        this.compiledType.setSuper(superType == null ? Type.pointer_type : superType);
        if (j == nsupers) {
            interfaces = superTypes;
        } else {
            interfaces = new ClassType[j];
            System.arraycopy(superTypes, 0, interfaces, 0, j);
        }
        this.compiledType.setInterfaces(interfaces);
        if (this.compiledType.getName() == null) {
            this.compiledType.setName(this.getClassName(comp));
        }
        if (this.compiledType != comp.mainClass) {
            comp.addClass(this.compiledType);
        }
        if (this.isMakingClassPair()) {
            this.instanceType.setName(this.compiledType.getName() + "$class");
            comp.addClass(this.instanceType);
            Field prev = null;
            for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
                Field fld = decl.field;
                if (decl.getCanRead()) {
                    int fflags = decl.field.getFlags() | 1024;
                    String gname = ClassExp.slotToMethodName("get", decl.getName());
                    decl.getterMethod = this.compiledType.addMethod(gname, fflags, Type.typeArray0, null);
                    String sname = ClassExp.slotToMethodName("set", decl.getName());
                    Type[] stypes = new Type[]{null};
                    decl.setterMethod = this.compiledType.addMethod(sname, fflags, stypes, Type.voidType);
                    this.instanceType.removeField(fld, prev);
                    decl.field = null;
                }
                prev = fld;
            }
        }
    }

    public String getClassName(Compilation comp) {
        String name;
        if (this.classNameSpecifier != null) {
            name = this.classNameSpecifier;
        } else {
            int nlen;
            name = this.getName();
            if (name != null && (nlen = name.length()) > 2 && name.charAt(0) == '<' && name.charAt(nlen - 1) == '>') {
                name = name.substring(1, nlen - 1);
            }
        }
        if (name == null) {
            StringBuffer nbuf = new StringBuffer(100);
            comp.getModule().classFor(comp);
            nbuf.append(comp.mainClass.getName());
            nbuf.append('$');
            int len = nbuf.length();
            int i = 0;
            do {
                nbuf.append(i);
                name = nbuf.toString();
                if (comp.findNamedClass(name) != null) {
                    nbuf.setLength(len);
                    ++i;
                    continue;
                }
                break;
            } while (true);
        } else if (!this.isSimple() || this instanceof ObjectExp) {
            name = comp.generateClassName(name);
        } else {
            int dot;
            int start = 0;
            StringBuilder nbuf = new StringBuilder(100);
            while ((dot = name.indexOf(46, start)) >= 0) {
                nbuf.append(Mangling.mangleClassName(name.substring(start, dot)));
                start = dot + 1;
                if (start >= name.length()) continue;
                nbuf.append('.');
            }
            if (start == 0) {
                int dot2;
                this.setFlag(524288);
                String mainName = comp.mainClass == null ? null : comp.mainClass.getName();
                int n = dot2 = mainName == null ? -1 : mainName.lastIndexOf(46);
                if (dot2 > 0) {
                    nbuf.append(mainName.substring(0, dot2 + 1));
                } else if (comp.classPrefix != null) {
                    nbuf.append(comp.classPrefix);
                }
            } else if (start == 1 && start < name.length()) {
                nbuf.setLength(0);
                nbuf.append(comp.mainClass.getName());
                nbuf.append('$');
            } else {
                this.setFlag(524288);
            }
            if (start < name.length()) {
                nbuf.append(Mangling.mangleClassName(name.substring(start)));
            }
            name = nbuf.toString();
        }
        return name;
    }

    public void declareParts(Compilation comp) {
        if (this.state >= 3) {
            return;
        }
        this.setTypes(comp);
        this.state = 3;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (!decl.getCanRead()) continue;
            if (this.isMakingClassPair()) {
                Type ftype = decl.getType().getImplementationType();
                decl.getterMethod.setReturnType(ftype);
                decl.setterMethod.getParameterTypes()[0] = ftype;
                continue;
            }
            decl.setSimple(false);
            decl.field.setType(decl.getType());
        }
        LambdaExp child = this.firstChild;
        while (child != null) {
            if (child.isAbstract()) {
                this.setFlag(32768);
            }
            if ("*init*".equals(child.getName())) {
                this.explicitInit = true;
                if (child.isAbstract()) {
                    comp.error('e', "*init* method cannot be abstract", child);
                }
                if (this.compiledType instanceof PairClassType) {
                    comp.error('e', "'*init*' methods only supported for simple classes");
                }
            }
            child.setOuter(this);
            if (child != this.initMethod && child != this.clinitMethod && child.nameDecl != null && !child.nameDecl.getFlag(2048L) || !this.isMakingClassPair()) {
                child.addMethodFor(this.compiledType, comp, null);
            }
            if (this.isMakingClassPair()) {
                child.addMethodFor(this.instanceType, comp, this.compiledType);
            }
            child = child.nextSibling;
        }
        if (!this.explicitInit && !this.instanceType.isInterface()) {
            Compilation.getConstructor(this.instanceType, this);
        }
        int instanceModifiers = this.instanceType.getModifiers();
        if (this.isAbstract()) {
            this.instanceType.setModifiers(instanceModifiers |= 1024);
        }
        if (this.nameDecl != null) {
            this.instanceType.setModifiers(instanceModifiers & -2 | this.nameDecl.getAccessFlags((short)1));
        }
    }

    static void getImplMethods(ClassType interfaceType, String mname, Type[] paramTypes, ArrayList<Method> vec) {
        ClassExp.getImplMethods(interfaceType, mname, paramTypes, vec, null);
    }

    private static void getImplMethods(ClassType interfaceType, String mname, Type[] paramTypes, ArrayList<Method> vec, Type[] itypes) {
        ClassType implType;
        if (interfaceType instanceof PairClassType) {
            implType = ((PairClassType)interfaceType).instanceType;
        } else {
            if (!interfaceType.isInterface()) {
                return;
            }
            try {
                Class reflectClass = interfaceType.getReflectClass();
                if (reflectClass == null) {
                    return;
                }
                String implTypeName = interfaceType.getName() + "$class";
                ClassLoader loader = reflectClass.getClassLoader();
                Class<?> implClass = Class.forName(implTypeName, false, loader);
                implType = (ClassType)Type.make(implClass);
            }
            catch (Exception ex) {
                return;
            }
        }
        if (itypes == null) {
            itypes = new Type[paramTypes.length + 1];
            System.arraycopy(paramTypes, 0, itypes, 1, paramTypes.length);
        }
        itypes[0] = interfaceType;
        Method implMethod = implType.getDeclaredMethod(mname, itypes);
        if (implMethod != null) {
            int count = vec.size();
            if (count == 0 || !vec.get(count - 1).equals(implMethod)) {
                vec.add(implMethod);
            }
        } else {
            ClassType[] superInterfaces = interfaceType.getInterfaces();
            for (int i = 0; i < superInterfaces.length; ++i) {
                ClassExp.getImplMethods(superInterfaces[i], mname, paramTypes, vec, itypes);
            }
        }
    }

    private static void usedSuperClasses(ClassType clas, Compilation comp) {
        comp.usedClass(clas.getSuperclass());
        ClassType[] interfaces = clas.getInterfaces();
        if (interfaces != null) {
            int i = interfaces.length;
            while (--i >= 0) {
                comp.usedClass(interfaces[i]);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ClassType compileMembers(Compilation comp) {
        ClassType saveClass = comp.curClass;
        Method saveMethod = comp.method;
        try {
            ClassType new_class;
            CodeAttr code;
            Method[] methods;
            String filename;
            int nmethods;
            comp.curClass = new_class = this.getCompiledClassType(comp);
            LambdaExp outer = this.outerLambda();
            AttrContainer enclosing = null;
            if (outer instanceof ClassExp) {
                enclosing = outer.compiledType;
            } else if (outer != null && !(outer instanceof ModuleExp)) {
                enclosing = saveMethod;
            } else if (outer instanceof ModuleExp && !this.getFlag(524288)) {
                enclosing = outer.compiledType;
            }
            if (enclosing != null) {
                new_class.setEnclosingMember((Member)((Object)enclosing));
                if (enclosing instanceof ClassType) {
                    ((ClassType)enclosing).addMemberClass(new_class);
                }
            }
            if (this.instanceType != new_class) {
                this.instanceType.setEnclosingMember(this.compiledType);
                this.compiledType.addMemberClass(this.instanceType);
            }
            ClassExp.usedSuperClasses(this.compiledType, comp);
            if (this.compiledType != this.instanceType) {
                ClassExp.usedSuperClasses(this.instanceType, comp);
            }
            if ((filename = this.getFileName()) != null) {
                new_class.setSourceFile(filename);
            }
            LambdaExp saveLambda = comp.curLambda;
            comp.curLambda = this;
            this.allocFrame(comp);
            if (this.nameDecl != null) {
                this.nameDecl.compileAnnotations(this.compiledType, ElementType.TYPE);
            }
            for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
                decl.compileAnnotations(decl.field, ElementType.FIELD);
            }
            LambdaExp child = this.firstChild;
            while (child != null) {
                if (!(child.isAbstract() || child.isNative() || child == this.clinitMethod && this.compiledType == comp.mainClass)) {
                    Method save_method = comp.method;
                    LambdaExp save_lambda = comp.curLambda;
                    String saveFilename = comp.getFileName();
                    int saveLine = comp.getLineNumber();
                    int saveColumn = comp.getColumnNumber();
                    comp.setLine(child);
                    comp.method = child.getMainMethod();
                    Declaration childDecl = child.nameDecl;
                    if (childDecl != null) {
                        childDecl.compileAnnotations(comp.method, ElementType.METHOD);
                    }
                    comp.curClass = this.instanceType;
                    comp.curLambda = child;
                    comp.method.initCode();
                    child.allocChildClasses(comp);
                    child.allocParameters(comp);
                    if ("*init*".equals(child.getName())) {
                        code = comp.getCode();
                        if (this.staticLinkField != null) {
                            code.emitPushThis();
                            code.emitLoad(code.getCurrentScope().getVariable(1));
                            code.emitPutField(this.staticLinkField);
                        }
                        Expression bodyFirst = child.getBodyFirstExpression();
                        ClassType calledInit = this.checkForInitCall(bodyFirst);
                        ClassType superClass = this.instanceType.getSuperclass();
                        if (calledInit == null && superClass != null) {
                            ClassExp.invokeDefaultSuperConstructor(superClass, comp, this);
                            this.compileCallInitMethods(comp);
                        } else if (calledInit != this.instanceType) {
                            ((ApplyExp)bodyFirst).setFlag(16);
                        }
                        child.enterFunction(comp);
                        child.compileBody(comp);
                    } else {
                        child.enterFunction(comp);
                        child.compileBody(comp);
                    }
                    child.compileEnd(comp);
                    child.generateApplyMethods(comp);
                    Method thisMethod = comp.method;
                    Type[] ptypes = thisMethod.getParameterTypes();
                    Type rtype = thisMethod.getReturnType();
                    ClassType superClass = this.instanceType.getSuperclass();
                    Method superMethod = superClass.getMethod(child.getName(), ptypes);
                    if (superMethod != null && superMethod.getReturnType().compare(rtype) == 1) {
                        this.generateBridgeMethod(comp, thisMethod, ptypes, superMethod.getReturnType());
                    }
                    comp.method = save_method;
                    comp.curClass = new_class;
                    comp.curLambda = save_lambda;
                    comp.setLine(saveFilename, saveLine, saveColumn);
                }
                child = child.nextSibling;
            }
            if (!this.explicitInit && !this.instanceType.isInterface()) {
                comp.generateConstructor(this.instanceType, this);
            } else if (this.initChain != null) {
                this.initChain.reportError("unimplemented: explicit constructor cannot initialize ", comp);
            }
            if (this.isAbstract()) {
                methods = null;
                nmethods = 0;
            } else {
                methods = this.compiledType.getAbstractMethods();
                nmethods = methods.length;
            }
            for (int i = 0; i < nmethods; ++i) {
                char ch;
                Method impl;
                Method meth = methods[i];
                String mname = meth.getName();
                Type[] ptypes = meth.getParameterTypes();
                Type rtype = meth.getReturnType();
                Method mimpl = this.instanceType.getMethod(mname, ptypes);
                if (mimpl != null && !mimpl.isAbstract()) continue;
                ArrayList<Method> vec = new ArrayList<Method>();
                ClassExp.getImplMethods(this.compiledType, mname, ptypes, vec);
                if (vec.size() == 0 && mname.length() > 3 && mname.charAt(2) == 't' && mname.charAt(1) == 'e' && ((ch = mname.charAt(0)) == 'g' || ch == 's')) {
                    Type ftype;
                    if (ch == 's' && rtype.isVoid() && ptypes.length == 1) {
                        ftype = ptypes[0];
                    } else {
                        if (ch != 'g' || ptypes.length != 0) continue;
                        ftype = rtype;
                    }
                    String fname = Character.toLowerCase(mname.charAt(3)) + mname.substring(4);
                    Field fld = this.instanceType.getField(fname);
                    if (fld == null) {
                        fld = this.instanceType.addField(fname, ftype, 1);
                    }
                    Method impl2 = this.instanceType.addMethod(mname, 1, ptypes, rtype);
                    code = impl2.startCode();
                    code.emitPushThis();
                    if (ch == 'g') {
                        code.emitGetField(fld);
                    } else {
                        code.emitLoad(code.getArg(1));
                        code.emitPutField(fld);
                    }
                    code.emitReturn();
                    continue;
                }
                if (vec.size() != 1) {
                    Method method = impl = vec.size() != 0 ? null : this.findMethodForBridge(mname, ptypes, rtype);
                    if (impl != null) {
                        this.generateBridgeMethod(comp, impl, ptypes, rtype);
                        continue;
                    }
                    String msg = vec.size() == 0 ? "missing implementation for " : "ambiguous implementation for ";
                    comp.error('e', msg + meth);
                    continue;
                }
                impl = this.instanceType.addMethod(mname, 1, ptypes, rtype);
                code = impl.startCode();
                for (Variable var = code.getCurrentScope().firstVar(); var != null; var = var.nextVar()) {
                    code.emitLoad(var);
                }
                code.emitInvokeStatic(vec.get(0));
                code.emitReturn();
            }
            this.generateApplyMethods(comp);
            comp.curLambda = saveLambda;
            ClassType i = new_class;
            return i;
        }
        finally {
            comp.curClass = saveClass;
            comp.method = saveMethod;
        }
    }

    void compileCallInitMethods(Compilation comp) {
        comp.callInitMethods(this.getCompiledClassType(comp), new ArrayList<ClassType>(10));
    }

    protected Method findMethodForBridge(String mname, Type[] ptypes, Type rtype) {
        Method result = null;
        for (Method method = this.compiledType.getDeclaredMethods(); method != null; method = method.getNext()) {
            if (!mname.equals(method.getName()) || !method.getReturnType().isSubtype(rtype) || !Type.isMoreSpecific(method.getParameterTypes(), ptypes)) continue;
            result = method;
        }
        return result;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void generateBridgeMethod(Compilation comp, Method src_method, Type[] bridge_arg_types, Type bridge_return_type) {
        ClassType save_class = comp.curClass;
        Method save_method = comp.method;
        try {
            comp.curClass = this.getCompiledClassType(comp);
            comp.method = comp.curClass.addMethod(src_method.getName(), 4161, bridge_arg_types, bridge_return_type);
            Type[] src_arg_types = src_method.getParameterTypes();
            CodeAttr code = comp.method.startCode();
            code.emitLoad(code.getArg(0));
            for (int i = 0; i < src_arg_types.length; ++i) {
                code.emitLoad(code.getArg(i + 1));
                code.emitCheckcast(src_arg_types[i]);
            }
            code.emitInvokeVirtual(src_method);
            code.emitReturn();
        }
        finally {
            comp.method = save_method;
            comp.curClass = save_class;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        Compilation comp = visitor.getCompilation();
        if (comp == null) {
            return visitor.visitClassExp(this, d);
        }
        ClassType saveClass = comp.curClass;
        try {
            comp.curClass = this.compiledType;
            R r = visitor.visitClassExp(this, d);
            return r;
        }
        finally {
            comp.curClass = saveClass;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        LambdaExp save = visitor.currentLambda;
        visitor.currentLambda = this;
        if (this.supers != null) {
            this.supers = visitor.visitExps(this.supers, this.supers.length, d);
        }
        try {
            LambdaExp child = this.firstChild;
            while (child != null && visitor.exitValue == null) {
                Declaration firstParam;
                if (this.instanceType != null && (firstParam = child.firstDecl()) != null && firstParam.isThisParameter()) {
                    firstParam.setType(this.compiledType);
                }
                visitor.visitLambdaExp(child, d);
                child = child.nextSibling;
            }
        }
        finally {
            visitor.currentLambda = save;
        }
    }

    static void loadSuperStaticLink(Expression superExp, ClassType superClass, Compilation comp) {
        CodeAttr code = comp.getCode();
        superExp.compile(comp, Target.pushValue(Compilation.typeClassType));
        code.emitInvokeStatic(ClassType.make("gnu.expr.PairClassType").getDeclaredMethod("extractStaticLink", 1));
        code.emitCheckcast(superClass.getOuterLinkType());
    }

    void checkDefaultSuperConstructor(ClassType superClass, Compilation comp) {
        if (superClass.getDeclaredMethod("<init>", 0) == null) {
            comp.error('e', "super class " + superClass.getName() + " does not have a default constructor");
        }
    }

    static void invokeDefaultSuperConstructor(ClassType superClass, Compilation comp, LambdaExp lexp) {
        CodeAttr code = comp.getCode();
        Method superConstructor = superClass.getDeclaredMethod("<init>", 0);
        assert (superConstructor != null);
        code.emitPushThis();
        if (superClass.hasOuterLink() && lexp instanceof ClassExp) {
            ClassExp clExp = (ClassExp)lexp;
            Expression superExp = clExp.supers[clExp.superClassIndex];
            ClassExp.loadSuperStaticLink(superExp, superClass, comp);
        }
        code.emitInvokeSpecial(superConstructor);
    }

    @Override
    public void print(OutPort out) {
        out.startLogicalBlock("(" + this.getExpClassName() + "/", ")", 2);
        Object name = this.getSymbol();
        if (name != null) {
            out.print(name);
            out.print('/');
        }
        out.print(this.id);
        out.print("/fl:");
        out.print(Integer.toHexString(this.flags));
        if (this.supers.length > 0) {
            out.writeSpaceFill();
            out.startLogicalBlock("supers:", "", 2);
            for (int i = 0; i < this.supers.length; ++i) {
                this.supers[i].print(out);
                out.writeSpaceFill();
            }
            out.endLogicalBlock("");
        }
        Object prevMode = null;
        int key_args = this.keywords == null ? 0 : this.keywords.length;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            out.writeSpaceFill();
            decl.printInfo(out);
        }
        LambdaExp child = this.firstChild;
        while (child != null) {
            out.writeBreakLinear();
            child.print(out);
            child = child.nextSibling;
        }
        if (this.body != null) {
            out.writeBreakLinear();
            this.body.print(out);
        }
        out.endLogicalBlock(")");
    }

    @Override
    public Field compileSetField(Compilation comp) {
        Field field = this.allocFieldFor(comp);
        if (!this.getNeedsClosureEnv() && field.getStaticFlag() && !comp.immediate && this.type != Type.javalangClassType) {
            new Literal((Object)this.compiledType, this.type, comp.litTable).assign(field, comp.litTable);
        } else {
            new ClassInitializer(this, field, comp);
        }
        return field;
    }

    public static String slotToMethodName(String prefix, String sname) {
        if (!Language.isValidJavaName(sname)) {
            sname = Mangling.mangleName(sname, false);
        }
        int slen = sname.length();
        StringBuffer sbuf = new StringBuffer(slen + 3);
        sbuf.append(prefix);
        if (slen > 0) {
            sbuf.append(Character.toTitleCase(sname.charAt(0)));
            sbuf.append(sname.substring(1));
        }
        return sbuf.toString();
    }

    public Declaration addMethod(LambdaExp lexp, Object mname) {
        Declaration mdecl = this.addDeclaration(mname, Compilation.typeProcedure);
        lexp.setOuter(this);
        lexp.setClassMethod(true);
        mdecl.noteValue(lexp);
        mdecl.setFlag(0x100000L);
        mdecl.setProcedureDecl(true);
        lexp.setSymbol(mname);
        return mdecl;
    }
}

