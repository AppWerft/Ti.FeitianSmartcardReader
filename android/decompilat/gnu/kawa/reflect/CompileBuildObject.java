// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.Keyword;
import gnu.expr.BeginExp;
import gnu.mapping.Procedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ClassExp;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.mapping.Symbol;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Declaration;
import gnu.mapping.Namespace;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Compilation;
import gnu.expr.PrimProcedure;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;

public class CompileBuildObject
{
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
    
    public boolean resultTypeExtends(final ObjectType other) {
        return this.ctype.isSubtype(other);
    }
    
    public boolean resultTypeExtends(final Class other) {
        return this.ctype.isSubtype(Type.make(other));
    }
    
    public Expression getArg(final int i) {
        return this.exp.getArg(i);
    }
    
    public int getArgCount() {
        return this.exp.getArgCount();
    }
    
    public void setArg(final int i, final Expression arg) {
        this.exp.setArg(i, arg);
    }
    
    public int numKeywordArgs() {
        return this.exp.numKeywordArgs;
    }
    
    public int keywordStart() {
        return (this.exp.numKeywordArgs == 0) ? 1 : (this.exp.firstKeywordArgIndex - 1);
    }
    
    public void insertArgument(final int index, final Expression arg) {
        final Expression[] args = this.exp.getArgs();
        final Expression[] xargs = new Expression[args.length + 1];
        System.arraycopy(args, 0, xargs, 0, index);
        xargs[index] = arg;
        System.arraycopy(args, index, xargs, index + 1, args.length - index);
        this.exp.setArgs(xargs);
        this.exp.adjustSplice(this.exp, 1);
    }
    
    protected void init(final ApplyExp exp, final InlineCalls visitor, final Type required, final ObjectType ctype, final ClassType caller) {
        this.exp = exp;
        this.visitor = visitor;
        this.required = required;
        this.ctype = ctype;
        this.caller = caller;
    }
    
    public static CompileBuildObject make(final ApplyExp exp, final InlineCalls visitor, final Type required, final ObjectType ctype, final ClassType caller) {
        String builderName = null;
        Class builderClass = null;
        final Compilation comp = visitor.getCompilation();
        final Namespace ns = Namespace.valueOfNoCreate("gnu.kawa.reflect/ObjectBuilder");
        if (ns != null) {
            ObjectType btype = ctype;
            while (builderName == null) {
                final Symbol sym = ns.lookup(btype.getName());
                if (sym != null) {
                    Declaration builderDecl = comp.lookup(sym, 1);
                    if (builderDecl != null) {
                        builderDecl = Declaration.followAliases(builderDecl);
                        final Object val = builderDecl.getValue().valueIfConstant();
                        if (val instanceof String) {
                            builderName = (String)val;
                        }
                        if (val instanceof Class) {
                            builderClass = (Class)val;
                            builderName = builderClass.getName();
                        }
                    }
                }
                if (!(btype instanceof ClassType)) {
                    break;
                }
                btype = ((ClassType)btype).getSuperclass();
                if (btype == null) {
                    break;
                }
                if (btype == Type.objectType) {
                    break;
                }
            }
        }
        CompileBuildObject builder;
        if (builderName != null) {
            final ClassLoader loader = ObjectType.getContextClassLoader();
            try {
                if (builderClass == null) {
                    builderClass = Class.forName(builderName, false, loader);
                }
                builder = builderClass.newInstance();
            }
            catch (Exception ex) {
                comp.error('w', "while creating " + builderName + " for " + ctype + " - caught " + ex + " loader:" + loader);
                builder = new CompileBuildObject();
            }
        }
        else if (ctype instanceof LangObjType) {
            builder = ((LangObjType)ctype).getBuildObject();
        }
        else {
            builder = new CompileBuildObject();
        }
        builder.init(exp, visitor, required, ctype, caller);
        return builder;
    }
    
    public void setDefaultConstructor(final PrimProcedure proc) {
        this.defaultConstructor = proc;
        this.defaultConstructorSet = true;
    }
    
    public PrimProcedure getDefaultConstructor() {
        if (!this.defaultConstructorSet) {
            final Type rtype = this.ctype.getRealType();
            if (rtype instanceof ClassType) {
                final Method meth = ((ClassType)rtype).getDefaultConstructor();
                if (meth != null) {
                    this.defaultConstructor = new PrimProcedure(meth, this.getLanguage());
                }
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
    
    public Member findNamedMember(final String name) {
        Member member = SlotSet.lookupMember(this.ctype, name, this.caller);
        if (member == null) {
            final String mname = (name.length() == 0) ? this.getAddChildMethodName() : ClassExp.slotToMethodName("add", name);
            member = this.ctype.getMethod(mname, SlotSet.type1Array);
        }
        return member;
    }
    
    public Expression buildSetter(final Declaration target, final Member member, final Expression value) {
        return CompileReflect.makeSetterCall(new ReferenceExp(target), member, value);
    }
    
    public String getAddChildMethodName() {
        return "add";
    }
    
    public Expression buildAddChild(final Declaration target, final Expression child) {
        final Expression[] iargs = { new ReferenceExp(target), QuoteExp.getInstance(this.getAddChildMethodName()), child };
        return new ApplyExp(Invoke.invoke, iargs);
    }
    
    public boolean useBuilder(final int numCode, final InlineCalls visitor) {
        return (this.numKeywordArgs() > 0 && numCode > 0) || (numCode == -917504 && this.hasDefaultConstructor() && this.hasAddChildMethod());
    }
    
    public Expression build() {
        final Compilation comp = this.getCompilation();
        final Expression[] args = this.exp.getArgs();
        final StringBuffer errbuf = null;
        Expression e;
        if (this.numKeywordArgs() > 0) {
            final int keywordStart = this.keywordStart();
            final Expression[] xargs = new Expression[keywordStart];
            System.arraycopy(args, 0, xargs, 0, keywordStart);
            e = this.visitor.visit(new ApplyExp(this.exp.getFunction(), xargs), this.ctype);
        }
        else {
            final ApplyExp ae = new ApplyExp(this.defaultConstructor, new Expression[] { args[0] });
            ae.setType(this.ctype);
            e = ae;
        }
        comp.letStart();
        final Declaration adecl = comp.letVariable(null, this.ctype, e);
        adecl.setFlag(549755813888L);
        adecl.setCanRead(true);
        final BeginExp begin = new BeginExp();
        final int numKeys = this.numKeywordArgs();
        final int keywordStart2 = this.keywordStart();
        for (int j = 0; j < numKeys; ++j) {
            final int i = keywordStart2 + 2 * j;
            final Object value = args[i].valueIfConstant();
            final String name = ((Keyword)value).getName();
            final Member slot = this.findNamedMember(name);
            if (slot == null) {
                comp.error('w', "no field or setter '" + name + "' in class " + this.ctype.getName());
            }
            else {
                begin.add(this.visitor.visit(this.buildSetter(adecl, slot, args[i + 1]), Type.voidType));
            }
        }
        for (int k = keywordStart2 + 2 * numKeys; k < args.length; ++k) {
            begin.add(this.visitor.visit(this.buildAddChild(adecl, args[k]), (Type)null));
        }
        final ReferenceExp aref = new ReferenceExp(adecl);
        aref.setFlag(32);
        begin.add(aref);
        return this.visitor.checkType(comp.letDone(begin).setLine(this.exp), this.required);
    }
}
