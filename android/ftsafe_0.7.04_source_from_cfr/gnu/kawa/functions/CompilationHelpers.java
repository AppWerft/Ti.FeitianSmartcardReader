/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.SetArrayExp;
import gnu.kawa.functions.SetListExp;
import gnu.kawa.functions.Setter;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.ArrayGet;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.LazyType;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.Char;
import java.io.Externalizable;

public class CompilationHelpers {
    static final ClassType setterType = ClassType.make("gnu.kawa.functions.Setter");
    static final Field setterField = setterType.getDeclaredField("setter");
    public static final Declaration setterDecl = new Declaration((Object)"setter", setterField);
    public static final PrimProcedure getSetterProc;

    public static boolean maybeLazy(Expression exp) {
        if (exp instanceof QuoteExp) {
            return false;
        }
        return LazyType.maybeLazy(exp.getType());
    }

    private static boolean nonNumeric(Expression exp) {
        if (exp instanceof QuoteExp) {
            Object value = ((QuoteExp)exp).getValue();
            return !(value instanceof Number) && !(value instanceof Boolean) && !(value instanceof Char) && !(value instanceof Symbol);
        }
        return false;
    }

    public static Expression validateApplyToArgs(ApplyExp exp, InlineCalls visitor, Type required, Procedure applyToArgs) {
        Expression[] args = exp.getArgs();
        int nargs = args.length - 1;
        if (nargs >= 0) {
            Type ptype0;
            Expression proc = args[0];
            if (!proc.getFlag(1)) {
                Declaration decl;
                Expression pval = proc;
                if (proc instanceof ReferenceExp && (decl = ((ReferenceExp)proc).getBinding()) != null) {
                    pval = decl.getValue();
                }
                if (pval != null && pval.getClass() == LambdaExp.class && exp.firstSpliceArg < 0) {
                    Expression[] rargs = new Expression[nargs];
                    System.arraycopy(args, 1, rargs, 0, nargs);
                    exp.setFuncArgs(proc, rargs);
                    return visitor.visit((Expression)exp, required);
                }
                args[0] = proc = visitor.visit(proc, InlineCalls.typeForCalledFunction(proc));
            }
            if ((ptype0 = proc.getType()) == LangObjType.dynamicType) {
                exp.visitArgs(visitor);
                exp.setType(LangObjType.dynamicType);
                return exp;
            }
            Type ptype = ptype0.getRealType();
            Compilation comp = visitor.getCompilation();
            Language language = comp.getLanguage();
            if (ptype.isSubtype(Compilation.typeProcedure)) {
                Expression[] rargs;
                if (ptype.getRawType() == Compilation.typeLocationProc && nargs == 0) {
                    rargs = new Expression[]{proc, new QuoteExp("getValue")};
                    proc = new QuoteExp(Invoke.invoke);
                } else {
                    rargs = new Expression[nargs];
                    System.arraycopy(args, 1, rargs, 0, nargs);
                }
                exp.setFuncArgs(proc, rargs);
                exp.adjustSplice(exp, -1);
                return proc.validateApply(exp, visitor, required, null);
            }
            ClassType ctype = ptype instanceof ClassType ? (ClassType)ptype : (ptype instanceof ParameterizedType ? ((ParameterizedType)ptype).getRawType() : Type.objectType);
            Expression result = null;
            boolean isString = ctype.isSubclass(Compilation.typeCharSequence);
            boolean isSequence = ctype.isSubclass(Compilation.typeList);
            boolean isArray = ctype.isSubclass(GenArrayType.typeArray);
            if (CompileReflect.checkKnownClass(ptype, comp) >= 0) {
                if (ptype.isSubtype(Compilation.typeType) || language.getTypeFor(proc, false) != null) {
                    result = exp.setFuncArgs(Invoke.make, args);
                } else if (ptype instanceof ArrayType) {
                    Type elementType = ((ArrayType)ptype).getComponentType();
                    exp.setFuncArgs(new ArrayGet(elementType), args);
                    result = exp;
                } else if (exp.isSimple() && ((isString || isSequence) && nargs == 1 || isArray)) {
                    int rank = isString || isSequence ? 1 : (ptype instanceof GenArrayType ? ((GenArrayType)ptype).rank() : -1);
                    Type elementType = Type.objectType;
                    if (ptype instanceof GenArrayType) {
                        elementType = ((GenArrayType)ptype).getComponentType();
                    }
                    int resultRank = 0;
                    for (int i = 1; i <= nargs; ++i) {
                        args[i] = visitor.visit(args[i], null);
                        Type itype = args[1].getType();
                        int listIndexCompat = LangObjType.sequenceType.isCompatibleWithValue(itype);
                        int intIndexCompat = Type.intType.isCompatibleWithValue(itype);
                        int arrayIndexCompat = GenArrayType.typeArray.isCompatibleWithValue(itype);
                        if (resultRank >= 0 && intIndexCompat <= 0) {
                            int r;
                            resultRank = listIndexCompat > 0 ? ++resultRank : (ptype instanceof GenArrayType && (r = ((GenArrayType)ptype).rank()) >= 0 ? (resultRank += r) : -1);
                        }
                        if (listIndexCompat < 0 && intIndexCompat < 0 && arrayIndexCompat < 0) {
                            visitor.getCompilation().error('w', "index is neither integer, sequence, or array");
                            resultRank = -1;
                            continue;
                        }
                        if (intIndexCompat > 0) {
                            if (isString && nargs == 1) {
                                Method method = ClassType.make("gnu.lists.Strings").getDeclaredMethod("characterAt", 2);
                                PrimProcedure prproc = new PrimProcedure(method, (Type)LangPrimType.characterType, null);
                                result = exp.setFuncArgs(prproc, args);
                                continue;
                            }
                            if (nargs != 1 || !isSequence) continue;
                            String mname = "get";
                            Type retType = null;
                            String cname = ctype.getName();
                            LangObjType ltype = null;
                            if (cname.startsWith("gnu.lists.")) {
                                ltype = LangObjType.getInstanceFromClass(cname);
                            }
                            if (ltype != null && (retType = ltype.getElementType()) != null) {
                                mname = ltype.elementGetterMethodName();
                            } else if (ltype == LangObjType.vectorType && ptype instanceof ParameterizedType && ((ParameterizedType)ptype).getTypeArgumentTypes().length == 1) {
                                retType = ((ParameterizedType)ptype).getTypeArgumentType(0);
                            }
                            Method get = ctype.getMethod(mname, new Type[]{Type.intType});
                            ParameterizedType prtype = ptype instanceof ParameterizedType ? (ParameterizedType)ptype : null;
                            PrimProcedure prproc = new PrimProcedure(get, 'V', language, prtype);
                            if (retType != null) {
                                prproc.setReturnType(retType);
                            }
                            result = exp.setFuncArgs(prproc, args);
                            continue;
                        }
                        if (arrayIndexCompat <= 0 && listIndexCompat <= 0) continue;
                    }
                    if (rank >= 0 && rank != nargs) {
                        StringBuilder msg = new StringBuilder();
                        if (isSequence || isString) {
                            msg.append(isString ? "string" : "sequence").append(" requires 1 index");
                        } else {
                            msg.append("array has rank ").append(rank);
                        }
                        msg.append(" but there are ");
                        msg.append(nargs).append(" indexes");
                        visitor.getCompilation().error('w', msg.toString());
                    } else if (isArray && resultRank == 0 && result == null) {
                        char sig1 = elementType.getSignature().charAt(0);
                        String mname = elementType instanceof PrimType ? (sig1 == 'I' ? "getInt" : "effectiveIndex") : "get";
                        Method meth = nargs == 1 ? ctype.getMethod(mname, new Type[]{Type.intType}) : ctype.getDeclaredMethod(mname, nargs > 3 ? 4 : nargs);
                        PrimProcedure prproc = new PrimProcedure(meth);
                        result = exp.setFuncArgs(prproc, args);
                        if (mname == "effectiveIndex") {
                            switch (sig1) {
                                case 'Z': {
                                    mname = "getBooleanRaw";
                                    break;
                                }
                                case 'C': {
                                    mname = "getCharRaw";
                                    break;
                                }
                                case 'B': {
                                    mname = "getByteRaw";
                                    break;
                                }
                                case 'S': {
                                    mname = "getShortRaw";
                                    break;
                                }
                                case 'J': {
                                    mname = "getLongRaw";
                                    break;
                                }
                                case 'F': {
                                    mname = "getFloatRaw";
                                    break;
                                }
                                case 'D': {
                                    mname = "getDoubleRaw";
                                    break;
                                }
                                default: {
                                    throw new InternalError();
                                }
                            }
                            meth = GenArrayType.typeArray.getDeclaredMethod(mname, 1);
                            comp.letStart();
                            Declaration tdecl = comp.letVariable(null, ptype, args[0]);
                            tdecl.setFlag(0x8000000000L);
                            tdecl.setCanRead(true);
                            args[0] = new ReferenceExp(tdecl);
                            ReferenceExp aref = new ReferenceExp(tdecl);
                            aref.setFlag(32);
                            prproc = new PrimProcedure(meth);
                            prproc.setReturnType(elementType);
                            result = new ApplyExp(prproc, aref, result);
                            Expression let2 = comp.letDone(result).setLine(exp);
                            return visitor.visit(let2, required);
                        }
                        prproc.setReturnType(elementType);
                    }
                    if (isArray && !isString && result == null) {
                        PrimProcedure prproc = new PrimProcedure("gnu.lists.ComposedArray", "generalIndex", 3);
                        Expression[] xargs = new Expression[nargs + 2];
                        xargs[0] = args[0];
                        xargs[1] = QuoteExp.falseExp;
                        System.arraycopy(args, 1, xargs, 2, nargs);
                        result = exp.setFuncArgs(prproc, xargs);
                        Type retType = null;
                        if (resultRank > 0) {
                            retType = new GenArrayType(resultRank, elementType);
                        } else if (resultRank == 0 && elementType != Type.objectType) {
                            retType = elementType;
                        }
                        if (retType != null) {
                            result = Compilation.makeCoercion(result, retType);
                        }
                    }
                }
            }
            if (result != null) {
                result.setLine(exp);
                return visitor.visitApplyOnly((ApplyExp)result, required);
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }

    public static Expression validateSetter(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length == 1) {
            ClassType cimplType;
            Object value;
            Declaration decl;
            Expression arg = args[0];
            Type argType = arg.getType();
            if (argType instanceof ArrayType) {
                return new SetArrayExp(arg, (ArrayType)argType);
            }
            Type implType = argType.getRawType();
            if (implType instanceof ClassType && ((cimplType = (ClassType)implType).isSubclass(Compilation.typeList) || cimplType.isSubclass(GenArrayType.typeArray))) {
                if (exp instanceof SetListExp) {
                    return exp;
                }
                return new SetListExp(exp.getFunction(), (ObjectType)argType, args);
            }
            if (arg instanceof ReferenceExp && (decl = ((ReferenceExp)arg).getBinding()) != null) {
                arg = decl.getValue();
            }
            if (arg instanceof QuoteExp && (value = ((QuoteExp)arg).getValue()) instanceof Procedure) {
                Procedure setter;
                Procedure pvalue = (Procedure)value;
                try {
                    setter = pvalue.getSetter();
                }
                catch (RuntimeException ex) {
                    setter = null;
                    visitor.getCompilation().error('w', "procedure '" + pvalue.getName() + "' has no setter");
                }
                if (setter != null) {
                    if (setter instanceof Externalizable) {
                        return new QuoteExp(setter);
                    }
                    Declaration decl2 = Declaration.getDeclaration(setter);
                    if (decl2 != null) {
                        return new ReferenceExp(decl2);
                    }
                }
            }
            if (argType instanceof ClassType && ((ClassType)argType).isSubclass(Compilation.typeProcedure)) {
                return new ApplyExp(getSetterProc, args);
            }
        }
        return exp;
    }

    public static Expression validateIsEqv(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if ((CompilationHelpers.nonNumeric(args[0]) || CompilationHelpers.nonNumeric(args[1])) && !CompilationHelpers.maybeLazy(args[0]) && !CompilationHelpers.maybeLazy(args[1])) {
            return new ApplyExp(((IsEqv)proc).isEq, args);
        }
        Method meth = ClassType.make("gnu.kawa.functions.IsEqv").getDeclaredMethod("apply", 2);
        return new ApplyExp(new PrimProcedure(meth, visitor.getLanguage()), args).setLine(exp);
    }

    static {
        setterDecl.noteValue(new QuoteExp(Setter.setter));
        getSetterProc = new PrimProcedure(Compilation.typeProcedure.getDeclaredMethod("getSetter", 0));
    }
}

