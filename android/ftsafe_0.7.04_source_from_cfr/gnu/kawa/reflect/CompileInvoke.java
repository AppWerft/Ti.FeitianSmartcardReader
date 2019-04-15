/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.TypeValue;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.ArrayMake;
import gnu.kawa.reflect.ArrayNew;
import gnu.kawa.reflect.ArraySet;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.CompileBuildObject;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.Procedure;
import gnu.text.SourceLocator;
import java.lang.reflect.Array;

public class CompileInvoke {
    public static Expression validateApplyInvoke(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression arg0;
        Type type0;
        Invoke iproc = (Invoke)proc;
        char kind = iproc.kind;
        Compilation comp = visitor.getCompilation();
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        if (nargs == 0 || (kind == 'V' || kind == '*') && nargs == 1) {
            exp.visitArgs(visitor);
            return exp;
        }
        args[0] = arg0 = visitor.visit(args[0], null);
        Type type = type0 = kind == 'V' || kind == '*' ? arg0.getType() : iproc.language.getTypeFor(arg0);
        ObjectType type2 = type0 instanceof PairClassType && kind == 'N' ? ((PairClassType)type0).instanceType : (type0 instanceof LangObjType && kind == 'N' ? ((LangObjType)type0).getConstructorType() : (type0 instanceof ObjectType ? (ObjectType)type0 : null));
        if (kind == 'P') {
            if (type0 == null) {
                comp.error('e', "unknown class for invoke-special", arg0);
            } else if (!(type2 instanceof ClassType) || type2.isInterface()) {
                comp.error('e', "invalid class for invoke-special", arg0);
            }
        }
        String name = CompileInvoke.getMethodName(args, kind);
        if (kind == 'N' && type2 == LangObjType.constVectorType && required instanceof ArrayType) {
            type2 = (ObjectType)required;
        }
        if (kind == 'N' && type2 instanceof ArrayType) {
            Object arg1;
            int i;
            Declaration adecl;
            ArrayType atype = (ArrayType)type2;
            Type elementType = atype.getComponentType();
            Expression sizeArg = null;
            boolean lengthSpecified = false;
            if (args.length >= 3 && args[1] instanceof QuoteExp && (arg1 = ((QuoteExp)args[1]).getValue()) instanceof Keyword && ("length".equals(name = ((Keyword)arg1).getName()) || "size".equals(name))) {
                sizeArg = args[2];
                lengthSpecified = true;
            }
            if (sizeArg == null) {
                sizeArg = QuoteExp.getInstance(new Integer(args.length - 1));
            }
            sizeArg = visitor.visit(sizeArg, Type.intType);
            Object constantValue = null;
            if (visitor.processingAnnotations() && sizeArg instanceof QuoteExp) {
                try {
                    int sz = ((Number)sizeArg.valueIfConstant()).intValue();
                    constantValue = Array.newInstance(elementType.getReflectClass(), sz);
                }
                catch (Exception ex) {
                    comp.error('e', "bad array size: " + ex.getMessage());
                }
            }
            boolean useArrayMake = exp.numKeywordArgs == 0 && constantValue == null;
            ApplyExp alloc = new ApplyExp(new ArrayNew(elementType), sizeArg);
            alloc.setType(type2);
            if (lengthSpecified && args.length == 3) {
                return alloc;
            }
            if (useArrayMake) {
                adecl = null;
            } else {
                comp.letStart();
                adecl = comp.letVariable(null, type2, alloc);
                adecl.setCanRead(true);
            }
            BeginExp begin2 = new BeginExp();
            int index = 0;
            int n = i = lengthSpecified ? 3 : 1;
            while (i < args.length) {
                Object key;
                Expression arg = args[i];
                if (lengthSpecified && i + 1 < args.length && arg instanceof QuoteExp && (key = ((QuoteExp)arg).getValue()) instanceof Keyword) {
                    String kname = ((Keyword)key).getName();
                    try {
                        index = Integer.parseInt(kname);
                        arg = args[++i];
                    }
                    catch (Exception ex) {
                        comp.error('e', "non-integer keyword '" + kname + "' in array constructor");
                        return exp;
                    }
                }
                boolean isSplice = MakeSplice.argIfSplice(arg) != null;
                args[i] = arg = visitor.visit(arg, isSplice ? null : elementType);
                if (!(arg instanceof QuoteExp)) {
                    constantValue = null;
                } else if (constantValue != null && !useArrayMake) {
                    try {
                        Array.set(constantValue, index, arg.valueIfConstant());
                    }
                    catch (Exception ex) {
                        constantValue = null;
                    }
                }
                if (!useArrayMake) {
                    begin2.add(new ApplyExp(new ArraySet(elementType), new ReferenceExp(adecl), QuoteExp.getInstance(new Integer(index)), arg));
                }
                ++index;
                ++i;
            }
            if (constantValue != null) {
                return new QuoteExp(constantValue, type2);
            }
            if (useArrayMake) {
                Expression[] xargs = new Expression[args.length - 1];
                System.arraycopy(args, 1, xargs, 0, xargs.length);
                ApplyExp xexp = new ApplyExp(ArrayMake.getInstance(elementType), xargs);
                xexp.adjustSplice(exp, -1);
                xexp.setType(atype);
                return xexp;
            }
            begin2.add(new ReferenceExp(adecl));
            LetExp let2 = comp.letDone(begin2);
            return let2;
        }
        if (type2 != null && name != null) {
            return CompileInvoke.validateNamedInvoke(exp, visitor, type2, name, null, iproc, required);
        }
        exp.visitArgs(visitor);
        return exp;
    }

    public static Expression validateNamedInvoke(ApplyExp exp, InlineCalls visitor, ObjectType type, String name, PrimProcedure[] methods, Invoke iproc, Type required) {
        int margsLength;
        int i;
        int numCode;
        int objIndex;
        int argsStartIndex;
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        Compilation comp = visitor.getCompilation();
        char kind = iproc.kind;
        if (kind == 'V' || kind == '*') {
            margsLength = nargs - 1;
            argsStartIndex = 2;
            objIndex = 0;
        } else if (kind == 'N') {
            margsLength = nargs;
            argsStartIndex = 0;
            objIndex = -1;
        } else if (kind == 'S' || kind == 's') {
            margsLength = nargs - 2;
            argsStartIndex = 2;
            objIndex = -1;
        } else if (kind == 'P') {
            margsLength = nargs - 2;
            argsStartIndex = 3;
            objIndex = 1;
        } else {
            exp.visitArgs(visitor);
            return exp;
        }
        ClassType caller = comp == null ? null : (comp.curClass != null ? comp.curClass : comp.mainClass);
        ObjectType ctype = type;
        int keywordStart = kind == 'N' && exp.numKeywordArgs > 0 ? exp.firstKeywordArgIndex - 1 : nargs;
        int tailArgs = nargs - keywordStart;
        int spliceCount = exp.spliceCount();
        try {
            if (methods == null) {
                methods = CompileInvoke.getMethods(ctype, name, caller, iproc);
            }
            numCode = ClassMethods.selectApplicable(methods, margsLength - tailArgs - spliceCount, spliceCount > 0);
        }
        catch (Exception ex) {
            comp.error('w', "unknown class: " + type.getName());
            return exp;
        }
        if (kind == 'N') {
            Method defcons;
            Procedure constructor;
            ClassType creq;
            boolean usingConstVector = false;
            if (type == LangObjType.constVectorType && tailArgs == 0 && (required instanceof ClassType || required instanceof ParameterizedType) && (creq = (ClassType)required.getRawType()).isSubclass(Compilation.typeList) && (defcons = creq.getDefaultConstructor()) != null && exp.isSimple()) {
                Type[] paramTypes;
                type = ctype = creq;
                usingConstVector = true;
                keywordStart = 1;
                numCode = -917504;
                tailArgs = nargs - 1;
                methods[0] = new PrimProcedure(defcons, iproc.language);
                args[0] = new QuoteExp(ctype.getReflectClass());
                if (required instanceof ParameterizedType && (paramTypes = ((ParameterizedType)required).getTypeArgumentTypes()).length == 1) {
                    i = args.length;
                    while (--i > 0) {
                        args[i] = Compilation.makeCoercion(args[i], paramTypes[0]);
                    }
                }
            }
            if (type instanceof TypeValue && (constructor = ((TypeValue)((Object)type)).getConstructor()) != null) {
                Expression[] xargs = new Expression[nargs - 1];
                System.arraycopy(args, 1, xargs, 0, nargs - 1);
                ApplyExp xapp = new ApplyExp(constructor, xargs);
                xapp.adjustSplice(exp, -1);
                return visitor.visit(xapp.setLine(exp), required);
            }
            if (exp.firstSpliceArg >= 0) {
                exp.visitArgs(visitor);
                return exp;
            }
            CompileBuildObject builder = CompileBuildObject.make(exp, visitor, required, ctype, caller);
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
        } else if (numCode >= 0) {
            for (int i2 = 1; i2 < nargs; ++i2) {
                boolean last;
                Object atype = null;
                boolean bl = last = i2 == nargs - 1;
                if (kind == 'P' && i2 == 2 || kind != 'N' && i2 == 1) {
                    atype = null;
                } else if (kind == 'P' && i2 == 1) {
                    atype = ctype;
                } else if (numCode > 0) {
                    int pi = i2 - (kind == 'N' ? 1 : argsStartIndex);
                    for (int j = 0; j < numCode; ++j) {
                        PrimProcedure pproc = methods[j];
                        int pii = pi + (kind != 'S' && pproc.takesTarget() ? 1 : 0);
                        if (PrimProcedure.explicitArrayAsVarArgsAllowed && last && pproc.takesVarArgs() && pii == pproc.minArgs()) {
                            atype = null;
                        } else {
                            Type ptype = pproc.getParameterType(pii);
                            atype = j == 0 ? ptype : (ptype instanceof PrimType != atype instanceof PrimType ? null : Language.unionType((Type)atype, ptype));
                        }
                        if (atype == null) break;
                    }
                }
                args[i2] = visitor.visit(args[i2], (Type)atype);
            }
            long num = CompileInvoke.selectApplicable(methods, ctype, args, margsLength, argsStartIndex, objIndex);
            okCount = (int)(num >> 32);
            maybeCount = (int)num;
        }
        int nmethods = methods.length;
        if (okCount + maybeCount == 0 && kind == 'N') {
            methods = CompileInvoke.getMethods(ctype, "valueOf", caller, Invoke.invokeStatic);
            argsStartIndex = 1;
            margsLength = nargs - 1;
            long num = CompileInvoke.selectApplicable(methods, ctype, args, margsLength, argsStartIndex, -1);
            okCount = (int)(num >> 32);
            maybeCount = (int)num;
        }
        int index = -1;
        if (okCount + maybeCount == 0) {
            if (kind == 'P' || comp.warnInvokeUnknownMethod()) {
                if (kind == 'N') {
                    name = name + "/valueOf";
                }
                StringBuilder sbuf = new StringBuilder();
                if (nmethods + methods.length == 0) {
                    sbuf.append("no accessible method '");
                } else if (numCode == -983040) {
                    sbuf.append("too few arguments for method '");
                } else if (numCode == -917504) {
                    sbuf.append("too many arguments for method '");
                } else {
                    sbuf.append("no possibly applicable method '");
                }
                sbuf.append(name);
                sbuf.append("' in ");
                sbuf.append(type.getName());
                comp.error(kind == 'P' ? (char)'e' : 'w', sbuf.toString());
            }
        } else if (okCount == 1 || okCount == 0 && maybeCount == 1) {
            index = 0;
        } else if (okCount > 0) {
            index = PrimProcedure.mostSpecific(methods, okCount);
            if (index < 0 && kind == 'S') {
                for (i = 0; i < okCount; ++i) {
                    if (!methods[i].getStaticFlag()) continue;
                    if (index >= 0) {
                        index = -1;
                        break;
                    }
                    index = i;
                }
            }
            if (index < 0 && (kind == 'P' || comp.warnInvokeUnknownMethod())) {
                StringBuffer sbuf = new StringBuffer();
                sbuf.append("more than one definitely applicable method `");
                sbuf.append(name);
                sbuf.append("' in ");
                sbuf.append(type.getName());
                CompileInvoke.append(methods, okCount, sbuf);
                comp.error(kind == 'P' ? (char)'e' : 'w', sbuf.toString());
            }
        } else if (kind == 'P' || comp.warnInvokeUnknownMethod()) {
            StringBuffer sbuf = new StringBuffer();
            sbuf.append("more than one possibly applicable method '");
            sbuf.append(name);
            sbuf.append("' in ");
            sbuf.append(type.getName());
            CompileInvoke.append(methods, maybeCount, sbuf);
            comp.error(kind == 'P' ? (char)'e' : 'w', sbuf.toString());
        }
        if (index >= 0) {
            Expression[] margs = new Expression[margsLength];
            PrimProcedure method = methods[index];
            boolean variable = method.takesVarArgs();
            int dst = 0;
            int spdelta = -argsStartIndex;
            if (objIndex >= 0) {
                spdelta = exp.firstSpliceArg == objIndex ? -objIndex : ++spdelta;
                margs[dst++] = args[objIndex];
            }
            for (int src = argsStartIndex; src < args.length && dst < margs.length; ++src, ++dst) {
                margs[dst] = args[src];
            }
            ApplyExp e = new ApplyExp(method, margs);
            e.adjustSplice(exp, spdelta);
            e.setLine(exp);
            if (method.canCompile(e)) {
                return visitor.visitApplyOnly(e, required);
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }

    private static String getMethodName(Expression[] args, char kind) {
        int nameIndex;
        if (kind == 'N') {
            return "<init>";
        }
        int n = nameIndex = kind == 'P' ? 2 : 1;
        if (args.length >= nameIndex + 1) {
            return ClassMethods.checkName(args[nameIndex], false);
        }
        return null;
    }

    private static void append(PrimProcedure[] methods, int mcount, StringBuffer sbuf) {
        for (int i = 0; i < mcount; ++i) {
            sbuf.append("\n  candidate: ");
            sbuf.append(methods[i]);
        }
    }

    protected static PrimProcedure[] getMethods(ObjectType ctype, String mname, ClassType caller, Invoke iproc) {
        char kind = iproc.kind;
        return ClassMethods.getMethods(ctype, mname, kind == 'P' ? (char)'P' : (kind == '*' || kind == 'V' ? (char)'V' : '\u0000'), caller, iproc.language);
    }

    private static long selectApplicable(PrimProcedure[] methods, ObjectType ctype, Expression[] args, int margsLength, int argsStartIndex, int objIndex) {
        Type[] atypes = new Type[margsLength];
        int dst = 0;
        if (objIndex >= 0) {
            atypes[dst++] = ctype;
        }
        ClassType restType = null;
        for (int src = argsStartIndex; src < args.length && dst < atypes.length; ++src, ++dst) {
            Expression arg = args[src];
            Expression spliceArg = MakeSplice.argIfSplice(arg);
            if (spliceArg != null) {
                restType = Type.objectType;
                Type[] xtypes = new Type[dst];
                System.arraycopy(atypes, 0, xtypes, 0, dst);
                atypes = xtypes;
                break;
            }
            Type atype = null;
            if (InlineCalls.checkIntValue(arg) != null) {
                atype = Type.intType;
            } else if (InlineCalls.checkLongValue(arg) != null) {
                atype = Type.longType;
            } else if (atype == null) {
                atype = arg.getType();
            }
            atypes[dst] = atype;
        }
        return ClassMethods.selectApplicable(methods, atypes, restType);
    }

    public static synchronized PrimProcedure getStaticMethod(ClassType type, String name, Expression[] args) {
        PrimProcedure[] methods = CompileInvoke.getMethods(type, name, null, Invoke.invokeStatic);
        long num = CompileInvoke.selectApplicable(methods, type, args, args.length, 0, -1);
        int okCount = (int)(num >> 32);
        int maybeCount = (int)num;
        int index = methods == null ? -1 : (okCount > 0 ? PrimProcedure.mostSpecific(methods, okCount) : (maybeCount == 1 ? 0 : -1));
        return index < 0 ? null : methods[index];
    }
}

