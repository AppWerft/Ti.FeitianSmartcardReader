// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Named;
import java.io.Externalizable;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Method;
import gnu.expr.Language;
import gnu.bytecode.PrimType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.ArrayGet;
import gnu.bytecode.ArrayType;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.bytecode.ParameterizedType;
import gnu.kawa.reflect.Invoke;
import gnu.expr.Compilation;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.kawa.reflect.LazyType;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.expr.PrimProcedure;
import gnu.expr.Declaration;
import gnu.bytecode.Field;
import gnu.bytecode.ClassType;

public class CompilationHelpers
{
    static final ClassType setterType;
    static final Field setterField;
    public static final Declaration setterDecl;
    public static final PrimProcedure getSetterProc;
    
    public static boolean maybeLazy(final Expression exp) {
        return !(exp instanceof QuoteExp) && LazyType.maybeLazy(exp.getType());
    }
    
    private static boolean nonNumeric(final Expression exp) {
        if (exp instanceof QuoteExp) {
            final Object value = ((QuoteExp)exp).getValue();
            return !(value instanceof Number) && !(value instanceof Boolean) && !(value instanceof Char) && !(value instanceof Symbol);
        }
        return false;
    }
    
    public static Expression validateApplyToArgs(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure applyToArgs) {
        final Expression[] args = exp.getArgs();
        final int nargs = args.length - 1;
        if (nargs >= 0) {
            Expression proc = args[0];
            if (!proc.getFlag(1)) {
                Expression pval = proc;
                if (proc instanceof ReferenceExp) {
                    final Declaration decl = ((ReferenceExp)proc).getBinding();
                    if (decl != null) {
                        pval = decl.getValue();
                    }
                }
                if (pval != null && pval.getClass() == LambdaExp.class && exp.firstSpliceArg < 0) {
                    final Expression[] rargs = new Expression[nargs];
                    System.arraycopy(args, 1, rargs, 0, nargs);
                    exp.setFuncArgs(proc, rargs);
                    return visitor.visit(exp, required);
                }
                proc = visitor.visit(proc, InlineCalls.typeForCalledFunction(proc));
                args[0] = proc;
            }
            final Type ptype0 = proc.getType();
            if (ptype0 == LangObjType.dynamicType) {
                exp.visitArgs(visitor);
                exp.setType(LangObjType.dynamicType);
                return exp;
            }
            final Type ptype2 = ptype0.getRealType();
            final Compilation comp = visitor.getCompilation();
            final Language language = comp.getLanguage();
            if (ptype2.isSubtype(Compilation.typeProcedure)) {
                Expression[] rargs2;
                if (ptype2.getRawType() == Compilation.typeLocationProc && nargs == 0) {
                    rargs2 = new Expression[] { proc, new QuoteExp((Object)"getValue") };
                    proc = new QuoteExp(Invoke.invoke);
                }
                else {
                    rargs2 = new Expression[nargs];
                    System.arraycopy(args, 1, rargs2, 0, nargs);
                }
                exp.setFuncArgs(proc, rargs2);
                exp.adjustSplice(exp, -1);
                return proc.validateApply(exp, visitor, required, null);
            }
            final ClassType ctype = (ClassType)((ptype2 instanceof ClassType) ? ptype2 : ((ptype2 instanceof ParameterizedType) ? ((ParameterizedType)ptype2).getRawType() : Type.objectType));
            ApplyExp result = null;
            final boolean isString = ctype.isSubclass(Compilation.typeCharSequence);
            final boolean isSequence = ctype.isSubclass(Compilation.typeList);
            final boolean isArray = ctype.isSubclass(GenArrayType.typeArray);
            if (CompileReflect.checkKnownClass(ptype2, comp) >= 0) {
                if (ptype2.isSubtype(Compilation.typeType) || language.getTypeFor(proc, false) != null) {
                    result = exp.setFuncArgs(Invoke.make, args);
                }
                else if (ptype2 instanceof ArrayType) {
                    final Type elementType = ((ArrayType)ptype2).getComponentType();
                    exp.setFuncArgs(new ArrayGet(elementType), args);
                    result = exp;
                }
                else if (exp.isSimple() && (((isString || isSequence) && nargs == 1) || isArray)) {
                    final int rank = (isString || isSequence) ? 1 : ((ptype2 instanceof GenArrayType) ? ((GenArrayType)ptype2).rank() : -1);
                    Type elementType2 = Type.objectType;
                    if (ptype2 instanceof GenArrayType) {
                        elementType2 = ((GenArrayType)ptype2).getComponentType();
                    }
                    int resultRank = 0;
                    for (int i = 1; i <= nargs; ++i) {
                        args[i] = visitor.visit(args[i], (Type)null);
                        final Type itype = args[1].getType();
                        final int listIndexCompat = LangObjType.sequenceType.isCompatibleWithValue(itype);
                        final int intIndexCompat = Type.intType.isCompatibleWithValue(itype);
                        final int arrayIndexCompat = GenArrayType.typeArray.isCompatibleWithValue(itype);
                        if (resultRank >= 0 && intIndexCompat <= 0) {
                            if (listIndexCompat > 0) {
                                ++resultRank;
                            }
                            else {
                                final int r;
                                if (ptype2 instanceof GenArrayType && (r = ((GenArrayType)ptype2).rank()) >= 0) {
                                    resultRank += r;
                                }
                                else {
                                    resultRank = -1;
                                }
                            }
                        }
                        if (listIndexCompat < 0 && intIndexCompat < 0 && arrayIndexCompat < 0) {
                            visitor.getCompilation().error('w', "index is neither integer, sequence, or array");
                            resultRank = -1;
                        }
                        else if (intIndexCompat > 0) {
                            if (isString && nargs == 1) {
                                final Method method = ClassType.make("gnu.lists.Strings").getDeclaredMethod("characterAt", 2);
                                final PrimProcedure prproc = new PrimProcedure(method, LangPrimType.characterType, null);
                                result = exp.setFuncArgs(prproc, args);
                            }
                            else if (nargs == 1 && isSequence) {
                                String mname = "get";
                                Type retType = null;
                                final String cname = ctype.getName();
                                LangObjType ltype = null;
                                if (cname.startsWith("gnu.lists.")) {
                                    ltype = LangObjType.getInstanceFromClass(cname);
                                }
                                if (ltype != null && (retType = ltype.getElementType()) != null) {
                                    mname = ltype.elementGetterMethodName();
                                }
                                else if (ltype == LangObjType.vectorType && ptype2 instanceof ParameterizedType && ((ParameterizedType)ptype2).getTypeArgumentTypes().length == 1) {
                                    retType = ((ParameterizedType)ptype2).getTypeArgumentType(0);
                                }
                                final Method get = ctype.getMethod(mname, new Type[] { Type.intType });
                                final ParameterizedType prtype = (ptype2 instanceof ParameterizedType) ? ((ParameterizedType)ptype2) : null;
                                final PrimProcedure prproc2 = new PrimProcedure(get, 'V', language, prtype);
                                if (retType != null) {
                                    prproc2.setReturnType(retType);
                                }
                                result = exp.setFuncArgs(prproc2, args);
                            }
                        }
                        else if (arrayIndexCompat <= 0) {
                            if (listIndexCompat > 0) {}
                        }
                    }
                    if (rank >= 0 && rank != nargs) {
                        final StringBuilder msg = new StringBuilder();
                        if (isSequence || isString) {
                            msg.append(isString ? "string" : "sequence").append(" requires 1 index");
                        }
                        else {
                            msg.append("array has rank ").append(rank);
                        }
                        msg.append(" but there are ");
                        msg.append(nargs).append(" indexes");
                        visitor.getCompilation().error('w', msg.toString());
                    }
                    else if (isArray && resultRank == 0 && result == null) {
                        final char sig1 = elementType2.getSignature().charAt(0);
                        String mname2;
                        if (elementType2 instanceof PrimType) {
                            mname2 = ((sig1 == 'I') ? "getInt" : "effectiveIndex");
                        }
                        else {
                            mname2 = "get";
                        }
                        Method meth = (nargs == 1) ? ctype.getMethod(mname2, new Type[] { Type.intType }) : ctype.getDeclaredMethod(mname2, (nargs > 3) ? 4 : nargs);
                        PrimProcedure prproc3 = new PrimProcedure(meth);
                        result = exp.setFuncArgs(prproc3, args);
                        if (mname2 == "effectiveIndex") {
                            switch (sig1) {
                                case 'Z': {
                                    mname2 = "getBooleanRaw";
                                    break;
                                }
                                case 'C': {
                                    mname2 = "getCharRaw";
                                    break;
                                }
                                case 'B': {
                                    mname2 = "getByteRaw";
                                    break;
                                }
                                case 'S': {
                                    mname2 = "getShortRaw";
                                    break;
                                }
                                case 'J': {
                                    mname2 = "getLongRaw";
                                    break;
                                }
                                case 'F': {
                                    mname2 = "getFloatRaw";
                                    break;
                                }
                                case 'D': {
                                    mname2 = "getDoubleRaw";
                                    break;
                                }
                                default: {
                                    throw new InternalError();
                                }
                            }
                            meth = GenArrayType.typeArray.getDeclaredMethod(mname2, 1);
                            comp.letStart();
                            final Declaration tdecl = comp.letVariable(null, ptype2, args[0]);
                            tdecl.setFlag(549755813888L);
                            tdecl.setCanRead(true);
                            args[0] = new ReferenceExp(tdecl);
                            final ReferenceExp aref = new ReferenceExp(tdecl);
                            aref.setFlag(32);
                            prproc3 = new PrimProcedure(meth);
                            prproc3.setReturnType(elementType2);
                            result = new ApplyExp(prproc3, new Expression[] { aref, result });
                            final Expression let = comp.letDone(result).setLine(exp);
                            return visitor.visit(let, required);
                        }
                        prproc3.setReturnType(elementType2);
                    }
                    if (isArray && !isString && result == null) {
                        final PrimProcedure prproc4 = new PrimProcedure("gnu.lists.ComposedArray", "generalIndex", 3);
                        final Expression[] xargs = new Expression[nargs + 2];
                        xargs[0] = args[0];
                        xargs[1] = QuoteExp.falseExp;
                        System.arraycopy(args, 1, xargs, 2, nargs);
                        result = exp.setFuncArgs(prproc4, xargs);
                        Type retType2 = null;
                        if (resultRank > 0) {
                            retType2 = new GenArrayType(resultRank, elementType2);
                        }
                        else if (resultRank == 0 && elementType2 != Type.objectType) {
                            retType2 = elementType2;
                        }
                        if (retType2 != null) {
                            result = Compilation.makeCoercion(result, retType2);
                        }
                    }
                }
            }
            if (result != null) {
                result.setLine(exp);
                return visitor.visitApplyOnly(result, required);
            }
        }
        exp.visitArgs(visitor);
        return exp;
    }
    
    public static Expression validateSetter(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length == 1) {
            Expression arg = args[0];
            final Type argType = arg.getType();
            if (argType instanceof ArrayType) {
                return new SetArrayExp(arg, (ArrayType)argType);
            }
            final Type implType = argType.getRawType();
            if (implType instanceof ClassType) {
                final ClassType cimplType = (ClassType)implType;
                if (cimplType.isSubclass(Compilation.typeList) || cimplType.isSubclass(GenArrayType.typeArray)) {
                    if (exp instanceof SetListExp) {
                        return exp;
                    }
                    return new SetListExp(exp.getFunction(), (ObjectType)argType, args);
                }
            }
            if (arg instanceof ReferenceExp) {
                final Declaration decl = ((ReferenceExp)arg).getBinding();
                if (decl != null) {
                    arg = decl.getValue();
                }
            }
            if (arg instanceof QuoteExp) {
                final Object value = ((QuoteExp)arg).getValue();
                if (value instanceof Procedure) {
                    final Procedure pvalue = (Procedure)value;
                    Procedure setter;
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
                        final Declaration decl2 = Declaration.getDeclaration(setter);
                        if (decl2 != null) {
                            return new ReferenceExp(decl2);
                        }
                    }
                }
            }
            if (argType instanceof ClassType && ((ClassType)argType).isSubclass(Compilation.typeProcedure)) {
                return new ApplyExp(CompilationHelpers.getSetterProc, args);
            }
        }
        return exp;
    }
    
    public static Expression validateIsEqv(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if ((nonNumeric(args[0]) || nonNumeric(args[1])) && !maybeLazy(args[0]) && !maybeLazy(args[1])) {
            return new ApplyExp(((IsEqv)proc).isEq, args);
        }
        final Method meth = ClassType.make("gnu.kawa.functions.IsEqv").getDeclaredMethod("apply", 2);
        return new ApplyExp(new PrimProcedure(meth, visitor.getLanguage()), args).setLine(exp);
    }
    
    static {
        setterType = ClassType.make("gnu.kawa.functions.Setter");
        setterField = CompilationHelpers.setterType.getDeclaredField("setter");
        (setterDecl = new Declaration("setter", CompilationHelpers.setterField)).noteValue(new QuoteExp(Setter.setter));
        getSetterProc = new PrimProcedure(Compilation.typeProcedure.getDeclaredMethod("getSetter", 0));
    }
}
