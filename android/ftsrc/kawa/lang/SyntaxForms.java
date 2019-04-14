package kawa.lang;

import gnu.expr.Compilation;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SyntaxForms
{
  public static final boolean DEBUGGING = true;
  
  public SyntaxForms() {}
  
  public static Object makeForm(Object datum, TemplateScope scope)
  {
    if (((datum instanceof SyntaxForm)) || (datum == gnu.lists.LList.Empty) || ((datum instanceof Number)) || ((datum instanceof gnu.expr.Keyword)) || (scope == null))
    {



      return datum; }
    if ((datum instanceof PairWithPosition)) {
      return new PairWithPositionSyntaxForm((PairWithPosition)datum, scope);
    }
    if ((datum instanceof Pair))
      return new PairSyntaxForm((Pair)datum, scope);
    return new SimpleSyntaxForm(datum, scope);
  }
  









  public static Object makeWithTemplate(Object template, Object datum, Object srcloc)
  {
    if (((srcloc instanceof gnu.text.SourceLocator)) && ((datum instanceof Pair)))
    {
      Pair pdatum = (Pair)datum;
      gnu.text.SourceLocator sloc = (gnu.text.SourceLocator)srcloc;
      if ((template instanceof SyntaxForm)) {
        return new PairWithPositionSyntaxForm(pdatum, sloc, ((SyntaxForm)template).getScope());
      }
      
      return new PairWithPosition(sloc, pdatum.getCar(), pdatum.getCdr());
    }
    if ((datum instanceof SyntaxForm))
      return (SyntaxForm)datum;
    if ((template instanceof SyntaxForm)) {
      SyntaxForm sdatum = (SyntaxForm)template;
      if (datum == sdatum.getDatum())
        return sdatum;
      return fromDatum(datum, sdatum);
    }
    return datum;
  }
  
  public static Object makeWithTemplate(Object template, Object form) {
    return makeWithTemplate(template, form, null);
  }
  




  public static boolean identifierEquals(Object id1, Object id2, boolean checkBound)
  {
    Compilation comp = (Translator)Compilation.getCurrent();
    TemplateScope sc1;
    Object s1;
    TemplateScope sc1; if ((id1 instanceof SyntaxForm)) {
      SyntaxForm sf = (SyntaxForm)id1;
      Object s1 = sf.getDatum();
      sc1 = sf.getScope();
    }
    else {
      s1 = id1;
      sc1 = null; }
    TemplateScope sc2;
    Object s2; TemplateScope sc2; if ((id2 instanceof SyntaxForm)) {
      SyntaxForm sf = (SyntaxForm)id2;
      Object s2 = sf.getDatum();
      sc2 = sf.getScope();
    }
    else {
      s2 = id2;
      sc2 = null;
    }
    if (s1 != s2)
      return false;
    if (sc1 == sc2)
      return true;
    if (checkBound)
    {









      Object mark1 = sc1 != null ? macroMark : null;
      Object mark2 = sc2 != null ? macroMark : null;
      return mark1 == mark2;
    }
    gnu.expr.ScopeExp savedScope = comp.currentScope();
    if (sc1 != null)
      comp.setCurrentScope(sc1);
    gnu.expr.Declaration d1 = lexical.lookup(s1, -1);
    comp.setCurrentScope(sc2 != null ? sc2 : savedScope);
    gnu.expr.Declaration d2 = lexical.lookup(s2, -1);
    if (sc2 != null)
      comp.setCurrentScope(savedScope);
    return d1 == d2;
  }
  
  public static boolean isIdentifier(SyntaxForm form)
  {
    return form.getDatum() instanceof gnu.mapping.Symbol;
  }
  




  public static Object fromDatum(Object datum, SyntaxForm template)
  {
    return makeForm(datum, template.getScope());
  }
  
  public static Object fromDatumIfNeeded(Object datum, SyntaxForm template) {
    if (((datum instanceof SyntaxForm)) || (template == null))
      return datum;
    if (datum == template.getDatum()) {
      return template;
    }
    return fromDatum(datum, template);
  }
  
  public static gnu.expr.Expression rewrite(Object x)
  {
    Translator tr = (Translator)Compilation.getCurrent();
    return tr.rewrite(x);
  }
  
  public static gnu.expr.Expression rewriteBody(Object x)
  {
    Translator tr = (Translator)Compilation.getCurrent();
    return tr.rewrite_body(x);
  }
  


  public static String toString(SyntaxForm sform, String id)
  {
    StringBuilder sbuf = new StringBuilder("#<syntax");
    if (id != null)
    {
      sbuf.append('#');
      sbuf.append(id);
    }
    sbuf.append(' ');
    sbuf.append(sform.getDatum());
    

    TemplateScope scope = sform.getScope();
    if (scope == null)
    {
      sbuf.append(" in null");
    }
    else
    {
      sbuf.append(" in #");
      sbuf.append(id);
    }
    
    sbuf.append(">");
    return sbuf.toString();
  }
  
  public static class SimpleSyntaxForm
    implements SyntaxForm, java.io.Externalizable
  {
    private Object datum;
    private TemplateScope scope;
    static int counter;
    int id = ++counter;
    
    public SimpleSyntaxForm(Object datum, TemplateScope scope) {
      this.datum = datum;
      this.scope = scope;
    }
    
    public Object getDatum() {
      return datum;
    }
    
    public TemplateScope getScope() {
      return scope;
    }
    
    public String toString() {
      String sid = Integer.toString(id);
      return SyntaxForms.toString(this, sid);
    }
    
    public void writeExternal(ObjectOutput out) throws IOException {
      out.writeObject(datum);
      out.writeObject(scope);
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      datum = in.readObject();
      scope = ((TemplateScope)in.readObject());
    }
  }
  
  public static class PairSyntaxForm extends gnu.lists.ImmutablePair implements SyntaxForm, java.io.Externalizable
  {
    private Pair datum;
    private TemplateScope scope;
    
    public PairSyntaxForm(Pair datum, TemplateScope scope)
    {
      this.datum = datum;
      this.scope = scope;
    }
    
    public Object getDatum() {
      return datum;
    }
    
    public TemplateScope getScope() {
      return scope;
    }
    
    public Object getCar() {
      if (car == null)
        car = SyntaxForms.makeForm(datum.getCar(), scope);
      return car;
    }
    
    public Object getCdr() {
      if (cdr == null)
        cdr = SyntaxForms.makeForm(datum.getCdr(), scope);
      return cdr;
    }
    
    public String toString()
    {
      return SyntaxForms.toString(this, null);
    }
    
    public void writeExternal(ObjectOutput out) throws IOException {
      out.writeObject(datum);
      out.writeObject(scope);
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      datum = ((Pair)in.readObject());
      scope = ((TemplateScope)in.readObject());
    }
  }
  

  public static class PairWithPositionSyntaxForm
    extends PairWithPosition
    implements SyntaxForm, gnu.text.SourceLocator, java.io.Externalizable
  {
    private PairWithPosition datum;
    private TemplateScope scope;
    
    public PairWithPositionSyntaxForm(PairWithPosition datum, TemplateScope scope)
    {
      super(null, null);
      this.datum = datum;
      this.scope = scope;
    }
    

    public PairWithPositionSyntaxForm(Pair datum, gnu.text.SourceLocator where, TemplateScope scope)
    {
      this(new PairWithPosition(where, datum.getCar(), datum.getCdr()), scope);
    }
    
    public Object getDatum()
    {
      return datum;
    }
    
    public TemplateScope getScope() {
      return scope;
    }
    
    public Object getCar() {
      if (car == null)
        car = SyntaxForms.makeForm(datum.getCar(), scope);
      return car;
    }
    
    public Object getCdr() {
      if (cdr == null)
        cdr = SyntaxForms.makeForm(datum.getCdr(), scope);
      return cdr;
    }
    
    public String toString() {
      return SyntaxForms.toString(this, null);
    }
    
    public void writeExternal(ObjectOutput out) throws IOException {
      out.writeObject(datum);
      out.writeObject(scope);
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      datum = ((PairWithPosition)in.readObject());
      scope = ((TemplateScope)in.readObject());
    }
  }
}
