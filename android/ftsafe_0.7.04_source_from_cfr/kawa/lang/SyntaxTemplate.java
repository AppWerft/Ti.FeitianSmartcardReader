/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Vector;
import kawa.lang.Macro;
import kawa.lang.PatternScope;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class SyntaxTemplate
implements Externalizable {
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
    public static final SimpleSymbol dots3Symbol = LispLanguage.dots3_sym;

    protected SyntaxTemplate() {
    }

    public SyntaxTemplate(String patternNesting, String template_program, Object[] literal_values, int max_nesting) {
        this.patternNesting = patternNesting;
        this.template_program = template_program;
        this.literal_values = literal_values;
        this.max_nesting = max_nesting;
    }

    public SyntaxTemplate(Object template, SyntaxForm syntax2, Object ellipsis, Translator tr) {
        this.patternNesting = tr == null || tr.patternScope == null ? "" : tr.patternScope.patternNesting.toString();
        this.savedScope = tr.currentScope();
        if (this.savedScope instanceof PatternScope) {
            this.savedScope = this.savedScope.getOuter();
        }
        StringBuilder program = new StringBuilder();
        Vector literals_vector = new Vector();
        IdentityHashMap seen = new IdentityHashMap();
        this.convert_template(template, syntax2, program, 0, literals_vector, seen, false, ellipsis, tr);
        this.template_program = program.toString();
        this.literal_values = new Object[literals_vector.size()];
        literals_vector.copyInto(this.literal_values);
    }

    private int convert_template(Object form, SyntaxForm syntax2, StringBuilder template_program, int nesting, Vector literals_vector, IdentityHashMap seen, boolean isVector, Object ellipsis, Translator tr) {
        Object unseeNeeded = null;
        if (form instanceof Pair || form instanceof FVector) {
            if (seen.containsKey(form)) {
                tr.syntaxError("self-referential (cyclic) syntax template - " + form);
                return -2;
            }
            seen.put(form, form);
            unseeNeeded = form;
        }
        int r = this.xconvert_template(form, syntax2, template_program, nesting, literals_vector, seen, isVector, ellipsis, tr);
        if (unseeNeeded != null) {
            seen.remove(unseeNeeded);
        }
        return r;
    }

    private int xconvert_template(Object form, SyntaxForm syntax2, StringBuilder template_program, int nesting, Vector literals_vector, IdentityHashMap seen, boolean isVector, Object ellipsis, Translator tr) {
        int literals_index;
        while (form instanceof SyntaxForm) {
            syntax2 = (SyntaxForm)form;
            form = syntax2.getDatum();
        }
        if (form instanceof Pair) {
            Pair p;
            Object cdr;
            Pair cdr_pair;
            Pair pair = (Pair)form;
            int save_pc = template_program.length();
            Object car = pair.getCar();
            if (SyntaxPattern.literalIdentifierEq(car, syntax2 == null ? null : syntax2.getScope(), ellipsis, null) && (cdr = pair.getCdr()) instanceof Pair && (cdr_pair = (Pair)cdr).getCdr() == LList.Empty) {
                this.convert_template(cdr_pair.getCar(), syntax2, template_program, nesting, literals_vector, seen, false, null, tr);
                return -1;
            }
            int save_literals = literals_vector.size();
            template_program.append('\b');
            int num_dots3 = 0;
            Object rest = pair.getCdr();
            while (rest instanceof Pair && SyntaxPattern.literalIdentifierEq((p = (Pair)rest).getCar(), null, ellipsis, null)) {
                ++num_dots3;
                rest = p.getCdr();
                template_program.append('\u0005');
            }
            int ret_car = this.convert_template(car, syntax2, template_program, nesting + num_dots3, literals_vector, seen, false, ellipsis, tr);
            int ret_cdr = -2;
            if (rest != LList.Empty) {
                int delta = template_program.length() - save_pc - 1;
                template_program.setCharAt(save_pc, (char)((delta << 3) + 1));
                ret_cdr = this.convert_template(rest, syntax2, template_program, nesting, literals_vector, seen, isVector, ellipsis, tr);
            }
            if (num_dots3 > 0) {
                if (ret_car < 0) {
                    tr.syntaxError("... follows template with no suitably-nested pattern variable");
                }
                int i = num_dots3;
                while (--i >= 0) {
                    char op = (char)((ret_car << 3) + 5);
                    template_program.setCharAt(save_pc + i + 1, op);
                    int n = nesting + num_dots3;
                    if (n < this.max_nesting) continue;
                    this.max_nesting = n;
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
        } else {
            int pattern_var_num;
            if (form instanceof FVector) {
                template_program.append('(');
                return this.convert_template(LList.makeList((FVector)form), syntax2, template_program, nesting, literals_vector, seen, true, ellipsis, tr);
            }
            if (form == LList.Empty) {
                template_program.append('\u0010');
                return -2;
            }
            if (form instanceof Symbol && tr != null && tr.patternScope != null && (pattern_var_num = SyntaxTemplate.indexOf(tr.patternScope.pattern_names, form)) >= 0) {
                int op;
                int var_nesting = this.patternNesting.charAt(pattern_var_num);
                int n = op = (var_nesting & '\u0001') != 0 ? 3 : 2;
                if ((var_nesting >>= 1) > nesting) {
                    tr.syntaxError("inconsistent ... nesting of " + form);
                }
                template_program.append((char)(op + 8 * pattern_var_num));
                return var_nesting == nesting ? pattern_var_num : -1;
            }
        }
        Object xform = tr.namespaceResolve(form);
        Macro macro = tr.currentMacroDefinition;
        if (xform instanceof Symbol && macro != null && macro.capturedScope instanceof ModuleExp) {
            tr.noteAccess(xform, tr.currentScope());
        }
        form = SyntaxForms.makeWithTemplate(syntax2, form);
        if (template_program.length() == 0 && form instanceof PairWithPosition) {
            PairWithPosition pform = (PairWithPosition)form;
            form = new Pair(pform.getCar(), pform.getCdr());
        }
        if ((literals_index = SyntaxTemplate.indexOf(literals_vector, form)) < 0) {
            literals_index = literals_vector.size();
            literals_vector.addElement(form);
        }
        if (!(form instanceof SyntaxForm || form == ellipsis || form instanceof CharSequence || form instanceof Number || form instanceof Boolean)) {
            template_program.append('\u0018');
        }
        template_program.append((char)(4 + 8 * literals_index));
        return form == ellipsis ? -1 : -2;
    }

    static int indexOf(Vector vec, Object elem) {
        int len = vec.size();
        for (int i = 0; i < len; ++i) {
            if (vec.elementAt(i) != elem) continue;
            return i;
        }
        return -1;
    }

    private int get_count(Object var, int nesting, int[] indexes) {
        for (int level = 0; level < nesting; ++level) {
            var = ((Object[])var)[indexes[level]];
        }
        Object[] var_array = (Object[])var;
        return var_array.length;
    }

    public Object execute(Object[] vars, TemplateScope templateScope) {
        Object result = this.execute(0, vars, 0, new int[this.max_nesting], (Translator)Compilation.getCurrent(), templateScope);
        return result;
    }

    public Object execute(Object[] vars, Translator tr) {
        return this.execute(0, vars, 0, new int[this.max_nesting], tr, TemplateScope.make(tr, this.savedScope));
    }

    Object get_var(int var_num, Object[] vars, int[] indexes, Translator tr) {
        Object var = vars[var_num];
        if (var_num < this.patternNesting.length()) {
            int var_nesting = this.patternNesting.charAt(var_num) >> 1;
            for (int level = 0; level < var_nesting; ++level) {
                int ind = indexes[level];
                Object[] varr = (Object[])var;
                if (ind >= varr.length) {
                    String mname;
                    Syntax macro = tr.getCurrentSyntax();
                    String string = mname = macro == null ? null : macro.getName();
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

    LList executeToList(int pc, Object[] vars, int nesting, int[] indexes, Translator tr, TemplateScope templateScope) {
        int pc0 = pc;
        int ch = this.template_program.charAt(pc);
        while ((ch & 7) == 7) {
            ch = ch - 7 << 13 | this.template_program.charAt(++pc);
        }
        if ((ch & 7) == 3) {
            Pair p = (Pair)this.get_var(ch >> 3, vars, indexes, tr);
            return Translator.makePair(p, p.getCar(), LList.Empty);
        }
        if ((ch & 7) == 5) {
            int var_num = ch >> 3;
            Object var = vars[var_num];
            int count = this.get_count(var, nesting, indexes);
            LList result = LList.Empty;
            Pair last = null;
            ++pc;
            for (int j = 0; j < count; ++j) {
                indexes[nesting] = j;
                LList list = this.executeToList(pc, vars, nesting + 1, indexes, tr, templateScope);
                if (last == null) {
                    result = list;
                } else {
                    last.setCdrBackdoor(list);
                }
                while (list instanceof Pair) {
                    last = (Pair)list;
                    list = (LList)last.getCdr();
                }
            }
            return result;
        }
        Object v = this.execute(pc0, vars, nesting, indexes, tr, templateScope);
        return new Pair(v, LList.Empty);
    }

    Object execute(int pc, Object[] vars, int nesting, int[] indexes, Translator tr, TemplateScope templateScope) {
        int ch = this.template_program.charAt(pc);
        while ((ch & 7) == 7) {
            ch = ch - 7 << 13 | this.template_program.charAt(++pc);
        }
        if (ch == 8) {
            return this.executeToList(pc + 1, vars, nesting, indexes, tr, templateScope);
        }
        if (ch == 16) {
            return LList.Empty;
        }
        if (ch == 24) {
            Object v = this.execute(pc + 1, vars, nesting, indexes, tr, templateScope);
            return SyntaxForms.makeForm(v, templateScope);
        }
        if ((ch & 7) == 1) {
            Pair p = null;
            Object result = null;
            do {
                Object q = this.executeToList(++pc, vars, nesting, indexes, tr, templateScope);
                if (p == null) {
                    result = q;
                } else {
                    p.setCdrBackdoor(q);
                }
                while (q instanceof Pair) {
                    p = (Pair)q;
                    q = p.getCdr();
                }
            } while (((ch = (int)this.template_program.charAt(pc += ch >> 3)) & 7) == 1);
            Object cdr = this.execute(pc, vars, nesting, indexes, tr, templateScope);
            if (p == null) {
                result = cdr;
            } else {
                p.setCdrBackdoor(cdr);
            }
            return result;
        }
        if (ch == 40) {
            Object el = this.execute(pc + 1, vars, nesting, indexes, tr, templateScope);
            return new FVector((LList)el);
        }
        if ((ch & 7) == 4) {
            int lit_no = ch >> 3;
            return this.literal_values[lit_no];
        }
        if ((ch & 6) == 2) {
            Object var = this.get_var(ch >> 3, vars, indexes, tr);
            if ((ch & 7) == 3) {
                var = ((Pair)var).getCar();
            }
            return var;
        }
        throw new Error("unknown template code: " + ch + " at " + pc);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.patternNesting);
        out.writeObject(this.template_program);
        out.writeObject(this.literal_values);
        out.writeInt(this.max_nesting);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.patternNesting = (String)in.readObject();
        this.template_program = (String)in.readObject();
        this.literal_values = (Object[])in.readObject();
        this.max_nesting = in.readInt();
    }
}

