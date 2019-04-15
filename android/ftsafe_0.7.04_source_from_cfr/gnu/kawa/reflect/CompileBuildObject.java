/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class CompileBuildObject {
    ApplyExp exp;
    InlineCalls visitor;
    Type required;
    ObjectType ctype;
    ClassType caller;
    boolean defaultConstructorSet;
    PrimProcedure defaultConstructor;

    public Compilation getCompilation() {
        return this.visitor.getCompilation();
    }

    public Language getLanguage() {
        return this.getCompilation().getLanguage();
    }

    public ObjectType getResultType() {
        return this.ctype;
    }

    public boolean resultTypeExtends(ObjectType other) {
        return this.ctype.isSubtype(other);
    }

    public boolean resultTypeExtends(Class other) {
        return this.ctype.isSubtype(ClassType.make(other));
    }

    public Expression getArg(int i) {
        return this.exp.getArg(i);
    }

    public int getArgCount() {
        return this.exp.getArgCount();
    }

    public void setArg(int i, Expression arg) {
        this.exp.setArg(i, arg);
    }

    public int numKeywordArgs() {
        return this.exp.numKeywordArgs;
    }

    public int keywordStart() {
        return this.exp.numKeywordArgs == 0 ? 1 : this.exp.firstKeywordArgIndex - 1;
    }

    public void insertArgument(int index, Expression arg) {
        Expression[] args = this.exp.getArgs();
        Expression[] xargs = new Expression[args.length + 1];
        System.arraycopy(args, 0, xargs, 0, index);
        xargs[index] = arg;
        System.arraycopy(args, index, xargs, index + 1, args.length - index);
        this.exp.setArgs(xargs);
        this.exp.adjustSplice(this.exp, 1);
    }

    protected void init(ApplyExp exp, InlineCalls visitor, Type required, ObjectType ctype, ClassType caller) {
        this.exp = exp;
        this.visitor = visitor;
        this.required = required;
        this.ctype = ctype;
        this.caller = caller;
    }

    public static CompileBuildObject make(ApplyExp exp, InlineCalls visitor, Type required, ObjectType ctype, ClassType caller) {
        CompileBuildObject builder;
        String builderName = null;
        Class builderClass = null;
        Compilation comp = visitor.getCompilation();
        Namespace ns = Namespace.valueOfNoCreate("gnu.kawa.reflect/ObjectBuilder");
        if (ns != null) {
            ObjectType btype = ctype;
            while (builderName == null) {
                Declaration builderDecl;
                Symbol sym = ns.lookup(btype.getName());
                if (sym != null && (builderDecl = comp.lookup(sym, 1)) != null) {
                    Object val = (builderDecl = Declaration.followAliases(builderDecl)).getValue().valueIfConstant();
                    if (val instanceof String) {
                        builderName = (String)val;
                    }
                    if (val instanceof Class) {
                        builderClass = (Class)val;
                        builderName = builderClass.getName();
                    }
                }
                if (btype instanceof ClassType && (btype = ((ClassType)btype).getSuperclass()) != null && btype != Type.objectType) continue;
                break;
            }
        }
        if (builderName != null) {
            ClassLoader loader = ObjectType.getContextClassLoader();
            try {
                if (builderClass == null) {
                    builderClass = Class.forName(builderName, false, loader);
                }
                builder = (CompileBuildObject)builderClass.newInstance();
            }
            catch (Exception ex) {
                comp.error('w', "while creating " + builderName + " for " + ctype + " - caught " + ex + " loader:" + loader);
                builder = new CompileBuildObject();
            }
        } else {
            builder = ctype instanceof LangObjType ? ((LangObjType)ctype).getBuildObject() : new CompileBuildObject();
        }
        builder.init(exp, visitor, required, ctype, caller);
        return builder;
    }

    public void setDefaultConstructor(PrimProcedure proc) {
        this.defaultConstructor = proc;
        this.defaultConstructorSet = true;
    }

    public PrimProcedure getDefaultConstructor() {
        if (!this.defaultConstructorSet) {
            Method meth;
            Type rtype = this.ctype.getRealType();
            if (rtype instanceof ClassType && (meth = ((ClassType)rtype).getDefaultConstructor()) != null) {
                this.defaultConstructor = new PrimProcedure(meth, this.getLanguage());
            }
            this.defaultConstructorSet = true;
        }
        return this.defaultConstructor;
    }

    public boolean hasDefaultConstructor() {
        return this.getDefaultConstructor() != null;
    }

    public boolean hasAddChildMethod() {
        return ClassMethods.selectApplicable(ClassMethods.getMethods(this.ctype, this.getAddChildMethodName(), 'V', null, this.getLanguage()), 2, false) > 0;
    }

    public Member findNamedMember(String name) {
        Member member = SlotSet.lookupMember(this.ctype, name, this.caller);
        if (member == null) {
            String mname = name.length() == 0 ? this.getAddChildMethodName() : ClassExp.slotToMethodName("add", name);
            member = this.ctype.getMethod(mname, SlotSet.type1Array);
        }
        return member;
    }

    public Expression buildSetter(Declaration target, Member member, Expression value) {
        return CompileReflect.makeSetterCall(new ReferenceExp(target), member, value);
    }

    public String getAddChildMethodName() {
        return "add";
    }

    public Expression buildAddChild(Declaration target, Expression child) {
        Expression[] iargs = new Expression[]{new ReferenceExp(target), QuoteExp.getInstance(this.getAddChildMethodName()), child};
        return new ApplyExp(Invoke.invoke, iargs);
    }

    public boolean useBuilder(int numCode, InlineCalls visitor) {
        if (this.numKeywordArgs() > 0 && numCode > 0) {
            return true;
        }
        return numCode == -917504 && this.hasDefaultConstructor() && this.hasAddChildMethod();
    }

    public Expression build() {
        Expression e;
        Compilation comp = this.getCompilation();
        Expression[] args = this.exp.getArgs();
        Object errbuf = null;
        if (this.numKeywordArgs() > 0) {
            int keywordStart = this.keywordStart();
            Expression[] xargs = new Expression[keywordStart];
            System.arraycopy(args, 0, xargs, 0, keywordStart);
            e = this.visitor.visit((Expression)new ApplyExp(this.exp.getFunction(), xargs), this.ctype);
        } else {
            ApplyExp ae = new ApplyExp(this.defaultConstructor, args[0]);
            ae.setType(this.ctype);
            e = ae;
        }
        comp.letStart();
        Declaration adecl = comp.letVariable(null, this.ctype, e);
        adecl.setFlag(0x8000000000L);
        adecl.setCanRead(true);
        BeginExp begin2 = new BeginExp();
        int numKeys = this.numKeywordArgs();
        int keywordStart = this.keywordStart();
        for (int j = 0; j < numKeys; ++j) {
            int i = keywordStart + 2 * j;
            Object value = args[i].valueIfConstant();
            String name = ((Keyword)value).getName();
            Member slot = this.findNamedMember(name);
            if (slot == null) {
                comp.error('w', "no field or setter '" + name + "' in class " + this.ctype.getName());
                continue;
            }
            begin2.add(this.visitor.visit(this.buildSetter(adecl, slot, args[i + 1]), Type.voidType));
        }
        for (int i = keywordStart + 2 * numKeys; i < args.length; ++i) {
            begin2.add(this.visitor.visit(this.buildAddChild(adecl, args[i]), null));
        }
        ReferenceExp aref = new ReferenceExp(adecl);
        aref.setFlag(32);
        begin2.add(aref);
        return this.visitor.checkType(comp.letDone(begin2).setLine(this.exp), this.required);
    }
}

