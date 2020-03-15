// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.Variable;
import gnu.bytecode.AttrContainer;
import java.lang.annotation.ElementType;
import gnu.bytecode.Member;
import java.util.ArrayList;
import gnu.text.SourceLocator;
import gnu.bytecode.Field;
import gnu.bytecode.ParameterizedType;
import java.util.Hashtable;
import gnu.bytecode.Method;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;

public class ClassExp extends LambdaExp
{
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
    public int superClassIndex;
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
    
    public void setClassType(final ClassType type) {
        this.compiledType = type;
        this.instanceType = type;
    }
    
    public ClassExp(final boolean simple, final ClassType type) {
        this.superClassIndex = -1;
        this.simple = simple;
        this.setClassType(type);
    }
    
    @Override
    protected boolean mustCompile() {
        return true;
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        this.compilePushClass(comp, target);
    }
    
    public void compilePushClass(final Compilation comp, final Target target) {
        final ClassType new_class = this.compiledType;
        final CodeAttr code = comp.getCode();
        final ClassType typeClass = Type.javalangClassType;
        final boolean needsLink = this.getNeedsClosureEnv();
        comp.loadClassRef(new_class);
        ClassType typeType;
        if (this.isSimple() && !needsLink) {
            typeType = typeClass;
        }
        else {
            int nargs;
            if (this.isMakingClassPair() || needsLink) {
                if (new_class == this.instanceType) {
                    code.emitDup(this.instanceType);
                }
                else {
                    comp.loadClassRef(this.instanceType);
                }
                typeType = ClassType.make("gnu.expr.PairClassType");
                nargs = (needsLink ? 3 : 2);
            }
            else {
                typeType = Compilation.typeType;
                nargs = 1;
            }
            final Type[] argsClass = new Type[nargs];
            if (needsLink) {
                this.getOwningLambda().loadHeapFrame(comp);
                argsClass[--nargs] = Type.objectType;
            }
            while (--nargs >= 0) {
                argsClass[nargs] = typeClass;
            }
            final Method makeMethod = typeType.addMethod("make", argsClass, typeType, 9);
            code.emitInvokeStatic(makeMethod);
        }
        target.compileFromStack(comp, typeType);
    }
    
    @Override
    protected ClassType getCompiledClassType(final Compilation comp) {
        return this.compiledType;
    }
    
    public void createFields(final Compilation comp) {
        if (this.state >= 1) {
            return;
        }
        this.state = 1;
        final Hashtable<String, Declaration> seenFields = new Hashtable<String, Declaration>();
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.getCanRead()) {
                int flags = decl.getAccessFlags((short)1);
                if (decl.getFlag(2048L)) {
                    flags |= 0x8;
                }
                final String fname = Mangling.mangleNameIfNeeded(decl.getName());
                decl.field = this.instanceType.addField(fname, null, flags);
                final Declaration old = seenFields.get(fname);
                if (old != null) {
                    ScopeExp.duplicateDeclarationError(old, decl, comp);
                }
                seenFields.put(fname, decl);
            }
        }
    }
    
    public void setTypes(final Compilation comp) {
        if (this.state >= 2) {
            return;
        }
        this.createFields(comp);
        this.state = 2;
        final int nsupers = (this.supers == null) ? 0 : this.supers.length;
        final ClassType[] superTypes = new ClassType[nsupers];
        ClassType superType = null;
        int j = 0;
        for (int i = 0; i < nsupers; ++i) {
            final Type st = Language.getDefaultLanguage().getTypeFor(this.supers[i]);
            ClassType t;
            if (st instanceof ClassType) {
                t = (ClassType)st;
            }
            else {
                if (!(st instanceof ParameterizedType)) {
                    comp.setLine(this.supers[i]);
                    comp.error('e', "invalid super type");
                    continue;
                }
                t = ((ParameterizedType)st).getRawType();
            }
            int modifiers;
            try {
                modifiers = t.getModifiers();
            }
            catch (RuntimeException ex) {
                modifiers = 0;
                if (comp != null) {
                    comp.error('e', "unknown super-type " + t.getName());
                }
            }
            if ((modifiers & 0x200) == 0x0) {
                if (j < i) {
                    comp.error('e', "duplicate superclass for " + this);
                }
                superType = t;
                this.superClassIndex = i;
            }
            else {
                superTypes[j++] = t;
            }
        }
        if (superType != null && (this.flags & 0x10000) != 0x0) {
            comp.error('e', "cannot be interface since has superclass");
        }
        if (!this.simple && superType == null && (this.flags & 0x20000) == 0x0 && (this.getFlag(262144) || (this.nameDecl != null && this.nameDecl.isPublic()))) {
            final PairClassType ptype = new PairClassType();
            (this.compiledType = ptype).setInterface(true);
            ptype.instanceType = this.instanceType;
            final ClassType[] interfaces = { this.compiledType };
            this.instanceType.setSuper(Type.pointer_type);
            this.instanceType.setInterfaces(interfaces);
        }
        else if (this.getFlag(65536)) {
            this.instanceType.setInterface(true);
        }
        this.compiledType.setSuper((superType == null) ? Type.pointer_type : superType);
        ClassType[] interfaces2;
        if (j == nsupers) {
            interfaces2 = superTypes;
        }
        else {
            interfaces2 = new ClassType[j];
            System.arraycopy(superTypes, 0, interfaces2, 0, j);
        }
        this.compiledType.setInterfaces(interfaces2);
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
                final Field fld = decl.field;
                if (decl.getCanRead()) {
                    final int fflags = decl.field.getFlags() | 0x400;
                    final String gname = slotToMethodName("get", decl.getName());
                    decl.getterMethod = this.compiledType.addMethod(gname, fflags, Type.typeArray0, null);
                    final String sname = slotToMethodName("set", decl.getName());
                    final Type[] stypes = { null };
                    decl.setterMethod = this.compiledType.addMethod(sname, fflags, stypes, Type.voidType);
                    this.instanceType.removeField(fld, prev);
                    decl.field = null;
                }
                prev = fld;
            }
        }
    }
    
    public String getClassName(final Compilation comp) {
        String name;
        if (this.classNameSpecifier != null) {
            name = this.classNameSpecifier;
        }
        else {
            name = this.getName();
            if (name != null) {
                final int nlen = name.length();
                if (nlen > 2 && name.charAt(0) == '<' && name.charAt(nlen - 1) == '>') {
                    name = name.substring(1, nlen - 1);
                }
            }
        }
        if (name == null) {
            final StringBuffer nbuf = new StringBuffer(100);
            comp.getModule().classFor(comp);
            nbuf.append(comp.mainClass.getName());
            nbuf.append('$');
            final int len = nbuf.length();
            int i = 0;
            while (true) {
                nbuf.append(i);
                name = nbuf.toString();
                if (comp.findNamedClass(name) == null) {
                    break;
                }
                nbuf.setLength(len);
                ++i;
            }
        }
        else if (!this.isSimple() || this instanceof ObjectExp) {
            name = comp.generateClassName(name);
        }
        else {
            int start = 0;
            final StringBuilder nbuf2 = new StringBuilder(100);
            while (true) {
                final int dot = name.indexOf(46, start);
                if (dot < 0) {
                    break;
                }
                nbuf2.append(Mangling.mangleClassName(name.substring(start, dot)));
                start = dot + 1;
                if (start >= name.length()) {
                    continue;
                }
                nbuf2.append('.');
            }
            if (start == 0) {
                this.setFlag(524288);
                final String mainName = (comp.mainClass == null) ? null : comp.mainClass.getName();
                final int dot2 = (mainName == null) ? -1 : mainName.lastIndexOf(46);
                if (dot2 > 0) {
                    nbuf2.append(mainName.substring(0, dot2 + 1));
                }
                else if (comp.classPrefix != null) {
                    nbuf2.append(comp.classPrefix);
                }
            }
            else if (start == 1 && start < name.length()) {
                nbuf2.setLength(0);
                nbuf2.append(comp.mainClass.getName());
                nbuf2.append('$');
            }
            else {
                this.setFlag(524288);
            }
            if (start < name.length()) {
                nbuf2.append(Mangling.mangleClassName(name.substring(start)));
            }
            name = nbuf2.toString();
        }
        return name;
    }
    
    public void declareParts(final Compilation comp) {
        if (this.state >= 3) {
            return;
        }
        this.setTypes(comp);
        this.state = 3;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.getCanRead()) {
                if (this.isMakingClassPair()) {
                    final Type ftype = decl.getType().getImplementationType();
                    decl.getterMethod.setReturnType(ftype);
                    decl.setterMethod.getParameterTypes()[0] = ftype;
                }
                else {
                    decl.setSimple(false);
                    decl.field.setType(decl.getType());
                }
            }
        }
        for (LambdaExp child = this.firstChild; child != null; child = child.nextSibling) {
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
            if ((child != this.initMethod && child != this.clinitMethod && child.nameDecl != null && !child.nameDecl.getFlag(2048L)) || !this.isMakingClassPair()) {
                child.addMethodFor(this.compiledType, comp, null);
            }
            if (this.isMakingClassPair()) {
                child.addMethodFor(this.instanceType, comp, this.compiledType);
            }
        }
        if (!this.explicitInit && !this.instanceType.isInterface()) {
            Compilation.getConstructor(this.instanceType, this);
        }
        int instanceModifiers = this.instanceType.getModifiers();
        if (this.isAbstract()) {
            instanceModifiers |= 0x400;
            this.instanceType.setModifiers(instanceModifiers);
        }
        if (this.nameDecl != null) {
            this.instanceType.setModifiers((instanceModifiers & 0xFFFFFFFE) | this.nameDecl.getAccessFlags((short)1));
        }
    }
    
    static void getImplMethods(final ClassType interfaceType, final String mname, final Type[] paramTypes, final ArrayList<Method> vec) {
        getImplMethods(interfaceType, mname, paramTypes, vec, null);
    }
    
    private static void getImplMethods(final ClassType interfaceType, final String mname, final Type[] paramTypes, final ArrayList<Method> vec, Type[] itypes) {
        ClassType implType;
        if (interfaceType instanceof PairClassType) {
            implType = ((PairClassType)interfaceType).instanceType;
        }
        else {
            if (!interfaceType.isInterface()) {
                return;
            }
            try {
                final Class reflectClass = interfaceType.getReflectClass();
                if (reflectClass == null) {
                    return;
                }
                final String implTypeName = interfaceType.getName() + "$class";
                final ClassLoader loader = reflectClass.getClassLoader();
                final Class implClass = Class.forName(implTypeName, false, loader);
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
        final Method implMethod = implType.getDeclaredMethod(mname, itypes);
        if (implMethod != null) {
            final int count = vec.size();
            if (count == 0 || !vec.get(count - 1).equals(implMethod)) {
                vec.add(implMethod);
            }
        }
        else {
            final ClassType[] superInterfaces = interfaceType.getInterfaces();
            for (int i = 0; i < superInterfaces.length; ++i) {
                getImplMethods(superInterfaces[i], mname, paramTypes, vec, itypes);
            }
        }
    }
    
    private static void usedSuperClasses(final ClassType clas, final Compilation comp) {
        comp.usedClass(clas.getSuperclass());
        final ClassType[] interfaces = clas.getInterfaces();
        if (interfaces != null) {
            int i = interfaces.length;
            while (--i >= 0) {
                comp.usedClass(interfaces[i]);
            }
        }
    }
    
    public ClassType compileMembers(final Compilation comp) {
        final ClassType saveClass = comp.curClass;
        final Method saveMethod = comp.method;
        try {
            final ClassType new_class = this.getCompiledClassType(comp);
            comp.curClass = new_class;
            final LambdaExp outer = this.outerLambda();
            Member enclosing = null;
            if (outer instanceof ClassExp) {
                enclosing = outer.compiledType;
            }
            else if (outer != null && !(outer instanceof ModuleExp)) {
                enclosing = saveMethod;
            }
            else if (outer instanceof ModuleExp && !this.getFlag(524288)) {
                enclosing = outer.compiledType;
            }
            if (enclosing != null) {
                new_class.setEnclosingMember(enclosing);
                if (enclosing instanceof ClassType) {
                    ((ClassType)enclosing).addMemberClass(new_class);
                }
            }
            if (this.instanceType != new_class) {
                this.instanceType.setEnclosingMember(this.compiledType);
                this.compiledType.addMemberClass(this.instanceType);
            }
            usedSuperClasses(this.compiledType, comp);
            if (this.compiledType != this.instanceType) {
                usedSuperClasses(this.instanceType, comp);
            }
            final String filename = this.getFileName();
            if (filename != null) {
                new_class.setSourceFile(filename);
            }
            final LambdaExp saveLambda = comp.curLambda;
            (comp.curLambda = this).allocFrame(comp);
            if (this.nameDecl != null) {
                this.nameDecl.compileAnnotations(this.compiledType, ElementType.TYPE);
            }
            for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
                decl.compileAnnotations(decl.field, ElementType.FIELD);
            }
            for (LambdaExp child = this.firstChild; child != null; child = child.nextSibling) {
                if (!child.isAbstract()) {
                    if (!child.isNative()) {
                        if (child != this.clinitMethod || this.compiledType != comp.mainClass) {
                            final Method save_method = comp.method;
                            final LambdaExp save_lambda = comp.curLambda;
                            final String saveFilename = comp.getFileName();
                            final int saveLine = comp.getLineNumber();
                            final int saveColumn = comp.getColumnNumber();
                            comp.setLine(child);
                            comp.method = child.getMainMethod();
                            final Declaration childDecl = child.nameDecl;
                            if (childDecl != null) {
                                childDecl.compileAnnotations(comp.method, ElementType.METHOD);
                            }
                            comp.curClass = this.instanceType;
                            comp.curLambda = child;
                            comp.method.initCode();
                            child.allocChildClasses(comp);
                            child.allocParameters(comp);
                            if ("*init*".equals(child.getName())) {
                                final CodeAttr code = comp.getCode();
                                if (this.staticLinkField != null) {
                                    code.emitPushThis();
                                    code.emitLoad(code.getCurrentScope().getVariable(1));
                                    code.emitPutField(this.staticLinkField);
                                }
                                final Expression bodyFirst = child.getBodyFirstExpression();
                                final ClassType calledInit = this.checkForInitCall(bodyFirst);
                                final ClassType superClass = this.instanceType.getSuperclass();
                                if (calledInit == null && superClass != null) {
                                    invokeDefaultSuperConstructor(superClass, comp, this);
                                    this.compileCallInitMethods(comp);
                                }
                                else if (calledInit != this.instanceType) {
                                    ((ApplyExp)bodyFirst).setFlag(16);
                                }
                                child.enterFunction(comp);
                                child.compileBody(comp);
                            }
                            else {
                                child.enterFunction(comp);
                                child.compileBody(comp);
                            }
                            child.compileEnd(comp);
                            child.generateApplyMethods(comp);
                            final Method thisMethod = comp.method;
                            final Type[] ptypes = thisMethod.getParameterTypes();
                            final Type rtype = thisMethod.getReturnType();
                            final ClassType superClass2 = this.instanceType.getSuperclass();
                            final Method superMethod = superClass2.getMethod(child.getName(), ptypes);
                            if (superMethod != null && superMethod.getReturnType().compare(rtype) == 1) {
                                this.generateBridgeMethod(comp, thisMethod, ptypes, superMethod.getReturnType());
                            }
                            comp.method = save_method;
                            comp.curClass = new_class;
                            comp.curLambda = save_lambda;
                            comp.setLine(saveFilename, saveLine, saveColumn);
                        }
                    }
                }
            }
            if (!this.explicitInit && !this.instanceType.isInterface()) {
                comp.generateConstructor(this.instanceType, this);
            }
            else if (this.initChain != null) {
                this.initChain.reportError("unimplemented: explicit constructor cannot initialize ", comp);
            }
            Method[] methods;
            if (this.isAbstract()) {
                methods = null;
                final int nmethods = 0;
            }
            else {
                methods = this.compiledType.getAbstractMethods();
                final int nmethods = methods.length;
            }
            for (final Method meth : methods) {
                final String mname = meth.getName();
                final Type[] ptypes2 = meth.getParameterTypes();
                final Type rtype2 = meth.getReturnType();
                final Method mimpl = this.instanceType.getMethod(mname, ptypes2);
                Label_1279: {
                    if (mimpl == null || mimpl.isAbstract()) {
                        final ArrayList<Method> vec = new ArrayList<Method>();
                        getImplMethods(this.compiledType, mname, ptypes2, vec);
                        final char ch;
                        if (vec.size() == 0 && mname.length() > 3 && mname.charAt(2) == 't' && mname.charAt(1) == 'e' && ((ch = mname.charAt(0)) == 'g' || ch == 's')) {
                            Type ftype;
                            if (ch == 's' && rtype2.isVoid() && ptypes2.length == 1) {
                                ftype = ptypes2[0];
                            }
                            else {
                                if (ch != 'g' || ptypes2.length != 0) {
                                    break Label_1279;
                                }
                                ftype = rtype2;
                            }
                            final String fname = Character.toLowerCase(mname.charAt(3)) + mname.substring(4);
                            Field fld = this.instanceType.getField(fname);
                            if (fld == null) {
                                fld = this.instanceType.addField(fname, ftype, 1);
                            }
                            final Method impl = this.instanceType.addMethod(mname, 1, ptypes2, rtype2);
                            final CodeAttr code = impl.startCode();
                            code.emitPushThis();
                            if (ch == 'g') {
                                code.emitGetField(fld);
                            }
                            else {
                                code.emitLoad(code.getArg(1));
                                code.emitPutField(fld);
                            }
                            code.emitReturn();
                        }
                        else if (vec.size() != 1) {
                            final Method impl2 = (vec.size() != 0) ? null : this.findMethodForBridge(mname, ptypes2, rtype2);
                            if (impl2 != null) {
                                this.generateBridgeMethod(comp, impl2, ptypes2, rtype2);
                            }
                            else {
                                final String msg = (vec.size() == 0) ? "missing implementation for " : "ambiguous implementation for ";
                                comp.error('e', msg + meth);
                            }
                        }
                        else {
                            final Method impl2 = this.instanceType.addMethod(mname, 1, ptypes2, rtype2);
                            final CodeAttr code = impl2.startCode();
                            for (Variable var = code.getCurrentScope().firstVar(); var != null; var = var.nextVar()) {
                                code.emitLoad(var);
                            }
                            code.emitInvokeStatic(vec.get(0));
                            code.emitReturn();
                        }
                    }
                }
            }
            this.generateApplyMethods(comp);
            comp.curLambda = saveLambda;
            return new_class;
        }
        finally {
            comp.curClass = saveClass;
            comp.method = saveMethod;
        }
    }
    
    void compileCallInitMethods(final Compilation comp) {
        comp.callInitMethods(this.getCompiledClassType(comp), new ArrayList<ClassType>(10));
    }
    
    protected Method findMethodForBridge(final String mname, final Type[] ptypes, final Type rtype) {
        Method result = null;
        for (Method method = this.compiledType.getDeclaredMethods(); method != null; method = method.getNext()) {
            if (mname.equals(method.getName()) && method.getReturnType().isSubtype(rtype) && Type.isMoreSpecific(method.getParameterTypes(), ptypes)) {
                result = method;
            }
        }
        return result;
    }
    
    public final void generateBridgeMethod(final Compilation comp, final Method src_method, final Type[] bridge_arg_types, final Type bridge_return_type) {
        final ClassType save_class = comp.curClass;
        final Method save_method = comp.method;
        try {
            comp.curClass = this.getCompiledClassType(comp);
            comp.method = comp.curClass.addMethod(src_method.getName(), 4161, bridge_arg_types, bridge_return_type);
            final Type[] src_arg_types = src_method.getParameterTypes();
            final CodeAttr code = comp.method.startCode();
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
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        final Compilation comp = visitor.getCompilation();
        if (comp == null) {
            return visitor.visitClassExp(this, d);
        }
        final ClassType saveClass = comp.curClass;
        try {
            comp.curClass = this.compiledType;
            return visitor.visitClassExp(this, d);
        }
        finally {
            comp.curClass = saveClass;
        }
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        final LambdaExp save = visitor.currentLambda;
        visitor.currentLambda = this;
        if (this.supers != null) {
            this.supers = visitor.visitExps(this.supers, this.supers.length, d);
        }
        try {
            for (LambdaExp child = this.firstChild; child != null && visitor.exitValue == null; child = child.nextSibling) {
                if (this.instanceType != null) {
                    final Declaration firstParam = child.firstDecl();
                    if (firstParam != null && firstParam.isThisParameter()) {
                        firstParam.setType(this.compiledType);
                    }
                }
                visitor.visitLambdaExp(child, d);
            }
        }
        finally {
            visitor.currentLambda = save;
        }
    }
    
    static void loadSuperStaticLink(final Expression superExp, final ClassType superClass, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        superExp.compile(comp, Target.pushValue(Compilation.typeClassType));
        code.emitInvokeStatic(ClassType.make("gnu.expr.PairClassType").getDeclaredMethod("extractStaticLink", 1));
        code.emitCheckcast(superClass.getOuterLinkType());
    }
    
    void checkDefaultSuperConstructor(final ClassType superClass, final Compilation comp) {
        if (superClass.getDeclaredMethod("<init>", 0) == null) {
            comp.error('e', "super class " + superClass.getName() + " does not have a default constructor");
        }
    }
    
    static void invokeDefaultSuperConstructor(final ClassType superClass, final Compilation comp, final LambdaExp lexp) {
        final CodeAttr code = comp.getCode();
        final Method superConstructor = superClass.getDeclaredMethod("<init>", 0);
        assert superConstructor != null;
        code.emitPushThis();
        if (superClass.hasOuterLink() && lexp instanceof ClassExp) {
            final ClassExp clExp = (ClassExp)lexp;
            final Expression superExp = clExp.supers[clExp.superClassIndex];
            loadSuperStaticLink(superExp, superClass, comp);
        }
        code.emitInvokeSpecial(superConstructor);
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(" + this.getExpClassName() + "/", ")", 2);
        final Object name = this.getSymbol();
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
        final Special prevMode = null;
        final int key_args = (this.keywords == null) ? 0 : this.keywords.length;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            out.writeSpaceFill();
            decl.printInfo(out);
        }
        for (LambdaExp child = this.firstChild; child != null; child = child.nextSibling) {
            out.writeBreakLinear();
            child.print(out);
        }
        if (this.body != null) {
            out.writeBreakLinear();
            this.body.print(out);
        }
        out.endLogicalBlock(")");
    }
    
    @Override
    public Field compileSetField(final Compilation comp) {
        final Field field = this.allocFieldFor(comp);
        if (!this.getNeedsClosureEnv() && field.getStaticFlag() && !comp.immediate && this.type != Type.javalangClassType) {
            new Literal(this.compiledType, this.type, comp.litTable).assign(field, comp.litTable);
        }
        else {
            new ClassInitializer(this, field, comp);
        }
        return field;
    }
    
    public static String slotToMethodName(final String prefix, String sname) {
        if (!Language.isValidJavaName(sname)) {
            sname = Mangling.mangleName(sname, false);
        }
        final int slen = sname.length();
        final StringBuffer sbuf = new StringBuffer(slen + 3);
        sbuf.append(prefix);
        if (slen > 0) {
            sbuf.append(Character.toTitleCase(sname.charAt(0)));
            sbuf.append(sname.substring(1));
        }
        return sbuf.toString();
    }
    
    public Declaration addMethod(final LambdaExp lexp, final Object mname) {
        final Declaration mdecl = this.addDeclaration(mname, Compilation.typeProcedure);
        lexp.setOuter(this);
        lexp.setClassMethod(true);
        mdecl.noteValue(lexp);
        mdecl.setFlag(1048576L);
        mdecl.setProcedureDecl(true);
        lexp.setSymbol(mname);
        return mdecl;
    }
}
