/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.LetExp;
import gnu.expr.ScopeExp;
import java.util.Vector;
import kawa.lang.Translator;

public class PatternScope
extends LetExp {
    PatternScope previousSyntax;
    public Vector pattern_names;
    public StringBuffer patternNesting;
    public Declaration matchArray;

    public static PatternScope push(Translator tr) {
        PatternScope oldScope;
        PatternScope newScope = new PatternScope();
        newScope.previousSyntax = oldScope = tr.patternScope;
        tr.patternScope = newScope;
        if (oldScope == null) {
            newScope.pattern_names = new Vector();
            newScope.patternNesting = new StringBuffer();
        } else {
            newScope.pattern_names = (Vector)oldScope.pattern_names.clone();
            newScope.patternNesting = new StringBuffer(oldScope.patternNesting.toString());
        }
        newScope.setOuter(tr.currentScope());
        return newScope;
    }

    public static void pop(Translator tr) {
        tr.patternScope = tr.patternScope.previousSyntax;
    }
}

