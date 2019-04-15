/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.ObjectExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.util.Vector;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.SchemeCompilation;

public class object
extends Syntax {
    public static final object objectSyntax = new object(SchemeCompilation.lambda);
    Lambda lambda;
    public static final Keyword accessKeyword;
    public static final Keyword classNameKeyword;
    public static final Keyword interfaceKeyword;
    public static final Keyword throwsKeyword;
    static final Keyword typeKeyword;
    public static final Keyword allocationKeyword;
    static final Keyword initKeyword;
    static final Keyword initformKeyword;
    static final Keyword init_formKeyword;
    static final Keyword init_valueKeyword;
    static final Keyword init_keywordKeyword;
    static final Symbol coloncolon;

    public object(Lambda lambda) {
        this.lambda = lambda;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object[] saved;
        if (!(form.getCdr() instanceof Pair)) {
            return tr.syntaxError("missing superclass specification in object");
        }
        Pair pair = (Pair)form.getCdr();
        ObjectExp oexp = new ObjectExp();
        if (pair.getCar() instanceof FString) {
            if (!(pair.getCdr() instanceof Pair)) {
                return tr.syntaxError("missing superclass specification after object class name");
            }
            pair = (Pair)pair.getCdr();
        }
        if ((saved = this.scanClassDef(pair, oexp, tr)) != null) {
            this.rewriteClassDef(saved, tr);
        }
        return oexp;
    }

    public Object[] scanClassDef(Pair pair, ClassExp oexp, Translator tr) {
        tr.mustCompileHere();
        Object superlist = pair.getCar();
        Object components = pair.getCdr();
        Object classNamePair = null;
        long classAccessFlag = 0L;
        Vector<Object> inits = new Vector<Object>(20);
        Object obj = components;
        while (obj != LList.Empty) {
            Object savedPos1;
            block64 : {
                Declaration decl;
                Object pair_car;
                block56 : {
                    Object args;
                    while (obj instanceof SyntaxForm) {
                        obj = ((SyntaxForm)obj).getDatum();
                    }
                    if (!(obj instanceof Pair)) {
                        tr.error('e', "object member not a list");
                        return null;
                    }
                    pair = (Pair)obj;
                    pair_car = pair.getCar();
                    while (pair_car instanceof SyntaxForm) {
                        pair_car = ((SyntaxForm)pair_car).getDatum();
                    }
                    obj = pair.getCdr();
                    savedPos1 = tr.pushPositionOf(pair);
                    if (pair_car instanceof Keyword) {
                        while (obj instanceof SyntaxForm) {
                            obj = ((SyntaxForm)obj).getDatum();
                        }
                        if (obj instanceof Pair) {
                            if (pair_car == interfaceKeyword) {
                                Object val = ((Pair)obj).getCar();
                                while (val instanceof SyntaxForm) {
                                    val = ((SyntaxForm)val).getDatum();
                                }
                                if (val == Boolean.FALSE) {
                                    oexp.setFlag(131072);
                                } else {
                                    oexp.setFlag(98304);
                                }
                                obj = ((Pair)obj).getCdr();
                                tr.popPositionOf(savedPos1);
                                continue;
                            }
                            if (pair_car == classNameKeyword) {
                                if (classNamePair != null) {
                                    tr.error('e', "duplicate class-name specifiers");
                                }
                                classNamePair = obj;
                                obj = ((Pair)obj).getCdr();
                                tr.popPositionOf(savedPos1);
                                continue;
                            }
                            if (pair_car == accessKeyword) {
                                Object savedPos2 = tr.pushPositionOf(obj);
                                classAccessFlag = object.addAccessFlags(((Pair)obj).getCar(), classAccessFlag, 60179873792L, "class", tr);
                                if (oexp.nameDecl == null) {
                                    tr.error('e', "access specifier for anonymous class");
                                }
                                tr.popPositionOf(savedPos2);
                                obj = ((Pair)obj).getCdr();
                                tr.popPositionOf(savedPos1);
                                continue;
                            }
                        }
                    } else if (pair_car instanceof Pair && Lambda.isAnnotationSymbol(((Pair)pair_car).getCar())) {
                        if (oexp.nameDecl == null) {
                            tr.error('e', "annotation for anonymous class");
                            continue;
                        }
                        oexp.nameDecl.addAnnotation(new LangExp(pair));
                        continue;
                    }
                    if (!(pair_car instanceof Pair)) {
                        tr.error('e', "object member not a list");
                        return null;
                    }
                    pair = (Pair)pair_car;
                    pair_car = pair.getCar();
                    while (pair_car instanceof SyntaxForm) {
                        pair_car = ((SyntaxForm)pair_car).getDatum();
                    }
                    if (!(pair_car instanceof String) && !(pair_car instanceof Symbol) && !(pair_car instanceof Keyword)) break block56;
                    Pair typePair = null;
                    Object sname = pair_car;
                    int allocationFlag = 0;
                    long accessFlag = 0L;
                    if (sname instanceof Keyword) {
                        decl = null;
                        args = pair;
                    } else {
                        decl = oexp.addDeclaration(sname);
                        decl.setSimple(false);
                        decl.setFlag(0x100000L);
                        Translator.setLine(decl, (Object)pair);
                        args = pair.getCdr();
                    }
                    int nKeywords = 0;
                    boolean seenInit = false;
                    Pair initPair = null;
                    while (args != LList.Empty) {
                        Object savedPos2;
                        block59 : {
                            Pair keyPair;
                            Object key;
                            block57 : {
                                Object value;
                                block62 : {
                                    block63 : {
                                        block61 : {
                                            block60 : {
                                                block58 : {
                                                    while (args instanceof SyntaxForm) {
                                                        args = ((SyntaxForm)args).getDatum();
                                                    }
                                                    keyPair = pair = (Pair)args;
                                                    key = Translator.stripSyntax(pair.getCar());
                                                    savedPos2 = tr.pushPositionOf(pair);
                                                    args = pair.getCdr();
                                                    if (key != coloncolon && !(key instanceof Keyword) || !(args instanceof Pair)) break block57;
                                                    ++nKeywords;
                                                    pair = (Pair)args;
                                                    value = Translator.stripSyntax(pair.getCar());
                                                    args = pair.getCdr();
                                                    if (key != coloncolon && key != typeKeyword) break block58;
                                                    typePair = pair;
                                                    break block59;
                                                }
                                                if (key != allocationKeyword) break block60;
                                                if (allocationFlag != 0) {
                                                    tr.error('e', "duplicate allocation: specification");
                                                }
                                                if (object.matches(value, "class", tr) || object.matches(value, "static", tr)) {
                                                    allocationFlag = 2048;
                                                } else if (object.matches(value, "instance", tr)) {
                                                    allocationFlag = 4096;
                                                } else {
                                                    tr.error('e', "unknown allocation kind '" + value + "'");
                                                }
                                                break block59;
                                            }
                                            if (key != initKeyword && key != initformKeyword && key != init_formKeyword && key != init_valueKeyword) break block61;
                                            if (seenInit) {
                                                tr.error('e', "duplicate initialization");
                                            }
                                            seenInit = true;
                                            if (key != initKeyword) {
                                                initPair = pair;
                                            }
                                            break block59;
                                        }
                                        if (key != init_keywordKeyword) break block62;
                                        if (value instanceof Keyword) break block63;
                                        tr.error('e', "invalid 'init-keyword' - not a keyword");
                                        break block59;
                                    }
                                    if (((Keyword)value).getName() == sname.toString()) break block59;
                                    tr.error('w', "init-keyword option ignored");
                                    break block59;
                                }
                                if (key == accessKeyword) {
                                    Object savedPos3 = tr.pushPositionOf(pair);
                                    accessFlag = object.addAccessFlags(value, accessFlag, 32463912960L, "field", tr);
                                    tr.popPositionOf(savedPos3);
                                } else {
                                    tr.error('w', "unknown slot keyword '" + key + "'");
                                }
                                break block59;
                            }
                            if (args == LList.Empty && !seenInit) {
                                initPair = keyPair;
                                seenInit = true;
                            } else if (args instanceof Pair && nKeywords == 0 && !seenInit && typePair == null && (pair = (Pair)args).getCdr() == LList.Empty) {
                                typePair = keyPair;
                                initPair = pair;
                                args = pair.getCdr();
                                seenInit = true;
                            } else if (key instanceof Pair && Lambda.isAnnotationSymbol(((Pair)key).getCar())) {
                                decl.addAnnotation(new LangExp(keyPair));
                            } else {
                                args = null;
                                break;
                            }
                        }
                        tr.popPositionOf(savedPos2);
                    }
                    if (args != LList.Empty) {
                        tr.error('e', "invalid argument list for slot '" + sname + '\'' + " args:" + (args == null ? "null" : args.getClass().getName()));
                        return null;
                    }
                    if (seenInit) {
                        boolean isStatic;
                        boolean bl = isStatic = allocationFlag == 2048;
                        inits.addElement(decl != null ? decl : (isStatic ? Boolean.TRUE : Boolean.FALSE));
                        inits.addElement(initPair);
                    }
                    if (decl == null) {
                        if (!seenInit) {
                            tr.error('e', "missing field name");
                            return null;
                        }
                    } else {
                        if (typePair != null) {
                            decl.setTypeExp(new LangExp(typePair));
                            decl.setFlag(8192L);
                        }
                        if (allocationFlag != 0) {
                            decl.setFlag(allocationFlag);
                        }
                        if (accessFlag != 0L) {
                            decl.setFlag(accessFlag);
                        }
                        decl.noteValueUnknown();
                        decl.setCanRead(true);
                        decl.setCanWrite(true);
                    }
                    break block64;
                }
                if (pair_car instanceof Pair) {
                    Pair mpair = (Pair)pair_car;
                    Object mname = mpair.getCar();
                    while (mname instanceof SyntaxForm) {
                        mname = ((SyntaxForm)mname).getDatum();
                    }
                    if (!(mname instanceof String) && !(mname instanceof Symbol)) {
                        tr.error('e', "missing method name");
                        return null;
                    }
                    LambdaExp lexp = new LambdaExp();
                    decl = oexp.addMethod(lexp, mname);
                    Translator.setLine(decl, (Object)mpair);
                    oexp.pushChild(lexp);
                } else {
                    tr.error('e', "invalid field/method definition");
                }
            }
            tr.popPositionOf(savedPos1);
        }
        oexp.reverseChildList();
        if (classAccessFlag != 0L && oexp.nameDecl != null) {
            oexp.nameDecl.setFlag(classAccessFlag);
            if ((classAccessFlag & 0x800000000L) != 0L) {
                oexp.setFlag(32768);
            }
        }
        if (classNamePair != null) {
            String classNameSpecifier;
            Expression classNameExp = tr.rewrite_car((Pair)classNamePair, false);
            Object classNameVal = classNameExp.valueIfConstant();
            boolean isString = classNameVal instanceof CharSequence;
            if (isString && (classNameSpecifier = classNameVal.toString()).length() > 0) {
                oexp.classNameSpecifier = classNameSpecifier;
            } else {
                tr.errorWithPosition("class-name specifier must be a non-empty string literal", classNamePair);
            }
        }
        Object[] result = new Object[]{oexp, components, inits, superlist};
        return result;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void rewriteClassDef(Object[] saved, Translator tr) {
        ClassExp oexp = (ClassExp)saved[0];
        Object components = saved[1];
        Vector inits = (Vector)saved[2];
        Object superlist = saved[3];
        LambdaExp method_list = oexp.firstChild;
        int num_supers = Translator.listLength(superlist);
        if (num_supers < 0) {
            tr.error('e', "object superclass specification not a list");
            num_supers = 0;
        }
        Expression[] supers = new Expression[num_supers];
        for (int i = 0; i < num_supers; ++i) {
            Declaration decl;
            Expression svalue;
            while (superlist instanceof SyntaxForm) {
                superlist = ((SyntaxForm)superlist).getDatum();
            }
            Pair superpair = (Pair)superlist;
            supers[i] = tr.rewrite_car(superpair, false);
            if (supers[i] instanceof ReferenceExp && (decl = Declaration.followAliases(((ReferenceExp)supers[i]).getBinding())) != null && (svalue = decl.getValue()) instanceof ClassExp) {
                ((ClassExp)svalue).setFlag(262144);
            }
            superlist = superpair.getCdr();
        }
        oexp.supers = supers;
        oexp.setTypes(tr);
        if (oexp.nameDecl != null) {
            Lambda.rewriteAnnotations(oexp.nameDecl, tr);
        }
        for (Declaration decl = oexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Lambda.rewriteAnnotations(decl, tr);
        }
        int len = inits.size();
        for (int i = 0; i < len; i += 2) {
            Object init = inits.elementAt(i + 1);
            if (init == null) continue;
            object.rewriteInit(inits.elementAt(i), oexp, (Pair)init, tr, null);
        }
        tr.push(oexp);
        LambdaExp meth = method_list;
        int init_index = 0;
        SyntaxForm componentsSyntax = null;
        Object obj = components;
        while (obj != LList.Empty) {
            while (obj instanceof SyntaxForm) {
                componentsSyntax = (SyntaxForm)obj;
                obj = componentsSyntax.getDatum();
            }
            Pair pair = (Pair)obj;
            Object savedPos1 = tr.pushPositionOf(pair);
            Object pair_car = pair.getCar();
            SyntaxForm memberSyntax = componentsSyntax;
            while (pair_car instanceof SyntaxForm) {
                memberSyntax = (SyntaxForm)pair_car;
                pair_car = memberSyntax.getDatum();
            }
            try {
                SyntaxForm memberCarSyntax;
                block30 : {
                    boolean isStatic;
                    Object d;
                    obj = pair.getCdr();
                    if (pair_car instanceof Keyword && obj instanceof Pair) {
                        obj = ((Pair)obj).getCdr();
                        continue;
                    }
                    pair = (Pair)pair_car;
                    pair_car = pair.getCar();
                    memberCarSyntax = memberSyntax;
                    while (pair_car instanceof SyntaxForm) {
                        memberCarSyntax = (SyntaxForm)pair_car;
                        pair_car = memberCarSyntax.getDatum();
                    }
                    if (Lambda.isAnnotationSymbol(pair_car)) continue;
                    if (!(pair_car instanceof String) && !(pair_car instanceof Symbol) && !(pair_car instanceof Keyword)) break block30;
                    Object type = null;
                    int nKeywords = 0;
                    Object args = pair_car instanceof Keyword ? pair : pair.getCdr();
                    Pair initPair = null;
                    SyntaxForm initSyntax = null;
                    while (args != LList.Empty) {
                        Object savedPos2;
                        block33 : {
                            Object key;
                            block31 : {
                                block32 : {
                                    while (args instanceof SyntaxForm) {
                                        memberSyntax = (SyntaxForm)args;
                                        args = memberSyntax.getDatum();
                                    }
                                    pair = (Pair)args;
                                    key = pair.getCar();
                                    while (key instanceof SyntaxForm) {
                                        key = ((SyntaxForm)key).getDatum();
                                    }
                                    savedPos2 = tr.pushPositionOf(pair);
                                    args = pair.getCdr();
                                    if (key != coloncolon && !(key instanceof Keyword) || !(args instanceof Pair)) break block31;
                                    ++nKeywords;
                                    pair = (Pair)args;
                                    Object value = pair.getCar();
                                    args = pair.getCdr();
                                    if (key != coloncolon && key != typeKeyword) break block32;
                                    type = value;
                                    break block33;
                                }
                                if (key != initKeyword && key != initformKeyword && key != init_formKeyword && key != init_valueKeyword) break block33;
                                initPair = pair;
                                initSyntax = memberSyntax;
                                break block33;
                            }
                            if (args == LList.Empty && initPair == null) {
                                initPair = pair;
                                initSyntax = memberSyntax;
                            } else if (args instanceof Pair && nKeywords == 0 && initPair == null && type == null && (pair = (Pair)args).getCdr() == LList.Empty) {
                                type = key;
                                initPair = pair;
                                initSyntax = memberSyntax;
                                args = pair.getCdr();
                            } else {
                                args = null;
                                break;
                            }
                        }
                        tr.popPositionOf(savedPos2);
                    }
                    if (initPair == null) continue;
                    boolean bl = (d = inits.elementAt(init_index++)) instanceof Declaration ? ((Declaration)d).getFlag(2048L) : (isStatic = d == Boolean.TRUE);
                    if (inits.elementAt(init_index++) != null) continue;
                    object.rewriteInit(d, oexp, initPair, tr, initSyntax);
                    continue;
                }
                if (pair_car instanceof Pair) {
                    ScopeExp save_scope = tr.currentScope();
                    if (memberSyntax != null) {
                        tr.setCurrentScope(memberSyntax.getScope());
                    }
                    if ("*init*".equals(meth.getName())) {
                        meth.setReturnType(Type.voidType);
                    }
                    Translator.setLine(meth, (Object)pair);
                    LambdaExp saveLambda = tr.curMethodLambda;
                    tr.curMethodLambda = meth;
                    this.lambda.rewrite(meth, ((Pair)pair_car).getCdr(), pair.getCdr(), tr, memberCarSyntax != null && (memberSyntax == null || memberCarSyntax.getScope() != memberSyntax.getScope()) ? memberCarSyntax.getScope() : null);
                    tr.curMethodLambda = saveLambda;
                    if (memberSyntax != null) {
                        tr.setCurrentScope(save_scope);
                    }
                    meth = meth.nextSibling;
                    continue;
                }
                tr.syntaxError("invalid field/method definition");
            }
            finally {
                tr.popPositionOf(savedPos1);
            }
        }
        for (Declaration decl = oexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression texp = decl.getTypeExpRaw();
            if (!(texp instanceof LangExp)) continue;
            Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
            tr.exp2Type(typeSpecPair, decl, null);
        }
        if (oexp.initMethod != null) {
            oexp.initMethod.setOuter(oexp);
        }
        if (oexp.clinitMethod != null) {
            oexp.clinitMethod.setOuter(oexp);
        }
        tr.pop(oexp);
    }

    private static void rewriteInit(Object d, ClassExp oexp, Pair initPair, Translator tr, SyntaxForm initSyntax) {
        LambdaExp initMethod;
        boolean isStatic = d instanceof Declaration ? ((Declaration)d).getFlag(2048L) : d == Boolean.TRUE;
        LambdaExp lambdaExp = initMethod = isStatic ? oexp.clinitMethod : oexp.initMethod;
        if (initMethod == null) {
            initMethod = new LambdaExp(new BeginExp());
            initMethod.setClassMethod(true);
            initMethod.setReturnType(Type.voidType);
            if (isStatic) {
                initMethod.setName("$clinit$");
                oexp.clinitMethod = initMethod;
            } else {
                initMethod.setName("$finit$");
                oexp.initMethod = initMethod;
                initMethod.add(null, new Declaration(ThisExp.THIS_NAME));
            }
            oexp.pushChild(initMethod);
        }
        tr.push(initMethod);
        LambdaExp saveLambda = tr.curMethodLambda;
        tr.curMethodLambda = initMethod;
        Expression initValue = tr.rewrite_car(initPair, initSyntax);
        if (d instanceof Declaration) {
            Declaration decl = (Declaration)d;
            SetExp sexp = new SetExp(decl, initValue);
            sexp.setLocation(decl);
            decl.noteValueFromSet(sexp);
            initValue = sexp;
        } else {
            initValue = Compilation.makeCoercion(initValue, new QuoteExp(Type.voidType));
        }
        ((BeginExp)initMethod.body).add(initValue);
        tr.curMethodLambda = saveLambda;
        tr.pop(initMethod);
    }

    static boolean matches(Object exp, String tag, Translator tr) {
        String value;
        Object qvalue;
        if (exp instanceof Keyword) {
            value = ((Keyword)exp).getName();
        } else if (exp instanceof FString) {
            value = ((FString)exp).toString();
        } else if (exp instanceof Pair && (qvalue = tr.matchQuoted((Pair)exp)) instanceof SimpleSymbol) {
            value = qvalue.toString();
        } else {
            return false;
        }
        return tag == null || tag.equals(value);
    }

    public static long addAccessFlags(Object value, long previous, long allowed, String kind, Translator tr) {
        long flags = object.matchAccess(value, tr);
        if (flags == 0L) {
            tr.error('e', "unknown access specifier " + value);
        } else if ((flags & (allowed ^ -1L)) != 0L) {
            tr.error('e', "invalid " + kind + " access specifier " + value);
        } else if ((previous & flags) != 0L) {
            tr.error('w', "duplicate " + kind + " access specifiers " + value);
        }
        return previous | flags;
    }

    static long matchAccess(Object value, Translator tr) {
        while (value instanceof SyntaxForm) {
            value = ((SyntaxForm)value).getDatum();
        }
        if (value instanceof Pair) {
            Pair p = (Pair)value;
            if ((value = tr.matchQuoted((Pair)value)) instanceof Pair) {
                return object.matchAccess2((Pair)value, tr);
            }
        }
        return object.matchAccess1(value, tr);
    }

    private static long matchAccess2(Pair pair, Translator tr) {
        long icdr;
        long icar = object.matchAccess1(pair.getCar(), tr);
        Object cdr = pair.getCdr();
        if (cdr == LList.Empty || icar == 0L) {
            return icar;
        }
        if (cdr instanceof Pair && (icdr = object.matchAccess2((Pair)cdr, tr)) != 0L) {
            return icar | icdr;
        }
        return 0L;
    }

    private static long matchAccess1(Object value, Translator tr) {
        if (value instanceof Keyword) {
            value = ((Keyword)value).getName();
        } else if (value instanceof FString) {
            value = ((FString)value).toString();
        } else if (value instanceof SimpleSymbol) {
            value = value.toString();
        }
        if ("private".equals(value)) {
            return 0x1000000L;
        }
        if ("protected".equals(value)) {
            return 0x2000000L;
        }
        if ("public".equals(value)) {
            return 0x4000000L;
        }
        if ("package".equals(value)) {
            return 0x8000000L;
        }
        if ("volatile".equals(value)) {
            return 0x80000000L;
        }
        if ("transient".equals(value)) {
            return 0x100000000L;
        }
        if ("enum".equals(value)) {
            return 0x200000000L;
        }
        if ("final".equals(value)) {
            return 0x400000000L;
        }
        if ("abstract".equals(value)) {
            return 0x800000000L;
        }
        if ("synchronized".equals(value)) {
            return 0x1000000000L;
        }
        if ("strictfp".equals(value)) {
            return 0x2000000000L;
        }
        return 0L;
    }

    static {
        objectSyntax.setName("object");
        accessKeyword = Keyword.make("access");
        classNameKeyword = Keyword.make("class-name");
        interfaceKeyword = Keyword.make("interface");
        throwsKeyword = Keyword.make("throws");
        typeKeyword = Keyword.make("type");
        allocationKeyword = Keyword.make("allocation");
        initKeyword = Keyword.make("init");
        initformKeyword = Keyword.make("initform");
        init_formKeyword = Keyword.make("init-form");
        init_valueKeyword = Keyword.make("init-value");
        init_keywordKeyword = Keyword.make("init-keyword");
        coloncolon = Namespace.EmptyNamespace.getSymbol("::");
    }
}

