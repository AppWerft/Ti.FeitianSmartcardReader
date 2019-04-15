/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.OutPort;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PrintConsumer;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.io.Externalizable;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.util.Vector;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.PatternScope;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class SyntaxPattern
extends Pattern
implements Externalizable {
    String program;
    String fileLine;
    public static final SimpleSymbol underscoreSymbol = Symbol.valueOf("_");
    static final int MATCH_MISC = 0;
    static final int MATCH_NIL = 8;
    static final int MATCH_VECTOR = 16;
    static final int MATCH_IGNORE = 24;
    static final int MATCH_WIDE = 1;
    static final int MATCH_EQUALS = 2;
    static final int MATCH_ANY = 3;
    static final int MATCH_PAIR = 4;
    static final int MATCH_LREPEAT = 5;
    static final int MATCH_LENGTH = 6;
    static final int MATCH_ANY_CAR = 7;
    Object[] literals;
    int varCount;
    public static boolean printSyntaxPatternMatch;

    @Override
    public int varCount() {
        return this.varCount;
    }

    @Override
    public boolean match(Object obj, Object[] vars, int start_vars) {
        boolean r = this.match(obj, vars, start_vars, 0, null);
        if (printSyntaxPatternMatch && r) {
            OutPort log = OutPort.errDefault();
            log.startLogicalBlock("{syntax-pattern ", false, "}");
            log.setIndentation(-14, false);
            if (this.fileLine != null) {
                log.print(this.fileLine);
            }
            log.writeSpaceLinear();
            log.print("match ");
            DisplayFormat.schemeWriteFormat.writeObject(obj, log);
            if (r) {
                log.print(" -> vars: ");
                for (int i = start_vars; i < vars.length; ++i) {
                    log.writeSpaceLinear();
                    log.print(i);
                    log.print(": ");
                    DisplayFormat.schemeWriteFormat.writeObject(vars[i], log);
                }
            } else {
                log.println(" -> failed");
            }
            log.endLogicalBlock("}");
            log.println();
        }
        return r;
    }

    public SyntaxPattern(String program, Object[] literals, int varCount, String fileLine) {
        this.program = program;
        this.literals = literals;
        this.varCount = varCount;
        this.fileLine = fileLine;
    }

    public SyntaxPattern(Object pattern, Object[] literal_identifiers, Translator tr) {
        this(new StringBuilder(), pattern, null, SyntaxRule.dots3Symbol, literal_identifiers, tr);
    }

    SyntaxPattern(StringBuilder programbuf, Object pattern, SyntaxForm syntax2, Object ellipsis, Object[] literal_identifiers, Translator tr) {
        Vector literalsbuf = new Vector();
        this.translate(pattern, programbuf, ellipsis, literal_identifiers, 0, literalsbuf, null, '\u0000', tr);
        this.program = programbuf.toString();
        this.literals = new Object[literalsbuf.size()];
        literalsbuf.copyInto(this.literals);
        this.varCount = tr.patternScope.pattern_names.size();
        String filename = tr.getFileName();
        int fileslash = filename.replace(File.separatorChar, '/').lastIndexOf(47);
        this.fileLine = fileslash >= 0 ? filename.substring(fileslash + 1) : filename;
        int line = tr.getLineNumber();
        if (line > 0) {
            this.fileLine = this.fileLine + ':' + line;
        }
    }

    public void disassemble() {
        this.disassemble(OutPort.errDefault(), (Translator)Compilation.getCurrent(), 0, this.program.length());
    }

    public void disassemble(PrintWriter ps, Translator tr) {
        this.disassemble(ps, tr, 0, this.program.length());
    }

    void disassemble(PrintWriter ps, Translator tr, int start, int limit) {
        Vector pattern_names = null;
        if (tr != null && tr.patternScope != null) {
            pattern_names = tr.patternScope.pattern_names;
        }
        int value = 0;
        int i = start;
        block9 : while (i < limit) {
            char ch = this.program.charAt(i);
            ps.print(" " + i + ": " + ch);
            ++i;
            int opcode = ch & 7;
            value = value << 13 | ch >> 3;
            switch (opcode) {
                case 1: {
                    ps.println(" - WIDE " + value);
                    continue block9;
                }
                case 2: {
                    ps.print(" - EQUALS[" + value + "]");
                    if (this.literals != null && value >= 0 && value < this.literals.length) {
                        ps.print(this.literals[value]);
                    }
                    ps.println();
                    break;
                }
                case 3: 
                case 7: {
                    ps.print((opcode == 3 ? " - ANY[" : " - ANY_CAR[") + value + "]");
                    if (pattern_names != null && value >= 0 && value < pattern_names.size()) {
                        ps.print(pattern_names.elementAt(value));
                    }
                    ps.println();
                    break;
                }
                case 4: {
                    ps.println(" - PAIR[" + value + "]");
                    break;
                }
                case 5: {
                    ps.println(" - LREPEAT[" + value + "]");
                    this.disassemble(ps, tr, i, i + value);
                    ps.println(" " + (i += value) + ": - repeat first var:" + (this.program.charAt(i++) >> 3));
                    ps.println(" " + i + ": - repeast nested vars:" + (this.program.charAt(i++) >> 3));
                    break;
                }
                case 6: {
                    ps.println(" - LENGTH " + (value >> 1) + " pairs. " + ((value & 1) == 0 ? "pure list" : "impure list"));
                    break;
                }
                case 0: {
                    ps.print("[misc ch:" + ch + " n:" + 8 + "]");
                    if (ch == '\b') {
                        ps.println(" - NIL");
                        break;
                    }
                    if (ch == '\u0010') {
                        ps.println(" - VECTOR");
                        break;
                    }
                    if (ch == '\u0018') {
                        ps.println(" - IGNORE");
                        break;
                    }
                }
                default: {
                    ps.println(" - " + opcode + '/' + value);
                }
            }
            value = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void translate(Object pattern, StringBuilder program, Object ellipsis, Object[] literal_identifiers, int nesting, Vector literals, SyntaxForm syntax2, char context, Translator tr) {
        PatternScope patternScope = tr.patternScope;
        Vector patternNames = patternScope.pattern_names;
        do {
            if (pattern instanceof SyntaxForm) {
                syntax2 = (SyntaxForm)pattern;
                pattern = syntax2.getDatum();
                continue;
            }
            if (pattern instanceof Pair) {
                Object savePos = tr.pushPositionOf(pattern);
                try {
                    Pair nextPair;
                    Object nextCar;
                    int start_pc = program.length();
                    program.append('\u0004');
                    Pair pair = (Pair)pattern;
                    SyntaxForm car_syntax = syntax2;
                    Object next = pair.getCdr();
                    while (next instanceof SyntaxForm) {
                        syntax2 = (SyntaxForm)next;
                        next = syntax2.getDatum();
                    }
                    boolean repeat = false;
                    if (next instanceof Pair && SyntaxPattern.literalIdentifierEq(nextCar = (nextPair = (Pair)next).getCar(), syntax2 == null ? null : syntax2.getScope(), ellipsis, null)) {
                        repeat = true;
                        next = nextPair.getCdr();
                        while (next instanceof SyntaxForm) {
                            syntax2 = (SyntaxForm)next;
                            next = syntax2.getDatum();
                        }
                    }
                    int subvar0 = patternNames.size();
                    if (context == 'P') {
                        context = '\u0000';
                    }
                    this.translate(pair.getCar(), program, ellipsis, literal_identifiers, repeat ? nesting + 1 : nesting, literals, car_syntax, context == 'V' ? (char)'\u0000' : 'P', tr);
                    int subvarN = patternNames.size() - subvar0;
                    int width = program.length() - start_pc - 1 << 3 | (repeat ? 5 : 4);
                    if (width > 65535) {
                        start_pc += SyntaxPattern.insertInt(start_pc, program, (width >> 13) + 1);
                    }
                    program.setCharAt(start_pc, (char)width);
                    int restLength = Translator.listLength(next);
                    if (restLength == Integer.MIN_VALUE) {
                        tr.syntaxError("cyclic pattern list");
                        return;
                    }
                    if (repeat) {
                        SyntaxPattern.addInt(program, subvar0 << 3);
                        SyntaxPattern.addInt(program, subvarN << 3);
                        if (next == LList.Empty) {
                            program.append('\b');
                            return;
                        }
                        restLength = restLength >= 0 ? restLength << 1 : (-restLength << 1) - 1;
                        SyntaxPattern.addInt(program, restLength << 3 | 6);
                    }
                    pattern = next;
                }
                finally {
                    tr.popPositionOf(savePos);
                }
                continue;
            }
            if (pattern instanceof Symbol && !(pattern instanceof Keyword)) {
                ScopeExp current = tr.currentScope();
                ScopeExp scope1 = syntax2 == null ? current : syntax2.getScope();
                int j = literal_identifiers.length;
                while (--j >= 0) {
                    ScopeExp scope2;
                    Object literal = literal_identifiers[j];
                    if (literal instanceof SyntaxForm) {
                        SyntaxForm syntax22 = (SyntaxForm)literal;
                        literal = syntax22.getDatum();
                        scope2 = syntax22.getScope();
                    } else {
                        scope2 = tr.currentMacroDefinition != null ? tr.currentMacroDefinition.getCapturedScope() : current;
                    }
                    if (!SyntaxPattern.literalIdentifierEq(pattern, scope1, literal, scope2)) continue;
                    int i = SyntaxTemplate.indexOf(literals, pattern);
                    if (i < 0) {
                        i = literals.size();
                        literals.addElement(pattern);
                    }
                    SyntaxPattern.addInt(program, i << 3 | 2);
                    return;
                }
                if (SyntaxPattern.literalIdentifierEq(pattern, scope1, underscoreSymbol, null)) {
                    program.append('\u0018');
                    return;
                }
                if (patternNames.contains(pattern)) {
                    tr.syntaxError("duplicated pattern variable " + pattern);
                }
                int i = patternNames.size();
                patternNames.addElement(pattern);
                boolean matchCar = context == 'P';
                int n = (nesting << 1) + (matchCar ? 1 : 0);
                patternScope.patternNesting.append((char)n);
                Declaration decl = patternScope.addDeclaration(pattern);
                decl.setInitValue(QuoteExp.undefined_exp);
                decl.setLocation(tr);
                tr.push(decl);
                SyntaxPattern.addInt(program, i << 3 | (matchCar ? 7 : 3));
                return;
            }
            if (pattern == LList.Empty) {
                program.append('\b');
                return;
            }
            if (!(pattern instanceof FVector)) break;
            program.append('\u0010');
            pattern = LList.makeList((FVector)pattern);
            context = (char)86;
        } while (true);
        int i = SyntaxTemplate.indexOf(literals, pattern);
        if (i < 0) {
            i = literals.size();
            literals.addElement(pattern);
        }
        SyntaxPattern.addInt(program, i << 3 | 2);
    }

    private static void addInt(StringBuilder sbuf, int val) {
        if (val > 65535) {
            SyntaxPattern.addInt(sbuf, (val << 13) + 1);
        }
        sbuf.append((char)val);
    }

    private static int insertInt(int offset, StringBuilder sbuf, int val) {
        if (val > 65535) {
            offset += SyntaxPattern.insertInt(offset, sbuf, (val << 13) + 1);
        }
        sbuf.insert(offset, (char)val);
        return offset + 1;
    }

    boolean match_car(Pair p, Object[] vars, int start_vars, int pc, SyntaxForm syntax2) {
        int pc_start = pc;
        char ch = this.program.charAt(pc++);
        int value = ch >> 3;
        while ((ch & 7) == 1) {
            ch = this.program.charAt(pc++);
            value = value << 13 | ch >> 3;
        }
        if ((ch & 7) == 7) {
            if (syntax2 != null && !(p.getCar() instanceof SyntaxForm)) {
                p = Translator.makePair(p, SyntaxForms.fromDatum(p.getCar(), syntax2), p.getCdr());
            }
            vars[start_vars + value] = p;
            return true;
        }
        return this.match(p.getCar(), vars, start_vars, pc_start, syntax2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean match(Object obj, Object[] vars, int start_vars, int pc, SyntaxForm syntax2) {
        int value = 0;
        block10 : do {
            if (obj instanceof SyntaxForm) {
                syntax2 = (SyntaxForm)obj;
                obj = syntax2.getDatum();
                continue;
            }
            char ch = this.program.charAt(pc++);
            int opcode = ch & 7;
            value = value << 13 | ch >> 3;
            switch (opcode) {
                Pair p;
                case 1: {
                    continue block10;
                }
                case 0: {
                    if (ch == '\b') {
                        if (obj != LList.Empty) return false;
                        return true;
                    }
                    if (ch == '\u0010') {
                        if (obj instanceof FVector) return this.match(LList.makeList((FVector)obj), vars, start_vars, pc, syntax2);
                        return false;
                    }
                    if (ch != '\u0018') throw new Error("unknown pattern opcode");
                    return true;
                }
                case 8: {
                    if (obj != LList.Empty) return false;
                    return true;
                }
                case 6: {
                    int npairs = value >> 1;
                    Object o = obj;
                    int i = 0;
                    do {
                        if (o instanceof SyntaxForm) {
                            o = ((SyntaxForm)o).getDatum();
                            continue;
                        }
                        if (i == npairs) {
                            if (!((value & 1) == 0 ? o != LList.Empty : o instanceof Pair)) break;
                            return false;
                        }
                        if (!(o instanceof Pair)) return false;
                        o = ((Pair)o).getCdr();
                        ++i;
                    } while (true);
                    value = 0;
                    continue block10;
                }
                case 4: {
                    if (!(obj instanceof Pair)) {
                        return false;
                    }
                    p = (Pair)obj;
                    if (!this.match_car(p, vars, start_vars, pc, syntax2)) {
                        return false;
                    }
                    pc += value;
                    value = 0;
                    obj = p.getCdr();
                    continue block10;
                }
                case 5: {
                    int j;
                    boolean listValue;
                    int pairsRequired;
                    int repeat_pc = pc;
                    pc += value;
                    ch = this.program.charAt(pc++);
                    int subvar0 = ch >> 3;
                    while ((ch & 7) == 1) {
                        ch = this.program.charAt(pc++);
                        subvar0 = subvar0 << 13 | ch >> 3;
                    }
                    subvar0 += start_vars;
                    int subvarN = this.program.charAt(pc++) >> 3;
                    while ((ch & 7) == 1) {
                        ch = this.program.charAt(pc++);
                        subvarN = subvarN << 13 | ch >> 3;
                    }
                    ch = this.program.charAt(pc++);
                    boolean listRequired = true;
                    if (ch == '\b') {
                        pairsRequired = 0;
                    } else {
                        value = ch >> 3;
                        while ((ch & 7) == 1) {
                            ch = this.program.charAt(pc++);
                            value = value << 13 | ch >> 3;
                        }
                        if ((value & 1) != 0) {
                            listRequired = false;
                        }
                        pairsRequired = value >> 1;
                    }
                    int pairsValue = Translator.listLength(obj);
                    if (pairsValue >= 0) {
                        listValue = true;
                    } else {
                        listValue = false;
                        pairsValue = -1 - pairsValue;
                    }
                    if (pairsValue < pairsRequired) return false;
                    if (listRequired && !listValue) {
                        return false;
                    }
                    int repeat_count = pairsValue - pairsRequired;
                    Object[][] arrays2 = new Object[subvarN][];
                    for (j = 0; j < subvarN; ++j) {
                        arrays2[j] = new Object[repeat_count];
                    }
                    for (int i = 0; i < repeat_count; ++i) {
                        while (obj instanceof SyntaxForm) {
                            syntax2 = (SyntaxForm)obj;
                            obj = syntax2.getDatum();
                        }
                        p = (Pair)obj;
                        if (!this.match_car(p, vars, start_vars, repeat_pc, syntax2)) {
                            return false;
                        }
                        obj = p.getCdr();
                        for (int j2 = 0; j2 < subvarN; ++j2) {
                            arrays2[j2][i] = vars[subvar0 + j2];
                        }
                    }
                    for (j = 0; j < subvarN; ++j) {
                        vars[subvar0 + j] = arrays2[j];
                    }
                    value = 0;
                    if (pairsRequired == 0 && listRequired) return true;
                    continue block10;
                }
                case 2: {
                    Object lit = this.literals[value];
                    Translator tr = (Translator)Compilation.getCurrent();
                    Syntax curSyntax = tr.getCurrentSyntax();
                    ScopeExp sc1 = curSyntax instanceof Macro ? ((Macro)curSyntax).getCapturedScope() : null;
                    ScopeExp sc2 = syntax2 == null ? tr.currentScope() : syntax2.getScope();
                    return SyntaxPattern.literalIdentifierEq(lit, sc1, obj, sc2);
                }
                case 3: {
                    if (syntax2 != null) {
                        obj = SyntaxForms.fromDatum(obj, syntax2);
                    }
                    vars[start_vars + value] = obj;
                    return true;
                }
            }
            break;
        } while (true);
        this.disassemble();
        throw new Error("unrecognized pattern opcode @pc:" + pc);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.program);
        out.writeObject(this.literals);
        out.writeInt(this.varCount);
        out.writeUTF(this.fileLine == null ? "" : this.fileLine);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.literals = (Object[])in.readObject();
        this.program = (String)in.readObject();
        this.varCount = in.readInt();
        String fline = in.readUTF();
        if (fline != null) {
            this.fileLine = fline;
        }
    }

    public static Object[] allocVars(int varCount, Object[] outer) {
        Object[] vars = new Object[varCount];
        if (outer != null) {
            int toCopy = outer.length;
            if (toCopy > varCount) {
                toCopy = varCount;
            }
            System.arraycopy(outer, 0, vars, 0, toCopy);
        }
        return vars;
    }

    public static boolean literalIdentifierEq(Object id1, ScopeExp sc1, Object id2, ScopeExp sc2) {
        if (id1 instanceof SyntaxForm) {
            SyntaxForm form1 = (SyntaxForm)id1;
            id1 = form1.getDatum();
            sc1 = form1.getScope();
        }
        if (id2 instanceof SyntaxForm) {
            SyntaxForm form2 = (SyntaxForm)id2;
            id2 = form2.getDatum();
            sc2 = form2.getScope();
        }
        if (!(id1 == id2 || id1 != null && id2 != null && id1.equals(id2))) {
            return false;
        }
        if (sc1 == sc2) {
            return true;
        }
        Declaration d1 = null;
        Declaration d2 = null;
        while (sc1 != null && !(sc1 instanceof ModuleExp) && (d1 = sc1.lookup(id1)) == null) {
            sc1 = sc1.getOuter();
        }
        while (sc2 != null && !(sc2 instanceof ModuleExp) && (d2 = sc2.lookup(id2)) == null) {
            sc2 = sc2.getOuter();
        }
        return d1 == d2;
    }

    public static Object[] getLiteralsList(Object list, SyntaxForm syntax2, Translator tr) {
        Object savePos = tr.pushPositionOf(list);
        int count = Translator.listLength(list);
        if (count < 0) {
            tr.error('e', "missing or malformed literals list");
            count = 0;
        }
        Object[] literals = new Object[count];
        for (int i = 0; i < count; ++i) {
            while (list instanceof SyntaxForm) {
                syntax2 = (SyntaxForm)list;
                list = syntax2.getDatum();
            }
            Pair pair = (Pair)list;
            tr.pushPositionOf(pair);
            Object literal = pair.getCar();
            Object wrapped = SyntaxForms.fromDatumIfNeeded(literal, syntax2);
            literal = Translator.stripSyntax(literal);
            if (!(literal instanceof Symbol)) {
                tr.error('e', "non-symbol '" + literal + "' in literals list");
            }
            literals[i] = wrapped;
            list = pair.getCdr();
        }
        tr.popPositionOf(savePos);
        return literals;
    }

    public String toString() {
        StringBuilder sbuf = new StringBuilder("#<syntax-pattern");
        if (this.fileLine != null) {
            sbuf.append(' ');
            sbuf.append(this.fileLine);
        }
        sbuf.append('>');
        return sbuf.toString();
    }
}

