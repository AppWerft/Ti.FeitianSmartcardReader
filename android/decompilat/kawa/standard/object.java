// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.expr.QuoteExp;
import gnu.text.SourceLocator;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.expr.BeginExp;
import gnu.bytecode.Type;
import gnu.expr.ScopeExp;
import gnu.expr.Compilation;
import gnu.expr.ReferenceExp;
import gnu.expr.Declaration;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import kawa.lang.SyntaxForm;
import gnu.lists.LList;
import java.util.Vector;
import gnu.expr.ClassExp;
import gnu.lists.FString;
import gnu.expr.ObjectExp;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import gnu.expr.Keyword;
import kawa.lang.Lambda;
import kawa.lang.Syntax;

public class object extends Syntax
{
    public static final object objectSyntax;
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
    
    public object(final Lambda lambda) {
        this.lambda = lambda;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        if (!(form.getCdr() instanceof Pair)) {
            return tr.syntaxError("missing superclass specification in object");
        }
        Pair pair = (Pair)form.getCdr();
        final ObjectExp oexp = new ObjectExp();
        if (pair.getCar() instanceof FString) {
            if (!(pair.getCdr() instanceof Pair)) {
                return tr.syntaxError("missing superclass specification after object class name");
            }
            pair = (Pair)pair.getCdr();
        }
        final Object[] saved = this.scanClassDef(pair, oexp, tr);
        if (saved != null) {
            this.rewriteClassDef(saved, tr);
        }
        return oexp;
    }
    
    public Object[] scanClassDef(Pair pair, final ClassExp oexp, final Translator tr) {
        tr.mustCompileHere();
        final Object superlist = pair.getCar();
        final Object components = pair.getCdr();
        Object classNamePair = null;
        long classAccessFlag = 0L;
        final Vector inits = new Vector(20);
        Object obj = components;
        while (obj != LList.Empty) {
            while (obj instanceof SyntaxForm) {
                obj = ((SyntaxForm)obj).getDatum();
            }
            if (!(obj instanceof Pair)) {
                tr.error('e', "object member not a list");
                return null;
            }
            pair = (Pair)obj;
            Object pair_car;
            for (pair_car = pair.getCar(); pair_car instanceof SyntaxForm; pair_car = ((SyntaxForm)pair_car).getDatum()) {}
            obj = pair.getCdr();
            final Object savedPos1 = tr.pushPositionOf(pair);
            if (pair_car instanceof Keyword) {
                while (obj instanceof SyntaxForm) {
                    obj = ((SyntaxForm)obj).getDatum();
                }
                if (obj instanceof Pair) {
                    if (pair_car == object.interfaceKeyword) {
                        Object val;
                        for (val = ((Pair)obj).getCar(); val instanceof SyntaxForm; val = ((SyntaxForm)val).getDatum()) {}
                        if (val == Boolean.FALSE) {
                            oexp.setFlag(131072);
                        }
                        else {
                            oexp.setFlag(98304);
                        }
                        obj = ((Pair)obj).getCdr();
                        tr.popPositionOf(savedPos1);
                        continue;
                    }
                    if (pair_car == object.classNameKeyword) {
                        if (classNamePair != null) {
                            tr.error('e', "duplicate class-name specifiers");
                        }
                        classNamePair = obj;
                        obj = ((Pair)obj).getCdr();
                        tr.popPositionOf(savedPos1);
                        continue;
                    }
                    if (pair_car == object.accessKeyword) {
                        final Object savedPos2 = tr.pushPositionOf(obj);
                        classAccessFlag = addAccessFlags(((Pair)obj).getCar(), classAccessFlag, 60179873792L, "class", tr);
                        if (oexp.nameDecl == null) {
                            tr.error('e', "access specifier for anonymous class");
                        }
                        tr.popPositionOf(savedPos2);
                        obj = ((Pair)obj).getCdr();
                        tr.popPositionOf(savedPos1);
                        continue;
                    }
                }
            }
            else if (pair_car instanceof Pair && Lambda.isAnnotationSymbol(((Pair)pair_car).getCar())) {
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
            for (pair_car = pair.getCar(); pair_car instanceof SyntaxForm; pair_car = ((SyntaxForm)pair_car).getDatum()) {}
            if (pair_car instanceof String || pair_car instanceof Symbol || pair_car instanceof Keyword) {
                Pair typePair = null;
                final Object sname = pair_car;
                int allocationFlag = 0;
                long accessFlag = 0L;
                Declaration decl;
                Object args;
                if (sname instanceof Keyword) {
                    decl = null;
                    args = pair;
                }
                else {
                    decl = oexp.addDeclaration(sname);
                    decl.setSimple(false);
                    decl.setFlag(1048576L);
                    Translator.setLine(decl, pair);
                    args = pair.getCdr();
                }
                int nKeywords = 0;
                boolean seenInit = false;
                Pair initPair = null;
                while (args != LList.Empty) {
                    while (args instanceof SyntaxForm) {
                        args = ((SyntaxForm)args).getDatum();
                    }
                    final Pair keyPair;
                    pair = (keyPair = (Pair)args);
                    final Object key = Translator.stripSyntax(pair.getCar());
                    final Object savedPos3 = tr.pushPositionOf(pair);
                    args = pair.getCdr();
                    if ((key == object.coloncolon || key instanceof Keyword) && args instanceof Pair) {
                        ++nKeywords;
                        pair = (Pair)args;
                        final Object value = Translator.stripSyntax(pair.getCar());
                        args = pair.getCdr();
                        if (key == object.coloncolon || key == object.typeKeyword) {
                            typePair = pair;
                        }
                        else if (key == object.allocationKeyword) {
                            if (allocationFlag != 0) {
                                tr.error('e', "duplicate allocation: specification");
                            }
                            if (matches(value, "class", tr) || matches(value, "static", tr)) {
                                allocationFlag = 2048;
                            }
                            else if (matches(value, "instance", tr)) {
                                allocationFlag = 4096;
                            }
                            else {
                                tr.error('e', "unknown allocation kind '" + value + "'");
                            }
                        }
                        else if (key == object.initKeyword || key == object.initformKeyword || key == object.init_formKeyword || key == object.init_valueKeyword) {
                            if (seenInit) {
                                tr.error('e', "duplicate initialization");
                            }
                            seenInit = true;
                            if (key != object.initKeyword) {
                                initPair = pair;
                            }
                        }
                        else if (key == object.init_keywordKeyword) {
                            if (!(value instanceof Keyword)) {
                                tr.error('e', "invalid 'init-keyword' - not a keyword");
                            }
                            else if (((Keyword)value).getName() != sname.toString()) {
                                tr.error('w', "init-keyword option ignored");
                            }
                        }
                        else if (key == object.accessKeyword) {
                            final Object savedPos4 = tr.pushPositionOf(pair);
                            accessFlag = addAccessFlags(value, accessFlag, 32463912960L, "field", tr);
                            tr.popPositionOf(savedPos4);
                        }
                        else {
                            tr.error('w', "unknown slot keyword '" + key + "'");
                        }
                    }
                    else if (args == LList.Empty && !seenInit) {
                        initPair = keyPair;
                        seenInit = true;
                    }
                    else if (args instanceof Pair && nKeywords == 0 && !seenInit && typePair == null && (pair = (Pair)args).getCdr() == LList.Empty) {
                        typePair = keyPair;
                        initPair = pair;
                        args = pair.getCdr();
                        seenInit = true;
                    }
                    else {
                        if (!(key instanceof Pair) || !Lambda.isAnnotationSymbol(((Pair)key).getCar())) {
                            args = null;
                            break;
                        }
                        decl.addAnnotation(new LangExp(keyPair));
                    }
                    tr.popPositionOf(savedPos3);
                }
                if (args != LList.Empty) {
                    tr.error('e', "invalid argument list for slot '" + sname + '\'' + " args:" + ((args == null) ? "null" : args.getClass().getName()));
                    return null;
                }
                if (seenInit) {
                    final boolean isStatic = allocationFlag == 2048;
                    inits.addElement((decl != null) ? decl : (isStatic ? Boolean.TRUE : Boolean.FALSE));
                    inits.addElement(initPair);
                }
                if (decl == null) {
                    if (!seenInit) {
                        tr.error('e', "missing field name");
                        return null;
                    }
                }
                else {
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
            }
            else if (pair_car instanceof Pair) {
                final Pair mpair = (Pair)pair_car;
                Object mname;
                for (mname = mpair.getCar(); mname instanceof SyntaxForm; mname = ((SyntaxForm)mname).getDatum()) {}
                if (!(mname instanceof String) && !(mname instanceof Symbol)) {
                    tr.error('e', "missing method name");
                    return null;
                }
                final LambdaExp lexp = new LambdaExp();
                final Declaration decl = oexp.addMethod(lexp, mname);
                Translator.setLine(decl, mpair);
                oexp.pushChild(lexp);
            }
            else {
                tr.error('e', "invalid field/method definition");
            }
            tr.popPositionOf(savedPos1);
        }
        oexp.reverseChildList();
        if (classAccessFlag != 0L && oexp.nameDecl != null) {
            oexp.nameDecl.setFlag(classAccessFlag);
            if ((classAccessFlag & 0x800000000L) != 0x0L) {
                oexp.setFlag(32768);
            }
        }
        if (classNamePair != null) {
            final Expression classNameExp = tr.rewrite_car((Pair)classNamePair, false);
            final Object classNameVal = classNameExp.valueIfConstant();
            final boolean isString = classNameVal instanceof CharSequence;
            final String classNameSpecifier;
            if (isString && (classNameSpecifier = classNameVal.toString()).length() > 0) {
                oexp.classNameSpecifier = classNameSpecifier;
            }
            else {
                tr.errorWithPosition("class-name specifier must be a non-empty string literal", classNamePair);
            }
        }
        final Object[] result = { oexp, components, inits, superlist };
        return result;
    }
    
    public void rewriteClassDef(final Object[] saved, final Translator tr) {
        final ClassExp oexp = (ClassExp)saved[0];
        final Object components = saved[1];
        final Vector inits = (Vector)saved[2];
        Object superlist = saved[3];
        final LambdaExp method_list = oexp.firstChild;
        int num_supers = Translator.listLength(superlist);
        if (num_supers < 0) {
            tr.error('e', "object superclass specification not a list");
            num_supers = 0;
        }
        final Expression[] supers = new Expression[num_supers];
        for (int i = 0; i < num_supers; ++i) {
            while (superlist instanceof SyntaxForm) {
                superlist = ((SyntaxForm)superlist).getDatum();
            }
            final Pair superpair = (Pair)superlist;
            supers[i] = tr.rewrite_car(superpair, false);
            if (supers[i] instanceof ReferenceExp) {
                final Declaration decl = Declaration.followAliases(((ReferenceExp)supers[i]).getBinding());
                final Expression svalue;
                if (decl != null && (svalue = decl.getValue()) instanceof ClassExp) {
                    ((ClassExp)svalue).setFlag(262144);
                }
            }
            superlist = superpair.getCdr();
        }
        oexp.supers = supers;
        oexp.setTypes(tr);
        if (oexp.nameDecl != null) {
            Lambda.rewriteAnnotations(oexp.nameDecl, tr);
        }
        for (Declaration decl2 = oexp.firstDecl(); decl2 != null; decl2 = decl2.nextDecl()) {
            Lambda.rewriteAnnotations(decl2, tr);
        }
        for (int len = inits.size(), j = 0; j < len; j += 2) {
            final Object init = inits.elementAt(j + 1);
            if (init != null) {
                rewriteInit(inits.elementAt(j), oexp, (Pair)init, tr, null);
            }
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
            final Object savedPos1 = tr.pushPositionOf(pair);
            Object pair_car;
            SyntaxForm memberSyntax;
            for (pair_car = pair.getCar(), memberSyntax = componentsSyntax; pair_car instanceof SyntaxForm; pair_car = memberSyntax.getDatum()) {
                memberSyntax = (SyntaxForm)pair_car;
            }
            try {
                obj = pair.getCdr();
                if (pair_car instanceof Keyword && obj instanceof Pair) {
                    obj = ((Pair)obj).getCdr();
                }
                else {
                    pair = (Pair)pair_car;
                    SyntaxForm memberCarSyntax;
                    for (pair_car = pair.getCar(), memberCarSyntax = memberSyntax; pair_car instanceof SyntaxForm; pair_car = memberCarSyntax.getDatum()) {
                        memberCarSyntax = (SyntaxForm)pair_car;
                    }
                    if (Lambda.isAnnotationSymbol(pair_car)) {
                        continue;
                    }
                    if (pair_car instanceof String || pair_car instanceof Symbol || pair_car instanceof Keyword) {
                        Object type = null;
                        int nKeywords = 0;
                        Object args = (pair_car instanceof Keyword) ? pair : pair.getCdr();
                        Pair initPair = null;
                        SyntaxForm initSyntax = null;
                        while (args != LList.Empty) {
                            while (args instanceof SyntaxForm) {
                                memberSyntax = (SyntaxForm)args;
                                args = memberSyntax.getDatum();
                            }
                            pair = (Pair)args;
                            Object key;
                            for (key = pair.getCar(); key instanceof SyntaxForm; key = ((SyntaxForm)key).getDatum()) {}
                            final Object savedPos2 = tr.pushPositionOf(pair);
                            args = pair.getCdr();
                            if ((key == object.coloncolon || key instanceof Keyword) && args instanceof Pair) {
                                ++nKeywords;
                                pair = (Pair)args;
                                final Object value = pair.getCar();
                                args = pair.getCdr();
                                if (key == object.coloncolon || key == object.typeKeyword) {
                                    type = value;
                                }
                                else if (key == object.initKeyword || key == object.initformKeyword || key == object.init_formKeyword || key == object.init_valueKeyword) {
                                    initPair = pair;
                                    initSyntax = memberSyntax;
                                }
                            }
                            else if (args == LList.Empty && initPair == null) {
                                initPair = pair;
                                initSyntax = memberSyntax;
                            }
                            else {
                                if (!(args instanceof Pair) || nKeywords != 0 || initPair != null || type != null || (pair = (Pair)args).getCdr() != LList.Empty) {
                                    args = null;
                                    break;
                                }
                                type = key;
                                initPair = pair;
                                initSyntax = memberSyntax;
                                args = pair.getCdr();
                            }
                            tr.popPositionOf(savedPos2);
                        }
                        if (initPair == null) {
                            continue;
                        }
                        final Object d = inits.elementAt(init_index++);
                        final boolean isStatic = (d instanceof Declaration) ? ((Declaration)d).getFlag(2048L) : (d == Boolean.TRUE);
                        if (inits.elementAt(init_index++) != null) {
                            continue;
                        }
                        rewriteInit(d, oexp, initPair, tr, initSyntax);
                    }
                    else if (pair_car instanceof Pair) {
                        final ScopeExp save_scope = tr.currentScope();
                        if (memberSyntax != null) {
                            tr.setCurrentScope(memberSyntax.getScope());
                        }
                        if ("*init*".equals(meth.getName())) {
                            meth.setReturnType(Type.voidType);
                        }
                        Translator.setLine(meth, pair);
                        final LambdaExp saveLambda = tr.curMethodLambda;
                        tr.curMethodLambda = meth;
                        this.lambda.rewrite(meth, ((Pair)pair_car).getCdr(), pair.getCdr(), tr, (memberCarSyntax != null && (memberSyntax == null || memberCarSyntax.getScope() != memberSyntax.getScope())) ? memberCarSyntax.getScope() : null);
                        tr.curMethodLambda = saveLambda;
                        if (memberSyntax != null) {
                            tr.setCurrentScope(save_scope);
                        }
                        meth = meth.nextSibling;
                    }
                    else {
                        tr.syntaxError("invalid field/method definition");
                    }
                }
            }
            finally {
                tr.popPositionOf(savedPos1);
            }
        }
        for (Declaration decl3 = oexp.firstDecl(); decl3 != null; decl3 = decl3.nextDecl()) {
            final Expression texp = decl3.getTypeExpRaw();
            if (texp instanceof LangExp) {
                final Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
                tr.exp2Type(typeSpecPair, decl3, null);
            }
        }
        if (oexp.initMethod != null) {
            oexp.initMethod.setOuter(oexp);
        }
        if (oexp.clinitMethod != null) {
            oexp.clinitMethod.setOuter(oexp);
        }
        tr.pop(oexp);
    }
    
    private static void rewriteInit(final Object d, final ClassExp oexp, final Pair initPair, final Translator tr, final SyntaxForm initSyntax) {
        final boolean isStatic = (d instanceof Declaration) ? ((Declaration)d).getFlag(2048L) : (d == Boolean.TRUE);
        LambdaExp initMethod = isStatic ? oexp.clinitMethod : oexp.initMethod;
        if (initMethod == null) {
            initMethod = new LambdaExp(new BeginExp());
            initMethod.setClassMethod(true);
            initMethod.setReturnType(Type.voidType);
            if (isStatic) {
                initMethod.setName("$clinit$");
                oexp.clinitMethod = initMethod;
            }
            else {
                initMethod.setName("$finit$");
                (oexp.initMethod = initMethod).add(null, new Declaration(ThisExp.THIS_NAME));
            }
            oexp.pushChild(initMethod);
        }
        tr.push(initMethod);
        final LambdaExp saveLambda = tr.curMethodLambda;
        tr.curMethodLambda = initMethod;
        Expression initValue = tr.rewrite_car(initPair, initSyntax);
        if (d instanceof Declaration) {
            final Declaration decl = (Declaration)d;
            final SetExp sexp = new SetExp(decl, initValue);
            sexp.setLocation(decl);
            decl.noteValueFromSet(sexp);
            initValue = sexp;
        }
        else {
            initValue = Compilation.makeCoercion(initValue, new QuoteExp(Type.voidType));
        }
        ((BeginExp)initMethod.body).add(initValue);
        tr.curMethodLambda = saveLambda;
        tr.pop(initMethod);
    }
    
    static boolean matches(final Object exp, final String tag, final Translator tr) {
        String value;
        if (exp instanceof Keyword) {
            value = ((Keyword)exp).getName();
        }
        else if (exp instanceof FString) {
            value = ((FString)exp).toString();
        }
        else {
            final Object qvalue;
            if (!(exp instanceof Pair) || !((qvalue = tr.matchQuoted((Pair)exp)) instanceof SimpleSymbol)) {
                return false;
            }
            value = qvalue.toString();
        }
        return tag == null || tag.equals(value);
    }
    
    public static long addAccessFlags(final Object value, final long previous, final long allowed, final String kind, final Translator tr) {
        final long flags = matchAccess(value, tr);
        if (flags == 0L) {
            tr.error('e', "unknown access specifier " + value);
        }
        else if ((flags & ~allowed) != 0x0L) {
            tr.error('e', "invalid " + kind + " access specifier " + value);
        }
        else if ((previous & flags) != 0x0L) {
            tr.error('w', "duplicate " + kind + " access specifiers " + value);
        }
        return previous | flags;
    }
    
    static long matchAccess(Object value, final Translator tr) {
        while (value instanceof SyntaxForm) {
            value = ((SyntaxForm)value).getDatum();
        }
        if (value instanceof Pair) {
            final Pair p = (Pair)value;
            value = tr.matchQuoted((Pair)value);
            if (value instanceof Pair) {
                return matchAccess2((Pair)value, tr);
            }
        }
        return matchAccess1(value, tr);
    }
    
    private static long matchAccess2(final Pair pair, final Translator tr) {
        final long icar = matchAccess1(pair.getCar(), tr);
        final Object cdr = pair.getCdr();
        if (cdr == LList.Empty || icar == 0L) {
            return icar;
        }
        if (cdr instanceof Pair) {
            final long icdr = matchAccess2((Pair)cdr, tr);
            if (icdr != 0L) {
                return icar | icdr;
            }
        }
        return 0L;
    }
    
    private static long matchAccess1(Object value, final Translator tr) {
        if (value instanceof Keyword) {
            value = ((Keyword)value).getName();
        }
        else if (value instanceof FString) {
            value = ((FString)value).toString();
        }
        else if (value instanceof SimpleSymbol) {
            value = value.toString();
        }
        if ("private".equals(value)) {
            return 16777216L;
        }
        if ("protected".equals(value)) {
            return 33554432L;
        }
        if ("public".equals(value)) {
            return 67108864L;
        }
        if ("package".equals(value)) {
            return 134217728L;
        }
        if ("volatile".equals(value)) {
            return 2147483648L;
        }
        if ("transient".equals(value)) {
            return 4294967296L;
        }
        if ("enum".equals(value)) {
            return 8589934592L;
        }
        if ("final".equals(value)) {
            return 17179869184L;
        }
        if ("abstract".equals(value)) {
            return 34359738368L;
        }
        if ("synchronized".equals(value)) {
            return 68719476736L;
        }
        if ("strictfp".equals(value)) {
            return 137438953472L;
        }
        return 0L;
    }
    
    static {
        (objectSyntax = new object(SchemeCompilation.lambda)).setName("object");
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
