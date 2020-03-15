// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.kawa.reflect.Invoke;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;
import gnu.mapping.Namespace;
import kawa.lang.Translator;
import gnu.mapping.Environment;
import gnu.kawa.reflect.SlotSet;
import gnu.bytecode.Member;
import gnu.expr.PrimProcedure;
import gnu.expr.Language;
import gnu.bytecode.ArrayType;
import gnu.mapping.HasNamedParts;
import gnu.expr.Declaration;
import gnu.expr.Compilation;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.ClassMethods;
import gnu.expr.Mangling;
import gnu.kawa.reflect.CompileReflect;
import gnu.bytecode.ObjectType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.ReferenceExp;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.bytecode.ClassType;

public class CompileNamedPart
{
    static final ClassType typeHasNamedParts;
    
    public static Expression validateGetNamedPart(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length != 2 || !(args[1] instanceof QuoteExp) || !(exp instanceof GetNamedExp)) {
            return exp;
        }
        final Expression context = args[0];
        Declaration decl = null;
        if (context instanceof ReferenceExp) {
            final ReferenceExp rexp = (ReferenceExp)context;
            if ("*".equals(rexp.getName())) {
                return makeGetNamedInstancePartExp(args[1]);
            }
            decl = rexp.getBinding();
        }
        final String mname = ((QuoteExp)args[1]).getValue().toString();
        final Type type = context.getType();
        if (type == LangObjType.dynamicType) {
            exp.setType(LangObjType.dynamicType);
            return exp;
        }
        final boolean isInstanceOperator = context == QuoteExp.nullExp;
        final Compilation comp = visitor.getCompilation();
        final Language language = comp.getLanguage();
        final Type typeval = language.getTypeFor(context, false);
        final ClassType caller = (comp == null) ? null : ((comp.curClass != null) ? comp.curClass : comp.mainClass);
        final GetNamedExp nexp = (GetNamedExp)exp;
        if (typeval != null) {
            if (mname.equals("<>")) {
                return new QuoteExp(typeval);
            }
            if (typeval instanceof ObjectType) {
                if (mname.equals("new")) {
                    return nexp.setProcedureKind('N');
                }
                if (mname.equals("instance?")) {
                    return nexp.setProcedureKind('I');
                }
                if (mname.equals("@")) {
                    return nexp.setProcedureKind('C');
                }
            }
        }
        if (typeval instanceof ObjectType) {
            if (mname.length() > 1 && mname.charAt(0) == '.') {
                return new QuoteExp(new NamedPart(typeval, mname, 'D'));
            }
            if (CompileReflect.checkKnownClass(typeval, comp) < 0) {
                return exp;
            }
            final ObjectType otype = (ObjectType)typeval;
            final PrimProcedure[] methods = ClassMethods.getMethods(otype, Mangling.mangleName(mname), '\0', caller, language);
            if (methods != null && methods.length > 0) {
                nexp.methods = methods;
                nexp.otype = otype;
                nexp.mname = mname;
                return nexp.setProcedureKind('S');
            }
            final ApplyExp aexp = new ApplyExp(SlotGet.staticField, args);
            aexp.setLine(exp);
            return visitor.visitApplyOnly(aexp, required);
        }
        else {
            if (typeval != null) {}
            if (type.isSubtype(Compilation.typeClassType) || type.isSubtype(Type.javalangClassType)) {
                return exp;
            }
            if (type instanceof ObjectType) {
                final ObjectType otype = (ObjectType)type;
                final PrimProcedure[] methods = ClassMethods.getMethods(otype, Mangling.mangleName(mname), 'V', caller, language);
                if (methods != null && methods.length > 0) {
                    nexp.methods = methods;
                    return nexp.setProcedureKind('M');
                }
                if (type.isSubtype(CompileNamedPart.typeHasNamedParts)) {
                    Object val;
                    if (decl != null && (val = Declaration.followAliases(decl).getConstantValue()) != null) {
                        final HasNamedParts value = (HasNamedParts)val;
                        if (value.isConstant(mname)) {
                            val = value.get(mname);
                            return QuoteExp.getInstance(val);
                        }
                    }
                    args = new Expression[] { args[0], QuoteExp.getInstance(mname) };
                    return new ApplyExp(CompileNamedPart.typeHasNamedParts.getDeclaredMethod("get", 1), args).setLine(exp);
                }
                final Member part = SlotGet.lookupMember(otype, mname, caller);
                if (part != null || (mname.equals("length") && type instanceof ArrayType)) {
                    final ApplyExp aexp2 = new ApplyExp(SlotGet.field, args);
                    aexp2.setLine(exp);
                    return visitor.visitApplyOnly(aexp2, required);
                }
            }
            if (comp.warnUnknownMember()) {
                comp.error('w', "no known slot '" + mname + "' in " + type.getName());
            }
            return exp;
        }
    }
    
    public static Expression validateSetNamedPart(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        if (args.length != 3 || !(args[1] instanceof QuoteExp)) {
            exp.visitArgs(visitor);
            return exp;
        }
        args[0] = visitor.visit(args[0], (Type)null);
        args[1] = visitor.visit(args[1], (Type)null);
        final Expression context = args[0];
        final String mname = ((QuoteExp)args[1]).getValue().toString();
        final Type type = context.getType();
        final Compilation comp = visitor.getCompilation();
        final Language language = comp.getLanguage();
        final Type typeval = language.getTypeFor(context);
        final ClassType caller = (comp == null) ? null : ((comp.curClass != null) ? comp.curClass : comp.mainClass);
        final ApplyExp original = exp;
        if (typeval instanceof ClassType) {
            exp = new ApplyExp(SlotSet.set$Mnstatic$Mnfield$Ex, args);
        }
        else if (type instanceof ClassType) {
            final Member part = SlotSet.lookupMember((ObjectType)type, mname, caller);
            if (part != null) {
                return visitor.visit(CompileReflect.makeSetterCall(args[0], part, args[2]), Type.voidType);
            }
        }
        exp.setType(Type.voidType);
        if (exp == original) {
            args[2] = visitor.visit(args[2], (Type)null);
            return exp;
        }
        exp.setLine(original);
        return visitor.visit(exp, required);
    }
    
    public static Expression makeExp(Expression clas, final Expression member) {
        final String combinedName = combineName(clas, member);
        final Environment env = Environment.getCurrent();
        if (combinedName != null) {
            final Translator tr = (Translator)Compilation.getCurrent();
            final Symbol symbol = Namespace.EmptyNamespace.getSymbol(combinedName);
            final Declaration decl = tr.lexical.lookup(symbol, false);
            if (!Declaration.isUnknown(decl)) {
                return new ReferenceExp(decl);
            }
            final Object property = null;
            if (symbol != null && env.isBound(symbol, property)) {
                return new ReferenceExp((Object)combinedName);
            }
        }
        final ReferenceExp rexp;
        if (clas instanceof ReferenceExp && (rexp = (ReferenceExp)clas).isUnknown()) {
            final Object rsym = rexp.getSymbol();
            final Symbol sym = (Symbol)((rsym instanceof Symbol) ? rsym : env.getSymbol(rsym.toString()));
            if (env.get(sym, null) == null) {
                final String name = rexp.getName();
                try {
                    final Class cl = ObjectType.getContextClass(name);
                    clas = QuoteExp.getInstance(Type.make(cl));
                }
                catch (Exception ex) {}
            }
        }
        final Expression[] args = { clas, member };
        final GetNamedExp exp = new GetNamedExp(args);
        exp.combinedName = combinedName;
        return exp;
    }
    
    public static String combineName(final Expression part1, final Expression part2) {
        final Object name2;
        String name3;
        if ((name2 = part2.valueIfConstant()) instanceof SimpleSymbol && ((part1 instanceof ReferenceExp && (name3 = ((ReferenceExp)part1).getSimpleName()) != null) || (part1 instanceof GetNamedExp && (name3 = ((GetNamedExp)part1).combinedName) != null))) {
            return (name3 + ':' + name2).intern();
        }
        return null;
    }
    
    public static Expression makeExp(final Expression clas, final String member) {
        return makeExp(clas, new QuoteExp((Object)member));
    }
    
    public static Expression makeExp(final Type type, final String member) {
        return makeExp(new QuoteExp(type), new QuoteExp((Object)member));
    }
    
    public static Expression validateNamedPart(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final NamedPart namedPart = (NamedPart)proc;
        switch (namedPart.kind) {
            case 'D': {
                final String fname = namedPart.member.toString().substring(1);
                final Expression[] xargs = { null, QuoteExp.getInstance(fname) };
                SlotGet slotProc;
                if (args.length > 0) {
                    xargs[0] = Compilation.makeCoercion(args[0], new QuoteExp(namedPart.container));
                    slotProc = SlotGet.field;
                }
                else {
                    xargs[0] = QuoteExp.getInstance(namedPart.container);
                    slotProc = SlotGet.staticField;
                }
                final ApplyExp aexp = new ApplyExp(slotProc, xargs);
                aexp.setLine(exp);
                return visitor.visitApplyOnly(aexp, required);
            }
            default: {
                return exp;
            }
        }
    }
    
    public static Expression validateNamedPartSetter(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final NamedPart get = (NamedPart)((NamedPart.Setter)proc).getGetter();
        if (get.kind == 'D') {
            final Expression[] xargs = { null, QuoteExp.getInstance(get.member.toString().substring(1)), exp.getArgs()[0] };
            SlotSet slotProc;
            if (exp.getArgCount() == 1) {
                xargs[0] = QuoteExp.getInstance(get.container);
                slotProc = SlotSet.set$Mnstatic$Mnfield$Ex;
            }
            else {
                if (exp.getArgCount() != 2) {
                    return exp;
                }
                xargs[0] = Compilation.makeCoercion(exp.getArgs()[0], new QuoteExp(get.container));
                slotProc = SlotSet.set$Mnfield$Ex;
            }
            final ApplyExp aexp = new ApplyExp(slotProc, xargs);
            aexp.setLine(exp);
            return visitor.visitApplyOnly(aexp, required);
        }
        return exp;
    }
    
    public static Expression makeGetNamedInstancePartExp(final Expression member) {
        if (member instanceof QuoteExp) {
            final Object val = ((QuoteExp)member).getValue();
            if (val instanceof SimpleSymbol) {
                return QuoteExp.getInstance(new GetNamedInstancePart(val.toString()));
            }
        }
        return new ApplyExp(Invoke.make, new Expression[] { new QuoteExp(ClassType.make("gnu.kawa.functions.GetNamedInstancePart")), member });
    }
    
    public static Expression validateGetNamedInstancePart(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final GetNamedInstancePart gproc = (GetNamedInstancePart)proc;
        Expression[] xargs;
        Procedure property;
        if (gproc.isField) {
            xargs = new Expression[] { args[0], new QuoteExp((Object)gproc.pname) };
            property = SlotGet.field;
        }
        else {
            final int nargs = args.length;
            xargs = new Expression[nargs + 1];
            xargs[0] = args[0];
            xargs[1] = new QuoteExp((Object)gproc.pname);
            System.arraycopy(args, 1, xargs, 2, nargs - 1);
            property = Invoke.invoke;
        }
        return visitor.visitApplyOnly(new ApplyExp(property, xargs), required);
    }
    
    public static Expression validateSetNamedInstancePart(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final String pname = ((SetNamedInstancePart)proc).pname;
        final Expression[] xargs = { args[0], new QuoteExp((Object)pname), args[1] };
        return visitor.visitApplyOnly(new ApplyExp(SlotSet.set$Mnfield$Ex, xargs), required);
    }
    
    static {
        typeHasNamedParts = ClassType.make("gnu.mapping.HasNamedParts");
    }
}
