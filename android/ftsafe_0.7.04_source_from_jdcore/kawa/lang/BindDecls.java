package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.Symbol;

public class BindDecls
{
  public static final BindDecls instance = new BindDecls();
  
  public boolean allowShadowing = false;
  
  public boolean makeConstant = true;
  
  static final Symbol underScoreSymbol = Symbol.valueOf("_");
  
  public BindDecls() {}
  
  public Declaration define(Symbol name, SyntaxForm nameSyntax, ScopeExp scope, Translator comp) { Declaration oldDecl = lexical.lookup(name, false);
    Declaration decl = comp.define(name, nameSyntax, scope);
    if ((!allowShadowing) && (oldDecl != null) && (context != scope))
    {
      comp.error('w', decl, "new declaration '", "' shadows old declaration");
      comp.error('w', oldDecl, "(this is the previous declaration of '", "')");
    }
    return decl;
  }
  







  public Object[] parsePatternCar(Pair patList, int scanNesting, ScopeExp scope, Translator comp)
  {
    Object next = patList.getCdr();
    Type type = null;
    if ((next instanceof Pair)) {
      Pair nextPair = (Pair)next;
      if (comp.matches(nextPair.getCar(), "::")) {
        Object nextCdr = nextPair.getCdr();
        if ((nextCdr instanceof Pair)) {
          Pair nextCdrPair = (Pair)nextCdr;
          type = comp.exp2Type(nextCdrPair);
          next = nextCdrPair.getCdr();
        }
        else {
          Object saveLoc = comp.pushPositionOf(nextPair);
          comp.error('e', "missing type after '::'");
          comp.popPositionOf(saveLoc);
          next = nextCdr;
        }
      }
    }
    Object pattern = patList.getCar();
    Object saveLoc = comp.pushPositionOf(patList);
    
    Object patval = pattern;
    SyntaxForm nameSyntax = null;
    if ((patval instanceof SyntaxForm)) {
      nameSyntax = (SyntaxForm)patval;
      patval = nameSyntax.getDatum();
    }
    patval = comp.namespaceResolve(patval);
    Declaration decl = null;
    if ((patval instanceof Symbol)) {
      if (patval == underScoreSymbol) {
        decl = scope.addDeclaration((Object)null);
      } else {
        decl = define((Symbol)patval, nameSyntax, scope, comp);
        Translator.setLine(decl, patList);
      }
      if (((scope instanceof gnu.expr.ModuleExp)) && ((patval == underScoreSymbol) || (!scope.getFlag(4194304))))
      {

        decl.setPrivate(true); }
      if (makeConstant)
        decl.setFlag(16384L);
      decl.setFlag(262144L);
    }
    else if ((pattern instanceof Pair)) {
      Pair patpair = (Pair)pattern;
      Object patcar = patpair.getCar();
      if (patcar == gnu.kawa.lispexpr.LispLanguage.bracket_list_sym) {
        decl = scope.addDeclaration((Object)null);
        if (type != null) {}
        
        decl.setPrivate(true);
        decl.setFlag(16384L);
        decl.setFlag(262144L);
        parseBracketListPattern(patpair, scanNesting, scope, decl, comp);

      }
      else
      {

        comp.syntaxError("unrecognized pattern operator " + patcar);
      }
    } else {
      comp.error('e', "unrecognized pattern " + pattern); }
    if (decl != null)
      decl.setScanNesting(scanNesting);
    if ((type != null) && (decl != null)) {
      decl.setType(type);
      decl.setFlag(8192L);
    }
    comp.popPositionOf(saveLoc);
    return new Object[] { next, decl };
  }
  


  public void parseBracketListPattern(Pair patpair, int scanNesting, ScopeExp scope, Declaration decl, Translator comp)
  {
    ClassType listType = ClassType.make("java.util.List");
    decl.setFlag(2199023255552L);
    if (decl.getTypeExpRaw() != null) {
      Declaration d = scope.addDeclaration((Object)null);
      d.setFlag(3298534883328L);
      d.setScanNesting(scanNesting);
      setInitializer(d, new ReferenceExp(decl), scope, comp);
      decl = d;
    }
    int count = 0;
    Object cdr = patpair.getCdr();
    int ellipsisCount = 0;
    for (; 
        cdr != gnu.lists.LList.Empty; count++)
    {

      if (!(cdr instanceof Pair))
        break;
      patpair = (Pair)cdr;
      boolean sawEllipsis = false;
      int curScanNesting = scanNesting;
      if ((patpair.getCdr() instanceof Pair)) {
        Object nextCar = ((Pair)patpair.getCdr()).getCar();
        Object ellipsis = SyntaxRule.dots3Symbol;
        if (SyntaxPattern.literalIdentifierEq(nextCar, null, ellipsis, null)) {
          sawEllipsis = true;
          curScanNesting++;
          if (ellipsisCount > 0)
            comp.error('e', "multiple '...' in pattern");
          ellipsisCount++;
        }
      }
      Object[] r = parsePatternCar(patpair, curScanNesting, scope, comp);
      
      cdr = sawEllipsis ? ((Pair)patpair.getCdr()).getCdr() : r[0];
      Declaration d = (Declaration)r[1];
      d.setScanNesting(curScanNesting);
      d.setFlag(3298534883328L);
      Expression init;
      Expression init; if (sawEllipsis) {
        int restCount = Translator.listLength(cdr);
        gnu.bytecode.Method dropMethod = ClassType.make("gnu.lists.Sequences").getDeclaredMethod("drop", restCount == 0 ? 2 : 3);
        
        Expression[] args = new Expression[restCount == 0 ? 2 : 3];
        args[0] = new ReferenceExp(decl);
        args[1] = new QuoteExp(Integer.valueOf(count), Type.intType);
        if (restCount != 0)
          args[2] = new QuoteExp(Integer.valueOf(restCount), Type.intType);
        init = new gnu.expr.ApplyExp(dropMethod, args);
      }
      else {
        gnu.bytecode.Method indexMethod = listType.getMethod("get", new Type[] { Type.intType });
        
        init = new gnu.expr.ApplyExp(indexMethod, new Expression[] { new ReferenceExp(decl), new QuoteExp(Integer.valueOf(count), Type.intType) });
      }
      

      setInitializer(d, init, scope, comp);
    }
    Type type = new gnu.kawa.lispexpr.SeqSizeType(count - ellipsisCount, ellipsisCount == 0, "java.util.List");
    
    decl.setType(type);
  }
  
  private void setInitializer(Declaration decl, Expression init, ScopeExp scope, Translator comp) {
    if (((scope instanceof gnu.expr.ModuleExp)) || (((scope instanceof gnu.expr.LetExp)) && (scope.getFlag(2))))
    {

      gnu.expr.SetExp sexp = new gnu.expr.SetExp(decl, init);
      comp.pushForm(sexp);
      decl.noteValueFromSet(sexp);
    }
    else {
      decl.setInitValue(init);
      decl.noteValueFromLet(scope);
    }
  }
}
