/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.URIPath;
import java.net.URI;

class URIStringPath
extends URIPath {
    String uriString;

    @Override
    public String toURIString() {
        return this.uriString;
    }

    public URIStringPath(URI uri, String uriString) {
        super(uri);
        this.uriString = uriString;
    }
}

