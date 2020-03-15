// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class SyntaxRule extends SyntaxTemplate implements Externalizable
{
    SyntaxPattern pattern;
    
    public SyntaxRule() {
    }
    
    public SyntaxRule(final SyntaxPattern pattern, final String pattern_nesting, final String template_program, final Object[] literal_values, final int max_nesting) {
        super(pattern_nesting, template_program, literal_values, max_nesting);
        this.pattern = pattern;
    }
    
    public SyntaxRule(final SyntaxPattern pattern, final Object template, final SyntaxForm template_syntax, final Object ellipsis, final Translator tr) {
        super(template, template_syntax, ellipsis, tr);
        this.pattern = pattern;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.pattern);
        super.writeExternal(out);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.pattern = (SyntaxPattern)in.readObject();
        super.readExternal(in);
    }
}
