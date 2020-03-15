// 
// Decompiled by Procyon v0.5.36
// 

package gnu.ecmascript;

import gnu.mapping.Values;
import gnu.lists.Sequence;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.kawa.io.TtyInPort;
import kawa.standard.Scheme;
import gnu.expr.LambdaExp;
import gnu.expr.ErrorExp;
import gnu.kawa.io.OutPort;
import java.util.Vector;
import gnu.expr.BeginExp;
import gnu.expr.ApplyExp;
import gnu.expr.QuoteExp;
import gnu.expr.SetExp;
import gnu.expr.ReferenceExp;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.expr.IfExp;
import gnu.expr.Expression;
import gnu.kawa.io.InPort;

public class Parser
{
    InPort port;
    Lexer lexer;
    Object previous_token;
    Object token;
    public static Expression eofExpr;
    public static final Expression[] emptyArgs;
    public int errors;
    static Expression emptyStatement;
    
    public Parser(final InPort port) {
        this.port = port;
        this.lexer = new Lexer(port);
    }
    
    public Expression parseConditionalExpression() throws IOException, SyntaxException {
        final Expression exp1 = this.parseBinaryExpression(1);
        final Object result = this.peekToken();
        if (result != Lexer.condToken) {
            return exp1;
        }
        this.skipToken();
        final Expression exp2 = this.parseAssignmentExpression();
        if (this.getToken() != Lexer.colonToken) {
            return this.syntaxError("expected ':' in conditional expression");
        }
        final Expression exp3 = this.parseAssignmentExpression();
        return new IfExp(exp1, exp2, exp3);
    }
    
    public Expression parseAssignmentExpression() throws IOException, SyntaxException {
        final Expression exp1 = this.parseConditionalExpression();
        final Object token = this.peekToken();
        if (token == Lexer.equalToken) {
            this.skipToken();
            final Expression exp2 = this.parseAssignmentExpression();
            if (exp1 instanceof ReferenceExp) {
                final SetExp sex = new SetExp(((ReferenceExp)exp1).getName(), exp2);
                sex.setDefining(true);
                return sex;
            }
            return this.syntaxError("unmplemented non-symbol ihs in assignment");
        }
        else {
            if (!(token instanceof Reserved)) {
                return exp1;
            }
            final Reserved op = (Reserved)token;
            if (!op.isAssignmentOp()) {
                return exp1;
            }
            this.skipToken();
            final Expression exp3 = this.parseAssignmentExpression();
            final Expression[] args = { exp1, exp3 };
            return new ApplyExp(new QuoteExp(op.proc), args);
        }
    }
    
    public Expression parseExpression() throws IOException, SyntaxException {
        Expression[] exps = null;
        int nExps = 0;
        while (true) {
            final Expression exp1 = this.parseAssignmentExpression();
            final boolean last = this.peekToken() != Lexer.commaToken;
            Label_0103: {
                if (exps == null) {
                    if (last) {
                        return exp1;
                    }
                    exps = new Expression[2];
                }
                else {
                    if (last) {
                        if (exps.length == nExps + 1) {
                            break Label_0103;
                        }
                    }
                    else if (exps.length > nExps) {
                        break Label_0103;
                    }
                    final int newsize = last ? (nExps + 1) : (2 * exps.length);
                    final Expression[] new_exps = new Expression[newsize];
                    System.arraycopy(exps, 0, new_exps, 0, nExps);
                    exps = new_exps;
                }
            }
            exps[nExps++] = exp1;
            if (last) {
                return new BeginExp(exps);
            }
            this.skipToken();
        }
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
        final Object result = this.peekToken();
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
        }
        else if (this.token != Lexer.rbraceToken && this.token != Lexer.eofToken) {
            if (this.previous_token != Lexer.eolToken) {
                this.syntaxError("missing ';' after expression");
            }
        }
    }
    
    public Expression parsePrimaryExpression() throws IOException, SyntaxException {
        final Object result = this.getToken();
        if (result instanceof QuoteExp) {
            return (QuoteExp)result;
        }
        if (result instanceof String) {
            return new ReferenceExp(result);
        }
        if (result != Lexer.lparenToken) {
            return this.syntaxError("unexpected token: " + result);
        }
        final Expression expr = this.parseExpression();
        final Object token = this.getToken();
        if (token != Lexer.rparenToken) {
            return this.syntaxError("expected ')' - got:" + token);
        }
        return expr;
    }
    
    public Expression makePropertyAccessor(final Expression exp, final Expression prop) {
        return null;
    }
    
    public Expression[] parseArguments() throws IOException, SyntaxException {
        this.skipToken();
        Object token = this.peekToken();
        if (token == Lexer.rparenToken) {
            this.skipToken();
            return Parser.emptyArgs;
        }
        final Vector args = new Vector(10);
        while (true) {
            final Expression arg = this.parseAssignmentExpression();
            args.addElement(arg);
            token = this.getToken();
            if (token == Lexer.rparenToken) {
                break;
            }
            if (token == Lexer.commaToken) {
                continue;
            }
            this.syntaxError("invalid token '" + token + "' in argument list");
        }
        final Expression[] exps = new Expression[args.size()];
        args.copyInto(exps);
        return exps;
    }
    
    public Expression makeNewExpression(Expression exp, Expression[] args) {
        if (args == null) {
            args = Parser.emptyArgs;
        }
        exp = null;
        return new ApplyExp(exp, args);
    }
    
    public Expression makeCallExpression(final Expression exp, final Expression[] args) {
        return new ApplyExp(exp, args);
    }
    
    public String getIdentifier() throws IOException, SyntaxException {
        final Object token = this.getToken();
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
        while (true) {
            Object token = this.peekToken();
            if (token == Lexer.dotToken) {
                this.skipToken();
                final String name = this.getIdentifier();
                exp = this.makePropertyAccessor(exp, new QuoteExp((Object)name));
            }
            else if (token == Lexer.lbracketToken) {
                this.skipToken();
                final Expression prop = this.parseExpression();
                token = this.getToken();
                if (token != Lexer.rbracketToken) {
                    return this.syntaxError("expected ']' - got:" + token);
                }
                exp = this.makePropertyAccessor(exp, prop);
            }
            else {
                if (token != Lexer.lparenToken) {
                    break;
                }
                final Expression[] args = this.parseArguments();
                System.err.println("after parseArgs:" + this.peekToken());
                if (newCount > 0) {
                    exp = this.makeNewExpression(exp, args);
                    --newCount;
                }
                else {
                    exp = this.makeCallExpression(exp, args);
                }
            }
        }
        while (newCount > 0) {
            exp = this.makeNewExpression(exp, null);
            --newCount;
        }
        return exp;
    }
    
    public Expression parsePostfixExpression() throws IOException, SyntaxException {
        final Expression exp = this.parseLeftHandSideExpression();
        final Object op = this.peekTokenOrLine();
        if (op != Reserved.opPlusPlus && op != Reserved.opMinusMinus) {
            return exp;
        }
        this.skipToken();
        final Expression[] args = { exp };
        return new ApplyExp(new QuoteExp(((Reserved)op).proc), args);
    }
    
    public Expression parseUnaryExpression() throws IOException, SyntaxException {
        return this.parsePostfixExpression();
    }
    
    public Expression syntaxError(final String message) {
        ++this.errors;
        final OutPort err = OutPort.errDefault();
        final String current_filename = this.port.getName();
        final int current_line = this.port.getLineNumber() + 1;
        final int current_column = this.port.getColumnNumber() + 1;
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
    
    public Expression parseBinaryExpression(final int prio) throws IOException, SyntaxException {
        Expression exp1 = this.parseUnaryExpression();
        while (true) {
            this.token = this.peekToken();
            if (!(this.token instanceof Reserved)) {
                return exp1;
            }
            final Reserved op = (Reserved)this.token;
            if (op.prio < prio) {
                return exp1;
            }
            this.getToken();
            final Expression exp2 = this.parseBinaryExpression(op.prio + 1);
            final Expression[] args = { exp1, exp2 };
            exp1 = new ApplyExp(new QuoteExp(op.proc), args);
        }
    }
    
    public Expression parseIfStatement() throws IOException, SyntaxException {
        this.skipToken();
        Object token = this.getToken();
        if (token != Lexer.lparenToken) {
            return this.syntaxError("expected '(' - got:" + token);
        }
        final Expression test_part = this.parseExpression();
        token = this.getToken();
        if (token != Lexer.rparenToken) {
            return this.syntaxError("expected ')' - got:" + token);
        }
        final Expression then_part = this.parseStatement();
        token = this.peekToken();
        Expression else_part;
        if (token == Lexer.elseToken) {
            this.skipToken();
            else_part = this.parseStatement();
        }
        else {
            else_part = null;
        }
        return new IfExp(test_part, then_part, else_part);
    }
    
    public Expression buildLoop(final Expression init, final Expression test, final Expression incr, final Expression body) {
        if (init != null) {
            final Expression[] pair = { init, this.buildLoop(null, test, incr, body) };
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
        final Expression test_part = this.parseExpression();
        token = this.getToken();
        if (token != Lexer.rparenToken) {
            return this.syntaxError("expected ')' - got:" + token);
        }
        final Expression body = this.parseStatement();
        return this.buildLoop(null, test_part, null, body);
    }
    
    public Expression parseFunctionDefinition() throws IOException, SyntaxException {
        this.skipToken();
        final String name = this.getIdentifier();
        Object token = this.getToken();
        if (token != Lexer.lparenToken) {
            return this.syntaxError("expected '(' - got:" + token);
        }
        final Vector args = new Vector(10);
        if (this.peekToken() == Lexer.rparenToken) {
            this.skipToken();
        }
        else {
            while (true) {
                final String arg = this.getIdentifier();
                args.addElement(arg);
                token = this.getToken();
                if (token == Lexer.rparenToken) {
                    break;
                }
                if (token == Lexer.commaToken) {
                    continue;
                }
                this.syntaxError("invalid token '" + token + "' in argument list");
            }
        }
        final Expression body = this.parseBlock();
        final LambdaExp lexp = new LambdaExp(body);
        lexp.setName(name);
        final SetExp sexp = new SetExp(name, lexp);
        sexp.setDefining(true);
        return sexp;
    }
    
    public Expression parseBlock() throws IOException, SyntaxException {
        Expression[] exps = null;
        if (this.getToken() != Lexer.lbraceToken) {
            return this.syntaxError("extened '{'");
        }
        int nExps = 0;
        while (true) {
            this.token = this.peekToken();
            boolean last;
            if (this.token == Lexer.rbraceToken) {
                this.skipToken();
                if (exps == null) {
                    return Parser.emptyStatement;
                }
                last = true;
            }
            else {
                last = false;
            }
            Label_0122: {
                if (exps == null) {
                    exps = new Expression[2];
                }
                else {
                    if (last) {
                        if (exps.length == nExps) {
                            break Label_0122;
                        }
                    }
                    else if (exps.length > nExps) {
                        break Label_0122;
                    }
                    final int newsize = last ? nExps : (2 * exps.length);
                    final Expression[] new_exps = new Expression[newsize];
                    System.arraycopy(exps, 0, new_exps, 0, nExps);
                    exps = new_exps;
                }
            }
            if (last) {
                return new BeginExp(exps);
            }
            exps[nExps++] = this.parseStatement();
        }
    }
    
    public Expression parseStatement() throws IOException, SyntaxException {
        final Object token = this.peekToken();
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
            return Parser.eofExpr;
        }
        if (token == Lexer.semicolonToken) {
            this.skipToken();
            return Parser.emptyStatement;
        }
        if (token == Lexer.lbraceToken) {
            return this.parseBlock();
        }
        final Expression exp = this.parseExpression();
        this.getSemicolon();
        return exp;
    }
    
    public static void main(final String[] args) {
        final Language language = new Scheme();
        final InPort inp = InPort.inDefault();
        if (inp instanceof TtyInPort) {
            final Object prompter = new Prompter();
            ((TtyInPort)inp).setPrompter((Procedure)prompter);
        }
        final Parser parser = new Parser(inp);
        final OutPort out = OutPort.outDefault();
        try {
            while (true) {
                final Expression expr = parser.parseStatement();
                if (expr == Parser.eofExpr) {
                    break;
                }
                out.print("[Expression: ");
                expr.print(out);
                out.println("]");
                final Object result = expr.eval(Environment.user());
                out.print("result: ");
                out.print(result);
                out.println();
            }
        }
        catch (Throwable ex) {
            System.err.println("caught exception:" + ex);
            ex.printStackTrace(System.err);
        }
    }
    
    static {
        Parser.eofExpr = new QuoteExp(Sequence.eofValue);
        emptyArgs = new Expression[0];
        Parser.emptyStatement = new QuoteExp(Values.empty);
    }
}
