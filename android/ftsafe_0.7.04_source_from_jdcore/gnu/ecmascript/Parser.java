package gnu.ecmascript;

import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.SetExp;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.Vector;

public class Parser
{
  InPort port;
  Lexer lexer;
  Object previous_token;
  Object token;
  public static Expression eofExpr = new QuoteExp(gnu.lists.Sequence.eofValue);
  
  public Parser(InPort port)
  {
    this.port = port;
    lexer = new Lexer(port);
  }
  
  public Expression parseConditionalExpression()
    throws IOException, SyntaxException
  {
    Expression exp1 = parseBinaryExpression(1);
    Object result = peekToken();
    if (result != Lexer.condToken)
      return exp1;
    skipToken();
    Expression exp2 = parseAssignmentExpression();
    if (getToken() != Lexer.colonToken)
      return syntaxError("expected ':' in conditional expression");
    Expression exp3 = parseAssignmentExpression();
    return new gnu.expr.IfExp(exp1, exp2, exp3);
  }
  
  public Expression parseAssignmentExpression()
    throws IOException, SyntaxException
  {
    Expression exp1 = parseConditionalExpression();
    Object token = peekToken();
    if (token == Lexer.equalToken)
    {
      skipToken();
      Expression exp2 = parseAssignmentExpression();
      if ((exp1 instanceof gnu.expr.ReferenceExp))
      {
        SetExp sex = new SetExp(((gnu.expr.ReferenceExp)exp1).getName(), exp2);
        sex.setDefining(true);
        return sex;
      }
      return syntaxError("unmplemented non-symbol ihs in assignment");
    }
    

    if (!(token instanceof Reserved))
      return exp1;
    Reserved op = (Reserved)token;
    if (!op.isAssignmentOp())
      return exp1;
    skipToken();
    Expression exp2 = parseAssignmentExpression();
    Expression[] args = { exp1, exp2 };
    return new ApplyExp(new QuoteExp(proc), args);
  }
  

  public Expression parseExpression()
    throws IOException, SyntaxException
  {
    Expression[] exps = null;
    int nExps = 0;
    for (;;)
    {
      Expression exp1 = parseAssignmentExpression();
      boolean last = peekToken() != Lexer.commaToken;
      if (exps == null)
      {
        if (last)
          return exp1;
        exps = new Expression[2];
      }
      else if (last ? exps.length != nExps + 1 : exps.length <= nExps)
      {
        int newsize = last ? nExps + 1 : 2 * exps.length;
        Expression[] new_exps = new Expression[newsize];
        System.arraycopy(exps, 0, new_exps, 0, nExps);
        exps = new_exps;
      }
      exps[(nExps++)] = exp1;
      if (last)
        return new gnu.expr.BeginExp(exps);
      skipToken();
    }
  }
  



  public Object peekTokenOrLine()
    throws IOException, SyntaxException
  {
    if (token == null)
      token = lexer.getToken();
    return token;
  }
  



  public Object peekToken()
    throws IOException, SyntaxException
  {
    if (token == null)
      token = lexer.getToken();
    while (token == Lexer.eolToken)
    {
      skipToken();
      token = lexer.getToken();
    }
    return token;
  }
  
  public Object getToken()
    throws IOException, SyntaxException
  {
    Object result = peekToken();
    skipToken();
    return result;
  }
  
  public final void skipToken()
  {
    if (token != Lexer.eofToken)
    {
      previous_token = token;
      token = null;
    }
  }
  

  public void getSemicolon()
    throws IOException, SyntaxException
  {
    token = peekToken();
    if (token == Lexer.semicolonToken) {
      skipToken();
    } else if ((token != Lexer.rbraceToken) && (token != Lexer.eofToken) && (previous_token != Lexer.eolToken))
    {



      syntaxError("missing ';' after expression");
    }
  }
  
  public Expression parsePrimaryExpression()
    throws IOException, SyntaxException
  {
    Object result = getToken();
    if ((result instanceof QuoteExp))
      return (QuoteExp)result;
    if ((result instanceof String))
      return new gnu.expr.ReferenceExp((String)result);
    if (result == Lexer.lparenToken)
    {
      Expression expr = parseExpression();
      Object token = getToken();
      if (token != Lexer.rparenToken)
        return syntaxError("expected ')' - got:" + token);
      return expr;
    }
    return syntaxError("unexpected token: " + result);
  }
  
  public Expression makePropertyAccessor(Expression exp, Expression prop)
  {
    return null;
  }
  
  public static final Expression[] emptyArgs = new Expression[0];
  public int errors;
  
  public Expression[] parseArguments() throws IOException, SyntaxException
  {
    skipToken();
    Object token = peekToken();
    if (token == Lexer.rparenToken)
    {
      skipToken();
      return emptyArgs;
    }
    Vector args = new Vector(10);
    for (;;)
    {
      Expression arg = parseAssignmentExpression();
      args.addElement(arg);
      token = getToken();
      if (token == Lexer.rparenToken)
        break;
      if (token != Lexer.commaToken)
        syntaxError("invalid token '" + token + "' in argument list");
    }
    Expression[] exps = new Expression[args.size()];
    args.copyInto(exps);
    return exps;
  }
  
  public Expression makeNewExpression(Expression exp, Expression[] args)
  {
    if (args == null)
      args = emptyArgs;
    exp = null;
    return new ApplyExp(exp, args);
  }
  
  public Expression makeCallExpression(Expression exp, Expression[] args)
  {
    return new ApplyExp(exp, args);
  }
  
  public String getIdentifier()
    throws IOException, SyntaxException
  {
    Object token = getToken();
    if ((token instanceof String))
      return (String)token;
    syntaxError("missing identifier");
    return "??";
  }
  
  public Expression parseLeftHandSideExpression()
    throws IOException, SyntaxException
  {
    int newCount = 0;
    while (peekToken() == Lexer.newToken)
    {
      newCount++;
      skipToken();
    }
    Expression exp = parsePrimaryExpression();
    for (;;)
    {
      Object token = peekToken();
      if (token == Lexer.dotToken)
      {
        skipToken();
        String name = getIdentifier();
        exp = makePropertyAccessor(exp, new QuoteExp(name));
      }
      else if (token == Lexer.lbracketToken)
      {
        skipToken();
        Expression prop = parseExpression();
        token = getToken();
        if (token != Lexer.rbracketToken)
          return syntaxError("expected ']' - got:" + token);
        exp = makePropertyAccessor(exp, prop);
      } else {
        if (token != Lexer.lparenToken)
          break;
        Expression[] args = parseArguments();
        System.err.println("after parseArgs:" + peekToken());
        if (newCount > 0)
        {
          exp = makeNewExpression(exp, args);
          newCount--;
        }
        else {
          exp = makeCallExpression(exp, args);
        }
      }
    }
    for (; 
        newCount > 0; newCount--)
    {
      exp = makeNewExpression(exp, null);
    }
    return exp;
  }
  
  public Expression parsePostfixExpression()
    throws IOException, SyntaxException
  {
    Expression exp = parseLeftHandSideExpression();
    Object op = peekTokenOrLine();
    if ((op != Reserved.opPlusPlus) && (op != Reserved.opMinusMinus))
      return exp;
    skipToken();
    Expression[] args = { exp };
    return new ApplyExp(new QuoteExp(proc), args);
  }
  



  public Expression parseUnaryExpression()
    throws IOException, SyntaxException
  {
    return parsePostfixExpression();
  }
  



  public Expression syntaxError(String message)
  {
    errors += 1;
    OutPort err = OutPort.errDefault();
    String current_filename = port.getName();
    int current_line = port.getLineNumber() + 1;
    int current_column = port.getColumnNumber() + 1;
    if (current_line > 0)
    {
      if (current_filename != null)
        err.print(current_filename);
      err.print(':');
      err.print(current_line);
      if (current_column > 1)
      {
        err.print(':');
        err.print(current_column);
      }
      err.print(": ");
    }
    err.println(message);
    return new gnu.expr.ErrorExp(message);
  }
  
  public Expression parseBinaryExpression(int prio)
    throws IOException, SyntaxException
  {
    Expression exp1 = parseUnaryExpression();
    for (;;)
    {
      token = peekToken();
      if (!(token instanceof Reserved))
        return exp1;
      Reserved op = (Reserved)token;
      if (prio < prio)
        return exp1;
      getToken();
      Expression exp2 = parseBinaryExpression(prio + 1);
      Expression[] args = { exp1, exp2 };
      exp1 = new ApplyExp(new QuoteExp(proc), args);
    }
  }
  
  static Expression emptyStatement = new QuoteExp(gnu.mapping.Values.empty);
  
  public Expression parseIfStatement()
    throws IOException, SyntaxException
  {
    skipToken();
    Object token = getToken();
    if (token != Lexer.lparenToken)
      return syntaxError("expected '(' - got:" + token);
    Expression test_part = parseExpression();
    token = getToken();
    if (token != Lexer.rparenToken)
      return syntaxError("expected ')' - got:" + token);
    Expression then_part = parseStatement();
    token = peekToken();
    Expression else_part;
    Expression else_part; if (token == Lexer.elseToken)
    {
      skipToken();
      else_part = parseStatement();
    }
    else {
      else_part = null; }
    return new gnu.expr.IfExp(test_part, then_part, else_part);
  }
  

  public Expression buildLoop(Expression init, Expression test, Expression incr, Expression body)
  {
    if (init != null)
    {
      Expression[] pair = new Expression[2];
      pair[0] = init;
      pair[1] = buildLoop(null, test, incr, body);
      return new gnu.expr.BeginExp(pair);
    }
    throw new Error("not implemented - buildLoop");
  }
  
  public Expression parseWhileStatement()
    throws IOException, SyntaxException
  {
    skipToken();
    Object token = getToken();
    if (token != Lexer.lparenToken)
      return syntaxError("expected '(' - got:" + token);
    Expression test_part = parseExpression();
    token = getToken();
    if (token != Lexer.rparenToken)
      return syntaxError("expected ')' - got:" + token);
    Expression body = parseStatement();
    return buildLoop(null, test_part, null, body);
  }
  
  public Expression parseFunctionDefinition()
    throws IOException, SyntaxException
  {
    skipToken();
    String name = getIdentifier();
    Object token = getToken();
    if (token != Lexer.lparenToken)
      return syntaxError("expected '(' - got:" + token);
    Vector args = new Vector(10);
    if (peekToken() == Lexer.rparenToken)
    {
      skipToken();
    }
    else
    {
      for (;;)
      {
        String arg = getIdentifier();
        args.addElement(arg);
        token = getToken();
        if (token == Lexer.rparenToken)
          break;
        if (token != Lexer.commaToken)
          syntaxError("invalid token '" + token + "' in argument list");
      }
    }
    Expression body = parseBlock();
    gnu.expr.LambdaExp lexp = new gnu.expr.LambdaExp(body);
    lexp.setName(name);
    SetExp sexp = new SetExp(name, lexp);
    sexp.setDefining(true);
    return sexp;
  }
  
  public Expression parseBlock()
    throws IOException, SyntaxException
  {
    Expression[] exps = null;
    if (getToken() != Lexer.lbraceToken)
      return syntaxError("extened '{'");
    int nExps = 0;
    for (;;)
    {
      token = peekToken();
      boolean last;
      boolean last; if (token == Lexer.rbraceToken)
      {
        skipToken();
        if (exps == null)
          return emptyStatement;
        last = true;
      }
      else {
        last = false; }
      if (exps == null) {
        exps = new Expression[2];
      } else if (last ? exps.length != nExps : exps.length <= nExps)
      {
        int newsize = last ? nExps : 2 * exps.length;
        Expression[] new_exps = new Expression[newsize];
        System.arraycopy(exps, 0, new_exps, 0, nExps);
        exps = new_exps;
      }
      if (last)
        return new gnu.expr.BeginExp(exps);
      exps[(nExps++)] = parseStatement();
    }
  }
  
  public Expression parseStatement()
    throws IOException, SyntaxException
  {
    Object token = peekToken();
    if ((token instanceof Reserved))
    {
      switch (prio) {
      case 31: 
        return parseIfStatement();
      case 32:  return parseWhileStatement();
      case 41:  return parseFunctionDefinition();
      }
    }
    if (token == Lexer.eofToken)
      return eofExpr;
    if (token == Lexer.semicolonToken)
    {
      skipToken();
      return emptyStatement;
    }
    if (token == Lexer.lbraceToken) {
      return parseBlock();
    }
    Expression exp = parseExpression();
    getSemicolon();
    return exp;
  }
  
  public static void main(String[] args)
  {
    gnu.expr.Language language = new kawa.standard.Scheme();
    
    InPort inp = InPort.inDefault();
    if ((inp instanceof gnu.kawa.io.TtyInPort))
    {
      Object prompter = new Prompter();
      ((gnu.kawa.io.TtyInPort)inp).setPrompter((gnu.mapping.Procedure)prompter);
    }
    
    Parser parser = new Parser(inp);
    OutPort out = OutPort.outDefault();
    










    try
    {
      for (;;)
      {
        Expression expr = parser.parseStatement();
        if (expr == eofExpr)
          break;
        out.print("[Expression: ");
        expr.print(out);
        out.println("]");
        Object result = expr.eval(gnu.mapping.Environment.user());
        out.print("result: ");
        out.print(result);
        out.println();
      }
      return;
    } catch (Throwable ex) {
      System.err.println("caught exception:" + ex);
      ex.printStackTrace(System.err); return;
    }
  }
}
