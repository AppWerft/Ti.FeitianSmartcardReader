// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import java.io.IOException;
import gnu.mapping.Values;
import gnu.lists.FString;
import gnu.expr.Special;
import gnu.kawa.io.InPort;

public class read_line
{
    public static Object apply(final InPort in, final String handling) throws IOException {
        int ch = in.read();
        if (ch < 0) {
            return Special.eof;
        }
        int pos;
        final int start = pos = in.pos - 1;
        final int limit = in.limit;
        final char[] buffer = in.buffer;
        int delim = -1;
        while (pos < limit) {
            ch = buffer[pos++];
            if (ch == 13 || ch == 10) {
                --pos;
                if (handling == "trim" || handling == "peek") {
                    if (handling == "peek") {
                        delim = 0;
                    }
                    if (ch == 10) {
                        delim = 1;
                    }
                    else {
                        if (pos + 1 >= limit) {
                            break;
                        }
                        delim = ((buffer[pos + 1] == '\n') ? 2 : 1);
                    }
                    in.pos = pos + delim;
                }
                else {
                    if (handling != "concat" || ch != 10) {
                        break;
                    }
                    in.pos = ++pos;
                }
                return new FString(buffer, start, pos - start);
            }
        }
        final StringBuffer sbuf = new StringBuffer(100);
        if (pos > start) {
            sbuf.append(buffer, start, pos - start);
        }
        in.pos = pos;
        final char mode = (handling == "peek") ? 'P' : ((handling == "concat" || handling == "split") ? 'A' : 'I');
        in.readLine(sbuf, mode);
        int length = sbuf.length();
        if (handling == "split") {
            if (length == 0) {
                delim = 0;
            }
            else {
                final char last = sbuf.charAt(length - 1);
                if (last == '\r') {
                    delim = 1;
                }
                else if (last != '\n') {
                    delim = 0;
                }
                else if (last > '\u0002' && sbuf.charAt(length - 2) == '\r') {
                    delim = 2;
                }
                else {
                    delim = 1;
                }
                length -= delim;
            }
        }
        final FString dataStr = new FString(sbuf, 0, length);
        if (handling == "split") {
            final FString delimStr = new FString(sbuf, length - delim, delim);
            return Values.values2(dataStr, delimStr);
        }
        return dataStr;
    }
}
