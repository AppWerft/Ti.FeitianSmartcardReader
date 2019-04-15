/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.GetNamedExp;
import gnu.kawa.functions.GetNamedInstancePart;
import gnu.kawa.functions.NamedPart;
import gnu.kawa.functions.SetNamedInstancePart;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.HasNamedParts;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Translator;

public class CompileNamedPart {
    static final ClassType typeHasNamedParts = ClassType.make("gnu.mapping.HasNamedParts");

    public static Expression validateGetNamedPart(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length != 2 || !(args[1] instanceof QuoteExp) || !(exp instanceof GetNamedExp)) {
            return exp;
        }
        Expression context = args[0];
        Declaration decl = null;
        if (context instanceof ReferenceExp) {
            ReferenceExp rexp = (ReferenceExp)context;
            if ("*".equals(rexp.getName())) {
                return CompileNamedPart.makeGetNamedInstancePartExp(args[1]);
            }
            decl = rexp.getBinding();
        }
        String mname = ((QuoteExp)args[1]).getValue().toString();
        Type type = context.getType();
        if (type == LangObjType.dynamicType) {
            exp.setType(LangObjType.dynamicType);
            return exp;
        }
        boolean isInstanceOperator = context == QuoteExp.nullExp;
        Compilation comp = visitor.getCompilation();
        Language language = comp.getLanguage();
        Type typeval = language.getTypeFor(context, false);
        ClassType caller = comp == null ? null : (comp.curClass != null ? comp.curClass : comp.mainClass);
        GetNamedExp nexp = (GetNamedExp)exp;
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
            ObjectType otype = (ObjectType)typeval;
            PrimProcedure[] methods = ClassMethods.getMethods(otype, Mangling.mangleName(mname), '\u0000', caller, language);
            if (methods != null && methods.length > 0) {
                nexp.methods = methods;
                nexp.otype = otype;
                nexp.mname = mname;
                return nexp.setProcedureKind('S');
            }
            ApplyExp aexp = new ApplyExp(SlotGet.staticField, args);
            aexp.setLine(exp);
            return visitor.visitApplyOnly(aexp, required);
        }
        if (typeval != null) {
            // empty if block
        }
        if (type.isSubtype(Compilation.typeClassType) || type.isSubtype(Type.javalangClassType)) {
            return exp;
        }
        if (type instanceof ObjectType) {
            ObjectType otype = (ObjectType)type;
            PrimProcedure[] methods = ClassMethods.getMethods(otype, Mangling.mangleName(mname), 'V', caller, language);
            if (methods != null && methods.length > 0) {
                nexp.methods = methods;
                return nexp.setProcedureKind('M');
            }
            if (type.isSubtype(typeHasNamedParts)) {
                Object val;
                HasNamedParts value;
                if (decl != null && (val = Declaration.followAliases(decl).getConstantValue()) != null && (value = (HasNamedParts)val).isConstant(mname)) {
                    val = value.get(mname);
                    return QuoteExp.getInstance(val);
                }
                args = new Expression[]{args[0], QuoteExp.getInstance(mname)};
                return new ApplyExp(typeHasNamedParts.getDeclaredMethod("get", 1), args).setLine(exp);
            }
            Member part = SlotGet.lookupMember(otype, mname, caller);
            if (part != null || mname.equals("length") && type instanceof ArrayType) {
                ApplyExp aexp = new ApplyExp(SlotGet.field, args);
                aexp.setLine(exp);
                return visitor.visitApplyOnly(aexp, required);
            }
        }
        if (comp.warnUnknownMember()) {
            comp.error('w', "no known slot '" + mname + "' in " + type.getName());
        }
        return exp;
    }

    public static Expression validateSetNamedPart(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Member part;
        Expression[] args = exp.getArgs();
        if (args.length != 3 || !(args[1] instanceof QuoteExp)) {
            exp.visitArgs(visitor);
            return exp;
        }
        args[0] = visitor.visit(args[0], null);
        args[1] = visitor.visit(args[1], null);
        Expression context = args[0];
        String mname = ((QuoteExp)args[1]).getValue().toString();
        Type type = context.getType();
        Compilation comp = visitor.getCompilation();
        Language language = comp.getLanguage();
        Type typeval = language.getTypeFor(context);
        ClassType caller = comp == null ? null : (comp.curClass != null ? comp.curClass : comp.mainClass);
        ApplyExp original = exp;
        if (typeval instanceof ClassType) {
            exp = new ApplyExp(SlotSet.set$Mnstatic$Mnfield$Ex, args);
        } else if (type instanceof ClassType && (part = SlotSet.lookupMember((ClassType)type, mname, caller)) != null) {
            return visitor.visit(CompileReflect.makeSetterCall(args[0], part, args[2]), Type.voidType);
        }
        exp.setType(Type.voidType);
        if (exp == original) {
            args[2] = visitor.visit(args[2], null);
            return exp;
        }
        exp.setLine(original);
        return visitor.visit((Expression)exp, required);
    }

    public static Expression makeExp(Expression clas, Expression member) {
        ReferenceExp rexp;
        String combinedName = CompileNamedPart.combineName(clas, member);
        Environment env = Environment.getCurrent();
        if (combinedName != null) {
            Translator tr = (Translator)Compilation.getCurrent();
            Symbol symbol = Namespace.EmptyNamespace.getSymbol(combinedName);
            Declaration decl = tr.lexical.lookup((Object)symbol, false);
            if (!Declaration.isUnknown(decl)) {
                return new ReferenceExp(decl);
            }
            Object property = null;
            if (symbol != null && env.isBound(symbol, property)) {
                return new ReferenceExp(combinedName);
            }
        }
        if (clas instanceof ReferenceExp && (rexp = (ReferenceExp)clas).isUnknown()) {
            Symbol sym;
            Object rsym = rexp.getSymbol();
            Symbol symbol = sym = rsym instanceof Symbol ? (Symbol)rsym : env.getSymbol(rsym.toString());
            if (env.get(sym, null) == null) {
                String name = rexp.getName();
                try {
                    Class cl = ClassType.getContextClass(name);
                    clas = QuoteExp.getInstance(Type.make(cl));
                }
                catch (Exception ex) {
                    // empty catch block
                }
            }
        }
        Expression[] args = new Expression[]{clas, member};
        GetNamedExp exp = new GetNamedExp(args);
        exp.combinedName = combinedName;
        return exp;
    }

    public static String combineName(Expression part1, Expression part2) {
        String name1;
        Object name2 = part2.valueIfConstant();
        if (name2 instanceof SimpleSymbol && (part1 instanceof ReferenceExp && (name1 = ((ReferenceExp)part1).getSimpleName()) != null || part1 instanceof GetNamedExp && (name1 = ((GetNamedExp)part1).combinedName) != null)) {
            return (name1 + ':' + name2).intern();
        }
        return null;
    }

    public static Expression makeExp(Expression clas, String member) {
        return CompileNamedPart.makeExp(clas, new QuoteExp(member));
    }

    public static Expression makeExp(Type type, String member) {
        return CompileNamedPart.makeExp((Expression)new QuoteExp(type), new QuoteExp(member));
    }

    public static Expression validateNamedPart(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        NamedPart namedPart = (NamedPart)proc;
        switch (namedPart.kind) {
            case 'D': {
                SlotGet slotProc;
                String fname = namedPart.member.toString().substring(1);
                Expression[] xargs = new Expression[2];
                xargs[1] = QuoteExp.getInstance(fname);
                if (args.length > 0) {
                    xargs[0] = Compilation.makeCoercion(args[0], new QuoteExp(namedPart.container));
                    slotProc = SlotGet.field;
                } else {
                    xargs[0] = QuoteExp.getInstance(namedPart.container);
                    slotProc = SlotGet.staticField;
                }
                ApplyExp aexp = new ApplyExp(slotProc, xargs);
                aexp.setLine(exp);
                return visitor.visitApplyOnly(aexp, required);
            }
        }
        return exp;
    }

    public static Expression validateNamedPartSetter(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        NamedPart get = (NamedPart)((NamedPart.Setter)proc).getGetter();
        if (get.kind == 'D') {
            SlotSet slotProc;
            Expression[] xargs = new Expression[3];
            xargs[1] = QuoteExp.getInstance(get.member.toString().substring(1));
            xargs[2] = exp.getArgs()[0];
            if (exp.getArgCount() == 1) {
                xargs[0] = QuoteExp.getInstance(get.container);
                slotProc = SlotSet.set$Mnstatic$Mnfield$Ex;
            } else if (exp.getArgCount() == 2) {
                xargs[0] = Compilation.makeCoercion(exp.getArgs()[0], new QuoteExp(get.container));
                slotProc = SlotSet.set$Mnfield$Ex;
            } else {
                return exp;
            }
            ApplyExp aexp = new ApplyExp(slotProc, xargs);
            aexp.setLine(exp);
            return visitor.visitApplyOnly(aexp, required);
        }
        return exp;
    }

    public static Expression makeGetNamedInstancePartExp(Expression member) {
        Object val;
        if (member instanceof QuoteExp && (val = ((QuoteExp)member).getValue()) instanceof SimpleSymbol) {
            return QuoteExp.getInstance(new GetNamedInstancePart(val.toString()));
        }
        return new ApplyExp(Invoke.make, new QuoteExp(ClassType.make("gnu.kawa.functions.GetNamedInstancePart")), member);
    }

    public static Expression validateGetNamedInstancePart(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Procedure property;
        Expression[] xargs;
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        GetNamedInstancePart gproc = (GetNamedInstancePart)proc;
        if (gproc.isField) {
            xargs = new Expression[]{args[0], new QuoteExp(gproc.pname)};
            property = SlotGet.field;
        } else {
            int nargs = args.length;
            xargs = new Expression[nargs + 1];
            xargs[0] = args[0];
            xargs[1] = new QuoteExp(gproc.pname);
            System.arraycopy(args, 1, xargs, 2, nargs - 1);
            property = Invoke.invoke;
        }
        return visitor.visitApplyOnly(new ApplyExp(property, xargs), required);
    }

    public static Expression validateSetNamedInstancePart(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        String pname = ((SetNamedInstancePart)proc).pname;
        Expression[] xargs = new Expression[]{args[0], new QuoteExp(pname), args[1]};
        return visitor.visitApplyOnly(new ApplyExp(SlotSet.set$Mnfield$Ex, xargs), required);
    }
}

