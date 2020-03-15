// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.Method;
import gnu.expr.Language;
import gnu.bytecode.PrimType;
import gnu.expr.TypeValue;
import gnu.bytecode.ParameterizedType;
import gnu.expr.LetExp;
import gnu.expr.Declaration;
import gnu.expr.Compilation;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.MakeSplice;
import gnu.expr.BeginExp;
import java.lang.reflect.Array;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.text.SourceLocator;
import gnu.bytecode.ObjectType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.PairClassType;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;

public class CompileInvoke
{
    public static Expression validateApplyInvoke(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Invoke iproc = (Invoke)proc;
        final char kind = iproc.kind;
        final Compilation comp = visitor.getCompilation();
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        if (nargs == 0 || ((kind == 'V' || kind == '*') && nargs == 1)) {
            exp.visitArgs(visitor);
            return exp;
        }
        final Expression arg0 = visitor.visit(args[0], (Type)null);
        args[0] = arg0;
        final Type type0 = (kind == 'V' || kind == '*') ? arg0.getType() : iproc.language.getTypeFor(arg0);
        ObjectType type2;
        if (type0 instanceof PairClassType && kind == 'N') {
            type2 = ((PairClassType)type0).instanceType;
        }
        else if (type0 instanceof LangObjType && kind == 'N') {
            type2 = ((LangObjType)type0).getConstructorType();
        }
        else if (type0 instanceof ObjectType) {
            type2 = (ObjectType)type0;
        }
        else {
            type2 = null;
        }
        if (kind == 'P') {
            if (type0 == null) {
                comp.error('e', "unknown class for invoke-special", arg0);
            }
            else if (!(type2 instanceof ClassType) || type2.isInterface()) {
                comp.error('e', "invalid class for invoke-special", arg0);
            }
        }
        String name = getMethodName(args, kind);
        if (kind == 'N' && type2 == LangObjType.constVectorType && required instanceof ArrayType) {
            type2 = (ObjectType)required;
        }
        if (kind == 'N' && type2 instanceof ArrayType) {
            final ArrayType atype = (ArrayType)type2;
            final Type elementType = atype.getComponentType();
            Expression sizeArg = null;
            boolean lengthSpecified = false;
            if (args.length >= 3 && args[1] instanceof QuoteExp) {
                final Object arg2 = ((QuoteExp)args[1]).getValue();
                if (arg2 instanceof Keyword && ("length".equals(name = ((Keyword)arg2).getName()) || "size".equals(name))) {
                    sizeArg = args[2];
                    lengthSpecified = true;
                }
            }
            if (sizeArg == null) {
                sizeArg = QuoteExp.getInstance(new Integer(args.length - 1));
            }
            sizeArg = visitor.visit(sizeArg, Type.intType);
            Object constantValue = null;
            if (visitor.processingAnnotations() && sizeArg instanceof QuoteExp) {
                try {
                    final int sz = ((Number)sizeArg.valueIfConstant()).intValue();
                    constantValue = Array.newInstance(elementType.getReflectClass(), sz);
                }
                catch (Exception ex) {
                    comp.error('e', "bad array size: " + ex.getMessage());
                }
            }
            final boolean useArrayMake = exp.numKeywordArgs == 0 && constantValue == null;
            final ApplyExp alloc = new ApplyExp(new ArrayNew(elementType), new Expression[] { sizeArg });
            alloc.setType(type2);
            if (lengthSpecified && args.length == 3) {
                return alloc;
            }
            Declaration adecl;
            if (useArrayMake) {
                adecl = null;
            }
            else {
                comp.letStart();
                adecl = comp.letVariable(null, type2, alloc);
                adecl.setCanRead(true);
            }
            final BeginExp begin = new BeginExp();
            int index = 0;
            for (int i = lengthSpecified ? 3 : 1; i < args.length; ++i) {
                Expression arg3 = args[i];
                if (lengthSpecified && i + 1 < args.length && arg3 instanceof QuoteExp) {
                    final Object key = ((QuoteExp)arg3).getValue();
                    if (key instanceof Keyword) {
                        final String kname = ((Keyword)key).getName();
                        try {
                            index = Integer.parseInt(kname);
                            arg3 = args[++i];
                        }
                        catch (Exception ex2) {
                            comp.error('e', "non-integer keyword '" + kname + "' in array constructor");
                            return exp;
                        }
                    }
                }
                final boolean isSplice = MakeSplice.argIfSplice(arg3) != null;
                arg3 = visitor.visit(arg3, isSplice ? null : elementType);
                args[i] = arg3;
                if (!(arg3 instanceof QuoteExp)) {
                    constantValue = null;
                }
                else if (constantValue != null && !useArrayMake) {
                    try {
                        Array.set(constantValue, index, arg3.valueIfConstant());
                    }
                    catch (Exception ex3) {
                        constantValue = null;
                    }
                }
                if (!useArrayMake) {
                    begin.add(new ApplyExp(new ArraySet(elementType), new Expression[] { new ReferenceExp(adecl), QuoteExp.getInstance(new Integer(index)), arg3 }));
                }
                ++index;
            }
            if (constantValue != null) {
                return new QuoteExp(constantValue, type2);
            }
            if (useArrayMake) {
                final Expression[] xargs = new Expression[args.length - 1];
                System.arraycopy(args, 1, xargs, 0, xargs.length);
                final ApplyExp xexp = new ApplyExp(ArrayMake.getInstance(elementType), xargs);
                xexp.adjustSplice(exp, -1);
                xexp.setType(atype);
                return xexp;
            }
            begin.add(new ReferenceExp(adecl));
            final LetExp let = comp.letDone(begin);
            return let;
        }
        else {
            if (type2 != null && name != null) {
                return validateNamedInvoke(exp, visitor, type2, name, null, iproc, required);
            }
            exp.visitArgs(visitor);
            return exp;
        }
    }
    
    public static Expression validateNamedInvoke(final ApplyExp exp, final InlineCalls visitor, ObjectType type, String name, PrimProcedure[] methods, final Invoke iproc, final Type required) {
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        final Compilation comp = visitor.getCompilation();
        final char kind = iproc.kind;
        int margsLength;
        int argsStartIndex;
        int objIndex;
        if (kind == 'V' || kind == '*') {
            margsLength = nargs - 1;
            argsStartIndex = 2;
            objIndex = 0;
        }
        else if (kind == 'N') {
            margsLength = nargs;
            argsStartIndex = 0;
            objIndex = -1;
        }
        else if (kind == 'S' || kind == 's') {
            margsLength = nargs - 2;
            argsStartIndex = 2;
            objIndex = -1;
        }
        else {
            if (kind != 'P') {
                exp.visitArgs(visitor);
                return exp;
            }
            margsLength = nargs - 2;
            argsStartIndex = 3;
            objIndex = 1;
        }
        final ClassType caller = (comp == null) ? null : ((comp.curClass != null) ? comp.curClass : comp.mainClass);
        ObjectType ctype = type;
        int keywordStart = (kind == 'N' && exp.numKeywordArgs > 0) ? (exp.firstKeywordArgIndex - 1) : nargs;
        int tailArgs = nargs - keywordStart;
        final int spliceCount = exp.spliceCount();
        int numCode;
        try {
            if (methods == null) {
                methods = getMethods(ctype, name, caller, iproc);
            }
            numCode = ClassMethods.selectApplicable(methods, margsLength - tailArgs - spliceCount, spliceCount > 0);
        }
        catch (Exception ex) {
            comp.error('w', "unknown class: " + type.getName());
            return exp;
        }
        if (kind == 'N') {
            boolean usingConstVector = false;
            final ClassType creq;
            final Method defcons;
            if (type == LangObjType.constVectorType && tailArgs == 0 && (required instanceof ClassType || required instanceof ParameterizedType) && (creq = (ClassType)required.getRawType()).isSubclass(Compilation.typeList) && (defcons = creq.getDefaultConstructor()) != null && exp.isSimple()) {
                ctype = (type = creq);
                usingConstVector = true;
                keywordStart = 1;
                numCode = -917504;
                tailArgs = nargs - 1;
                methods[0] = new PrimProcedure(defcons, iproc.language);
                args[0] = new QuoteExp(ctype.getReflectClass());
                if (required instanceof ParameterizedType) {
                    final Type[] paramTypes = ((ParameterizedType)required).getTypeArgumentTypes();
                    if (paramTypes.length == 1) {
                        int i = args.length;
                        while (--i > 0) {
                            args[i] = Compilation.makeCoercion(args[i], paramTypes[0]);
                        }
                    }
                }
            }
            if (type instanceof TypeValue) {
                final Procedure constructor = ((TypeValue)type).getConstructor();
                if (constructor != null) {
                    final Expression[] xargs = new Expression[nargs - 1];
                    System.arraycopy(args, 1, xargs, 0, nargs - 1);
                    final ApplyExp xapp = new ApplyExp(constructor, xargs);
                    xapp.adjustSplice(exp, -1);
                    return visitor.visit(xapp.setLine(exp), required);
                }
            }
            if (exp.firstSpliceArg >= 0) {
                exp.visitArgs(visitor);
                return exp;
            }
            final CompileBuildObject builder = CompileBuildObject.make(exp, visitor, required, ctype, caller);
            if (usingConstVector) {
                builder.setDefaultConstructor(methods[0]);
                return builder.build();
            }
            if (builder.useBuilder(numCode, visitor)) {
                return builder.build();
            }
        }
        int okCount = 0;
        int maybeCount = 0;
        if (kind == 'N' && tailArgs > 0) {
            comp.error('w', "args following keyword args but no 'add' method");
        }
        else if (numCode >= 0) {
            for (int j = 1; j < nargs; ++j) {
                Type atype = null;
                final boolean last = j == nargs - 1;
                if ((kind == 'P' && j == 2) || (kind != 'N' && j == 1)) {
                    atype = null;
                }
                else if (kind == 'P' && j == 1) {
                    atype = ctype;
                }
                else if (numCode > 0) {
                    final int pi = j - ((kind == 'N') ? 1 : argsStartIndex);
                    for (int k = 0; k < numCode; ++k) {
                        final PrimProcedure pproc = methods[k];
                        final int pii = pi + ((kind != 'S' && pproc.takesTarget()) ? 1 : 0);
                        if (PrimProcedure.explicitArrayAsVarArgsAllowed && last && pproc.takesVarArgs() && pii == pproc.minArgs()) {
                            atype = null;
                        }
                        else {
                            final Type ptype = pproc.getParameterType(pii);
                            if (k == 0) {
                                atype = ptype;
                            }
                            else if (ptype instanceof PrimType != atype instanceof PrimType) {
                                atype = null;
                            }
                            else {
                                atype = Language.unionType(atype, ptype);
                            }
                        }
                        if (atype == null) {
                            break;
                        }
                    }
                }
                args[j] = visitor.visit(args[j], atype);
            }
            final long num = selectApplicable(methods, ctype, args, margsLength, argsStartIndex, objIndex);
            okCount = (int)(num >> 32);
            maybeCount = (int)num;
        }
        final int nmethods = methods.length;
        if (okCount + maybeCount == 0 && kind == 'N') {
            methods = getMethods(ctype, "valueOf", caller, Invoke.invokeStatic);
            argsStartIndex = 1;
            margsLength = nargs - 1;
            final long num2 = selectApplicable(methods, ctype, args, margsLength, argsStartIndex, -1);
            okCount = (int)(num2 >> 32);
            maybeCount = (int)num2;
        }
        int index = -1;
        if (okCount + maybeCount == 0) {
            if (kind == 'P' || comp.warnInvokeUnknownMethod()) {
                if (kind == 'N') {
                    name += "/valueOf";
                }
                final StringBuilder sbuf = new StringBuilder();
                if (nmethods + methods.length == 0) {
                    sbuf.append("no accessible method '");
                }
                else if (numCode == -983040) {
                    sbuf.append("too few arguments for method '");
                }
                else if (numCode == -917504) {
                    sbuf.append("too many arguments for method '");
                }
                else {
                    sbuf.append("no possibly applicable method '");
                }
                sbuf.append(name);
                sbuf.append("' in ");
                sbuf.append(type.getName());
                comp.error((kind == 'P') ? 'e' : 'w', sbuf.toString());
            }
        }
        else if (okCount == 1 || (okCount == 0 && maybeCount == 1)) {
            index = 0;
        }
        else if (okCount > 0) {
            index = PrimProcedure.mostSpecific(methods, okCount);
            if (index < 0 && kind == 'S') {
                for (int i = 0; i < okCount; ++i) {
                    if (methods[i].getStaticFlag()) {
                        if (index >= 0) {
                            index = -1;
                            break;
                        }
                        index = i;
                    }
                }
            }
            if (index < 0 && (kind == 'P' || comp.warnInvokeUnknownMethod())) {
                final StringBuffer sbuf2 = new StringBuffer();
                sbuf2.append("more than one definitely applicable method `");
                sbuf2.append(name);
                sbuf2.append("' in ");
                sbuf2.append(type.getName());
                append(methods, okCount, sbuf2);
                comp.error((kind == 'P') ? 'e' : 'w', sbuf2.toString());
            }
        }
        else if (kind == 'P' || comp.warnInvokeUnknownMethod()) {
            final StringBuffer sbuf2 = new StringBuffer();
            sbuf2.append("more than one possibly applicable method '");
            sbuf2.append(name);
            sbuf2.append("' in ");
            sbuf2.append(type.getName());
            append(methods, maybeCount, sbuf2);
            comp.error((kind == 'P') ? 'e' : 'w', sbuf2.toString());
        }
        if (index >= 0) {
            final Expression[] margs = new Expression[margsLength];
            final PrimProcedure method = methods[index];
            final boolean variable = method.takesVarArgs();
            int dst = 0;
            int spdelta = -argsStartIndex;
            if (objIndex >= 0) {
                if (exp.firstSpliceArg == objIndex) {
                    spdelta = -objIndex;
                }
                else {
                    ++spdelta;
                }
                margs[dst++] = args[objIndex];
            }
            for (int src = argsStartIndex; src < args.length && dst < margs.length; ++src, ++dst) {
                margs[dst] = args[src];
            }
            final ApplyExp e = new ApplyExp(method, margs);
            e.adjustSplice(exp, spdelta);
            e.setLine(exp);
            if (method.canCompile(e)) {
                return visitor.visitApplyOnly(e, required);
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }
    
    private static String getMethodName(final Expression[] args, final char kind) {
        if (kind == 'N') {
            return "<init>";
        }
        final int nameIndex = (kind == 'P') ? 2 : 1;
        if (args.length >= nameIndex + 1) {
            return ClassMethods.checkName(args[nameIndex], false);
        }
        return null;
    }
    
    private static void append(final PrimProcedure[] methods, final int mcount, final StringBuffer sbuf) {
        for (int i = 0; i < mcount; ++i) {
            sbuf.append("\n  candidate: ");
            sbuf.append(methods[i]);
        }
    }
    
    protected static PrimProcedure[] getMethods(final ObjectType ctype, final String mname, final ClassType caller, final Invoke iproc) {
        final int kind = iproc.kind;
        return ClassMethods.getMethods(ctype, mname, (kind == 80) ? 'P' : ((kind == 42 || kind == 86) ? 'V' : '\0'), caller, iproc.language);
    }
    
    private static long selectApplicable(final PrimProcedure[] methods, final ObjectType ctype, final Expression[] args, final int margsLength, final int argsStartIndex, final int objIndex) {
        Type[] atypes = new Type[margsLength];
        int dst = 0;
        if (objIndex >= 0) {
            atypes[dst++] = ctype;
        }
        Type restType = null;
        for (int src = argsStartIndex; src < args.length && dst < atypes.length; ++src, ++dst) {
            final Expression arg = args[src];
            final Expression spliceArg = MakeSplice.argIfSplice(arg);
            if (spliceArg != null) {
                restType = Type.objectType;
                final Type[] xtypes = new Type[dst];
                System.arraycopy(atypes, 0, xtypes, 0, dst);
                atypes = xtypes;
                break;
            }
            Type atype = null;
            if (InlineCalls.checkIntValue(arg) != null) {
                atype = Type.intType;
            }
            else if (InlineCalls.checkLongValue(arg) != null) {
                atype = Type.longType;
            }
            else if (atype == null) {
                atype = arg.getType();
            }
            atypes[dst] = atype;
        }
        return ClassMethods.selectApplicable(methods, atypes, restType);
    }
    
    public static synchronized PrimProcedure getStaticMethod(final ClassType type, final String name, final Expression[] args) {
        final PrimProcedure[] methods = getMethods(type, name, null, Invoke.invokeStatic);
        final long num = selectApplicable(methods, type, args, args.length, 0, -1);
        final int okCount = (int)(num >> 32);
        final int maybeCount = (int)num;
        int index;
        if (methods == null) {
            index = -1;
        }
        else if (okCount > 0) {
            index = PrimProcedure.mostSpecific(methods, okCount);
        }
        else if (maybeCount == 1) {
            index = 0;
        }
        else {
            index = -1;
        }
        return (index < 0) ? null : methods[index];
    }
}
