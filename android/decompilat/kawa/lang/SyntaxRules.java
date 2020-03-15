// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.kawa.format.ReportFormat;
import gnu.lists.Consumer;
import gnu.expr.ErrorExp;
import gnu.expr.Compilation;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.io.Externalizable;
import gnu.kawa.format.Printable;
import gnu.mapping.Procedure1;

public class SyntaxRules extends Procedure1 implements Printable, Externalizable
{
    Object[] literal_identifiers;
    SyntaxRule[] rules;
    int maxVars;
    
    public SyntaxRules() {
        this.maxVars = 0;
    }
    
    public SyntaxRules(final Object[] literal_identifiers, final SyntaxRule[] rules, final int maxVars, final Object name) {
        this.maxVars = 0;
        this.literal_identifiers = literal_identifiers;
        this.rules = rules;
        this.maxVars = maxVars;
        if (name != null) {
            this.setSymbol(name);
        }
    }
    
    public SyntaxRules(final Object ellipsis, final Object[] literal_identifiers, Object srules, final Translator tr) {
        this.maxVars = 0;
        final Macro curMacro = tr.currentMacroDefinition;
        if (curMacro != null) {
            final Object curName = curMacro.getSymbol();
            if (curName != null) {
                this.setSymbol(curName);
            }
        }
        this.literal_identifiers = literal_identifiers;
        int rules_count = Translator.listLength(srules);
        if (rules_count < 0) {
            rules_count = 0;
            tr.syntaxError("missing or invalid syntax-rules");
        }
        this.rules = new SyntaxRule[rules_count];
        SyntaxForm rules_syntax = null;
        Pair rules_pair;
        for (int i = 0; i < rules_count; ++i, srules = rules_pair.getCdr()) {
            while (srules instanceof SyntaxForm) {
                rules_syntax = (SyntaxForm)srules;
                srules = rules_syntax.getDatum();
            }
            rules_pair = (Pair)srules;
            SyntaxForm rule_syntax;
            Object syntax_rule;
            for (rule_syntax = rules_syntax, syntax_rule = rules_pair.getCar(); syntax_rule instanceof SyntaxForm; syntax_rule = rule_syntax.getDatum()) {
                rule_syntax = (SyntaxForm)syntax_rule;
            }
            if (!(syntax_rule instanceof Pair)) {
                tr.error('e', "missing pattern in syntax rule #" + i);
                return;
            }
            SyntaxForm pattern_syntax = rule_syntax;
            Pair syntax_rule_pair = (Pair)syntax_rule;
            Object pattern = syntax_rule_pair.getCar();
            final String save_filename = tr.getFileName();
            final int save_line = tr.getLineNumber();
            final int save_column = tr.getColumnNumber();
            try {
                SyntaxForm template_syntax = rule_syntax;
                tr.setLine(syntax_rule_pair);
                for (syntax_rule = syntax_rule_pair.getCdr(); syntax_rule instanceof SyntaxForm; syntax_rule = template_syntax.getDatum()) {
                    template_syntax = (SyntaxForm)syntax_rule;
                }
                if (!(syntax_rule instanceof Pair)) {
                    tr.error('e', "missing template in syntax rule #" + i);
                    return;
                }
                syntax_rule_pair = (Pair)syntax_rule;
                if (syntax_rule_pair.getCdr() != LList.Empty) {
                    final Object save = tr.pushPositionOf(syntax_rule_pair.getCdr());
                    tr.error('e', "junk after syntax rule #" + i);
                    tr.popPositionOf(save);
                    return;
                }
                final Object template = syntax_rule_pair.getCar();
                final PatternScope patternScope = PatternScope.push(tr);
                tr.push(patternScope);
                try {
                    while (pattern instanceof SyntaxForm) {
                        pattern_syntax = (SyntaxForm)pattern;
                        pattern = pattern_syntax.getDatum();
                    }
                    final StringBuilder programbuf = new StringBuilder();
                    if (!(pattern instanceof Pair)) {
                        tr.error('e', "pattern does not start with name");
                        return;
                    }
                    final Pair p = (Pair)pattern;
                    programbuf.append('\f');
                    programbuf.append('\u0018');
                    pattern = p.getCdr();
                    final SyntaxPattern spattern = new SyntaxPattern(programbuf, pattern, pattern_syntax, ellipsis, literal_identifiers, tr);
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
        }
        int i = this.rules.length;
        while (--i >= 0) {
            final int size = this.rules[i].patternNesting.length();
            if (size > this.maxVars) {
                this.maxVars = size;
            }
        }
    }
    
    @Override
    public Object apply1(final Object arg) {
        if (arg instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)arg;
            final Translator tr = (Translator)Compilation.getCurrent();
            final ScopeExp save_scope = tr.currentScope();
            tr.setCurrentScope(sf.getScope());
            try {
                return this.expand(sf, tr);
            }
            finally {
                tr.setCurrentScope(save_scope);
            }
        }
        return this.expand(arg, (Translator)Compilation.getCurrent());
    }
    
    public Object expand(final Object obj, final Translator tr) {
        final Object[] vars = new Object[this.maxVars];
        final Macro macro = (Macro)tr.getCurrentSyntax();
        for (int i = 0; i < this.rules.length; ++i) {
            final SyntaxRule rule = this.rules[i];
            if (rule == null) {
                return new ErrorExp("error defining " + macro);
            }
            final Pattern pattern = rule.pattern;
            final boolean matched = pattern.match(obj, vars, 0);
            if (matched) {
                final Object expansion = rule.execute(vars, tr);
                return expansion;
            }
        }
        return tr.syntaxError("no matching syntax-rule for " + this.getName());
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<macro ");
        ReportFormat.print(this.getName(), out);
        out.write(62);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.literal_identifiers);
        out.writeObject(this.rules);
        out.writeInt(this.maxVars);
        out.writeObject(this.getSymbol());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.literal_identifiers = (Object[])in.readObject();
        this.rules = (SyntaxRule[])in.readObject();
        this.maxVars = in.readInt();
        final Object name = in.readObject();
        if (name != null) {
            this.setSymbol(name);
        }
    }
}
