/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.Translator;

public class SyntaxRule
extends SyntaxTemplate
implements Externalizable {
    SyntaxPattern pattern;

    public SyntaxRule() {
    }

    public SyntaxRule(SyntaxPattern pattern, String pattern_nesting, String template_program, Object[] literal_values, int max_nesting) {
        super(pattern_nesting, template_program, literal_values, max_nesting);
        this.pattern = pattern;
    }

    public SyntaxRule(SyntaxPattern pattern, Object template, SyntaxForm template_syntax, Object ellipsis, Translator tr) {
        super(template, template_syntax, ellipsis, tr);
        this.pattern = pattern;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.pattern);
        super.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.pattern = (SyntaxPattern)in.readObject();
        super.readExternal(in);
    }
}

