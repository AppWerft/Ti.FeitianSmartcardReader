/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.ScopeExp;
import gnu.kawa.format.Printable;
import gnu.kawa.format.ReportFormat;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure1;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.PatternScope;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class SyntaxRules
extends Procedure1
implements Printable,
Externalizable {
    Object[] literal_identifiers;
    SyntaxRule[] rules;
    int maxVars = 0;

    public SyntaxRules() {
    }

    public SyntaxRules(Object[] literal_identifiers, SyntaxRule[] rules, int maxVars, Object name) {
        this.literal_identifiers = literal_identifiers;
        this.rules = rules;
        this.maxVars = maxVars;
        if (name != null) {
            this.setSymbol(name);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SyntaxRules(Object ellipsis, Object[] literal_identifiers, Object srules, Translator tr) {
        int i;
        Object curName;
        Macro curMacro = tr.currentMacroDefinition;
        if (curMacro != null && (curName = curMacro.getSymbol()) != null) {
            this.setSymbol(curName);
        }
        this.literal_identifiers = literal_identifiers;
        int rules_count = Translator.listLength(srules);
        if (rules_count < 0) {
            rules_count = 0;
            tr.syntaxError("missing or invalid syntax-rules");
        }
        this.rules = new SyntaxRule[rules_count];
        SyntaxForm rules_syntax = null;
        for (i = 0; i < rules_count; ++i) {
            Pair rules_pair;
            while (srules instanceof SyntaxForm) {
                rules_syntax = (SyntaxForm)srules;
                srules = rules_syntax.getDatum();
            }
            rules_pair = (Pair)srules;
            SyntaxForm rule_syntax = rules_syntax;
            Object syntax_rule = rules_pair.getCar();
            while (syntax_rule instanceof SyntaxForm) {
                rule_syntax = (SyntaxForm)syntax_rule;
                syntax_rule = rule_syntax.getDatum();
            }
            if (!(syntax_rule instanceof Pair)) {
                tr.error('e', "missing pattern in syntax rule #" + i);
                return;
            }
            SyntaxForm pattern_syntax = rule_syntax;
            Pair syntax_rule_pair = (Pair)syntax_rule;
            Object pattern = syntax_rule_pair.getCar();
            String save_filename = tr.getFileName();
            int save_line = tr.getLineNumber();
            int save_column = tr.getColumnNumber();
            try {
                SyntaxForm template_syntax = rule_syntax;
                tr.setLine(syntax_rule_pair);
                syntax_rule = syntax_rule_pair.getCdr();
                while (syntax_rule instanceof SyntaxForm) {
                    template_syntax = (SyntaxForm)syntax_rule;
                    syntax_rule = template_syntax.getDatum();
                }
                if (!(syntax_rule instanceof Pair)) {
                    tr.error('e', "missing template in syntax rule #" + i);
                    return;
                }
                syntax_rule_pair = (Pair)syntax_rule;
                if (syntax_rule_pair.getCdr() != LList.Empty) {
                    Object save = tr.pushPositionOf(syntax_rule_pair.getCdr());
                    tr.error('e', "junk after syntax rule #" + i);
                    tr.popPositionOf(save);
                    return;
                }
                Object template = syntax_rule_pair.getCar();
                PatternScope patternScope = PatternScope.push(tr);
                tr.push(patternScope);
                try {
                    while (pattern instanceof SyntaxForm) {
                        pattern_syntax = (SyntaxForm)pattern;
                        pattern = pattern_syntax.getDatum();
                    }
                    StringBuilder programbuf = new StringBuilder();
                    if (!(pattern instanceof Pair)) {
                        tr.error('e', "pattern does not start with name");
                        return;
                    }
                    Pair p = (Pair)pattern;
                    programbuf.append('\f');
                    programbuf.append('\u0018');
                    pattern = p.getCdr();
                    SyntaxPattern spattern = new SyntaxPattern(programbuf, pattern, pattern_syntax, ellipsis, literal_identifiers, tr);
                    this.rules[i] = new SyntaxRule(spattern, template, template_syntax, ellipsis, tr);
                }
                finally {
                    PatternScope.pop(tr);
                    tr.pop();
                }
            }
            finally {
                tr.setLine(save_filename, save_line, save_column);
            }
            srules = rules_pair.getCdr();
        }
        i = this.rules.length;
        while (--i >= 0) {
            int size = this.rules[i].patternNesting.length();
            if (size <= this.maxVars) continue;
            this.maxVars = size;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object apply1(Object arg) {
        if (arg instanceof SyntaxForm) {
            SyntaxForm sf = (SyntaxForm)arg;
            Translator tr = (Translator)Compilation.getCurrent();
            ScopeExp save_scope = tr.currentScope();
            tr.setCurrentScope(sf.getScope());
            try {
                Object object2 = this.expand(sf, tr);
                return object2;
            }
            finally {
                tr.setCurrentScope(save_scope);
            }
        }
        return this.expand(arg, (Translator)Compilation.getCurrent());
    }

    public Object expand(Object obj, Translator tr) {
        Object[] vars = new Object[this.maxVars];
        Macro macro = (Macro)tr.getCurrentSyntax();
        for (int i = 0; i < this.rules.length; ++i) {
            SyntaxRule rule = this.rules[i];
            if (rule == null) {
                return new ErrorExp("error defining " + macro);
            }
            SyntaxPattern pattern = rule.pattern;
            boolean matched = ((Pattern)pattern).match(obj, vars, 0);
            if (!matched) continue;
            Object expansion = rule.execute(vars, tr);
            return expansion;
        }
        return tr.syntaxError("no matching syntax-rule for " + this.getName());
    }

    @Override
    public void print(Consumer out) {
        out.write("#<macro ");
        ReportFormat.print(this.getName(), out);
        out.write(62);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.literal_identifiers);
        out.writeObject(this.rules);
        out.writeInt(this.maxVars);
        out.writeObject(this.getSymbol());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.literal_identifiers = (Object[])in.readObject();
        this.rules = (SyntaxRule[])in.readObject();
        this.maxVars = in.readInt();
        Object name = in.readObject();
        if (name != null) {
            this.setSymbol(name);
        }
    }
}

