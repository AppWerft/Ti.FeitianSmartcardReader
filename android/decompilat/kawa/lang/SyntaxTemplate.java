// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.kawa.lispexpr.LispLanguage;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.Compilation;
import gnu.lists.PairWithPosition;
import gnu.expr.ModuleExp;
import gnu.mapping.Symbol;
import java.util.List;
import gnu.lists.LList;
import gnu.lists.FVector;
import gnu.lists.Pair;
import java.util.IdentityHashMap;
import java.util.Vector;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ScopeExp;
import java.io.Externalizable;

public class SyntaxTemplate implements Externalizable
{
    String template_program;
    ScopeExp savedScope;
    static final int BUILD_MISC = 0;
    static final int BUILD_LIST1 = 8;
    static final int BUILD_NIL = 16;
    static final int BUILD_SYNTAX = 24;
    static final int BUILD_VECTOR = 40;
    static final int BUILD_CONS = 1;
    static final int BUILD_VAR = 2;
    static final int BUILD_VAR_CAR = 3;
    static final int BUILD_LITERAL = 4;
    static final int BUILD_DOTS = 5;
    static final int BUILD_WIDE = 7;
    String patternNesting;
    int max_nesting;
    Object[] literal_values;
    public static final SimpleSymbol dots3Symbol;
    
    protected SyntaxTemplate() {
    }
    
    public SyntaxTemplate(final String patternNesting, final String template_program, final Object[] literal_values, final int max_nesting) {
        this.patternNesting = patternNesting;
        this.template_program = template_program;
        this.literal_values = literal_values;
        this.max_nesting = max_nesting;
    }
    
    public SyntaxTemplate(final Object template, final SyntaxForm syntax, final Object ellipsis, final Translator tr) {
        this.patternNesting = ((tr == null || tr.patternScope == null) ? "" : tr.patternScope.patternNesting.toString());
        this.savedScope = tr.currentScope();
        if (this.savedScope instanceof PatternScope) {
            this.savedScope = this.savedScope.getOuter();
        }
        final StringBuilder program = new StringBuilder();
        final Vector literals_vector = new Vector();
        final IdentityHashMap seen = new IdentityHashMap();
        this.convert_template(template, syntax, program, 0, literals_vector, seen, false, ellipsis, tr);
        this.template_program = program.toString();
        literals_vector.copyInto(this.literal_values = new Object[literals_vector.size()]);
    }
    
    private int convert_template(final Object form, final SyntaxForm syntax, final StringBuilder template_program, final int nesting, final Vector literals_vector, final IdentityHashMap seen, final boolean isVector, final Object ellipsis, final Translator tr) {
        Object unseeNeeded = null;
        if (form instanceof Pair || form instanceof FVector) {
            if (seen.containsKey(form)) {
                tr.syntaxError("self-referential (cyclic) syntax template - " + form);
                return -2;
            }
            seen.put(form, form);
            unseeNeeded = form;
        }
        final int r = this.xconvert_template(form, syntax, template_program, nesting, literals_vector, seen, isVector, ellipsis, tr);
        if (unseeNeeded != null) {
            seen.remove(unseeNeeded);
        }
        return r;
    }
    
    private int xconvert_template(Object form, SyntaxForm syntax, final StringBuilder template_program, final int nesting, final Vector literals_vector, final IdentityHashMap seen, final boolean isVector, final Object ellipsis, final Translator tr) {
        while (form instanceof SyntaxForm) {
            syntax = (SyntaxForm)form;
            form = syntax.getDatum();
        }
        if (form instanceof Pair) {
            final Pair pair = (Pair)form;
            final int save_pc = template_program.length();
            final Object car = pair.getCar();
            if (SyntaxPattern.literalIdentifierEq(car, (syntax == null) ? null : syntax.getScope(), ellipsis, null)) {
                final Object cdr = pair.getCdr();
                if (cdr instanceof Pair) {
                    final Pair cdr_pair = (Pair)cdr;
                    if (cdr_pair.getCdr() == LList.Empty) {
                        this.convert_template(cdr_pair.getCar(), syntax, template_program, nesting, literals_vector, seen, false, null, tr);
                        return -1;
                    }
                }
            }
            final int save_literals = literals_vector.size();
            template_program.append('\b');
            int num_dots3 = 0;
            Object rest = pair.getCdr();
            while (rest instanceof Pair) {
                final Pair p = (Pair)rest;
                if (!SyntaxPattern.literalIdentifierEq(p.getCar(), null, ellipsis, null)) {
                    break;
                }
                ++num_dots3;
                rest = p.getCdr();
                template_program.append('\u0005');
            }
            final int ret_car = this.convert_template(car, syntax, template_program, nesting + num_dots3, literals_vector, seen, false, ellipsis, tr);
            int ret_cdr = -2;
            if (rest != LList.Empty) {
                final int delta = template_program.length() - save_pc - 1;
                template_program.setCharAt(save_pc, (char)((delta << 3) + 1));
                ret_cdr = this.convert_template(rest, syntax, template_program, nesting, literals_vector, seen, isVector, ellipsis, tr);
            }
            if (num_dots3 > 0) {
                if (ret_car < 0) {
                    tr.syntaxError("... follows template with no suitably-nested pattern variable");
                }
                int i = num_dots3;
                while (--i >= 0) {
                    final char op = (char)((ret_car << 3) + 5);
                    template_program.setCharAt(save_pc + i + 1, op);
                    final int n = nesting + num_dots3;
                    if (n >= this.max_nesting) {
                        this.max_nesting = n;
                    }
                }
            }
            if (ret_car >= 0) {
                return ret_car;
            }
            if (ret_cdr >= 0) {
                return ret_cdr;
            }
            if (ret_car == -1 || ret_cdr == -1) {
                return -1;
            }
            if (isVector) {
                return -2;
            }
            literals_vector.setSize(save_literals);
            template_program.setLength(save_pc);
        }
        else {
            if (form instanceof FVector) {
                template_program.append('(');
                return this.convert_template(LList.makeList((List)form), syntax, template_program, nesting, literals_vector, seen, true, ellipsis, tr);
            }
            if (form == LList.Empty) {
                template_program.append('\u0010');
                return -2;
            }
            if (form instanceof Symbol && tr != null && tr.patternScope != null) {
                final int pattern_var_num = indexOf(tr.patternScope.pattern_names, form);
                if (pattern_var_num >= 0) {
                    int var_nesting = this.patternNesting.charAt(pattern_var_num);
                    final int op2 = ((var_nesting & 0x1) != 0x0) ? 3 : 2;
                    var_nesting >>= 1;
                    if (var_nesting > nesting) {
                        tr.syntaxError("inconsistent ... nesting of " + form);
                    }
                    template_program.append((char)(op2 + 8 * pattern_var_num));
                    return (var_nesting == nesting) ? pattern_var_num : -1;
                }
            }
        }
        final Object xform = tr.namespaceResolve(form);
        final Macro macro = tr.currentMacroDefinition;
        if (xform instanceof Symbol && macro != null && macro.capturedScope instanceof ModuleExp) {
            tr.noteAccess(xform, tr.currentScope());
        }
        form = SyntaxForms.makeWithTemplate(syntax, form);
        if (template_program.length() == 0 && form instanceof PairWithPosition) {
            final PairWithPosition pform = (PairWithPosition)form;
            form = new Pair(pform.getCar(), pform.getCdr());
        }
        int literals_index = indexOf(literals_vector, form);
        if (literals_index < 0) {
            literals_index = literals_vector.size();
            literals_vector.addElement(form);
        }
        if (!(form instanceof SyntaxForm) && form != ellipsis && !(form instanceof CharSequence) && !(form instanceof Number) && !(form instanceof Boolean)) {
            template_program.append('\u0018');
        }
        template_program.append((char)(4 + 8 * literals_index));
        return (form == ellipsis) ? -1 : -2;
    }
    
    static int indexOf(final Vector vec, final Object elem) {
        for (int len = vec.size(), i = 0; i < len; ++i) {
            if (vec.elementAt(i) == elem) {
                return i;
            }
        }
        return -1;
    }
    
    private int get_count(Object var, final int nesting, final int[] indexes) {
        for (int level = 0; level < nesting; ++level) {
            var = ((Object[])var)[indexes[level]];
        }
        final Object[] var_array = (Object[])var;
        return var_array.length;
    }
    
    public Object execute(final Object[] vars, final TemplateScope templateScope) {
        final Object result = this.execute(0, vars, 0, new int[this.max_nesting], (Translator)Compilation.getCurrent(), templateScope);
        return result;
    }
    
    public Object execute(final Object[] vars, final Translator tr) {
        return this.execute(0, vars, 0, new int[this.max_nesting], tr, TemplateScope.make(tr, this.savedScope));
    }
    
    Object get_var(final int var_num, final Object[] vars, final int[] indexes, final Translator tr) {
        Object var = vars[var_num];
        if (var_num < this.patternNesting.length()) {
            for (int var_nesting = this.patternNesting.charAt(var_num) >> 1, level = 0; level < var_nesting; ++level) {
                final Object[] varr = (Object[])var;
                final int ind = indexes[level];
                if (ind >= varr.length) {
                    final Syntax macro = tr.getCurrentSyntax();
                    String mname = (macro == null) ? null : macro.getName();
                    if (mname == null) {
                        mname = "<unknown>";
                    }
                    tr.syntaxError("inconsistent use of ellipsis variable in macro " + mname);
                    return LList.list1(var);
                }
                var = varr[ind];
            }
        }
        return var;
    }
    
    LList executeToList(int pc, final Object[] vars, final int nesting, final int[] indexes, final Translator tr, final TemplateScope templateScope) {
        final int pc2 = pc;
        int ch;
        for (ch = this.template_program.charAt(pc); (ch & 0x7) == 0x7; ch = (ch - 7 << 13 | this.template_program.charAt(++pc))) {}
        if ((ch & 0x7) == 0x3) {
            final Pair p = (Pair)this.get_var(ch >> 3, vars, indexes, tr);
            return Translator.makePair(p, p.getCar(), LList.Empty);
        }
        if ((ch & 0x7) == 0x5) {
            final int var_num = ch >> 3;
            final Object var = vars[var_num];
            final int count = this.get_count(var, nesting, indexes);
            LList result = LList.Empty;
            Pair last = null;
            ++pc;
            for (int j = 0; j < count; ++j) {
                indexes[nesting] = j;
                LList list = this.executeToList(pc, vars, nesting + 1, indexes, tr, templateScope);
                if (last == null) {
                    result = list;
                }
                else {
                    last.setCdrBackdoor(list);
                }
                while (list instanceof Pair) {
                    last = (Pair)list;
                    list = (LList)last.getCdr();
                }
            }
            return result;
        }
        final Object v = this.execute(pc2, vars, nesting, indexes, tr, templateScope);
        return new Pair(v, LList.Empty);
    }
    
    Object execute(int pc, final Object[] vars, final int nesting, final int[] indexes, final Translator tr, final TemplateScope templateScope) {
        int ch;
        for (ch = this.template_program.charAt(pc); (ch & 0x7) == 0x7; ch = (ch - 7 << 13 | this.template_program.charAt(++pc))) {}
        if (ch == 8) {
            return this.executeToList(pc + 1, vars, nesting, indexes, tr, templateScope);
        }
        if (ch == 16) {
            return LList.Empty;
        }
        if (ch == 24) {
            final Object v = this.execute(pc + 1, vars, nesting, indexes, tr, templateScope);
            return SyntaxForms.makeForm(v, templateScope);
        }
        if ((ch & 0x7) == 0x1) {
            Pair p = null;
            Object result = null;
            do {
                ++pc;
                Object q = this.executeToList(pc, vars, nesting, indexes, tr, templateScope);
                if (p == null) {
                    result = q;
                }
                else {
                    p.setCdrBackdoor(q);
                }
                while (q instanceof Pair) {
                    p = (Pair)q;
                    q = p.getCdr();
                }
                pc += ch >> 3;
                ch = this.template_program.charAt(pc);
            } while ((ch & 0x7) == 0x1);
            final Object cdr = this.execute(pc, vars, nesting, indexes, tr, templateScope);
            if (p == null) {
                result = cdr;
            }
            else {
                p.setCdrBackdoor(cdr);
            }
            return result;
        }
        if (ch == 40) {
            final Object el = this.execute(pc + 1, vars, nesting, indexes, tr, templateScope);
            return new FVector((List)el);
        }
        if ((ch & 0x7) == 0x4) {
            final int lit_no = ch >> 3;
            return this.literal_values[lit_no];
        }
        if ((ch & 0x6) == 0x2) {
            Object var = this.get_var(ch >> 3, vars, indexes, tr);
            if ((ch & 0x7) == 0x3) {
                var = ((Pair)var).getCar();
            }
            return var;
        }
        throw new Error("unknown template code: " + ch + " at " + pc);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.patternNesting);
        out.writeObject(this.template_program);
        out.writeObject(this.literal_values);
        out.writeInt(this.max_nesting);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.patternNesting = (String)in.readObject();
        this.template_program = (String)in.readObject();
        this.literal_values = (Object[])in.readObject();
        this.max_nesting = in.readInt();
    }
    
    static {
        dots3Symbol = LispLanguage.dots3_sym;
    }
}
