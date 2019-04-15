/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.text.SourceMessages;
import gnu.xml.XMLFilter;
import java.io.IOException;
import java.io.InputStream;

public class XMLParser {
    private static final int EXPECT_NAME_MODIFIER = 1;
    private static final int SKIP_SPACES_MODIFIER = 2;
    private static final int INIT_STATE = 0;
    private static final int TEXT_STATE = 1;
    private static final int BEGIN_ELEMENT_STATE = 2;
    private static final int END_ELEMENT_STATE = 4;
    private static final int SAW_ENTITY_REF = 6;
    private static final int ATTRIBUTE_SEEN_NAME_STATE = 8;
    private static final int MAYBE_ATTRIBUTE_STATE = 10;
    private static final int ATTRIBUTE_SEEN_EQ_STATE = 11;
    private static final int DOCTYPE_SEEN_STATE = 13;
    private static final int DOCTYPE_NAME_SEEN_STATE = 16;
    private static final int SAW_LEFT_STATE = 14;
    private static final int SAW_LEFT_SLASH_STATE = 19;
    private static final int SAW_LEFT_EXCL_STATE = 20;
    private static final int SAW_LEFT_QUEST_STATE = 21;
    private static final int SAW_LEFT_EXCL_MINUS_STATE = 22;
    private static final int SAW_AMP_STATE = 25;
    private static final int SAW_AMP_SHARP_STATE = 26;
    private static final int EXPECT_RIGHT_STATE = 27;
    private static final int PREV_WAS_CR_STATE = 28;
    private static final int INIT_LEFT_QUEST_STATE = 30;
    private static final int INIT_TEXT_STATE = 31;
    private static final int INIT_LEFT_STATE = 34;
    private static final int INVALID_VERSION_DECL = 35;
    private static final int SAW_ERROR = 36;
    private static final int SAW_EOF_ERROR = 37;
    private static final int MISSING_XML_DECL = 38;
    static final String BAD_ENCODING_SYNTAX = "bad 'encoding' declaration";
    static final String BAD_STANDALONE_SYNTAX = "bad 'standalone' declaration";

    public static void parse(Object uri, SourceMessages messages, Consumer out) throws IOException {
        XMLParser.parse(Path.openInputStream(uri), uri, messages, out);
    }

    public static BinaryInPort XMLStreamReader(InputStream strm) throws IOException {
        BinaryInPort in = new BinaryInPort(strm);
        in.setFromByteOrderMark();
        in.setKeepFullLines(false);
        return in;
    }

    public static void parse(InputStream strm, Object uri, SourceMessages messages, Consumer out) throws IOException {
        BinaryInPort in = XMLParser.XMLStreamReader(strm);
        if (uri != null) {
            in.setName(uri);
        }
        XMLParser.parse((InPort)in, messages, out);
        in.close();
    }

    public static void parse(InPort in, SourceMessages messages, Consumer out) throws IOException {
        XMLFilter filter = new XMLFilter(out);
        filter.setMessages(messages);
        filter.setSourceLocator(in);
        filter.startDocument();
        Path uri = in.getPath();
        if (uri != null) {
            filter.writeDocumentUri(uri);
        }
        XMLParser.parse(in, filter);
        filter.endDocument();
    }

    public static void parse(InPort in, SourceMessages messages, XMLFilter filter) throws IOException {
        filter.setMessages(messages);
        filter.setSourceLocator(in);
        filter.startDocument();
        Path uri = in.getPath();
        if (uri != null) {
            filter.writeDocumentUri(uri);
        }
        XMLParser.parse(in, filter);
        filter.endDocument();
        in.close();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void parse(InPort in, XMLFilter out) {
        buffer = in.buffer;
        pos = in.pos;
        limit = in.limit;
        strict = false;
        state = 0;
        terminator = '<';
        continue_state = 14;
        ch = ' ';
        length = 0;
        dstart = -1;
        message = null;
        start = -1;
        block30 : do {
            block128 : {
                block134 : {
                    block130 : {
                        block136 : {
                            block137 : {
                                block133 : {
                                    block135 : {
                                        block131 : {
                                            block129 : {
                                                switch (state) {
                                                    case 0: {
                                                        state = 31;
                                                        break block128;
                                                    }
                                                    case 31: {
                                                        if (ch != 60) ** GOTO lbl22
                                                        state = 34;
                                                        break block128;
lbl22: // 1 sources:
                                                        state = strict != false ? 38 : 1;
                                                        continue block30;
                                                    }
                                                    case 34: {
                                                        if (ch != 63) ** GOTO lbl29
                                                        start = pos;
                                                        state = 33;
                                                        break block128;
lbl29: // 1 sources:
                                                        state = strict != false ? 38 : 14;
                                                        continue block30;
                                                    }
                                                    case 38: {
                                                        message = "missing XML declaration";
                                                        state = 36;
                                                        continue block30;
                                                    }
                                                    case 35: {
                                                        pos = dstart;
                                                        message = "invalid xml version specifier";
                                                        state = 36;
                                                        continue block30;
                                                    }
                                                    case 36: {
                                                        in.pos = pos;
                                                        start = -1;
                                                        out.error('e', message);
                                                        do {
                                                            if (pos < limit) continue;
                                                            return;
                                                        } while ((ch = buffer[pos++]) != 62);
                                                        state = 1;
                                                        break block128;
                                                    }
                                                    case 37: {
                                                        in.pos = pos;
                                                        out.error('f', "unexpected end-of-file");
                                                        return;
                                                    }
                                                    case 1: {
                                                        start = pos - 1;
                                                        length = pos;
                                                        do {
                                                            if (ch == terminator) {
                                                                state = continue_state;
                                                                break;
                                                            }
                                                            if (ch == '&') {
                                                                state = 25;
                                                                break;
                                                            }
                                                            if (ch != 13) ** GOTO lbl89
                                                            length = pos - length;
                                                            in.pos = pos;
                                                            if (length > 0) {
                                                                out.textFromParser(buffer, start, length);
                                                            }
                                                            if (pos < limit) {
                                                                ch = buffer[pos];
                                                                if (ch == '\n') {
                                                                    start = pos++;
                                                                    length = pos;
                                                                } else {
                                                                    out.linefeedFromParser();
                                                                    if (ch == '\u0085') {
                                                                        start = pos++;
                                                                        length = pos + 1;
                                                                    } else {
                                                                        in.incrLineNumber(1, pos);
                                                                        start = pos++;
                                                                        length = pos;
                                                                        continue;
                                                                    }
                                                                }
                                                                in.incrLineNumber(1, pos);
                                                            } else {
                                                                out.linefeedFromParser();
                                                                state = 28;
                                                                break block128;
lbl89: // 1 sources:
                                                                if (ch == '\u0085' || ch == '\u2028') {
                                                                    length = pos - length;
                                                                    in.pos = pos - 1;
                                                                    if (length > 0) {
                                                                        out.textFromParser(buffer, start, length);
                                                                    }
                                                                    out.linefeedFromParser();
                                                                    in.incrLineNumber(1, pos);
                                                                    length = pos + 1;
                                                                    start = pos;
                                                                } else if (ch == '\n') {
                                                                    in.incrLineNumber(1, pos);
                                                                }
                                                            }
                                                            if (pos == limit) {
                                                                --length;
                                                                break;
                                                            }
                                                            ch = buffer[pos++];
                                                        } while (true);
                                                        length = pos - length;
                                                        if (length > 0) {
                                                            in.pos = pos;
                                                            out.textFromParser(buffer, start, length);
                                                        }
                                                        start = -1;
                                                        break block128;
                                                    }
                                                    case 28: {
                                                        state = 1;
                                                        if (ch != '\n' && ch != 133) ** GOTO lbl117
                                                        in.incrLineNumber(1, pos);
                                                        break block128;
lbl117: // 1 sources:
                                                        in.incrLineNumber(1, pos - 1);
                                                        continue block30;
                                                    }
                                                    case 12: 
                                                    case 15: 
                                                    case 23: 
                                                    case 29: 
                                                    case 32: {
                                                        if (ch == 32 || ch == '\t') break block128;
                                                        if (ch != '\n' && ch != '\r' && ch != '\u0085' && ch != 8232) ** GOTO lbl124
                                                        in.incrLineNumber(1, pos);
                                                        break block128;
lbl124: // 1 sources:
                                                        state -= 2;
                                                        continue block30;
                                                    }
                                                    case 3: 
                                                    case 5: 
                                                    case 7: 
                                                    case 9: 
                                                    case 17: 
                                                    case 24: 
                                                    case 33: {
                                                        length = start + 1;
                                                        do {
                                                            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '_' || ch == ':' || ch >= '\u00c0' && (ch <= '\u02ff' || ch >= '\u0370' && (ch <= '\u1fff' && ch != '\u037e' || ch >= '\u200c' && (ch <= '\u200d' || ch >= '\u2070' && ch <= '\u218f' || ch >= '\u2c00' && ch <= '\u2fef' || ch >= '\u3001' && ch <= '\ud7ff' || ch >= '\uf900' && ch <= '\ufffd'))) || pos > length && ch >= '0' && ch <= '9' || ch == '.' || ch == '-' || ch == '\u00b7' || ch > '\u0300' && (ch <= '\u036f' || ch >= '\u203f' && ch <= '\u2040'))) {
                                                                --state;
                                                                if ((length = pos - length) != 0) continue block30;
                                                                message = state == 8 ? "missing or invalid attribute name" : (state == 2 || state == 4 ? "missing or invalid element name" : "missing or invalid name");
                                                                state = 36;
                                                                continue block30;
                                                            }
                                                            if (pos < limit) {
                                                                ch = buffer[pos++];
                                                                continue;
                                                            }
                                                            break block128;
                                                            break;
                                                        } while (true);
                                                    }
                                                    case 26: {
                                                        break;
                                                    }
                                                    case 25: {
                                                        if (ch != 35) ** GOTO lbl148
                                                        state = 26;
                                                        start = pos;
                                                        length = 0;
                                                        dstart = 0;
                                                        break block128;
lbl148: // 1 sources:
                                                        start = pos - 1;
                                                        state = 7;
                                                        continue block30;
                                                    }
                                                    case 6: {
                                                        in.pos = pos;
                                                        if (ch != ';') {
                                                            out.error('w', "missing ';'");
                                                        }
                                                        out.emitEntityReference(buffer, start, length);
                                                        start = -1;
                                                        state = 1;
                                                        break block128;
                                                    }
                                                    case 14: {
                                                        if (ch != 47) ** GOTO lbl163
                                                        state = 19;
                                                        break block128;
lbl163: // 1 sources:
                                                        if (ch != 63) ** GOTO lbl167
                                                        start = pos;
                                                        state = 24;
                                                        break block128;
lbl167: // 1 sources:
                                                        if (ch != 33) ** GOTO lbl171
                                                        state = 20;
                                                        start = pos;
                                                        break block128;
lbl171: // 1 sources:
                                                        start = pos - 1;
                                                        state = 3;
                                                        continue block30;
                                                    }
                                                    case 2: {
                                                        in.pos = pos - length;
                                                        out.emitStartElement(buffer, start, length);
                                                        state = 12;
                                                        start = -1;
                                                        continue block30;
                                                    }
                                                    case 21: 
                                                    case 30: {
                                                        if (dstart < 0) {
                                                            dstart = pos - 1;
                                                        }
                                                        do {
                                                            if (ch == '>' && buffer[end = pos - 2] == '?' && end >= dstart) {
                                                                in.pos = pos;
                                                                if (length == 3 && buffer[start] == 'x' && buffer[start + 1] == 'm' && buffer[start + 2] == 'l') {
                                                                    if (state == 30) {
                                                                        if (end <= dstart + 7 || buffer[dstart] != 'v' || buffer[dstart + 1] != 'e' || buffer[dstart + 2] != 'r' || buffer[dstart + 3] != 's' || buffer[dstart + 4] != 'i' || buffer[dstart + 5] != 'o' || buffer[dstart + 6] != 'n') {
                                                                            pos = dstart;
                                                                            message = "xml declaration without version";
                                                                            state = 36;
                                                                            continue block30;
                                                                        }
                                                                        ch = buffer[dstart += 7];
                                                                        while (Character.isWhitespace(ch) && ++dstart < end) {
                                                                            ch = buffer[dstart];
                                                                        }
                                                                        if (ch != '=') {
                                                                            state = 35;
                                                                            continue block30;
                                                                        }
                                                                        ch = buffer[++dstart];
                                                                        while (Character.isWhitespace(ch) && ++dstart < end) {
                                                                            ch = buffer[dstart];
                                                                        }
                                                                        if (ch != '\'' && ch != '\"') {
                                                                            state = 35;
                                                                            continue block30;
                                                                        }
                                                                        quote = ch;
                                                                        i = ++dstart;
                                                                        break block129;
                                                                    }
                                                                    message = "<?xml must be at start of file";
                                                                    state = 36;
                                                                    continue block30;
                                                                }
                                                                if (strict && state == 30) {
                                                                    state = 38;
                                                                    continue block30;
                                                                }
                                                                out.processingInstructionFromParser(buffer, start, length, dstart, end - dstart);
                                                                break block130;
                                                            }
                                                            if (pos < limit) {
                                                                ch = buffer[pos++];
                                                                continue;
                                                            }
                                                            break block128;
                                                            break;
                                                        } while (true);
                                                    }
                                                    case 20: {
                                                        break block134;
                                                    }
                                                    case 13: {
                                                        state = 17;
                                                        start = pos - 1;
                                                        continue block30;
                                                    }
                                                    case 16: {
                                                        if (dstart < 0) {
                                                            dstart = pos - 1;
                                                            dstart -= start;
                                                            dstart <<= 1;
                                                            terminator = '\u0000';
                                                        }
                                                        do {
                                                            if (ch != '\'' && ch != 34) ** GOTO lbl242
                                                            if (terminator != '\u0000') ** GOTO lbl239
                                                            terminator = ch;
                                                            ** GOTO lbl-1000
lbl239: // 1 sources:
                                                            if (terminator != ch) ** GOTO lbl-1000
                                                            terminator = '\u0000';
                                                            ** GOTO lbl-1000
lbl242: // 1 sources:
                                                            if (terminator != '\u0000') ** GOTO lbl-1000
                                                            if (ch != 91) ** GOTO lbl246
                                                            dstart |= 1;
                                                            ** GOTO lbl-1000
lbl246: // 1 sources:
                                                            if (ch != 93) ** GOTO lbl249
                                                            dstart &= -2;
                                                            ** GOTO lbl-1000
lbl249: // 1 sources:
                                                            if (ch == '>' && (dstart & 1) == 0) {
                                                                in.pos = pos;
                                                                dstart >>= 1;
                                                                out.emitDoctypeDecl(buffer, start, length, dstart += start, pos - 1 - dstart);
                                                                terminator = '<';
                                                                start = -1;
                                                                dstart = -1;
                                                                state = 1;
                                                            } else if (pos < limit) {
                                                                ch = buffer[pos++];
                                                                continue;
                                                            }
                                                            break block128;
                                                            break;
                                                        } while (true);
                                                    }
                                                    case 10: {
                                                        terminator = '<';
                                                        continue_state = 14;
                                                        if (ch != 47) ** GOTO lbl271
                                                        in.pos = pos;
                                                        out.emitEndAttributes();
                                                        out.emitEndElement(null, 0, 0);
                                                        state = 27;
                                                        break block128;
lbl271: // 1 sources:
                                                        if (ch != 62) ** GOTO lbl276
                                                        in.pos = pos;
                                                        out.emitEndAttributes();
                                                        state = 1;
                                                        break block128;
lbl276: // 1 sources:
                                                        start = pos - 1;
                                                        state = 9;
                                                        continue block30;
                                                    }
                                                    case 8: {
                                                        if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n' || ch == '\u0085' || ch == '\u2028') break block128;
                                                        in.pos = pos - length;
                                                        out.emitStartAttribute(buffer, start, length);
                                                        start = -1;
                                                        if (ch != 61) ** GOTO lbl287
                                                        state = 11;
                                                        break block128;
lbl287: // 1 sources:
                                                        out.emitEndAttributes();
                                                        message = "missing or misplaced '=' after attribute name";
                                                        state = 36;
                                                        continue block30;
                                                    }
                                                    case 11: {
                                                        if (ch == '\'' || ch == '\"') {
                                                            terminator = ch;
                                                            continue_state = 12;
                                                            state = 1;
                                                        } else if (ch != ' ' && ch != '\t' && ch != '\r' && ch != '\n' && ch != '\u0085' && ch != '\u2028') {
                                                            out.emitEndAttributes();
                                                            message = "missing or unquoted attribute value";
                                                            state = 36;
                                                            continue block30;
                                                        }
                                                        break block128;
                                                    }
                                                    case 19: {
                                                        start = pos - 1;
                                                        state = 5;
                                                        continue block30;
                                                    }
                                                    case 4: {
                                                        in.pos = pos;
                                                        out.emitEndElement(buffer, start, length);
                                                        start = -1;
                                                        state = 29;
                                                        continue block30;
                                                    }
                                                    case 27: {
                                                        if (ch != '>') {
                                                            message = "missing '>'";
                                                            state = 36;
                                                            continue block30;
                                                        }
                                                        state = 1;
                                                        break block128;
                                                    }
                                                }
                                                do {
                                                    if (ch == ';') {
                                                        in.pos = pos;
                                                        out.emitCharacterReference(length, buffer, start, pos - 1 - start);
                                                        state = 1;
                                                    } else {
                                                        if (ch == 'x' && dstart == 0) {
                                                            dstart = 16;
                                                        } else {
                                                            if (length >= 134217728 || (digit = Character.digit(ch, base = dstart == 0 ? 10 : dstart)) < 0) break;
                                                            length = length * base + digit;
                                                        }
                                                        if (pos < limit) {
                                                            ch = buffer[pos++];
                                                            continue;
                                                        }
                                                    }
                                                    break block128;
                                                    break;
                                                } while (true);
                                                in.pos = pos;
                                                out.error('e', "invalid character reference");
                                                state = 1;
                                                break block128;
                                            }
                                            do {
                                                if (i == end) {
                                                    state = 35;
                                                    continue block30;
                                                }
                                                ch = buffer[i];
                                                if (ch == quote) {
                                                    if (i == dstart + 3) {
                                                        break;
                                                    }
                                                    break block131;
                                                }
                                                ++i;
                                            } while (true);
                                            if (buffer[dstart] == '1' && buffer[dstart + 1] == '.' && (ch = buffer[dstart + 2]) == 48) break block135;
                                        }
                                        if (ch != '1') {
                                            state = 35;
                                            continue;
                                        }
                                    }
                                    for (dstart = i + 1; dstart < end && Character.isWhitespace(buffer[dstart]); ++dstart) {
                                    }
                                    if (end > dstart + 7 && buffer[dstart] == 'e' && buffer[dstart + 1] == 'n' && buffer[dstart + 2] == 'c' && buffer[dstart + 3] == 'o' && buffer[dstart + 4] == 'd' && buffer[dstart + 5] == 'i' && buffer[dstart + 6] == 'n' && buffer[dstart + 7] == 'g') {
                                        block132 : {
                                            ch = buffer[dstart += 8];
                                            while (Character.isWhitespace(ch) && ++dstart < end) {
                                                ch = buffer[dstart];
                                            }
                                            if (ch != '=') {
                                                message = "bad 'encoding' declaration";
                                                state = 36;
                                                continue;
                                            }
                                            ch = buffer[++dstart];
                                            while (Character.isWhitespace(ch) && ++dstart < end) {
                                                ch = buffer[dstart];
                                            }
                                            if (ch != '\'' && ch != '\"') {
                                                message = "bad 'encoding' declaration";
                                                state = 36;
                                                continue;
                                            }
                                            quote = ch;
                                            i = ++dstart;
                                            do {
                                                if (i == end) {
                                                    message = "bad 'encoding' declaration";
                                                    state = 36;
                                                    continue block30;
                                                }
                                                ch = buffer[i];
                                                if (ch == quote) {
                                                    encoding = new String(buffer, dstart, i - dstart);
                                                    if (in instanceof BinaryInPort) {
                                                        break;
                                                    }
                                                    break block132;
                                                }
                                                ++i;
                                            } while (true);
                                            ((BinaryInPort)in).setCharset(encoding);
                                        }
                                        for (dstart = i + 1; dstart < end && Character.isWhitespace(buffer[dstart]); ++dstart) {
                                        }
                                    }
                                    if (end <= dstart + 9 || buffer[dstart] != 's' || buffer[dstart + 1] != 't' || buffer[dstart + 2] != 'a' || buffer[dstart + 3] != 'n' || buffer[dstart + 4] != 'd' || buffer[dstart + 5] != 'a' || buffer[dstart + 6] != 'l' || buffer[dstart + 7] != 'o' || buffer[dstart + 8] != 'n' || buffer[dstart + 9] != 'e') break block136;
                                    ch = buffer[dstart += 10];
                                    while (Character.isWhitespace(ch) && ++dstart < end) {
                                        ch = buffer[dstart];
                                    }
                                    if (ch != '=') {
                                        message = "bad 'standalone' declaration";
                                        state = 36;
                                        continue;
                                    }
                                    ch = buffer[++dstart];
                                    while (Character.isWhitespace(ch) && ++dstart < end) {
                                        ch = buffer[dstart];
                                    }
                                    if (ch != '\'' && ch != '\"') {
                                        message = "bad 'standalone' declaration";
                                        state = 36;
                                        continue;
                                    }
                                    quote = ch;
                                    i = ++dstart;
                                    do {
                                        if (i == end) {
                                            message = "bad 'standalone' declaration";
                                            state = 36;
                                            continue block30;
                                        }
                                        ch = buffer[i];
                                        if (ch == quote) {
                                            if (i == dstart + 3) {
                                                break;
                                            }
                                            break block133;
                                        }
                                        ++i;
                                    } while (true);
                                    if (buffer[dstart] == 'y' && buffer[dstart + 1] == 'e' && buffer[dstart + 2] == 's') break block137;
                                }
                                if (i != dstart + 2 || buffer[dstart] != 'n' || buffer[dstart + 1] != 'o') {
                                    message = "bad 'standalone' declaration";
                                    state = 36;
                                    continue;
                                }
                            }
                            for (dstart = i + 1; dstart < end && Character.isWhitespace(buffer[dstart]); ++dstart) {
                            }
                        }
                        if (end != dstart) {
                            message = "junk at end of xml declaration";
                            pos = dstart;
                            state = 36;
                            continue;
                        }
                    }
                    start = -1;
                    dstart = -1;
                    state = 1;
                    break block128;
                }
                do {
                    block138 : {
                        if (ch != 62) break block138;
                        length = pos - 1 - start;
                        if (length >= 4 && buffer[start] == '-' && buffer[start + 1] == '-') {
                            if (buffer[pos - 2] == '-' && buffer[pos - 3] == '-') {
                                in.pos = pos;
                                out.commentFromParser(buffer, start + 2, length - 4);
                                start = -1;
                                break;
                            }
                        } else {
                            if (length < 6 || buffer[start] != '[' || buffer[start + 1] != 'C' || buffer[start + 2] != 'D' || buffer[start + 3] != 'A' || buffer[start + 4] != 'T' || buffer[start + 5] != 'A' || buffer[start + 6] != '[') break;
                            if (buffer[pos - 2] == ']' && buffer[pos - 3] == ']') {
                                in.pos = pos;
                                out.writeCDATA(buffer, start + 7, pos - 10 - start);
                                start = -1;
                                break;
                            }
                        }
                        ** GOTO lbl-1000
                    }
                    if (pos == start + 7 && buffer[start] == 'D' && buffer[start + 1] == 'O' && buffer[start + 2] == 'C' && buffer[start + 3] == 'T' && buffer[start + 4] == 'Y' && buffer[start + 5] == 'P' && ch == 'E') {
                        start = -1;
                        state = 15;
                    } else if (pos < limit) {
                        ch = buffer[pos++];
                        continue;
                    }
                    break block128;
                    break;
                } while (true);
                start = -1;
                state = 1;
            }
            if (pos >= limit) {
                saved = pos - start;
                try {
                    if (start >= 0) {
                        in.setSaveStart(start);
                    }
                    in.pos = pos;
                    x = in.peek();
                    if (x < 0) {
                        if (state == 1) return;
                        if (state == 28) {
                            return;
                        }
                        state = 37;
                        continue;
                    }
                    if (start >= 0) {
                        in.setSaveStart(-1);
                    }
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
                pos = in.pos;
                buffer = in.buffer;
                limit = in.limit;
                start = start >= 0 ? pos - saved : limit;
            }
            ch = buffer[pos++];
        } while (true);
    }
}

