// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class IfState
{
    IfState previous;
    boolean doing_else;
    Label end_label;
    boolean andThenSet;
    
    public IfState(final CodeAttr code) {
        this(code, new Label(code));
    }
    
    public IfState(final CodeAttr code, final Label endLabel) {
        this.previous = code.if_stack;
        code.if_stack = this;
        this.end_label = endLabel;
    }
}
