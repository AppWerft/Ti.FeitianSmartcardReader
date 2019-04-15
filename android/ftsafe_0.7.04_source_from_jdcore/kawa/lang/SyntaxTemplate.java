package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.IdentityHashMap;
import java.util.Vector;













































public class SyntaxTemplate
  implements Externalizable
{
  String template_program;
  ScopeExp savedScope;
  static final int BUILD_MISC = 0;
  static final int BUILD_LIST1 = 8;
  static final int BUILD_NIL = 16;
  static final int BUILD_SYNTAX = 24;
  static final int BUILD_VECTOR = 40;
  static final int BUILD_CONS = 1;
  static final int BUILD_VAR = 2;
  static final int BUILD_VAR_CAR = 3;
  static final int BUILD_LITERAL = 4;
  static final int BUILD_DOTS = 5;
  static final int BUILD_WIDE = 7;
  String patternNesting;
  int max_nesting;
  Object[] literal_values;
  public static final SimpleSymbol dots3Symbol = LispLanguage.dots3_sym;
  





























  protected SyntaxTemplate() {}
  





























  public SyntaxTemplate(String patternNesting, String template_program, Object[] literal_values, int max_nesting)
  {
    this.patternNesting = patternNesting;
    this.template_program = template_program;
    this.literal_values = literal_values;
    this.max_nesting = max_nesting;
  }
  
  public SyntaxTemplate(Object template, SyntaxForm syntax, Object ellipsis, Translator tr)
  {
    patternNesting = ((tr == null) || (patternScope == null) ? "" : patternScope.patternNesting.toString());
    
    savedScope = tr.currentScope();
    if ((savedScope instanceof PatternScope))
      savedScope = savedScope.getOuter();
    StringBuilder program = new StringBuilder();
    Vector literals_vector = new Vector();
    IdentityHashMap seen = new IdentityHashMap();
    convert_template(template, syntax, program, 0, literals_vector, seen, false, ellipsis, tr);
    
    template_program = program.toString();
    literal_values = new Object[literals_vector.size()];
    literals_vector.copyInto(literal_values);
  }
  


































  private int convert_template(Object form, SyntaxForm syntax, StringBuilder template_program, int nesting, Vector literals_vector, IdentityHashMap seen, boolean isVector, Object ellipsis, Translator tr)
  {
    Object unseeNeeded = null;
    if (((form instanceof Pair)) || ((form instanceof FVector))) {
      if (seen.containsKey(form))
      {



        tr.syntaxError("self-referential (cyclic) syntax template - " + form);
        return -2;
      }
      seen.put(form, form);
      unseeNeeded = form;
    }
    int r = xconvert_template(form, syntax, template_program, nesting, literals_vector, seen, isVector, ellipsis, tr);
    

    if (unseeNeeded != null)
      seen.remove(unseeNeeded);
    return r;
  }
  






  private int xconvert_template(Object form, SyntaxForm syntax, StringBuilder template_program, int nesting, Vector literals_vector, IdentityHashMap seen, boolean isVector, Object ellipsis, Translator tr)
  {
    while ((form instanceof SyntaxForm)) {
      syntax = (SyntaxForm)form;
      form = syntax.getDatum();
    }
    
    if ((form instanceof Pair)) {
      Pair pair = (Pair)form;
      int save_pc = template_program.length();
      Object car = pair.getCar();
      

      if (SyntaxPattern.literalIdentifierEq(car, syntax == null ? null : syntax.getScope(), ellipsis, null))
      {
        Object cdr = pair.getCdr();
        if ((cdr instanceof Pair)) {
          Pair cdr_pair = (Pair)cdr;
          if (cdr_pair.getCdr() == LList.Empty) {
            convert_template(cdr_pair.getCar(), syntax, template_program, nesting, literals_vector, seen, false, null, tr);
            


            return -1;
          }
        }
      }
      
      int save_literals = literals_vector.size();
      

      template_program.append('\b');
      
      int num_dots3 = 0;
      Object rest = pair.getCdr();
      while ((rest instanceof Pair)) {
        Pair p = (Pair)rest;
        if (!SyntaxPattern.literalIdentifierEq(p.getCar(), null, ellipsis, null)) {
          break;
        }
        num_dots3++;
        rest = p.getCdr();
        template_program.append('\005');
      }
      int ret_car = convert_template(car, syntax, template_program, nesting + num_dots3, literals_vector, seen, false, ellipsis, tr);
      

      int ret_cdr = -2;
      if (rest != LList.Empty) {
        int delta = template_program.length() - save_pc - 1;
        template_program.setCharAt(save_pc, (char)((delta << 3) + 1));
        
        ret_cdr = convert_template(rest, syntax, template_program, nesting, literals_vector, seen, isVector, ellipsis, tr);
      }
      

      if (num_dots3 > 0) {
        if (ret_car < 0)
          tr.syntaxError("... follows template with no suitably-nested pattern variable");
        int i = num_dots3; for (;;) { i--; if (i < 0) break;
          char op = (char)((ret_car << 3) + 5);
          template_program.setCharAt(save_pc + i + 1, op);
          int n = nesting + num_dots3;
          if (n >= max_nesting)
            max_nesting = n;
        }
      }
      if (ret_car >= 0)
        return ret_car;
      if (ret_cdr >= 0)
        return ret_cdr;
      if ((ret_car == -1) || (ret_cdr == -1))
        return -1;
      if (isVector) {
        return -2;
      }
      

      literals_vector.setSize(save_literals);
      template_program.setLength(save_pc);
    } else { if ((form instanceof FVector)) {
        template_program.append('(');
        return convert_template(LList.makeList((FVector)form), syntax, template_program, nesting, literals_vector, seen, true, ellipsis, tr);
      }
      
      if (form == LList.Empty) {
        template_program.append('\020');
        return -2; }
      if (((form instanceof Symbol)) && (tr != null) && (patternScope != null))
      {
        int pattern_var_num = indexOf(patternScope.pattern_names, form);
        if (pattern_var_num >= 0) {
          int var_nesting = patternNesting.charAt(pattern_var_num);
          int op = (var_nesting & 0x1) != 0 ? 3 : 2;
          var_nesting >>= 1;
          


          if (var_nesting > nesting)
            tr.syntaxError("inconsistent ... nesting of " + form);
          template_program.append((char)(op + 8 * pattern_var_num));
          return var_nesting == nesting ? pattern_var_num : -1;
        }
      }
    }
    Object xform = tr.namespaceResolve(form);
    Macro macro = currentMacroDefinition;
    if (((xform instanceof Symbol)) && (macro != null) && ((capturedScope instanceof ModuleExp)))
    {
      tr.noteAccess(xform, tr.currentScope());
    }
    form = SyntaxForms.makeWithTemplate(syntax, form);
    if ((template_program.length() == 0) && ((form instanceof PairWithPosition)))
    {


      PairWithPosition pform = (PairWithPosition)form;
      form = new Pair(pform.getCar(), pform.getCdr());
    }
    int literals_index = indexOf(literals_vector, form);
    if (literals_index < 0) {
      literals_index = literals_vector.size();
      literals_vector.addElement(form);
    }
    if ((!(form instanceof SyntaxForm)) && (form != ellipsis) && (!(form instanceof CharSequence)) && (!(form instanceof Number)) && (!(form instanceof Boolean)))
    {


      template_program.append('\030'); }
    template_program.append((char)(4 + 8 * literals_index));
    return form == ellipsis ? -1 : -2;
  }
  
  static int indexOf(Vector vec, Object elem)
  {
    int len = vec.size();
    for (int i = 0; i < len; i++) {
      if (vec.elementAt(i) == elem)
        return i;
    }
    return -1;
  }
  
  private int get_count(Object var, int nesting, int[] indexes)
  {
    for (int level = 0; level < nesting; level++)
      var = ((Object[])(Object[])var)[indexes[level]];
    Object[] var_array = (Object[])var;
    return var_array.length;
  }
  




















  public Object execute(Object[] vars, TemplateScope templateScope)
  {
    Object result = execute(0, vars, 0, new int[max_nesting], (Translator)Compilation.getCurrent(), templateScope);
    














    return result;
  }
  
  public Object execute(Object[] vars, Translator tr) {
    return execute(0, vars, 0, new int[max_nesting], tr, TemplateScope.make(tr, savedScope));
  }
  
  Object get_var(int var_num, Object[] vars, int[] indexes, Translator tr) {
    Object var = vars[var_num];
    if (var_num < patternNesting.length()) {
      int var_nesting = patternNesting.charAt(var_num) >> '\001';
      for (int level = 0; level < var_nesting; level++) {
        Object[] varr = (Object[])var;
        int ind = indexes[level];
        if (ind >= varr.length) {
          Syntax macro = tr.getCurrentSyntax();
          String mname = macro == null ? null : macro.getName();
          if (mname == null)
            mname = "<unknown>";
          tr.syntaxError("inconsistent use of ellipsis variable in macro " + mname);
          return LList.list1(var);
        }
        var = varr[ind];
      }
    }
    return var;
  }
  



  LList executeToList(int pc, Object[] vars, int nesting, int[] indexes, Translator tr, TemplateScope templateScope)
  {
    int pc0 = pc;
    int ch = template_program.charAt(pc);
    while ((ch & 0x7) == 7)
      ch = ch - 7 << 13 | template_program.charAt(++pc);
    if ((ch & 0x7) == 3) {
      Pair p = (Pair)get_var(ch >> 3, vars, indexes, tr);
      return Translator.makePair(p, p.getCar(), LList.Empty); }
    if ((ch & 0x7) == 5) {
      int var_num = ch >> 3;
      Object var = vars[var_num];
      int count = get_count(var, nesting, indexes);
      LList result = LList.Empty;
      Pair last = null;
      pc++;
      for (int j = 0; j < count; j++) {
        indexes[nesting] = j;
        LList list = executeToList(pc, vars, nesting + 1, indexes, tr, templateScope);
        
        if (last == null) {
          result = list;
        } else {
          last.setCdrBackdoor(list);
        }
        
        while ((list instanceof Pair))
        {
          last = (Pair)list;
          list = (LList)last.getCdr();
        }
      }
      return result;
    }
    Object v = execute(pc0, vars, nesting, indexes, tr, templateScope);
    return new Pair(v, LList.Empty);
  }
  





  Object execute(int pc, Object[] vars, int nesting, int[] indexes, Translator tr, TemplateScope templateScope)
  {
    int ch = template_program.charAt(pc);
    






    while ((ch & 0x7) == 7)
      ch = ch - 7 << 13 | template_program.charAt(++pc);
    if (ch == 8)
      return executeToList(pc + 1, vars, nesting, indexes, tr, templateScope);
    if (ch == 16)
      return LList.Empty;
    if (ch == 24) {
      Object v = execute(pc + 1, vars, nesting, indexes, tr, templateScope);
      return SyntaxForms.makeForm(v, templateScope); }
    if ((ch & 0x7) == 1) {
      Pair p = null;
      Object result = null;
      for (;;) {
        pc++;
        Object q = executeToList(pc, vars, nesting, indexes, tr, templateScope);
        
        if (p == null) {
          result = q;
        } else
          p.setCdrBackdoor(q);
        while ((q instanceof Pair)) {
          p = (Pair)q;
          q = p.getCdr();
        }
        pc += (ch >> 3);
        ch = template_program.charAt(pc);
        if ((ch & 0x7) != 1)
          break;
      }
      Object cdr = execute(pc, vars, nesting, indexes, tr, templateScope);
      if (p == null) {
        result = cdr;
      } else
        p.setCdrBackdoor(cdr);
      return result; }
    if (ch == 40) {
      Object el = execute(pc + 1, vars, nesting, indexes, tr, templateScope);
      return new FVector((LList)el); }
    if ((ch & 0x7) == 4) {
      int lit_no = ch >> 3;
      



      return literal_values[lit_no]; }
    if ((ch & 0x6) == 2) {
      Object var = get_var(ch >> 3, vars, indexes, tr);
      if ((ch & 0x7) == 3)
        var = ((Pair)var).getCar();
      return var;
    }
    throw new Error("unknown template code: " + ch + " at " + pc);
  }
  

  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(patternNesting);
    out.writeObject(template_program);
    out.writeObject(literal_values);
    out.writeInt(max_nesting);
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    patternNesting = ((String)in.readObject());
    template_program = ((String)in.readObject());
    literal_values = ((Object[])in.readObject());
    max_nesting = in.readInt();
  }
}
