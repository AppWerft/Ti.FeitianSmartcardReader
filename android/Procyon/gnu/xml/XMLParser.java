// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import gnu.kawa.io.InPort;
import gnu.kawa.io.BinaryInPort;
import java.io.InputStream;
import java.io.IOException;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.text.SourceMessages;

public class XMLParser
{
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
    
    public static void parse(final Object uri, final SourceMessages messages, final Consumer out) throws IOException {
        parse(Path.openInputStream(uri), uri, messages, out);
    }
    
    public static BinaryInPort XMLStreamReader(final InputStream strm) throws IOException {
        final BinaryInPort in = new BinaryInPort(strm);
        in.setFromByteOrderMark();
        in.setKeepFullLines(false);
        return in;
    }
    
    public static void parse(final InputStream strm, final Object uri, final SourceMessages messages, final Consumer out) throws IOException {
        final BinaryInPort in = XMLStreamReader(strm);
        if (uri != null) {
            in.setName(uri);
        }
        parse(in, messages, out);
        in.close();
    }
    
    public static void parse(final InPort in, final SourceMessages messages, final Consumer out) throws IOException {
        final XMLFilter filter = new XMLFilter(out);
        filter.setMessages(messages);
        filter.setSourceLocator(in);
        filter.startDocument();
        final Object uri = in.getPath();
        if (uri != null) {
            filter.writeDocumentUri(uri);
        }
        parse(in, filter);
        filter.endDocument();
    }
    
    public static void parse(final InPort in, final SourceMessages messages, final XMLFilter filter) throws IOException {
        filter.setMessages(messages);
        filter.setSourceLocator(in);
        filter.startDocument();
        final Object uri = in.getPath();
        if (uri != null) {
            filter.writeDocumentUri(uri);
        }
        parse(in, filter);
        filter.endDocument();
        in.close();
    }
    
    public static void parse(final InPort in, final XMLFilter out) {
        char[] buffer = in.buffer;
        int pos = in.pos;
        int limit = in.limit;
        final boolean strict = false;
        int state = 0;
        char terminator = '<';
        int continue_state = 14;
        char ch = ' ';
        int length = 0;
        int dstart = -1;
        String message = null;
        int start = -1;
    Label_0638_Outer:
        while (true) {
            Label_3487: {
                switch (state) {
                    case 0: {
                        state = 31;
                        break;
                    }
                    case 31: {
                        if (ch == '<') {
                            state = 34;
                            break;
                        }
                        state = (strict ? 38 : 1);
                        continue;
                    }
                    case 34: {
                        if (ch == '?') {
                            start = pos;
                            state = 33;
                            break;
                        }
                        state = (strict ? 38 : 14);
                        continue;
                    }
                    case 38: {
                        message = "missing XML declaration";
                        state = 36;
                        continue;
                    }
                    case 35: {
                        pos = dstart;
                        message = "invalid xml version specifier";
                        state = 36;
                        continue;
                    }
                    case 36: {
                        in.pos = pos;
                        start = -1;
                        out.error('e', message);
                        while (pos < limit) {
                            ch = buffer[pos++];
                            if (ch == '>') {
                                state = 1;
                                break Label_3487;
                            }
                        }
                        return;
                    }
                    case 37: {
                        in.pos = pos;
                        out.error('f', "unexpected end-of-file");
                        return;
                    }
                    case 1: {
                        start = pos - 1;
                        length = pos;
                        while (true) {
                            while (ch != terminator) {
                                if (ch == '&') {
                                    state = 25;
                                }
                                else {
                                    if (ch == '\r') {
                                        length = pos - length;
                                        in.pos = pos;
                                        if (length > 0) {
                                            out.textFromParser(buffer, start, length);
                                        }
                                        if (pos >= limit) {
                                            out.linefeedFromParser();
                                            state = 28;
                                            break Label_3487;
                                        }
                                        ch = buffer[pos];
                                        if (ch == '\n') {
                                            start = pos;
                                            length = ++pos;
                                        }
                                        else {
                                            out.linefeedFromParser();
                                            if (ch != '\u0085') {
                                                in.incrLineNumber(1, pos);
                                                start = pos;
                                                length = ++pos;
                                                continue Label_0638_Outer;
                                            }
                                            start = pos++;
                                            length = pos + 1;
                                        }
                                        in.incrLineNumber(1, pos);
                                    }
                                    else if (ch == '\u0085' || ch == '\u2028') {
                                        length = pos - length;
                                        in.pos = pos - 1;
                                        if (length > 0) {
                                            out.textFromParser(buffer, start, length);
                                        }
                                        out.linefeedFromParser();
                                        in.incrLineNumber(1, pos);
                                        length = pos + 1;
                                        start = pos;
                                    }
                                    else if (ch == '\n') {
                                        in.incrLineNumber(1, pos);
                                    }
                                    if (pos != limit) {
                                        ch = buffer[pos++];
                                        continue Label_0638_Outer;
                                    }
                                    --length;
                                }
                                length = pos - length;
                                if (length > 0) {
                                    in.pos = pos;
                                    out.textFromParser(buffer, start, length);
                                }
                                start = -1;
                                break Label_3487;
                            }
                            state = continue_state;
                            continue;
                        }
                    }
                    case 28: {
                        state = 1;
                        if (ch == '\n' || ch == '\u0085') {
                            in.incrLineNumber(1, pos);
                            break;
                        }
                        in.incrLineNumber(1, pos - 1);
                        continue;
                    }
                    case 12:
                    case 15:
                    case 23:
                    case 29:
                    case 32: {
                        if (ch == ' ') {
                            break;
                        }
                        if (ch == '\t') {
                            break;
                        }
                        if (ch == '\n' || ch == '\r' || ch == '\u0085' || ch == '\u2028') {
                            in.incrLineNumber(1, pos);
                            break;
                        }
                        state -= 2;
                        continue;
                    }
                    case 3:
                    case 5:
                    case 7:
                    case 9:
                    case 17:
                    case 24:
                    case 33: {
                        length = start + 1;
                        while (true) {
                            if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && ch != '_' && ch != ':' && (ch < '\u00c0' || (ch > '\u02ff' && (ch < '\u0370' || ((ch > '\u1fff' || ch == '\u037e') && (ch < '\u200c' || (ch > '\u200d' && (ch < '\u2070' || ch > '\u218f') && (ch < '\u2c00' || ch > '\u2fef') && (ch < '\u3001' || ch > '\ud7ff') && (ch < '\uf900' || ch > '\ufffd'))))))) && (pos <= length || ch < '0' || ch > '9') && ch != '.' && ch != '-' && ch != '·') {
                                if (ch <= '\u0300') {
                                    break;
                                }
                                if (ch > '\u036f') {
                                    if (ch < '\u203f' || ch > '\u2040') {
                                        break;
                                    }
                                }
                            }
                            if (pos >= limit) {
                                break Label_3487;
                            }
                            ch = buffer[pos++];
                        }
                        --state;
                        length = pos - length;
                        if (length == 0) {
                            if (state == 8) {
                                message = "missing or invalid attribute name";
                            }
                            else if (state == 2 || state == 4) {
                                message = "missing or invalid element name";
                            }
                            else {
                                message = "missing or invalid name";
                            }
                            state = 36;
                            continue;
                        }
                        continue;
                    }
                    case 26: {
                        while (ch != ';') {
                            Label_1189: {
                                if (ch != 'x' || dstart != 0) {
                                    if (length < 134217728) {
                                        final int base = (dstart == 0) ? 10 : dstart;
                                        final int digit = Character.digit(ch, base);
                                        if (digit >= 0) {
                                            length = length * base + digit;
                                            break Label_1189;
                                        }
                                    }
                                    in.pos = pos;
                                    out.error('e', "invalid character reference");
                                    state = 1;
                                    break Label_3487;
                                }
                                dstart = 16;
                            }
                            if (pos >= limit) {
                                break Label_3487;
                            }
                            ch = buffer[pos++];
                        }
                        out.emitCharacterReference(length, buffer, start, (in.pos = pos) - 1 - start);
                        state = 1;
                        break;
                    }
                    case 25: {
                        if (ch == '#') {
                            state = 26;
                            start = pos;
                            length = 0;
                            dstart = 0;
                            break;
                        }
                        start = pos - 1;
                        state = 7;
                        continue;
                    }
                    case 6: {
                        in.pos = pos;
                        if (ch != ';') {
                            out.error('w', "missing ';'");
                        }
                        out.emitEntityReference(buffer, start, length);
                        start = -1;
                        state = 1;
                        break;
                    }
                    case 14: {
                        if (ch == '/') {
                            state = 19;
                            break;
                        }
                        if (ch == '?') {
                            start = pos;
                            state = 24;
                            break;
                        }
                        if (ch == '!') {
                            state = 20;
                            start = pos;
                            break;
                        }
                        start = pos - 1;
                        state = 3;
                        continue;
                    }
                    case 2: {
                        in.pos = pos - length;
                        out.emitStartElement(buffer, start, length);
                        state = 12;
                        start = -1;
                        continue;
                    }
                    case 21:
                    case 30: {
                        if (dstart < 0) {
                            dstart = pos - 1;
                        }
                        int end;
                        while (ch != '>' || buffer[end = pos - 2] != '?' || end < dstart) {
                            if (pos >= limit) {
                                break Label_3487;
                            }
                            ch = buffer[pos++];
                        }
                        in.pos = pos;
                        Label_2612: {
                            if (length == 3 && buffer[start] == 'x' && buffer[start + 1] == 'm' && buffer[start + 2] == 'l') {
                                if (state != 30) {
                                    message = "<?xml must be at start of file";
                                    state = 36;
                                    continue;
                                }
                                if (end <= dstart + 7 || buffer[dstart] != 'v' || buffer[dstart + 1] != 'e' || buffer[dstart + 2] != 'r' || buffer[dstart + 3] != 's' || buffer[dstart + 4] != 'i' || buffer[dstart + 5] != 'o' || buffer[dstart + 6] != 'n') {
                                    pos = dstart;
                                    message = "xml declaration without version";
                                    state = 36;
                                    continue;
                                }
                                for (dstart += 7, ch = buffer[dstart]; Character.isWhitespace(ch) && ++dstart < end; ch = buffer[dstart]) {}
                                if (ch != '=') {
                                    state = 35;
                                    continue;
                                }
                                for (ch = buffer[++dstart]; Character.isWhitespace(ch) && ++dstart < end; ch = buffer[dstart]) {}
                                if (ch != '\'' && ch != '\"') {
                                    state = 35;
                                    continue;
                                }
                                char quote = ch;
                                int i = ++dstart;
                                while (i != end) {
                                    ch = buffer[i];
                                    if (ch == quote) {
                                        if ((i != dstart + 3 || buffer[dstart] != '1' || buffer[dstart + 1] != '.' || (ch = buffer[dstart + 2]) != '0') && ch != '1') {
                                            state = 35;
                                            continue Label_0638_Outer;
                                        }
                                        for (dstart = i + 1; dstart < end && Character.isWhitespace(buffer[dstart]); ++dstart) {}
                                        Label_2139: {
                                            if (end > dstart + 7 && buffer[dstart] == 'e' && buffer[dstart + 1] == 'n' && buffer[dstart + 2] == 'c' && buffer[dstart + 3] == 'o' && buffer[dstart + 4] == 'd' && buffer[dstart + 5] == 'i' && buffer[dstart + 6] == 'n' && buffer[dstart + 7] == 'g') {
                                                for (dstart += 8, ch = buffer[dstart]; Character.isWhitespace(ch) && ++dstart < end; ch = buffer[dstart]) {}
                                                if (ch != '=') {
                                                    message = "bad 'encoding' declaration";
                                                    state = 36;
                                                    continue Label_0638_Outer;
                                                }
                                                for (ch = buffer[++dstart]; Character.isWhitespace(ch) && ++dstart < end; ch = buffer[dstart]) {}
                                                if (ch != '\'' && ch != '\"') {
                                                    message = "bad 'encoding' declaration";
                                                    state = 36;
                                                    continue Label_0638_Outer;
                                                }
                                                quote = ch;
                                                for (i = ++dstart; i != end; ++i) {
                                                    ch = buffer[i];
                                                    if (ch == quote) {
                                                        final String encoding = new String(buffer, dstart, i - dstart);
                                                        if (in instanceof BinaryInPort) {
                                                            ((BinaryInPort)in).setCharset(encoding);
                                                        }
                                                        for (dstart = i + 1; dstart < end && Character.isWhitespace(buffer[dstart]); ++dstart) {}
                                                        break Label_2139;
                                                    }
                                                }
                                                message = "bad 'encoding' declaration";
                                                state = 36;
                                                continue Label_0638_Outer;
                                            }
                                        }
                                        Label_2542: {
                                            if (end > dstart + 9 && buffer[dstart] == 's' && buffer[dstart + 1] == 't' && buffer[dstart + 2] == 'a' && buffer[dstart + 3] == 'n' && buffer[dstart + 4] == 'd' && buffer[dstart + 5] == 'a' && buffer[dstart + 6] == 'l' && buffer[dstart + 7] == 'o' && buffer[dstart + 8] == 'n' && buffer[dstart + 9] == 'e') {
                                                for (dstart += 10, ch = buffer[dstart]; Character.isWhitespace(ch) && ++dstart < end; ch = buffer[dstart]) {}
                                                if (ch != '=') {
                                                    message = "bad 'standalone' declaration";
                                                    state = 36;
                                                    continue Label_0638_Outer;
                                                }
                                                for (ch = buffer[++dstart]; Character.isWhitespace(ch) && ++dstart < end; ch = buffer[dstart]) {}
                                                if (ch != '\'' && ch != '\"') {
                                                    message = "bad 'standalone' declaration";
                                                    state = 36;
                                                    continue Label_0638_Outer;
                                                }
                                                quote = ch;
                                                for (i = ++dstart; i != end; ++i) {
                                                    ch = buffer[i];
                                                    if (ch == quote) {
                                                        if (i != dstart + 3 || buffer[dstart] != 'y' || buffer[dstart + 1] != 'e' || buffer[dstart + 2] != 's') {
                                                            if (i != dstart + 2 || buffer[dstart] != 'n' || buffer[dstart + 1] != 'o') {
                                                                message = "bad 'standalone' declaration";
                                                                state = 36;
                                                                continue Label_0638_Outer;
                                                            }
                                                        }
                                                        for (dstart = i + 1; dstart < end && Character.isWhitespace(buffer[dstart]); ++dstart) {}
                                                        break Label_2542;
                                                    }
                                                }
                                                message = "bad 'standalone' declaration";
                                                state = 36;
                                                continue Label_0638_Outer;
                                            }
                                        }
                                        if (end != dstart) {
                                            message = "junk at end of xml declaration";
                                            pos = dstart;
                                            state = 36;
                                            continue Label_0638_Outer;
                                        }
                                        break Label_2612;
                                    }
                                    else {
                                        ++i;
                                    }
                                }
                                state = 35;
                                continue;
                            }
                            else {
                                if (strict && state == 30) {
                                    state = 38;
                                    continue;
                                }
                                out.processingInstructionFromParser(buffer, start, length, dstart, end - dstart);
                            }
                        }
                        start = -1;
                        dstart = -1;
                        state = 1;
                        break;
                    }
                    case 20: {
                        while (true) {
                            if (ch == '>') {
                                length = pos - 1 - start;
                                if (length >= 4 && buffer[start] == '-' && buffer[start + 1] == '-') {
                                    if (buffer[pos - 2] == '-' && buffer[pos - 3] == '-') {
                                        in.pos = pos;
                                        out.commentFromParser(buffer, start + 2, length - 4);
                                        start = -1;
                                        break;
                                    }
                                }
                                else {
                                    if (length < 6 || buffer[start] != '[' || buffer[start + 1] != 'C' || buffer[start + 2] != 'D' || buffer[start + 3] != 'A' || buffer[start + 4] != 'T' || buffer[start + 5] != 'A' || buffer[start + 6] != '[') {
                                        break;
                                    }
                                    if (buffer[pos - 2] == ']' && buffer[pos - 3] == ']') {
                                        out.writeCDATA(buffer, start + 7, (in.pos = pos) - 10 - start);
                                        start = -1;
                                        break;
                                    }
                                }
                            }
                            else if (pos == start + 7 && buffer[start] == 'D' && buffer[start + 1] == 'O' && buffer[start + 2] == 'C' && buffer[start + 3] == 'T' && buffer[start + 4] == 'Y' && buffer[start + 5] == 'P' && ch == 'E') {
                                start = -1;
                                state = 15;
                                break Label_3487;
                            }
                            if (pos >= limit) {
                                break Label_3487;
                            }
                            ch = buffer[pos++];
                        }
                        start = -1;
                        state = 1;
                        break;
                    }
                    case 13: {
                        state = 17;
                        start = pos - 1;
                        continue;
                    }
                    case 16: {
                        if (dstart < 0) {
                            dstart = pos - 1;
                            dstart -= start;
                            dstart <<= 1;
                            terminator = '\0';
                        }
                        while (true) {
                            if (ch == '\'' || ch == '\"') {
                                if (terminator == '\0') {
                                    terminator = ch;
                                }
                                else if (terminator == ch) {
                                    terminator = '\0';
                                }
                            }
                            else if (terminator == '\0') {
                                if (ch == '[') {
                                    dstart |= 0x1;
                                }
                                else if (ch == ']') {
                                    dstart &= 0xFFFFFFFE;
                                }
                                else if (ch == '>' && (dstart & 0x1) == 0x0) {
                                    in.pos = pos;
                                    dstart >>= 1;
                                    dstart += start;
                                    out.emitDoctypeDecl(buffer, start, length, dstart, pos - 1 - dstart);
                                    terminator = '<';
                                    start = -1;
                                    dstart = -1;
                                    state = 1;
                                    break Label_3487;
                                }
                            }
                            if (pos >= limit) {
                                break Label_3487;
                            }
                            ch = buffer[pos++];
                        }
                        break;
                    }
                    case 10: {
                        terminator = '<';
                        continue_state = 14;
                        if (ch == '/') {
                            in.pos = pos;
                            out.emitEndAttributes();
                            out.emitEndElement(null, 0, 0);
                            state = 27;
                            break;
                        }
                        if (ch == '>') {
                            in.pos = pos;
                            out.emitEndAttributes();
                            state = 1;
                            break;
                        }
                        start = pos - 1;
                        state = 9;
                        continue;
                    }
                    case 8: {
                        if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n' || ch == '\u0085') {
                            break;
                        }
                        if (ch == '\u2028') {
                            break;
                        }
                        in.pos = pos - length;
                        out.emitStartAttribute(buffer, start, length);
                        start = -1;
                        if (ch == '=') {
                            state = 11;
                            break;
                        }
                        out.emitEndAttributes();
                        message = "missing or misplaced '=' after attribute name";
                        state = 36;
                        continue;
                    }
                    case 11: {
                        if (ch == '\'' || ch == '\"') {
                            terminator = ch;
                            continue_state = 12;
                            state = 1;
                            break;
                        }
                        if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n' || ch == '\u0085') {
                            break;
                        }
                        if (ch == '\u2028') {
                            break;
                        }
                        out.emitEndAttributes();
                        message = "missing or unquoted attribute value";
                        state = 36;
                        continue;
                    }
                    case 19: {
                        start = pos - 1;
                        state = 5;
                        continue;
                    }
                    case 4: {
                        in.pos = pos;
                        out.emitEndElement(buffer, start, length);
                        start = -1;
                        state = 29;
                        continue;
                    }
                    case 27: {
                        if (ch != '>') {
                            message = "missing '>'";
                            state = 36;
                            continue;
                        }
                        state = 1;
                        break;
                    }
                }
            }
            if (pos >= limit) {
                final int saved = pos - start;
                try {
                    if (start >= 0) {
                        in.setSaveStart(start);
                    }
                    in.pos = pos;
                    final int x = in.peek();
                    if (x < 0) {
                        if (state == 1 || state == 28) {
                            return;
                        }
                        state = 37;
                        continue;
                    }
                    else if (start >= 0) {
                        in.setSaveStart(-1);
                    }
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
                pos = in.pos;
                buffer = in.buffer;
                limit = in.limit;
                start = ((start >= 0) ? (pos - saved) : limit);
            }
            ch = buffer[pos++];
        }
    }
}
