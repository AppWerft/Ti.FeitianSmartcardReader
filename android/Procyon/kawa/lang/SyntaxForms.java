// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.lists.ImmutablePair;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;
import gnu.expr.Expression;
import gnu.mapping.Symbol;
import gnu.expr.Declaration;
import gnu.expr.ScopeExp;
import gnu.expr.Compilation;
import gnu.text.SourceLocator;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.expr.Keyword;
import gnu.lists.LList;

public class SyntaxForms
{
    public static final boolean DEBUGGING = true;
    
    public static Object makeForm(final Object datum, final TemplateScope scope) {
        if (datum instanceof SyntaxForm || datum == LList.Empty || datum instanceof Number || datum instanceof Keyword || scope == null) {
            return datum;
        }
        if (datum instanceof PairWithPosition) {
            return new PairWithPositionSyntaxForm((PairWithPosition)datum, scope);
        }
        if (datum instanceof Pair) {
            return new PairSyntaxForm((Pair)datum, scope);
        }
        return new SimpleSyntaxForm(datum, scope);
    }
    
    public static Object makeWithTemplate(final Object template, final Object datum, final Object srcloc) {
        if (srcloc instanceof SourceLocator && datum instanceof Pair) {
            final Pair pdatum = (Pair)datum;
            final SourceLocator sloc = (SourceLocator)srcloc;
            if (template instanceof SyntaxForm) {
                return new PairWithPositionSyntaxForm(pdatum, sloc, ((SyntaxForm)template).getScope());
            }
            return new PairWithPosition(sloc, pdatum.getCar(), pdatum.getCdr());
        }
        else {
            if (datum instanceof SyntaxForm) {
                return datum;
            }
            if (!(template instanceof SyntaxForm)) {
                return datum;
            }
            final SyntaxForm sdatum = (SyntaxForm)template;
            if (datum == sdatum.getDatum()) {
                return sdatum;
            }
            return fromDatum(datum, sdatum);
        }
    }
    
    public static Object makeWithTemplate(final Object template, final Object form) {
        return makeWithTemplate(template, form, null);
    }
    
    public static boolean identifierEquals(final Object id1, final Object id2, final boolean checkBound) {
        final Compilation comp = Compilation.getCurrent();
        Object s1;
        TemplateScope sc1;
        if (id1 instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)id1;
            s1 = sf.getDatum();
            sc1 = sf.getScope();
        }
        else {
            s1 = id1;
            sc1 = null;
        }
        Object s2;
        TemplateScope sc2;
        if (id2 instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)id2;
            s2 = sf.getDatum();
            sc2 = sf.getScope();
        }
        else {
            s2 = id2;
            sc2 = null;
        }
        if (s1 != s2) {
            return false;
        }
        if (sc1 == sc2) {
            return true;
        }
        if (checkBound) {
            final Object mark1 = (sc1 != null) ? sc1.macroMark : null;
            final Object mark2 = (sc2 != null) ? sc2.macroMark : null;
            return mark1 == mark2;
        }
        final ScopeExp savedScope = comp.currentScope();
        if (sc1 != null) {
            comp.setCurrentScope(sc1);
        }
        final Declaration d1 = comp.lexical.lookup(s1, -1);
        comp.setCurrentScope((sc2 != null) ? sc2 : savedScope);
        final Declaration d2 = comp.lexical.lookup(s2, -1);
        if (sc2 != null) {
            comp.setCurrentScope(savedScope);
        }
        return d1 == d2;
    }
    
    public static boolean isIdentifier(final SyntaxForm form) {
        return form.getDatum() instanceof Symbol;
    }
    
    public static Object fromDatum(final Object datum, final SyntaxForm template) {
        return makeForm(datum, template.getScope());
    }
    
    public static Object fromDatumIfNeeded(final Object datum, final SyntaxForm template) {
        if (datum instanceof SyntaxForm || template == null) {
            return datum;
        }
        if (datum == template.getDatum()) {
            return template;
        }
        return fromDatum(datum, template);
    }
    
    public static Expression rewrite(final Object x) {
        final Translator tr = (Translator)Compilation.getCurrent();
        return tr.rewrite(x);
    }
    
    public static Expression rewriteBody(final Object x) {
        final Translator tr = (Translator)Compilation.getCurrent();
        return tr.rewrite_body(x);
    }
    
    public static String toString(final SyntaxForm sform, final String id) {
        final StringBuilder sbuf = new StringBuilder("#<syntax");
        if (id != null) {
            sbuf.append('#');
            sbuf.append(id);
        }
        sbuf.append(' ');
        sbuf.append(sform.getDatum());
        final TemplateScope scope = sform.getScope();
        if (scope == null) {
            sbuf.append(" in null");
        }
        else {
            sbuf.append(" in #");
            sbuf.append(scope.id);
        }
        sbuf.append(">");
        return sbuf.toString();
    }
    
    public static class SimpleSyntaxForm implements SyntaxForm, Externalizable
    {
        private Object datum;
        private TemplateScope scope;
        static int counter;
        int id;
        
        public SimpleSyntaxForm(final Object datum, final TemplateScope scope) {
            this.id = ++SimpleSyntaxForm.counter;
            this.datum = datum;
            this.scope = scope;
        }
        
        @Override
        public Object getDatum() {
            return this.datum;
        }
        
        @Override
        public TemplateScope getScope() {
            return this.scope;
        }
        
        @Override
        public String toString() {
            final String sid = Integer.toString(this.id);
            return SyntaxForms.toString(this, sid);
        }
        
        @Override
        public void writeExternal(final ObjectOutput out) throws IOException {
            out.writeObject(this.datum);
            out.writeObject(this.scope);
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            this.datum = in.readObject();
            this.scope = (TemplateScope)in.readObject();
        }
    }
    
    public static class PairSyntaxForm extends ImmutablePair implements SyntaxForm, Externalizable
    {
        private Pair datum;
        private TemplateScope scope;
        
        public PairSyntaxForm(final Pair datum, final TemplateScope scope) {
            this.datum = datum;
            this.scope = scope;
        }
        
        @Override
        public Object getDatum() {
            return this.datum;
        }
        
        @Override
        public TemplateScope getScope() {
            return this.scope;
        }
        
        @Override
        public Object getCar() {
            if (this.car == null) {
                this.car = SyntaxForms.makeForm(this.datum.getCar(), this.scope);
            }
            return this.car;
        }
        
        @Override
        public Object getCdr() {
            if (this.cdr == null) {
                this.cdr = SyntaxForms.makeForm(this.datum.getCdr(), this.scope);
            }
            return this.cdr;
        }
        
        @Override
        public String toString() {
            return SyntaxForms.toString(this, null);
        }
        
        @Override
        public void writeExternal(final ObjectOutput out) throws IOException {
            out.writeObject(this.datum);
            out.writeObject(this.scope);
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            this.datum = (Pair)in.readObject();
            this.scope = (TemplateScope)in.readObject();
        }
    }
    
    public static class PairWithPositionSyntaxForm extends PairWithPosition implements SyntaxForm, SourceLocator, Externalizable
    {
        private PairWithPosition datum;
        private TemplateScope scope;
        
        public PairWithPositionSyntaxForm(final PairWithPosition datum, final TemplateScope scope) {
            super(datum, null, null);
            this.datum = datum;
            this.scope = scope;
        }
        
        public PairWithPositionSyntaxForm(final Pair datum, final SourceLocator where, final TemplateScope scope) {
            this(new PairWithPosition(where, datum.getCar(), datum.getCdr()), scope);
        }
        
        @Override
        public Object getDatum() {
            return this.datum;
        }
        
        @Override
        public TemplateScope getScope() {
            return this.scope;
        }
        
        @Override
        public Object getCar() {
            if (this.car == null) {
                this.car = SyntaxForms.makeForm(this.datum.getCar(), this.scope);
            }
            return this.car;
        }
        
        @Override
        public Object getCdr() {
            if (this.cdr == null) {
                this.cdr = SyntaxForms.makeForm(this.datum.getCdr(), this.scope);
            }
            return this.cdr;
        }
        
        @Override
        public String toString() {
            return SyntaxForms.toString(this, null);
        }
        
        @Override
        public void writeExternal(final ObjectOutput out) throws IOException {
            out.writeObject(this.datum);
            out.writeObject(this.scope);
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            this.datum = (PairWithPosition)in.readObject();
            this.scope = (TemplateScope)in.readObject();
        }
    }
}
