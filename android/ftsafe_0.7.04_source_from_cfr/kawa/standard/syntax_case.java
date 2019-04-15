/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BlockExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.ExitExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.math.IntNum;
import java.util.Vector;
import kawa.lang.Pattern;
import kawa.lang.PatternScope;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import kawa.lang.Translator;
import kawa.standard.syntax_case_work;

public class syntax_case
extends Syntax {
    public static final syntax_case syntax_case = new syntax_case();
    PrimProcedure call_error;
    private static final Method allocVars;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Expression rewriteClauses(Object clauses, syntax_case_work work, Translator tr) {
        Language language = tr.getLanguage();
        if (clauses == LList.Empty) {
            Expression[] args = new Expression[]{new QuoteExp("syntax-case"), new ReferenceExp(work.inputExpression)};
            if (this.call_error == null) {
                ClassType clas = ClassType.make("kawa.standard.syntax_case");
                Type[] argtypes = new Type[]{Compilation.javaStringType, Type.objectType};
                Method method = clas.addMethod("error", argtypes, Type.objectType, 9);
                this.call_error = new PrimProcedure(method, language);
            }
            return new ApplyExp(this.call_error, args);
        }
        Object savePos = tr.pushPositionOf(clauses);
        try {
            Expression fender;
            Object clause;
            Expression output;
            if (!(clauses instanceof Pair) || !((clause = ((Pair)clauses).getCar()) instanceof Pair)) {
                ErrorExp argtypes = tr.syntaxError("syntax-case:  bad clause list");
                return argtypes;
            }
            Pair pair = (Pair)clause;
            PatternScope clauseScope = PatternScope.push(tr);
            clauseScope.matchArray = tr.matchArray;
            tr.push(clauseScope);
            SyntaxForm syntax2 = null;
            Object tail = pair.getCdr();
            while (tail instanceof SyntaxForm) {
                syntax2 = (SyntaxForm)tail;
                tail = syntax2.getDatum();
            }
            if (!(tail instanceof Pair)) {
                ErrorExp errorExp = tr.syntaxError("missing syntax-case output expression");
                return errorExp;
            }
            int outerVarCount = clauseScope.pattern_names.size();
            SyntaxPattern pattern = new SyntaxPattern(pair.getCar(), work.literal_identifiers, tr);
            int varCount = pattern.varCount();
            if (varCount > work.maxVars) {
                work.maxVars = varCount;
            }
            BlockExp block = new BlockExp();
            Expression[] args = new Expression[]{new QuoteExp(pattern), new ReferenceExp(work.inputExpression), new ReferenceExp(tr.matchArray), new QuoteExp(IntNum.zero())};
            ApplyExp tryMatch = new ApplyExp(new PrimProcedure(Pattern.matchPatternMethod, language), args);
            pair = (Pair)tail;
            if (pair.getCdr() == LList.Empty) {
                output = tr.rewrite_car(pair, syntax2);
            } else {
                fender = tr.rewrite_car(pair, syntax2);
                if (!(pair.getCdr() instanceof Pair) || (pair = (Pair)pair.getCdr()).getCdr() != LList.Empty) {
                    ErrorExp errorExp = tr.syntaxError("syntax-case:  bad clause");
                    return errorExp;
                }
                output = new IfExp(fender, tr.rewrite_car(pair, syntax2), new ExitExp(block));
            }
            clauseScope.setBody(output);
            tr.pop(clauseScope);
            PatternScope.pop(tr);
            block.setBody(new IfExp(tryMatch, clauseScope, new ExitExp(block)), this.rewriteClauses(((Pair)clauses).getCdr(), work, tr));
            fender = block;
            return fender;
        }
        finally {
            tr.popPositionOf(savePos);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        syntax_case_work work = new syntax_case_work();
        Object obj = form.getCdr();
        if (obj instanceof Pair && ((Pair)obj).getCdr() instanceof Pair) {
            tr.letStart();
            form = (Pair)obj;
            work.inputExpression = tr.letVariable(null, null, tr.rewrite(form.getCar()));
            work.inputExpression.setCanRead(true);
            tr.letEnter();
            LetExp let2 = new LetExp();
            Declaration matchArrayOuter = tr.matchArray;
            Declaration matchArray = let2.addDeclaration((Object)null);
            matchArray.setType(Compilation.objArrayType);
            matchArray.setCanRead(true);
            tr.matchArray = matchArray;
            obj = form.getCdr();
            form = (Pair)obj;
            work.literal_identifiers = SyntaxPattern.getLiteralsList(form.getCar(), null, tr);
            obj = form.getCdr();
            try {
                tr.push(let2);
                let2.setBody(this.rewriteClauses(obj, work, tr));
                Expression[] args = new Expression[]{new QuoteExp(IntNum.make(work.maxVars)), matchArrayOuter == null ? QuoteExp.nullExp : new ReferenceExp(matchArrayOuter)};
                matchArray.setInitValue(new ApplyExp(allocVars, args));
                matchArray.noteValueUnknown();
                tr.pop(let2);
                LetExp letExp = tr.letDone(let2);
                return letExp;
            }
            finally {
                tr.matchArray = matchArrayOuter;
            }
        }
        return tr.syntaxError("insufficiant arguments to syntax-case");
    }

    public static Object error(String kind, Object arg) {
        Translator tr = (Translator)Compilation.getCurrent();
        if (tr == null) {
            throw new RuntimeException("no match in syntax-case");
        }
        Syntax syntax2 = tr.getCurrentSyntax();
        String name = syntax2 == null ? "some syntax" : syntax2.getName();
        String msg = "no matching case while expanding " + name;
        return tr.syntaxError(msg);
    }

    static {
        syntax_case.setName("syntax-case");
        allocVars = ClassType.make("kawa.lang.SyntaxPattern").getDeclaredMethod("allocVars", 2);
    }
}

