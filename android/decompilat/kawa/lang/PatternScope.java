// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.Declaration;
import java.util.Vector;
import gnu.expr.LetExp;

public class PatternScope extends LetExp
{
    PatternScope previousSyntax;
    public Vector pattern_names;
    public StringBuffer patternNesting;
    public Declaration matchArray;
    
    public static PatternScope push(final Translator tr) {
        final PatternScope newScope = new PatternScope();
        final PatternScope oldScope = tr.patternScope;
        newScope.previousSyntax = oldScope;
        tr.patternScope = newScope;
        if (oldScope == null) {
            newScope.pattern_names = new Vector();
            newScope.patternNesting = new StringBuffer();
        }
        else {
            newScope.pattern_names = (Vector)oldScope.pattern_names.clone();
            newScope.patternNesting = new StringBuffer(oldScope.patternNesting.toString());
        }
        newScope.setOuter(tr.currentScope());
        return newScope;
    }
    
    public static void pop(final Translator tr) {
        tr.patternScope = tr.patternScope.previousSyntax;
    }
}
