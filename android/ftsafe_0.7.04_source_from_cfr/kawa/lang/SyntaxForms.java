/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.NameLookup;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.ImmutablePair;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class SyntaxForms {
    public static final boolean DEBUGGING = true;

    public static Object makeForm(Object datum, TemplateScope scope) {
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

    public static Object makeWithTemplate(Object template, Object datum, Object srcloc) {
        if (srcloc instanceof SourceLocator && datum instanceof Pair) {
            Pair pdatum = (Pair)datum;
            SourceLocator sloc = (SourceLocator)srcloc;
            if (template instanceof SyntaxForm) {
                return new PairWithPositionSyntaxForm(pdatum, sloc, ((SyntaxForm)template).getScope());
            }
            return new PairWithPosition(sloc, pdatum.getCar(), pdatum.getCdr());
        }
        if (datum instanceof SyntaxForm) {
            return (SyntaxForm)datum;
        }
        if (template instanceof SyntaxForm) {
            SyntaxForm sdatum = (SyntaxForm)template;
            if (datum == sdatum.getDatum()) {
                return sdatum;
            }
            return SyntaxForms.fromDatum(datum, sdatum);
        }
        return datum;
    }

    public static Object makeWithTemplate(Object template, Object form) {
        return SyntaxForms.makeWithTemplate(template, form, null);
    }

    public static boolean identifierEquals(Object id1, Object id2, boolean checkBound) {
        TemplateScope sc1;
        Object s1;
        Object s2;
        TemplateScope sc2;
        SyntaxForm sf;
        Translator comp = (Translator)Compilation.getCurrent();
        if (id1 instanceof SyntaxForm) {
            sf = (SyntaxForm)id1;
            s1 = sf.getDatum();
            sc1 = sf.getScope();
        } else {
            s1 = id1;
            sc1 = null;
        }
        if (id2 instanceof SyntaxForm) {
            sf = (SyntaxForm)id2;
            s2 = sf.getDatum();
            sc2 = sf.getScope();
        } else {
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
            Object mark1 = sc1 != null ? sc1.macroMark : null;
            Object mark2 = sc2 != null ? sc2.macroMark : null;
            return mark1 == mark2;
        }
        ScopeExp savedScope = comp.currentScope();
        if (sc1 != null) {
            comp.setCurrentScope(sc1);
        }
        Declaration d1 = comp.lexical.lookup(s1, -1);
        comp.setCurrentScope(sc2 != null ? sc2 : savedScope);
        Declaration d2 = comp.lexical.lookup(s2, -1);
        if (sc2 != null) {
            comp.setCurrentScope(savedScope);
        }
        return d1 == d2;
    }

    public static boolean isIdentifier(SyntaxForm form) {
        return form.getDatum() instanceof Symbol;
    }

    public static Object fromDatum(Object datum, SyntaxForm template) {
        return SyntaxForms.makeForm(datum, template.getScope());
    }

    public static Object fromDatumIfNeeded(Object datum, SyntaxForm template) {
        if (datum instanceof SyntaxForm || template == null) {
            return datum;
        }
        if (datum == template.getDatum()) {
            return template;
        }
        return SyntaxForms.fromDatum(datum, template);
    }

    public static Expression rewrite(Object x) {
        Translator tr = (Translator)Compilation.getCurrent();
        return tr.rewrite(x);
    }

    public static Expression rewriteBody(Object x) {
        Translator tr = (Translator)Compilation.getCurrent();
        return tr.rewrite_body(x);
    }

    public static String toString(SyntaxForm sform, String id) {
        StringBuilder sbuf = new StringBuilder("#<syntax");
        if (id != null) {
            sbuf.append('#');
            sbuf.append(id);
        }
        sbuf.append(' ');
        sbuf.append(sform.getDatum());
        TemplateScope scope = sform.getScope();
        if (scope == null) {
            sbuf.append(" in null");
        } else {
            sbuf.append(" in #");
            sbuf.append(scope.id);
        }
        sbuf.append(">");
        return sbuf.toString();
    }

    public static class PairWithPositionSyntaxForm
    extends PairWithPosition
    implements SyntaxForm,
    SourceLocator,
    Externalizable {
        private PairWithPosition datum;
        private TemplateScope scope;

        public PairWithPositionSyntaxForm(PairWithPosition datum, TemplateScope scope) {
            super(datum, null, null);
            this.datum = datum;
            this.scope = scope;
        }

        public PairWithPositionSyntaxForm(Pair datum, SourceLocator where, TemplateScope scope) {
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
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.datum);
            out.writeObject(this.scope);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.datum = (PairWithPosition)in.readObject();
            this.scope = (TemplateScope)in.readObject();
        }
    }

    public static class PairSyntaxForm
    extends ImmutablePair
    implements SyntaxForm,
    Externalizable {
        private Pair datum;
        private TemplateScope scope;

        public PairSyntaxForm(Pair datum, TemplateScope scope) {
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
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.datum);
            out.writeObject(this.scope);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.datum = (Pair)in.readObject();
            this.scope = (TemplateScope)in.readObject();
        }
    }

    public static class SimpleSyntaxForm
    implements SyntaxForm,
    Externalizable {
        private Object datum;
        private TemplateScope scope;
        static int counter;
        int id = ++counter;

        public SimpleSyntaxForm(Object datum, TemplateScope scope) {
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

        public String toString() {
            String sid = Integer.toString(this.id);
            return SyntaxForms.toString(this, sid);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.datum);
            out.writeObject(this.scope);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.datum = in.readObject();
            this.scope = (TemplateScope)in.readObject();
        }
    }

}

