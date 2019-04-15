/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class prim_imports
extends ModuleBody {
    public static final StaticFieldLocation $St;
    public static final StaticFieldLocation $Pl;
    public static final StaticFieldLocation $Mn;
    public static final StaticFieldLocation $Sl;
    public static final StaticFieldLocation $Ls;
    public static final StaticFieldLocation $Ls$Eq;
    public static final StaticFieldLocation $Eq;
    public static final StaticFieldLocation $Gr;
    public static final StaticFieldLocation $Gr$Eq;
    public static final StaticFieldLocation append;
    public static final StaticFieldLocation apply;
    public static final StaticFieldLocation begin;
    public static final StaticFieldLocation bytevector;
    public static final StaticFieldLocation call$Mnwith$Mncurrent$Mncontinuation;
    public static final StaticFieldLocation call$Mnwith$Mnvalues;
    public static final StaticFieldLocation call$Slcc;
    public static final StaticFieldLocation cond$Mnexpand;
    public static final StaticFieldLocation eq$Qu;
    public static final StaticFieldLocation equal$Qu;
    public static final StaticFieldLocation eqv$Qu;
    public static final StaticFieldLocation even$Qu;
    public static final StaticFieldLocation expt;
    public static final StaticFieldLocation floor$Mnquotient;
    public static final StaticFieldLocation floor$Mnremainder;
    public static final StaticFieldLocation for$Mneach;
    public static final StaticFieldLocation include;
    public static final StaticFieldLocation include$Mnci;
    public static final StaticFieldLocation lambda;
    public static final StaticFieldLocation let$Mnsyntax;
    public static final StaticFieldLocation letrec$Mnsyntax;
    public static final StaticFieldLocation list;
    public static final StaticFieldLocation map;
    public static final StaticFieldLocation modulo;
    public static final StaticFieldLocation not;
    public static final StaticFieldLocation odd$Qu;
    public static final StaticFieldLocation quasiquote;
    public static final StaticFieldLocation quote;
    public static final StaticFieldLocation quotient;
    public static final StaticFieldLocation remainder;
    public static final StaticFieldLocation set$Ex;
    public static final StaticFieldLocation string;
    public static final StaticFieldLocation syntax$Mnerror;
    public static final StaticFieldLocation syntax$Mnrules;
    public static final StaticFieldLocation truncate$Mnquotient;
    public static final StaticFieldLocation truncate$Mnremainder;
    public static final StaticFieldLocation vector;
    public static final StaticFieldLocation vector$Mnappend;
    public static prim_imports $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new prim_imports();
        $Pl = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");
        $Mn = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");
        call$Mnwith$Mncurrent$Mncontinuation = StaticFieldLocation.make("gnu.kawa.functions.CallCC", "callcc");
        call$Slcc = StaticFieldLocation.make("gnu.kawa.functions.CallCC", "callcc");
        floor$Mnquotient = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "floorQuotient");
        floor$Mnremainder = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "modulo");
        truncate$Mnquotient = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "quotient");
        truncate$Mnremainder = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "remainder");
        $Sl = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "$Sl");
        modulo = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "modulo");
        quotient = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "quotient");
        remainder = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "remainder");
        $St = StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");
        list = StaticFieldLocation.make("gnu.kawa.lispexpr.LangObjType", "listType");
        string = StaticFieldLocation.make("gnu.kawa.lispexpr.LangObjType", "stringType");
        vector = StaticFieldLocation.make("gnu.kawa.lispexpr.LangObjType", "vectorType");
        bytevector = StaticFieldLocation.make("gnu.kawa.lispexpr.LangObjType", "u8vectorType");
        quote = StaticFieldLocation.make("kawa.lang.Quote", "plainQuote");
        quasiquote = StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
        append = StaticFieldLocation.make("kawa.standard.append", "append");
        begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        call$Mnwith$Mnvalues = StaticFieldLocation.make("gnu.kawa.functions.CallWithValues", "callWithValues");
        expt = StaticFieldLocation.make("kawa.standard.expt", "expt");
        cond$Mnexpand = StaticFieldLocation.make("kawa.standard.IfFeature", "condExpand");
        include = StaticFieldLocation.make("kawa.standard.Include", "include");
        include$Mnci = StaticFieldLocation.make("kawa.standard.Include", "includeCi");
        let$Mnsyntax = StaticFieldLocation.make("kawa.standard.let_syntax", "let_syntax");
        letrec$Mnsyntax = StaticFieldLocation.make("kawa.standard.let_syntax", "letrec_syntax");
        apply = StaticFieldLocation.make("kawa.standard.Scheme", "apply");
        map = StaticFieldLocation.make("kawa.standard.Scheme", "map");
        not = StaticFieldLocation.make("kawa.standard.Scheme", "not");
        for$Mneach = StaticFieldLocation.make("kawa.standard.Scheme", "forEach");
        odd$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isOdd");
        even$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEven");
        eq$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEq");
        eqv$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEqv");
        equal$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEqual");
        $Eq = StaticFieldLocation.make("kawa.standard.Scheme", "numEqu");
        $Gr = StaticFieldLocation.make("kawa.standard.Scheme", "numGrt");
        $Gr$Eq = StaticFieldLocation.make("kawa.standard.Scheme", "numGEq");
        $Ls = StaticFieldLocation.make("kawa.standard.Scheme", "numLss");
        $Ls$Eq = StaticFieldLocation.make("kawa.standard.Scheme", "numLEq");
        lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        set$Ex = StaticFieldLocation.make("kawa.standard.set_b", "set");
        syntax$Mnerror = StaticFieldLocation.make("kawa.standard.syntax_error", "syntax_error");
        syntax$Mnrules = StaticFieldLocation.make("kawa.standard.syntax_rules", "syntax_rules");
        vector$Mnappend = StaticFieldLocation.make("kawa.standard.vector_append", "vectorAppend");
        prim_imports.$runBody$();
    }

    public prim_imports() {
        ModuleInfo.register(this);
    }
}

