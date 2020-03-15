// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.net.URI;

class URIStringPath extends URIPath
{
    String uriString;
    
    @Override
    public String toURIString() {
        return this.uriString;
    }
    
    public URIStringPath(final URI uri, final String uriString) {
        super(uri);
        this.uriString = uriString;
    }
}
