// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.LetExp;
import gnu.expr.Language;
import gnu.expr.IfExp;
import gnu.expr.ExitExp;
import kawa.lang.Pattern;
import gnu.math.IntNum;
import gnu.expr.BlockExp;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxForm;
import gnu.expr.ScopeExp;
import kawa.lang.PatternScope;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.expr.ReferenceExp;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.bytecode.Method;
import gnu.expr.PrimProcedure;
import kawa.lang.Syntax;

public class syntax_case extends Syntax
{
    public static final syntax_case syntax_case;
    PrimProcedure call_error;
    private static final Method allocVars;
    
    Expression rewriteClauses(final Object clauses, final syntax_case_work work, final Translator tr) {
        final Language language = tr.getLanguage();
        if (clauses == LList.Empty) {
            final Expression[] args = { new QuoteExp((Object)"syntax-case"), new ReferenceExp(work.inputExpression) };
            if (this.call_error == null) {
                final ClassType clas = ClassType.make("kawa.standard.syntax_case");
                final Type[] argtypes = { Compilation.javaStringType, Type.objectType };
                final Method method = clas.addMethod("error", argtypes, Type.objectType, 9);
                this.call_error = new PrimProcedure(method, language);
            }
            return new ApplyExp(this.call_error, args);
        }
        final Object savePos = tr.pushPositionOf(clauses);
        try {
            final Object clause;
            if (!(clauses instanceof Pair) || !((clause = ((Pair)clauses).getCar()) instanceof Pair)) {
                return tr.syntaxError("syntax-case:  bad clause list");
            }
            Pair pair = (Pair)clause;
            final PatternScope clauseScope = PatternScope.push(tr);
            clauseScope.matchArray = tr.matchArray;
            tr.push(clauseScope);
            SyntaxForm syntax;
            Object tail;
            for (syntax = null, tail = pair.getCdr(); tail instanceof SyntaxForm; tail = syntax.getDatum()) {
                syntax = (SyntaxForm)tail;
            }
            if (!(tail instanceof Pair)) {
                return tr.syntaxError("missing syntax-case output expression");
            }
            final int outerVarCount = clauseScope.pattern_names.size();
            final SyntaxPattern pattern = new SyntaxPattern(pair.getCar(), work.literal_identifiers, tr);
            final int varCount = pattern.varCount();
            if (varCount > work.maxVars) {
                work.maxVars = varCount;
            }
            final BlockExp block = new BlockExp();
            final Expression[] args2 = { new QuoteExp(pattern), new ReferenceExp(work.inputExpression), new ReferenceExp(tr.matchArray), new QuoteExp(IntNum.zero()) };
            final Expression tryMatch = new ApplyExp(new PrimProcedure(Pattern.matchPatternMethod, language), args2);
            pair = (Pair)tail;
            Expression output;
            if (pair.getCdr() == LList.Empty) {
                output = tr.rewrite_car(pair, syntax);
            }
            else {
                final Expression fender = tr.rewrite_car(pair, syntax);
                if (!(pair.getCdr() instanceof Pair) || (pair = (Pair)pair.getCdr()).getCdr() != LList.Empty) {
                    return tr.syntaxError("syntax-case:  bad clause");
                }
                output = new IfExp(fender, tr.rewrite_car(pair, syntax), new ExitExp(block));
            }
            clauseScope.setBody(output);
            tr.pop(clauseScope);
            PatternScope.pop(tr);
            block.setBody(new IfExp(tryMatch, clauseScope, new ExitExp(block)), this.rewriteClauses(((Pair)clauses).getCdr(), work, tr));
            return block;
        }
        finally {
            tr.popPositionOf(savePos);
        }
    }
    
    @Override
    public Expression rewriteForm(Pair form, final Translator tr) {
        final syntax_case_work work = new syntax_case_work();
        Object obj = form.getCdr();
        if (obj instanceof Pair && ((Pair)obj).getCdr() instanceof Pair) {
            tr.letStart();
            form = (Pair)obj;
            (work.inputExpression = tr.letVariable(null, null, tr.rewrite(form.getCar()))).setCanRead(true);
            tr.letEnter();
            final LetExp let2 = new LetExp();
            final Declaration matchArrayOuter = tr.matchArray;
            final Declaration matchArray = let2.addDeclaration((Object)null);
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
                final Expression[] args = { new QuoteExp(IntNum.make(work.maxVars)), (matchArrayOuter == null) ? QuoteExp.nullExp : new ReferenceExp(matchArrayOuter) };
                matchArray.setInitValue(new ApplyExp(kawa.standard.syntax_case.allocVars, args));
                matchArray.noteValueUnknown();
                tr.pop(let2);
                return tr.letDone(let2);
            }
            finally {
                tr.matchArray = matchArrayOuter;
            }
        }
        return tr.syntaxError("insufficiant arguments to syntax-case");
    }
    
    public static Object error(final String kind, final Object arg) {
        final Translator tr = (Translator)Compilation.getCurrent();
        if (tr == null) {
            throw new RuntimeException("no match in syntax-case");
        }
        final Syntax syntax = tr.getCurrentSyntax();
        final String name = (syntax == null) ? "some syntax" : syntax.getName();
        final String msg = "no matching case while expanding " + name;
        return tr.syntaxError(msg);
    }
    
    static {
        (syntax_case = new syntax_case()).setName("syntax-case");
        allocVars = ClassType.make("kawa.lang.SyntaxPattern").getDeclaredMethod("allocVars", 2);
    }
}
