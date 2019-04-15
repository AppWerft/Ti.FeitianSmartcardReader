/*
 * Decompiled with CFR 0.139.
 */
package gnu.ecmascript;

import gnu.ecmascript.Lexer;
import gnu.ecmascript.Prompter;
import gnu.ecmascript.Reserved;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.TtyInPort;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.text.Char;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;
import kawa.standard.Scheme;

public class Parser {
    InPort port;
    Lexer lexer;
    Object previous_token;
    Object token;
    public static Expression eofExpr = new QuoteExp(Sequence.eofValue);
    public static final Expression[] emptyArgs = new Expression[0];
    public int errors;
    static Expression emptyStatement = new QuoteExp(Values.empty);

    public Parser(InPort port) {
        this.port = port;
        this.lexer = new Lexer(port);
    }

    public Expression parseConditionalExpression() throws IOException, SyntaxException {
        Expression exp1 = this.parseBinaryExpression(1);
        Object result = this.peekToken();
        if (result != Lexer.condToken) {
            return exp1;
        }
        this.skipToken();
        Expression exp2 = this.parseAssignmentExpression();
        if (this.getToken() != Lexer.colonToken) {
            return this.syntaxError("expected ':' in conditional expression");
        }
        Expression exp3 = this.parseAssignmentExpression();
        return new IfExp(exp1, exp2, exp3);
    }

    public Expression parseAssignmentExpression() throws IOException, SyntaxException {
        Expression exp1 = this.parseConditionalExpression();
        Object token = this.peekToken();
        if (token == Lexer.equalToken) {
            this.skipToken();
            Expression exp2 = this.parseAssignmentExpression();
            if (exp1 instanceof ReferenceExp) {
                SetExp sex = new SetExp(((ReferenceExp)exp1).getName(), exp2);
                sex.setDefining(true);
                return sex;
            }
            return this.syntaxError("unmplemented non-symbol ihs in assignment");
        }
        if (!(token instanceof Reserved)) {
            return exp1;
        }
        Reserved op = (Reserved)token;
        if (!op.isAssignmentOp()) {
            return exp1;
        }
        this.skipToken();
        Expression exp2 = this.parseAssignmentExpression();
        Expression[] args = new Expression[]{exp1, exp2};
        return new ApplyExp(new QuoteExp(op.proc), args);
    }

    public Expression parseExpression() throws IOException, SyntaxException {
        Expression[] exps = null;
        int nExps = 0;
        do {
            boolean last;
            Expression exp1 = this.parseAssignmentExpression();
            boolean bl = last = this.peekToken() != Lexer.commaToken;
            if (exps == null) {
                if (last) {
                    return exp1;
                }
                exps = new Expression[2];
            } else if (last ? exps.length != nExps + 1 : exps.length <= nExps) {
                int newsize = last ? nExps + 1 : 2 * exps.length;
                Expression[] new_exps = new Expression[newsize];
                System.arraycopy(exps, 0, new_exps, 0, nExps);
                exps = new_exps;
            }
            exps[nExps++] = exp1;
            if (last) {
                return new BeginExp(exps);
            }
            this.skipToken();
        } while (true);
    }

    public Object peekTokenOrLine() throws IOException, SyntaxException {
        if (this.token == null) {
            this.token = this.lexer.getToken();
        }
        return this.token;
    }

    public Object peekToken() throws IOException, SyntaxException {
        if (this.token == null) {
            this.token = this.lexer.getToken();
        }
        while (this.token == Lexer.eolToken) {
            this.skipToken();
            this.token = this.lexer.getToken();
        }
        return this.token;
    }

    public Object getToken() throws IOException, SyntaxException {
        Object result = this.peekToken();
        this.skipToken();
        return result;
    }

    public final void skipToken() {
        if (this.token != Lexer.eofToken) {
            this.previous_token = this.token;
            this.token = null;
        }
    }

    public void getSemicolon() throws IOException, SyntaxException {
        this.token = this.peekToken();
        if (this.token == Lexer.semicolonToken) {
            this.skipToken();
        } else if (this.token != Lexer.rbraceToken && this.token != Lexer.eofToken && this.previous_token != Lexer.eolToken) {
            this.syntaxError("missing ';' after expression");
        }
    }

    public Expression parsePrimaryExpression() throws IOException, SyntaxException {
        Object result = this.getToken();
        if (result instanceof QuoteExp) {
            return (QuoteExp)result;
        }
        if (result instanceof String) {
            return new ReferenceExp((String)result);
        }
        if (result == Lexer.lparenToken) {
            Expression expr = this.parseExpression();
            Object token = this.getToken();
            if (token != Lexer.rparenToken) {
                return this.syntaxError("expected ')' - got:" + token);
            }
            return expr;
        }
        return this.syntaxError("unexpected token: " + result);
    }

    public Expression makePropertyAccessor(Expression exp, Expression prop) {
        return null;
    }

    public Expression[] parseArguments() throws IOException, SyntaxException {
        this.skipToken();
        Object token = this.peekToken();
        if (token == Lexer.rparenToken) {
            this.skipToken();
            return emptyArgs;
        }
        Vector<Expression> args = new Vector<Expression>(10);
        do {
            Expression arg = this.parseAssignmentExpression();
            args.addElement(arg);
            token = this.getToken();
            if (token == Lexer.rparenToken) break;
            if (token == Lexer.commaToken) continue;
            this.syntaxError("invalid token '" + token + "' in argument list");
        } while (true);
        Object[] exps = new Expression[args.size()];
        args.copyInto(exps);
        return exps;
    }

    public Expression makeNewExpression(Expression exp, Expression[] args) {
        if (args == null) {
            args = emptyArgs;
        }
        exp = null;
        return new ApplyExp(exp, args);
    }

    public Expression makeCallExpression(Expression exp, Expression[] args) {
        return new ApplyExp(exp, args);
    }

    public String getIdentifier() throws IOException, SyntaxException {
        Object token = this.getToken();
        if (token instanceof String) {
            return (String)token;
        }
        this.syntaxError("missing identifier");
        return "??";
    }

    public Expression parseLeftHandSideExpression() throws IOException, SyntaxException {
        int newCount = 0;
        while (this.peekToken() == Lexer.newToken) {
            ++newCount;
            this.skipToken();
        }
        Expression exp = this.parsePrimaryExpression();
        do {
            Object token;
            if ((token = this.peekToken()) == Lexer.dotToken) {
                this.skipToken();
                String name = this.getIdentifier();
                exp = this.makePropertyAccessor(exp, new QuoteExp(name));
                continue;
            }
            if (token == Lexer.lbracketToken) {
                this.skipToken();
                Expression prop = this.parseExpression();
                token = this.getToken();
                if (token != Lexer.rbracketToken) {
                    return this.syntaxError("expected ']' - got:" + token);
                }
                exp = this.makePropertyAccessor(exp, prop);
                continue;
            }
            if (token != Lexer.lparenToken) break;
            Expression[] args = this.parseArguments();
            System.err.println("after parseArgs:" + this.peekToken());
            if (newCount > 0) {
                exp = this.makeNewExpression(exp, args);
                --newCount;
                continue;
            }
            exp = this.makeCallExpression(exp, args);
        } while (true);
        while (newCount > 0) {
            exp = this.makeNewExpression(exp, null);
            --newCount;
        }
        return exp;
    }

    public Expression parsePostfixExpression() throws IOException, SyntaxException {
        Expression exp = this.parseLeftHandSideExpression();
        Object op = this.peekTokenOrLine();
        if (op != Reserved.opPlusPlus && op != Reserved.opMinusMinus) {
            return exp;
        }
        this.skipToken();
        Expression[] args = new Expression[]{exp};
        return new ApplyExp(new QuoteExp(((Reserved)op).proc), args);
    }

    public Expression parseUnaryExpression() throws IOException, SyntaxException {
        return this.parsePostfixExpression();
    }

    public Expression syntaxError(String message) {
        ++this.errors;
        OutPort err = OutPort.errDefault();
        String current_filename = this.port.getName();
        int current_line = this.port.getLineNumber() + 1;
        int current_column = this.port.getColumnNumber() + 1;
        if (current_line > 0) {
            if (current_filename != null) {
                err.print(current_filename);
            }
            err.print(':');
            err.print(current_line);
            if (current_column > 1) {
                err.print(':');
                err.print(current_column);
            }
            err.print(": ");
        }
        err.println(message);
        return new ErrorExp(message);
    }

    public Expression parseBinaryExpression(int prio) throws IOException, SyntaxException {
        Expression exp1 = this.parseUnaryExpression();
        do {
            this.token = this.peekToken();
            if (!(this.token instanceof Reserved)) {
                return exp1;
            }
            Reserved op = (Reserved)this.token;
            if (op.prio < prio) {
                return exp1;
            }
            this.getToken();
            Expression exp2 = this.parseBinaryExpression(op.prio + 1);
            Expression[] args = new Expression[]{exp1, exp2};
            exp1 = new ApplyExp(new QuoteExp(op.proc), args);
        } while (true);
    }

    public Expression parseIfStatement() throws IOException, SyntaxException {
        Expression else_part;
        this.skipToken();
        Object token = this.getToken();
        if (token != Lexer.lparenToken) {
            return this.syntaxError("expected '(' - got:" + token);
        }
        Expression test_part = this.parseExpression();
        token = this.getToken();
        if (token != Lexer.rparenToken) {
            return this.syntaxError("expected ')' - got:" + token);
        }
        Expression then_part = this.parseStatement();
        token = this.peekToken();
        if (token == Lexer.elseToken) {
            this.skipToken();
            else_part = this.parseStatement();
        } else {
            else_part = null;
        }
        return new IfExp(test_part, then_part, else_part);
    }

    public Expression buildLoop(Expression init, Expression test, Expression incr, Expression body) {
        if (init != null) {
            Expression[] pair = new Expression[]{init, this.buildLoop(null, test, incr, body)};
            return new BeginExp(pair);
        }
        throw new Error("not implemented - buildLoop");
    }

    public Expression parseWhileStatement() throws IOException, SyntaxException {
        this.skipToken();
        Object token = this.getToken();
        if (token != Lexer.lparenToken) {
            return this.syntaxError("expected '(' - got:" + token);
        }
        Expression test_part = this.parseExpression();
        token = this.getToken();
        if (token != Lexer.rparenToken) {
            return this.syntaxError("expected ')' - got:" + token);
        }
        Expression body = this.parseStatement();
        return this.buildLoop(null, test_part, null, body);
    }

    public Expression parseFunctionDefinition() throws IOException, SyntaxException {
        this.skipToken();
        String name = this.getIdentifier();
        Object token = this.getToken();
        if (token != Lexer.lparenToken) {
            return this.syntaxError("expected '(' - got:" + token);
        }
        Vector<String> args = new Vector<String>(10);
        if (this.peekToken() == Lexer.rparenToken) {
            this.skipToken();
        } else {
            do {
                String arg = this.getIdentifier();
                args.addElement(arg);
                token = this.getToken();
                if (token == Lexer.rparenToken) break;
                if (token == Lexer.commaToken) continue;
                this.syntaxError("invalid token '" + token + "' in argument list");
            } while (true);
        }
        Expression body = this.parseBlock();
        LambdaExp lexp = new LambdaExp(body);
        lexp.setName(name);
        SetExp sexp = new SetExp(name, (Expression)lexp);
        sexp.setDefining(true);
        return sexp;
    }

    public Expression parseBlock() throws IOException, SyntaxException {
        Expression[] exps = null;
        if (this.getToken() != Lexer.lbraceToken) {
            return this.syntaxError("extened '{'");
        }
        int nExps = 0;
        do {
            boolean last;
            this.token = this.peekToken();
            if (this.token == Lexer.rbraceToken) {
                this.skipToken();
                if (exps == null) {
                    return emptyStatement;
                }
                last = true;
            } else {
                last = false;
            }
            if (exps == null) {
                exps = new Expression[2];
            } else if (last ? exps.length != nExps : exps.length <= nExps) {
                int newsize = last ? nExps : 2 * exps.length;
                Expression[] new_exps = new Expression[newsize];
                System.arraycopy(exps, 0, new_exps, 0, nExps);
                exps = new_exps;
            }
            if (last) {
                return new BeginExp(exps);
            }
            exps[nExps++] = this.parseStatement();
        } while (true);
    }

    public Expression parseStatement() throws IOException, SyntaxException {
        Object token = this.peekToken();
        if (token instanceof Reserved) {
            switch (((Reserved)token).prio) {
                case 31: {
                    return this.parseIfStatement();
                }
                case 32: {
                    return this.parseWhileStatement();
                }
                case 41: {
                    return this.parseFunctionDefinition();
                }
            }
        }
        if (token == Lexer.eofToken) {
            return eofExpr;
        }
        if (token == Lexer.semicolonToken) {
            this.skipToken();
            return emptyStatement;
        }
        if (token == Lexer.lbraceToken) {
            return this.parseBlock();
        }
        Expression exp = this.parseExpression();
        this.getSemicolon();
        return exp;
    }

    public static void main(String[] args) {
        Scheme language = new Scheme();
        InPort inp = InPort.inDefault();
        if (inp instanceof TtyInPort) {
            Prompter prompter = new Prompter();
            ((TtyInPort)inp).setPrompter(prompter);
        }
        Parser parser = new Parser(inp);
        OutPort out = OutPort.outDefault();
        try {
            Expression expr;
            while ((expr = parser.parseStatement()) != eofExpr) {
                out.print("[Expression: ");
                expr.print(out);
                out.println("]");
                Object result = expr.eval(Environment.user());
                out.print("result: ");
                out.print(result);
                out.println();
            }
        }
        catch (Throwable ex) {
            System.err.println("caught exception:" + ex);
            ex.printStackTrace(System.err);
            return;
        }
    }
}

