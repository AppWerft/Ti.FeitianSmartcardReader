// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.servlet;

import java.io.IOException;
import java.io.OutputStream;
import gnu.kawa.xml.HttpPrinter;

public class ServletPrinter extends HttpPrinter
{
    HttpRequestContext hctx;
    
    public ServletPrinter(final HttpRequestContext hctx, final int bufSize) throws IOException {
        super(new HttpOutputStream(hctx, bufSize));
        this.hctx = hctx;
    }
    
    @Override
    public void addHeader(final String label, final String value) {
        if (label.equalsIgnoreCase("Content-type")) {
            super.sawContentType = value;
            this.hctx.setContentType(value);
        }
        else if (label.equalsIgnoreCase("Status")) {
            final int lval = value.length();
            int code = 0;
            for (int i = 0; i < lval; ++i) {
                if (i >= lval) {
                    this.hctx.statusCode = code;
                    break;
                }
                final char ch = value.charAt(i);
                final int digit = Character.digit(ch, 10);
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
        }
        else {
            this.hctx.setResponseHeader(label, value);
        }
    }
    
    @Override
    public void printHeaders() {
    }
    
    @Override
    public boolean reset(final boolean headersAlso) {
        return ((HttpOutputStream)this.ostream).reset() & super.reset(headersAlso);
    }
}
