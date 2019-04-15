/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.servlet;

import gnu.kawa.servlet.HttpOutputStream;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.kawa.xml.HttpPrinter;
import java.io.IOException;
import java.io.OutputStream;

public class ServletPrinter
extends HttpPrinter {
    HttpRequestContext hctx;

    public ServletPrinter(HttpRequestContext hctx, int bufSize) throws IOException {
        super(new HttpOutputStream(hctx, bufSize));
        this.hctx = hctx;
    }

    @Override
    public void addHeader(String label, String value) {
        if (label.equalsIgnoreCase("Content-type")) {
            this.sawContentType = value;
            this.hctx.setContentType(value);
        } else if (label.equalsIgnoreCase("Status")) {
            int lval = value.length();
            int code = 0;
            for (int i = 0; i < lval; ++i) {
                if (i >= lval) {
                    this.hctx.statusCode = code;
                    break;
                }
                char ch = value.charAt(i);
                int digit = Character.digit(ch, 10);
                if (digit < 0) {
                    if (ch == ' ') {
                        ++i;
                    }
                    this.hctx.statusCode = code;
                    this.hctx.statusReasonPhrase = value.substring(i);
                    break;
                }
                code = 10 * code + digit;
            }
        } else {
            this.hctx.setResponseHeader(label, value);
        }
    }

    @Override
    public void printHeaders() {
    }

    @Override
    public boolean reset(boolean headersAlso) {
        return ((HttpOutputStream)this.ostream).reset() & super.reset(headersAlso);
    }
}

