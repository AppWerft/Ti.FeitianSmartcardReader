// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.ModuleExp;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.Declaration;
import java.util.List;
import gnu.lists.FVector;
import gnu.text.SourceLocator;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Keyword;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import java.io.PrintWriter;
import gnu.expr.Compilation;
import java.io.File;
import java.util.Vector;
import gnu.lists.PrintConsumer;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.OutPort;
import gnu.mapping.SimpleSymbol;
import java.io.Externalizable;

public class SyntaxPattern extends Pattern implements Externalizable
{
    String program;
    String fileLine;
    public static final SimpleSymbol underscoreSymbol;
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
    public boolean match(final Object obj, final Object[] vars, final int start_vars) {
        final boolean r = this.match(obj, vars, start_vars, 0, null);
        if (SyntaxPattern.printSyntaxPatternMatch && r) {
            final OutPort log = OutPort.errDefault();
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
            }
            else {
                log.println(" -> failed");
            }
            log.endLogicalBlock("}");
            log.println();
        }
        return r;
    }
    
    public SyntaxPattern(final String program, final Object[] literals, final int varCount, final String fileLine) {
        this.program = program;
        this.literals = literals;
        this.varCount = varCount;
        this.fileLine = fileLine;
    }
    
    public SyntaxPattern(final Object pattern, final Object[] literal_identifiers, final Translator tr) {
        this(new StringBuilder(), pattern, null, SyntaxRule.dots3Symbol, literal_identifiers, tr);
    }
    
    SyntaxPattern(final StringBuilder programbuf, final Object pattern, final SyntaxForm syntax, final Object ellipsis, final Object[] literal_identifiers, final Translator tr) {
        final Vector literalsbuf = new Vector();
        this.translate(pattern, programbuf, ellipsis, literal_identifiers, 0, literalsbuf, null, '\0', tr);
        this.program = programbuf.toString();
        literalsbuf.copyInto(this.literals = new Object[literalsbuf.size()]);
        this.varCount = tr.patternScope.pattern_names.size();
        final String filename = tr.getFileName();
        final int fileslash = filename.replace(File.separatorChar, '/').lastIndexOf(47);
        this.fileLine = ((fileslash >= 0) ? filename.substring(fileslash + 1) : filename);
        final int line = tr.getLineNumber();
        if (line > 0) {
            this.fileLine = this.fileLine + ':' + line;
        }
    }
    
    public void disassemble() {
        this.disassemble(OutPort.errDefault(), (Translator)Compilation.getCurrent(), 0, this.program.length());
    }
    
    public void disassemble(final PrintWriter ps, final Translator tr) {
        this.disassemble(ps, tr, 0, this.program.length());
    }
    
    void disassemble(final PrintWriter ps, final Translator tr, final int start, final int limit) {
        Vector pattern_names = null;
        if (tr != null && tr.patternScope != null) {
            pattern_names = tr.patternScope.pattern_names;
        }
        int value = 0;
        int i = start;
        while (i < limit) {
            final char ch = this.program.charAt(i);
            ps.print(" " + i + ": " + (int)ch);
            ++i;
            final int opcode = ch & '\u0007';
            value = (value << 13 | ch >> 3);
            Label_0674: {
                switch (opcode) {
                    case 1: {
                        ps.println(" - WIDE " + value);
                        continue;
                    }
                    case 2: {
                        ps.print(" - EQUALS[" + value + "]");
                        if (this.literals != null && value >= 0 && value < this.literals.length) {
                            ps.print(this.literals[value]);
                        }
                        ps.println();
                        break Label_0674;
                    }
                    case 3:
                    case 7: {
                        ps.print(((opcode == 3) ? " - ANY[" : " - ANY_CAR[") + value + "]");
                        if (pattern_names != null && value >= 0 && value < pattern_names.size()) {
                            ps.print(pattern_names.elementAt(value));
                        }
                        ps.println();
                        break Label_0674;
                    }
                    case 4: {
                        ps.println(" - PAIR[" + value + "]");
                        break Label_0674;
                    }
                    case 5: {
                        ps.println(" - LREPEAT[" + value + "]");
                        this.disassemble(ps, tr, i, i + value);
                        i += value;
                        ps.println(" " + i + ": - repeat first var:" + (this.program.charAt(i++) >> 3));
                        ps.println(" " + i + ": - repeast nested vars:" + (this.program.charAt(i++) >> 3));
                        break Label_0674;
                    }
                    case 6: {
                        ps.println(" - LENGTH " + (value >> 1) + " pairs. " + (((value & 0x1) == 0x0) ? "pure list" : "impure list"));
                        break Label_0674;
                    }
                    case 0: {
                        ps.print("[misc ch:" + (int)ch + " n:" + 8 + "]");
                        if (ch == '\b') {
                            ps.println(" - NIL");
                            break Label_0674;
                        }
                        if (ch == '\u0010') {
                            ps.println(" - VECTOR");
                            break Label_0674;
                        }
                        if (ch == '\u0018') {
                            ps.println(" - IGNORE");
                            break Label_0674;
                        }
                        break;
                    }
                }
                ps.println(" - " + opcode + '/' + value);
            }
            value = 0;
        }
    }
    
    void translate(Object pattern, final StringBuilder program, final Object ellipsis, final Object[] literal_identifiers, final int nesting, final Vector literals, SyntaxForm syntax, char context, final Translator tr) {
        final PatternScope patternScope = tr.patternScope;
        final Vector patternNames = patternScope.pattern_names;
        while (true) {
            if (pattern instanceof SyntaxForm) {
                syntax = (SyntaxForm)pattern;
                pattern = syntax.getDatum();
            }
            else {
                if (pattern instanceof Pair) {
                    final Object savePos = tr.pushPositionOf(pattern);
                    try {
                        int start_pc = program.length();
                        program.append('\u0004');
                        final Pair pair = (Pair)pattern;
                        final SyntaxForm car_syntax = syntax;
                        Object next;
                        for (next = pair.getCdr(); next instanceof SyntaxForm; next = syntax.getDatum()) {
                            syntax = (SyntaxForm)next;
                        }
                        boolean repeat = false;
                        if (next instanceof Pair) {
                            final Pair nextPair = (Pair)next;
                            final Object nextCar = nextPair.getCar();
                            if (literalIdentifierEq(nextCar, (syntax == null) ? null : syntax.getScope(), ellipsis, null)) {
                                repeat = true;
                                for (next = nextPair.getCdr(); next instanceof SyntaxForm; next = syntax.getDatum()) {
                                    syntax = (SyntaxForm)next;
                                }
                            }
                        }
                        final int subvar0 = patternNames.size();
                        if (context == 'P') {
                            context = '\0';
                        }
                        this.translate(pair.getCar(), program, ellipsis, literal_identifiers, repeat ? (nesting + 1) : nesting, literals, car_syntax, (context == 'V') ? '\0' : 'P', tr);
                        final int subvarN = patternNames.size() - subvar0;
                        final int width = program.length() - start_pc - 1 << 3 | (repeat ? 5 : 4);
                        if (width > 65535) {
                            start_pc += insertInt(start_pc, program, (width >> 13) + 1);
                        }
                        program.setCharAt(start_pc, (char)width);
                        int restLength = Translator.listLength(next);
                        if (restLength == Integer.MIN_VALUE) {
                            tr.syntaxError("cyclic pattern list");
                            return;
                        }
                        if (repeat) {
                            addInt(program, subvar0 << 3);
                            addInt(program, subvarN << 3);
                            if (next == LList.Empty) {
                                program.append('\b');
                                return;
                            }
                            restLength = ((restLength >= 0) ? (restLength << 1) : ((-restLength << 1) - 1));
                            addInt(program, restLength << 3 | 0x6);
                        }
                        pattern = next;
                        continue;
                    }
                    finally {
                        tr.popPositionOf(savePos);
                    }
                }
                if (pattern instanceof Symbol && !(pattern instanceof Keyword)) {
                    final ScopeExp current = tr.currentScope();
                    final ScopeExp scope1 = (syntax == null) ? current : syntax.getScope();
                    int j = literal_identifiers.length;
                    while (--j >= 0) {
                        Object literal = literal_identifiers[j];
                        ScopeExp scope2;
                        if (literal instanceof SyntaxForm) {
                            final SyntaxForm syntax2 = (SyntaxForm)literal;
                            literal = syntax2.getDatum();
                            scope2 = syntax2.getScope();
                        }
                        else if (tr.currentMacroDefinition != null) {
                            scope2 = tr.currentMacroDefinition.getCapturedScope();
                        }
                        else {
                            scope2 = current;
                        }
                        if (literalIdentifierEq(pattern, scope1, literal, scope2)) {
                            int i = SyntaxTemplate.indexOf(literals, pattern);
                            if (i < 0) {
                                i = literals.size();
                                literals.addElement(pattern);
                            }
                            addInt(program, i << 3 | 0x2);
                            return;
                        }
                    }
                    if (literalIdentifierEq(pattern, scope1, SyntaxPattern.underscoreSymbol, null)) {
                        program.append('\u0018');
                        return;
                    }
                    if (patternNames.contains(pattern)) {
                        tr.syntaxError("duplicated pattern variable " + pattern);
                    }
                    final int k = patternNames.size();
                    patternNames.addElement(pattern);
                    final boolean matchCar = context == 'P';
                    final int n = (nesting << 1) + (matchCar ? 1 : 0);
                    patternScope.patternNesting.append((char)n);
                    final Declaration decl = patternScope.addDeclaration(pattern);
                    decl.setInitValue(QuoteExp.undefined_exp);
                    decl.setLocation(tr);
                    tr.push(decl);
                    addInt(program, k << 3 | (matchCar ? 7 : 3));
                }
                else {
                    if (pattern == LList.Empty) {
                        program.append('\b');
                        return;
                    }
                    if (!(pattern instanceof FVector)) {
                        int l = SyntaxTemplate.indexOf(literals, pattern);
                        if (l < 0) {
                            l = literals.size();
                            literals.addElement(pattern);
                        }
                        addInt(program, l << 3 | 0x2);
                        return;
                    }
                    program.append('\u0010');
                    pattern = LList.makeList((List)pattern);
                    context = 'V';
                }
            }
        }
    }
    
    private static void addInt(final StringBuilder sbuf, final int val) {
        if (val > 65535) {
            addInt(sbuf, (val << 13) + 1);
        }
        sbuf.append((char)val);
    }
    
    private static int insertInt(int offset, final StringBuilder sbuf, final int val) {
        if (val > 65535) {
            offset += insertInt(offset, sbuf, (val << 13) + 1);
        }
        sbuf.insert(offset, (char)val);
        return offset + 1;
    }
    
    boolean match_car(Pair p, final Object[] vars, final int start_vars, int pc, final SyntaxForm syntax) {
        final int pc_start = pc;
        char ch;
        int value;
        for (value = (ch = this.program.charAt(pc++)) >> 3; (ch & '\u0007') == 0x1; value = (value << 13 | (ch = this.program.charAt(pc++)) >> 3)) {}
        if ((ch & '\u0007') == 0x7) {
            if (syntax != null && !(p.getCar() instanceof SyntaxForm)) {
                p = Translator.makePair(p, SyntaxForms.fromDatum(p.getCar(), syntax), p.getCdr());
            }
            vars[start_vars + value] = p;
            return true;
        }
        return this.match(p.getCar(), vars, start_vars, pc_start, syntax);
    }
    
    public boolean match(Object obj, final Object[] vars, final int start_vars, int pc, SyntaxForm syntax) {
        int value = 0;
        Label_0900: {
            Label_0879: {
                Label_0800: {
                Label_0003:
                    while (true) {
                        while (true) {
                            if (obj instanceof SyntaxForm) {
                                syntax = (SyntaxForm)obj;
                                obj = syntax.getDatum();
                            }
                            else {
                                char ch = this.program.charAt(pc++);
                                final int opcode = ch & '\u0007';
                                value = (value << 13 | ch >> 3);
                                switch (opcode) {
                                    case 1: {
                                        continue;
                                    }
                                    case 0: {
                                        if (ch == '\b') {
                                            return obj == LList.Empty;
                                        }
                                        if (ch == '\u0010') {
                                            return obj instanceof FVector && this.match(LList.makeList((List)obj), vars, start_vars, pc, syntax);
                                        }
                                        if (ch == '\u0018') {
                                            return true;
                                        }
                                        throw new Error("unknown pattern opcode");
                                    }
                                    case 8: {
                                        return obj == LList.Empty;
                                    }
                                    case 6: {
                                        final int npairs = value >> 1;
                                        Object o = obj;
                                        int i = 0;
                                        while (true) {
                                            if (o instanceof SyntaxForm) {
                                                o = ((SyntaxForm)o).getDatum();
                                            }
                                            else {
                                                if (i == npairs) {
                                                    if ((value & 0x1) == 0x0) {
                                                        if (o != LList.Empty) {
                                                            break Label_0003;
                                                        }
                                                    }
                                                    else if (o instanceof Pair) {
                                                        break Label_0003;
                                                    }
                                                    value = 0;
                                                    continue Label_0003;
                                                }
                                                if (!(o instanceof Pair)) {
                                                    return false;
                                                }
                                                o = ((Pair)o).getCdr();
                                                ++i;
                                            }
                                        }
                                        break;
                                    }
                                    case 4: {
                                        if (!(obj instanceof Pair)) {
                                            return false;
                                        }
                                        final Pair p = (Pair)obj;
                                        if (!this.match_car(p, vars, start_vars, pc, syntax)) {
                                            return false;
                                        }
                                        pc += value;
                                        value = 0;
                                        obj = p.getCdr();
                                        continue;
                                    }
                                    case 5: {
                                        final int repeat_pc = pc;
                                        int subvar0;
                                        for (pc += value, subvar0 = (ch = this.program.charAt(pc++)) >> 3; (ch & '\u0007') == 0x1; subvar0 = (subvar0 << 13 | (ch = this.program.charAt(pc++)) >> 3)) {}
                                        subvar0 += start_vars;
                                        int subvarN;
                                        for (subvarN = this.program.charAt(pc++) >> 3; (ch & '\u0007') == 0x1; subvarN = (subvarN << 13 | (ch = this.program.charAt(pc++)) >> 3)) {}
                                        ch = this.program.charAt(pc++);
                                        boolean listRequired = true;
                                        int pairsRequired;
                                        if (ch == '\b') {
                                            pairsRequired = 0;
                                        }
                                        else {
                                            for (value = ch >> 3; (ch & '\u0007') == 0x1; value = (value << 13 | (ch = this.program.charAt(pc++)) >> 3)) {}
                                            if ((value & 0x1) != 0x0) {
                                                listRequired = false;
                                            }
                                            pairsRequired = value >> 1;
                                        }
                                        int pairsValue = Translator.listLength(obj);
                                        boolean listValue;
                                        if (pairsValue >= 0) {
                                            listValue = true;
                                        }
                                        else {
                                            listValue = false;
                                            pairsValue = -1 - pairsValue;
                                        }
                                        if (pairsValue < pairsRequired || (listRequired && !listValue)) {
                                            return false;
                                        }
                                        final int repeat_count = pairsValue - pairsRequired;
                                        final Object[][] arrays = new Object[subvarN][];
                                        for (int j = 0; j < subvarN; ++j) {
                                            arrays[j] = new Object[repeat_count];
                                        }
                                        for (int k = 0; k < repeat_count; ++k) {
                                            while (obj instanceof SyntaxForm) {
                                                syntax = (SyntaxForm)obj;
                                                obj = syntax.getDatum();
                                            }
                                            final Pair p = (Pair)obj;
                                            if (!this.match_car(p, vars, start_vars, repeat_pc, syntax)) {
                                                return false;
                                            }
                                            obj = p.getCdr();
                                            for (int l = 0; l < subvarN; ++l) {
                                                arrays[l][k] = vars[subvar0 + l];
                                            }
                                        }
                                        for (int j = 0; j < subvarN; ++j) {
                                            vars[subvar0 + j] = arrays[j];
                                        }
                                        value = 0;
                                        if (pairsRequired == 0 && listRequired) {
                                            return true;
                                        }
                                        continue;
                                    }
                                    case 2: {
                                        break Label_0800;
                                    }
                                    case 3: {
                                        break Label_0879;
                                    }
                                    default: {
                                        break Label_0900;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return false;
                }
                final Object lit = this.literals[value];
                final Translator tr = (Translator)Compilation.getCurrent();
                final Syntax curSyntax = tr.getCurrentSyntax();
                final ScopeExp sc1 = (curSyntax instanceof Macro) ? ((Macro)curSyntax).getCapturedScope() : null;
                final ScopeExp sc2 = (syntax == null) ? tr.currentScope() : syntax.getScope();
                return literalIdentifierEq(lit, sc1, obj, sc2);
            }
            if (syntax != null) {
                obj = SyntaxForms.fromDatum(obj, syntax);
            }
            vars[start_vars + value] = obj;
            return true;
        }
        this.disassemble();
        throw new Error("unrecognized pattern opcode @pc:" + pc);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.program);
        out.writeObject(this.literals);
        out.writeInt(this.varCount);
        out.writeUTF((this.fileLine == null) ? "" : this.fileLine);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.literals = (Object[])in.readObject();
        this.program = (String)in.readObject();
        this.varCount = in.readInt();
        final String fline = in.readUTF();
        if (fline != null) {
            this.fileLine = fline;
        }
    }
    
    public static Object[] allocVars(final int varCount, final Object[] outer) {
        final Object[] vars = new Object[varCount];
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
            final SyntaxForm form1 = (SyntaxForm)id1;
            id1 = form1.getDatum();
            sc1 = form1.getScope();
        }
        if (id2 instanceof SyntaxForm) {
            final SyntaxForm form2 = (SyntaxForm)id2;
            id2 = form2.getDatum();
            sc2 = form2.getScope();
        }
        if (id1 != id2 && (id1 == null || id2 == null || !id1.equals(id2))) {
            return false;
        }
        if (sc1 == sc2) {
            return true;
        }
        Declaration d1 = null;
        Declaration d2 = null;
        while (sc1 != null && !(sc1 instanceof ModuleExp)) {
            d1 = sc1.lookup(id1);
            if (d1 != null) {
                break;
            }
            sc1 = sc1.getOuter();
        }
        while (sc2 != null && !(sc2 instanceof ModuleExp)) {
            d2 = sc2.lookup(id2);
            if (d2 != null) {
                break;
            }
            sc2 = sc2.getOuter();
        }
        return d1 == d2;
    }
    
    public static Object[] getLiteralsList(Object list, SyntaxForm syntax, final Translator tr) {
        final Object savePos = tr.pushPositionOf(list);
        int count = Translator.listLength(list);
        if (count < 0) {
            tr.error('e', "missing or malformed literals list");
            count = 0;
        }
        final Object[] literals = new Object[count];
        for (int i = 0; i < count; ++i) {
            while (list instanceof SyntaxForm) {
                syntax = (SyntaxForm)list;
                list = syntax.getDatum();
            }
            final Pair pair = (Pair)list;
            tr.pushPositionOf(pair);
            Object literal = pair.getCar();
            final Object wrapped = SyntaxForms.fromDatumIfNeeded(literal, syntax);
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
    
    @Override
    public String toString() {
        final StringBuilder sbuf = new StringBuilder("#<syntax-pattern");
        if (this.fileLine != null) {
            sbuf.append(' ');
            sbuf.append(this.fileLine);
        }
        sbuf.append('>');
        return sbuf.toString();
    }
    
    static {
        underscoreSymbol = Symbol.valueOf("_");
    }
}
