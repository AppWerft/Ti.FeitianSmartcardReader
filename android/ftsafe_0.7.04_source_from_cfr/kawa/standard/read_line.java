/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Special;
import gnu.kawa.io.InPort;
import gnu.lists.FString;
import gnu.mapping.Values;
import java.io.IOException;

public class read_line {
    public static Object apply(InPort in, String handling) throws IOException {
        int start;
        int ch = in.read();
        if (ch < 0) {
            return Special.eof;
        }
        int pos = start = in.pos - 1;
        int limit = in.limit;
        char[] buffer = in.buffer;
        int delim = -1;
        while (pos < limit) {
            if ((ch = buffer[pos++]) != 13 && ch != 10) continue;
            --pos;
            if (handling == "trim" || handling == "peek") {
                if (handling == "peek") {
                    delim = 0;
                }
                if (ch == 10) {
                    delim = 1;
                } else {
                    if (pos + 1 >= limit) break;
                    delim = buffer[pos + 1] == '\n' ? 2 : 1;
                }
                in.pos = pos + delim;
            } else {
                if (handling != "concat" || ch != 10) break;
                in.pos = ++pos;
            }
            return new FString(buffer, start, pos - start);
        }
        StringBuffer sbuf = new StringBuffer(100);
        if (pos > start) {
            sbuf.append(buffer, start, pos - start);
        }
        in.pos = pos;
        int mode = handling == "peek" ? 80 : (handling == "concat" || handling == "split" ? 65 : 73);
        in.readLine(sbuf, (char)mode);
        int length = sbuf.length();
        if (handling == "split") {
            if (length == 0) {
                delim = 0;
            } else {
                char last = sbuf.charAt(length - 1);
                delim = last == '\r' ? 1 : (last != '\n' ? 0 : (last > '\u0002' && sbuf.charAt(length - 2) == '\r' ? 2 : 1));
                length -= delim;
            }
        }
        FString dataStr = new FString(sbuf, 0, length);
        if (handling == "split") {
            FString delimStr = new FString(sbuf, length - delim, delim);
            return Values.values2(dataStr, delimStr);
        }
        return dataStr;
    }
}

