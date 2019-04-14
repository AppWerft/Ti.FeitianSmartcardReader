package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.OutPort;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.util.Vector;

public class SyntaxPattern extends Pattern implements Externalizable
{
  String program;
  String fileLine;
  public static final gnu.mapping.SimpleSymbol underscoreSymbol = Symbol.valueOf("_");
  


  static final int MATCH_MISC = 0;
  


  static final int MATCH_NIL = 8;
  


  static final int MATCH_VECTOR = 16;
  


  static final int MATCH_IGNORE = 24;
  


  static final int MATCH_WIDE = 1;
  


  static final int MATCH_EQUALS = 2;
  


  static final int MATCH_ANY = 3;
  


  static final int MATCH_PAIR = 4;
  

  static final int MATCH_LREPEAT = 5;
  

  static final int MATCH_LENGTH = 6;
  

  static final int MATCH_ANY_CAR = 7;
  

  Object[] literals;
  

  int varCount;
  

  public static boolean printSyntaxPatternMatch;
  


  public int varCount()
  {
    return varCount;
  }
  

  public boolean match(Object obj, Object[] vars, int start_vars)
  {
    boolean r = match(obj, vars, start_vars, 0, null);
    if ((printSyntaxPatternMatch) && (r)) {
      OutPort log = OutPort.errDefault();
      log.startLogicalBlock("{syntax-pattern ", false, "}");
      log.setIndentation(-14, false);
      if (fileLine != null) {
        log.print(fileLine);
      }
      log.writeSpaceLinear();
      log.print("match ");
      DisplayFormat.schemeWriteFormat.writeObject(obj, log);
      if (r) {
        log.print(" -> vars: ");
        for (int i = start_vars; i < vars.length; i++) {
          log.writeSpaceLinear();
          log.print(i);
          log.print(": ");
          DisplayFormat.schemeWriteFormat.writeObject(vars[i], log);
        }
      }
      else {
        log.println(" -> failed"); }
      log.endLogicalBlock("}");
      log.println();
    }
    return r;
  }
  

  public SyntaxPattern(String program, Object[] literals, int varCount, String fileLine)
  {
    this.program = program;
    this.literals = literals;
    this.varCount = varCount;
    this.fileLine = fileLine;
  }
  

  public SyntaxPattern(Object pattern, Object[] literal_identifiers, Translator tr)
  {
    this(new StringBuilder(), pattern, null, SyntaxRule.dots3Symbol, literal_identifiers, tr);
  }
  



  SyntaxPattern(StringBuilder programbuf, Object pattern, SyntaxForm syntax, Object ellipsis, Object[] literal_identifiers, Translator tr)
  {
    Vector literalsbuf = new Vector();
    translate(pattern, programbuf, ellipsis, literal_identifiers, 0, literalsbuf, null, '\000', tr);
    
    program = programbuf.toString();
    literals = new Object[literalsbuf.size()];
    literalsbuf.copyInto(literals);
    varCount = patternScope.pattern_names.size();
    String filename = tr.getFileName();
    int fileslash = filename.replace(File.separatorChar, '/').lastIndexOf('/');
    fileLine = (fileslash >= 0 ? filename.substring(fileslash + 1) : filename);
    int line = tr.getLineNumber();
    if (line > 0) {
      fileLine = (fileLine + ':' + line);
    }
  }
  























  public void disassemble()
  {
    disassemble(OutPort.errDefault(), (Translator)Compilation.getCurrent(), 0, program.length());
  }
  

  public void disassemble(PrintWriter ps, Translator tr)
  {
    disassemble(ps, tr, 0, program.length());
  }
  
  void disassemble(PrintWriter ps, Translator tr, int start, int limit)
  {
    Vector pattern_names = null;
    if ((tr != null) && (patternScope != null))
      pattern_names = patternScope.pattern_names;
    int value = 0;
    for (int i = start; i < limit;)
    {
      char ch = program.charAt(i);
      ps.print(" " + i + ": " + ch);
      i++;
      int opcode = ch & 0x7;
      value = value << 13 | ch >> '\003';
      switch (opcode)
      {
      case 1: 
        ps.println(" - WIDE " + value);
        break;
      case 2: 
        ps.print(" - EQUALS[" + value + "]");
        if ((literals != null) && (value >= 0) && (value < literals.length))
          ps.print(literals[value]);
        ps.println();
        break;
      case 3: 
      case 7: 
        ps.print((opcode == 3 ? " - ANY[" : " - ANY_CAR[") + value + "]");
        
        if ((pattern_names != null) && (value >= 0) && (value < pattern_names.size()))
        {
          ps.print(pattern_names.elementAt(value)); }
        ps.println();
        break;
      case 4: 
        ps.println(" - PAIR[" + value + "]");
        break;
      case 5: 
        ps.println(" - LREPEAT[" + value + "]");
        disassemble(ps, tr, i, i + value);
        i += value;
        ps.println(" " + i + ": - repeat first var:" + (program.charAt(i++) >> '\003'));
        ps.println(" " + i + ": - repeast nested vars:" + (program.charAt(i++) >> '\003'));
        break;
      case 6: 
        ps.println(" - LENGTH " + (value >> 1) + " pairs. " + ((value & 0x1) == 0 ? "pure list" : "impure list"));
        
        break;
      case 0: 
        ps.print("[misc ch:" + ch + " n:" + 8 + "]");
        if (ch == '\b')
        {
          ps.println(" - NIL");

        }
        else if (ch == '\020')
        {
          ps.println(" - VECTOR");

        }
        else if (ch == '\030')
        {
          ps.println(" - IGNORE"); }
        break;
      
      default: 
        ps.println(" - " + opcode + '/' + value);
        

        value = 0;
      }
      
    }
  }
  







  void translate(Object pattern, StringBuilder program, Object ellipsis, Object[] literal_identifiers, int nesting, Vector literals, SyntaxForm syntax, char context, Translator tr)
  {
    PatternScope patternScope = patternScope;
    Vector patternNames = pattern_names;
    for (;;)
    {
      if ((pattern instanceof SyntaxForm))
      {
        syntax = (SyntaxForm)pattern;
        pattern = syntax.getDatum();
      }
      else if ((pattern instanceof Pair))
      {
        Object savePos = tr.pushPositionOf(pattern);
        try
        {
          int start_pc = program.length();
          program.append('\004');
          Pair pair = (Pair)pattern;
          SyntaxForm car_syntax = syntax;
          Object next = pair.getCdr();
          while ((next instanceof SyntaxForm))
          {
            syntax = (SyntaxForm)next;
            next = syntax.getDatum();
          }
          boolean repeat = false;
          if ((next instanceof Pair)) {
            Pair nextPair = (Pair)next;
            Object nextCar = nextPair.getCar();
            if (literalIdentifierEq(nextCar, syntax == null ? null : syntax.getScope(), ellipsis, null)) {
              repeat = true;
              next = nextPair.getCdr();
              while ((next instanceof SyntaxForm))
              {
                syntax = (SyntaxForm)next;
                next = syntax.getDatum();
              }
            }
          }
          
          int subvar0 = patternNames.size();
          if (context == 'P')
            context = '\000';
          translate(pair.getCar(), program, ellipsis, literal_identifiers, repeat ? nesting + 1 : nesting, literals, car_syntax, context == 'V' ? '\000' : 'P', tr);
          



          int subvarN = patternNames.size() - subvar0;
          int width = program.length() - start_pc - 1 << 3 | (repeat ? 5 : 4);
          
          if (width > 65535) {
            start_pc += insertInt(start_pc, program, (width >> 13) + 1);
          }
          program.setCharAt(start_pc, (char)width);
          
          int restLength = Translator.listLength(next);
          if (restLength == Integer.MIN_VALUE)
          {
            tr.syntaxError("cyclic pattern list"); return;
          }
          

          if (repeat)
          {
            addInt(program, subvar0 << 3);
            addInt(program, subvarN << 3);
            if (next == LList.Empty)
            {
              program.append('\b'); return;
            }
            



            restLength = restLength >= 0 ? restLength << 1 : (-restLength << 1) - 1;
            
            addInt(program, restLength << 3 | 0x6);
          }
          

          pattern = next;
          



          tr.popPositionOf(savePos); continue; } finally { tr.popPositionOf(savePos);
        }
      } else {
        if (((pattern instanceof Symbol)) && (!(pattern instanceof gnu.expr.Keyword)))
        {
          ScopeExp current = tr.currentScope();
          ScopeExp scope1 = syntax == null ? current : syntax.getScope();
          int j = literal_identifiers.length; for (;;) { j--; if (j < 0) {
              break;
            }
            Object literal = literal_identifiers[j];
            ScopeExp scope2; ScopeExp scope2; if ((literal instanceof SyntaxForm))
            {
              SyntaxForm syntax2 = (SyntaxForm)literal;
              
              literal = syntax2.getDatum();
              scope2 = syntax2.getScope();
            } else { ScopeExp scope2;
              if (currentMacroDefinition != null) {
                scope2 = currentMacroDefinition.getCapturedScope();
              } else
                scope2 = current; }
            if (literalIdentifierEq(pattern, scope1, literal, scope2))
            {

              int i = SyntaxTemplate.indexOf(literals, pattern);
              if (i < 0)
              {
                i = literals.size();
                literals.addElement(pattern);
              }
              addInt(program, i << 3 | 0x2);
              return;
            }
          }
          if (literalIdentifierEq(pattern, scope1, underscoreSymbol, null)) {
            program.append('\030');
            return;
          }
          if (patternNames.contains(pattern))
            tr.syntaxError("duplicated pattern variable " + pattern);
          int i = patternNames.size();
          patternNames.addElement(pattern);
          boolean matchCar = context == 'P';
          int n = (nesting << 1) + (matchCar ? 1 : 0);
          patternNesting.append((char)n);
          Declaration decl = patternScope.addDeclaration(pattern);
          decl.setInitValue(QuoteExp.undefined_exp);
          decl.setLocation(tr);
          tr.push(decl);
          addInt(program, i << 3 | (matchCar ? 7 : 3));
          return;
        }
        if (pattern == LList.Empty)
        {
          program.append('\b');
          return;
        }
        if (!(pattern instanceof FVector))
          break;
        program.append('\020');
        pattern = LList.makeList((FVector)pattern);
        context = 'V';
      }
    }
    

    int i = SyntaxTemplate.indexOf(literals, pattern);
    if (i < 0)
    {
      i = literals.size();
      literals.addElement(pattern);
    }
    addInt(program, i << 3 | 0x2);
  }
  



  private static void addInt(StringBuilder sbuf, int val)
  {
    if (val > 65535)
      addInt(sbuf, (val << 13) + 1);
    sbuf.append((char)val);
  }
  
  private static int insertInt(int offset, StringBuilder sbuf, int val)
  {
    if (val > 65535)
      offset += insertInt(offset, sbuf, (val << 13) + 1);
    sbuf.insert(offset, (char)val);
    return offset + 1;
  }
  





  boolean match_car(Pair p, Object[] vars, int start_vars, int pc, SyntaxForm syntax)
  {
    int pc_start = pc;
    char ch;
    int value = (ch = program.charAt(pc++)) >> '\003';
    while ((ch & 0x7) == '\001')
      value = value << 13 | (ch = program.charAt(pc++)) >> '\003';
    if ((ch & 0x7) == '\007')
    {
      if ((syntax != null) && (!(p.getCar() instanceof SyntaxForm)))
        p = Translator.makePair(p, SyntaxForms.fromDatum(p.getCar(), syntax), p.getCdr());
      vars[(start_vars + value)] = p;
      return true;
    }
    return match(p.getCar(), vars, start_vars, pc_start, syntax);
  }
  

  public boolean match(Object obj, Object[] vars, int start_vars, int pc, SyntaxForm syntax)
  {
    int value = 0;
    boolean listRequired;
    int pairsRequired;
    do { Pair p;
      for (;;) { if ((obj instanceof SyntaxForm))
        {
          syntax = (SyntaxForm)obj;
          obj = syntax.getDatum();
        } else {
          ch = program.charAt(pc++);
          int opcode = ch & 0x7;
          value = value << 13 | ch >> '\003';
          switch (opcode)
          {
          case 1: 
            break;
          case 0: 
            if (ch == '\b')
              return obj == LList.Empty;
            if (ch == '\020')
            {
              if (!(obj instanceof FVector))
                return false;
              return match(LList.makeList((FVector)obj), vars, start_vars, pc, syntax);
            }
            
            if (ch == '\030') {
              return true;
            }
            throw new Error("unknown pattern opcode");
          case 8: 
            return obj == LList.Empty;
          case 6: 
            int npairs = value >> 1;
            Object o = obj;
            int i = 0;
            for (;;) {
              if ((o instanceof SyntaxForm)) {
                o = ((SyntaxForm)o).getDatum();
              } else { if (i == npairs)
                {
                  if ((value & 0x1) == 0 ? o == LList.Empty : !(o instanceof Pair)) break;
                  return false;
                }
                
                if ((o instanceof Pair)) {
                  o = ((Pair)o).getCdr();
                } else {
                  return false;
                }
                i++;
              }
            }
            











            value = 0;
            break;
          case 4: 
            if (!(obj instanceof Pair))
              return false;
            p = (Pair)obj;
            if (!match_car(p, vars, start_vars, pc, syntax))
              return false;
            pc += value;
            value = 0;
            obj = p.getCdr(); }
        }
      }
      int repeat_pc = pc;
      pc += value;
      int subvar0 = (ch = program.charAt(pc++)) >> '\003';
      while ((ch & 0x7) == '\001')
        subvar0 = subvar0 << 13 | (ch = program.charAt(pc++)) >> '\003';
      subvar0 += start_vars;
      int subvarN = program.charAt(pc++) >> '\003';
      while ((ch & 0x7) == '\001') {
        subvarN = subvarN << 13 | (ch = program.charAt(pc++)) >> '\003';
      }
      char ch = program.charAt(pc++);
      listRequired = true;
      int pairsRequired;
      if (ch == '\b')
      {
        pairsRequired = 0;
      }
      else
      {
        value = ch >> '\003';
        while ((ch & 0x7) == '\001')
          value = value << 13 | (ch = program.charAt(pc++)) >> '\003';
        if ((value & 0x1) != 0)
          listRequired = false;
        pairsRequired = value >> 1;
      }
      int pairsValue = Translator.listLength(obj);
      boolean listValue;
      boolean listValue;
      if (pairsValue >= 0) {
        listValue = true;
      }
      else {
        listValue = false;
        pairsValue = -1 - pairsValue;
      }
      if ((pairsValue < pairsRequired) || ((listRequired) && (!listValue)))
        return false;
      int repeat_count = pairsValue - pairsRequired;
      Object[][] arrays = new Object[subvarN][];
      
      for (int j = 0; j < subvarN; j++)
        arrays[j] = new Object[repeat_count];
      for (int i = 0; i < repeat_count; i++)
      {
        while ((obj instanceof SyntaxForm))
        {
          syntax = (SyntaxForm)obj;
          obj = syntax.getDatum();
        }
        p = (Pair)obj;
        if (!match_car(p, vars, start_vars, repeat_pc, syntax))
          return false;
        obj = p.getCdr();
        for (int j = 0; j < subvarN; j++)
          arrays[j][i] = vars[(subvar0 + j)];
      }
      for (int j = 0; j < subvarN; j++)
        vars[(subvar0 + j)] = arrays[j];
      value = 0;
    } while ((pairsRequired != 0) || (!listRequired));
    return true;
    

    Object lit = literals[value];
    Translator tr = (Translator)Compilation.getCurrent();
    Syntax curSyntax = tr.getCurrentSyntax();
    ScopeExp sc1 = (curSyntax instanceof Macro) ? ((Macro)curSyntax).getCapturedScope() : null;
    

    ScopeExp sc2 = syntax == null ? tr.currentScope() : syntax.getScope();
    
    return literalIdentifierEq(lit, sc1, obj, sc2);
    
    if (syntax != null)
      obj = SyntaxForms.fromDatum(obj, syntax);
    vars[(start_vars + value)] = obj;
    return true;
    

    disassemble();
    throw new Error("unrecognized pattern opcode @pc:" + pc);
  }
  

  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(program);
    out.writeObject(literals);
    out.writeInt(varCount);
    out.writeUTF(fileLine == null ? "" : fileLine);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    literals = ((Object[])in.readObject());
    program = ((String)in.readObject());
    varCount = in.readInt();
    String fline = in.readUTF();
    if (fline != null) {
      fileLine = fline;
    }
  }
  
  public static Object[] allocVars(int varCount, Object[] outer) {
    Object[] vars = new Object[varCount];
    if (outer != null) {
      int toCopy = outer.length;
      if (toCopy > varCount)
        toCopy = varCount;
      System.arraycopy(outer, 0, vars, 0, toCopy);
    }
    return vars;
  }
  
  public static boolean literalIdentifierEq(Object id1, ScopeExp sc1, Object id2, ScopeExp sc2)
  {
    if ((id1 instanceof SyntaxForm)) {
      SyntaxForm form1 = (SyntaxForm)id1;
      id1 = form1.getDatum();
      sc1 = form1.getScope();
    }
    if ((id2 instanceof SyntaxForm)) {
      SyntaxForm form2 = (SyntaxForm)id2;
      id2 = form2.getDatum();
      sc2 = form2.getScope();
    }
    if ((id1 != id2) && ((id1 == null) || (id2 == null) || (!id1.equals(id2))))
      return false;
    if (sc1 == sc2)
      return true;
    Declaration d1 = null;Declaration d2 = null;
    


    while ((sc1 != null) && (!(sc1 instanceof ModuleExp)))
    {
      d1 = sc1.lookup(id1);
      if (d1 != null)
        break;
      sc1 = sc1.getOuter();
    }
    while ((sc2 != null) && (!(sc2 instanceof ModuleExp)))
    {
      d2 = sc2.lookup(id2);
      if (d2 != null)
        break;
      sc2 = sc2.getOuter();
    }
    return d1 == d2;
  }
  


  public static Object[] getLiteralsList(Object list, SyntaxForm syntax, Translator tr)
  {
    Object savePos = tr.pushPositionOf(list);
    int count = Translator.listLength(list);
    if (count < 0)
    {
      tr.error('e', "missing or malformed literals list");
      count = 0;
    }
    Object[] literals = new Object[count];
    for (int i = 0; i < count; i++)
    {
      while ((list instanceof SyntaxForm))
      {
        syntax = (SyntaxForm)list;
        list = syntax.getDatum();
      }
      Pair pair = (Pair)list;
      tr.pushPositionOf(pair);
      Object literal = pair.getCar();
      Object wrapped = SyntaxForms.fromDatumIfNeeded(literal, syntax);
      literal = Translator.stripSyntax(literal);
      if (!(literal instanceof Symbol))
        tr.error('e', "non-symbol '" + literal + "' in literals list");
      literals[i] = wrapped;
      list = pair.getCdr();
    }
    tr.popPositionOf(savePos);
    return literals;
  }
  
  public String toString() {
    StringBuilder sbuf = new StringBuilder("#<syntax-pattern");
    if (fileLine != null) {
      sbuf.append(' ');
      sbuf.append(fileLine);
    }
    sbuf.append('>');
    return sbuf.toString();
  }
}
