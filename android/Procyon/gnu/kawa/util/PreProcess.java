// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class PreProcess
{
    Hashtable<String, Boolean> keywords;
    ArrayList<String>[] substitutions;
    int maxkey;
    String filename;
    int lineno;
    String outFilename;
    static final String JAVA4_FEATURES = "+JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio";
    static final String NO_JAVA4_FEATURES = "-JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -use:javax.lang.model -SAX2 -use:java.nio -Android";
    static final String JAVA5_FEATURES = "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName";
    static final String NO_JAVA6_FEATURES = "-JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model";
    static String[] version_features;
    byte[] resultBuffer;
    int resultLength;
    
    public PreProcess() {
        this.keywords = new Hashtable<String, Boolean>();
        this.substitutions = (ArrayList<String>[])new ArrayList[128];
    }
    
    void error(final String msg) {
        System.err.println(this.filename + ':' + this.lineno + ": " + msg);
        System.exit(-1);
    }
    
    public void filter(final String filename) throws Throwable {
        final boolean changed = this.filter(filename, new BufferedInputStream(new FileInputStream(filename)));
        final String outname = (this.outFilename == null) ? filename : this.outFilename;
        final boolean overwrite = filename.equals(outname);
        if (changed || !overwrite) {
            final FileOutputStream out = new FileOutputStream(outname);
            out.write(this.resultBuffer, 0, this.resultLength);
            out.close();
            System.err.println("Pre-processed " + filename + (overwrite ? "" : (" to " + outname)));
        }
    }
    
    public boolean filter(final String filename, final BufferedInputStream in) throws Throwable {
        this.filename = filename;
        boolean changed = false;
        byte[] buf = new byte[2000];
        int len = 0;
        int lineStart = 0;
        int dataStart = -1;
        int cmdLine = 0;
        final boolean removeCommented = this.outFilename != null && !filename.equals(this.outFilename);
        this.lineno = 1;
        int commentAt = -1;
        int curIndent = 0;
        int nesting = 0;
        int skipNesting = 0;
        String cmd = null;
        int changedLine = 0;
        boolean skipLine = false;
    Label_1466:
        while (true) {
            int c = in.read();
            if (c < 0) {
                break;
            }
            final int needed = len + this.maxkey + 10;
            final int buflen = buf.length;
            if (needed >= buflen) {
                final byte[] nbuf = new byte[needed + (buflen >> 2)];
                System.arraycopy(buf, 0, nbuf, 0, len);
                buf = nbuf;
            }
            if (commentAt >= 0 && dataStart < 0 && changedLine <= 0 && c != 13 && c != 10 && (commentAt == curIndent || (c != 32 && c != 9))) {
                boolean doComment;
                if (c == 47) {
                    in.mark(100);
                    int d = in.read();
                    if (d == 47) {
                        doComment = false;
                    }
                    else if (d == 42) {
                        do {
                            d = in.read();
                        } while (d == 32 || d == 9);
                        doComment = (d != 35);
                    }
                    else {
                        doComment = true;
                    }
                    in.reset();
                }
                else {
                    doComment = true;
                }
                if (doComment) {
                    skipLine = removeCommented;
                    buf[len++] = 47;
                    buf[len++] = 47;
                    buf[len++] = 32;
                    changedLine = 1;
                    changed = true;
                }
            }
            if (c != 32 && c != 9 && dataStart < 0) {
                dataStart = len;
                if (nesting > 0 && commentAt != curIndent && c == 47) {
                    c = in.read();
                    if (c < 0) {
                        break;
                    }
                    if (c != 47) {
                        buf[len++] = 47;
                    }
                    else {
                        c = in.read();
                        if (c < 0) {
                            break;
                        }
                        changedLine = -1;
                        changed = true;
                        if (c == 32) {
                            c = in.read();
                            if (c == 32 || c == 9) {
                                dataStart = -1;
                            }
                        }
                    }
                }
            }
            buf[len++] = (byte)c;
            Label_0776: {
                if (c < 127 && c > 32 && this.substitutions[c] != null) {
                    final int keystart = len - 1;
                    final ArrayList<String> subs = this.substitutions[c];
                    final int nsub = subs.size();
                    int next = in.read();
                    int i = 0;
                    while (true) {
                        while (i != nsub) {
                            final String key = subs.get(i);
                            final String val = subs.get(i + 1);
                            int keylen;
                            int j;
                            for (keylen = key.length(), j = 1; j < keylen; ++j) {
                                if (j == len - keystart) {
                                    if (next != key.charAt(j)) {
                                        break;
                                    }
                                    buf[len++] = (byte)next;
                                    next = in.read();
                                }
                                else if (buf[keystart + j] != key.charAt(j)) {
                                    break;
                                }
                            }
                            if (j == keylen) {
                                len = keystart;
                                for (int vallen = val.length(), k = 0; k < vallen; ++k) {
                                    if (len >= buf.length) {
                                        throw new ArrayIndexOutOfBoundsException("index:" + len + " arr-len:" + buf.length + " vallen:" + vallen);
                                    }
                                    buf[len++] = (byte)val.charAt(k);
                                }
                                if (next < 0) {
                                    break Label_1466;
                                }
                                c = next;
                                buf[len++] = (byte)c;
                                break Label_0776;
                            }
                            else {
                                i += 2;
                            }
                        }
                        continue;
                    }
                }
            }
            if (c == 10) {
                if (len == lineStart + 1 && commentAt >= 0) {
                    skipLine = removeCommented;
                }
                int firstNonSpace = -1;
                int lastNonSpace = 0;
                for (int l = lineStart; l < len - 1; ++l) {
                    if (buf[l] != 32 && buf[l] != 9 && buf[l] != 13) {
                        lastNonSpace = l;
                        if (firstNonSpace < 0) {
                            firstNonSpace = l;
                        }
                    }
                }
                if (lastNonSpace - firstNonSpace >= 4 && buf[firstNonSpace] == 47 && buf[firstNonSpace + 1] == 42 && buf[lastNonSpace - 1] == 42 && buf[lastNonSpace] == 47) {
                    for (firstNonSpace += 2; firstNonSpace < lastNonSpace && buf[firstNonSpace] == 32; ++firstNonSpace) {}
                    for (lastNonSpace -= 2; lastNonSpace > firstNonSpace && buf[lastNonSpace] == 32; --lastNonSpace) {}
                    if (buf[firstNonSpace] == 35) {
                        final String cmnt = new String(buf, firstNonSpace, lastNonSpace - firstNonSpace + 1, "ISO-8859-1");
                        final int sp = cmnt.indexOf(32);
                        cmdLine = this.lineno;
                        Object binding;
                        if (sp > 0) {
                            cmd = cmnt.substring(0, sp);
                            String rest = cmnt.substring(sp).trim();
                            while (true) {
                                final int bar = rest.indexOf(124);
                                if (bar < 0) {
                                    binding = this.keywords.get(rest);
                                    break;
                                }
                                binding = this.keywords.get(rest.substring(0, bar));
                                if (binding == Boolean.TRUE) {
                                    break;
                                }
                                rest = rest.substring(bar + 1);
                            }
                        }
                        else {
                            cmd = cmnt;
                            final String rest = "";
                            binding = null;
                        }
                        if ("#ifdef".equals(cmd) || "#ifndef".equals(cmd)) {
                            if (binding == null) {
                                binding = Boolean.FALSE;
                            }
                            ++nesting;
                            if (skipNesting > 0) {
                                commentAt = curIndent;
                            }
                            else if (cmd.charAt(3) == 'n' != (binding == Boolean.FALSE)) {
                                commentAt = curIndent;
                                skipNesting = nesting;
                            }
                            skipLine = removeCommented;
                        }
                        else if ("#else".equals(cmd)) {
                            if (nesting == 0) {
                                this.error("unexpected " + cmd);
                            }
                            else if (nesting == skipNesting) {
                                commentAt = -1;
                                skipNesting = 0;
                            }
                            else {
                                commentAt = curIndent;
                                if (skipNesting == 0) {
                                    skipNesting = nesting;
                                }
                            }
                        }
                        else if ("#endif".equals(cmd)) {
                            if (nesting == 0) {
                                this.error("unexpected " + cmd);
                            }
                            if (nesting == skipNesting) {
                                skipNesting = 0;
                                commentAt = -1;
                            }
                            else if (skipNesting > 0) {
                                commentAt = curIndent;
                            }
                            --nesting;
                            skipLine = removeCommented;
                        }
                        else {
                            this.error("unknown command: " + cmnt);
                        }
                    }
                }
                if (skipLine) {
                    len = lineStart;
                }
                else {
                    lineStart = len;
                }
                dataStart = -1;
                curIndent = 0;
                ++this.lineno;
                skipLine = false;
                changedLine = 0;
            }
            else {
                if (dataStart >= 0) {
                    continue;
                }
                curIndent = ((c == 9) ? (curIndent + 8 & 0xFFFFFFF8) : (curIndent + 1));
            }
        }
        if (nesting != 0) {
            this.lineno = cmdLine;
            this.error("unterminated " + cmd);
        }
        this.resultBuffer = buf;
        this.resultLength = len;
        return changed;
    }
    
    void putSubstitution(final String key, final String val) {
        final char key2 = key.charAt(0);
        if (key2 <= ' ' || key2 >= '\u007f') {
            this.error("invalid start character of substituton " + key);
        }
        ArrayList<String> substitution = this.substitutions[key2];
        if (substitution == null) {
            substitution = new ArrayList<String>();
            this.substitutions[key2] = substitution;
        }
        final int keylen = key.length();
        if (keylen > this.maxkey) {
            this.maxkey = keylen;
        }
        final int vallen = val.length();
        if (vallen > this.maxkey) {
            this.maxkey = vallen;
        }
        substitution.add(key);
        substitution.add(val);
    }
    
    String getSubstitution(final String key) {
        final char key2 = key.charAt(0);
        if (key2 <= ' ' || key2 >= '\u007f') {
            return null;
        }
        final ArrayList<String> substitution = this.substitutions[key2];
        if (substitution == null) {
            return null;
        }
        for (int sz = substitution.size(), i = 0; i < sz; i += 2) {
            if (substitution.get(i).equals(key)) {
                return substitution.get(i + 1);
            }
        }
        return null;
    }
    
    void handleArg(String arg) {
        final char arg2 = arg.charAt(0);
        if (arg2 == '=' || arg2 == '$' || arg2 == '@') {
            final int eq = arg.indexOf(61, 1);
            if (eq < 0) {
                this.error("missing substiution keyword in " + arg);
            }
            final String key = arg.substring((arg2 == '=') ? 1 : 0, eq);
            final String val = arg.substring(eq + 1);
            this.putSubstitution(key, val);
        }
        else if (arg.charAt(0) == '%') {
            arg = arg.substring(1);
            int i = 0;
            while (!arg.equals("UniformVector")) {
                if (i >= PreProcess.version_features.length) {
                    System.err.println("Unknown version: " + arg);
                    System.exit(-1);
                }
                if (arg.equals(PreProcess.version_features[i])) {
                    final String features = PreProcess.version_features[i + 1];
                    System.err.println("(variant " + arg + " maps to: " + features + ")");
                    final char feat0 = features.charAt(0);
                    final char sep = (feat0 == '/' || feat0 == ';') ? feat0 : ' ';
                    int start = 0;
                    while (start >= 0) {
                        final int ind = features.indexOf(sep, start);
                        String farg;
                        if (ind >= 0) {
                            farg = features.substring(start, ind);
                            start = ind + 1;
                        }
                        else {
                            farg = features.substring(start);
                            start = -1;
                        }
                        if (farg.length() > 0) {
                            this.handleArg(farg);
                        }
                    }
                    return;
                }
                i += 2;
            }
            this.putSubstitution("-*- java -*-", "");
            this.putSubstitution("$PREAMBLE$", "This file is generated from PrimVector.template. DO NOT EDIT!");
            final String TAG = this.getSubstitution("$TAG$");
            if (TAG != null && this.getSubstitution("$tag$") == null) {
                this.putSubstitution("$tag$", TAG.toLowerCase());
            }
            final String ptype = this.getSubstitution("$ptype$");
            if (ptype != null && this.getSubstitution("$Ptype$") == null) {
                this.putSubstitution("$Ptype$", Character.toUpperCase(ptype.charAt(0)) + ptype.substring(1));
            }
            if (this.getSubstitution("$MASK$") == null) {
                this.putSubstitution("$MASK$", "");
            }
            if (this.getSubstitution("@Abstract") == null) {
                this.putSubstitution("@Abstract", "");
            }
            if (this.getSubstitution("$ZERO$") == null) {
                this.putSubstitution("$ZERO$", "0");
            }
            if (this.getSubstitution("$RETURN_IF_UNEQUAL$(v1,v2)") == null) {
                this.putSubstitution("$RETURN_IF_UNEQUAL$(v1,v2)", "return v1 > v2 ? 1 : -1");
            }
        }
        else if (arg.charAt(0) == '+') {
            this.keywords.put(arg.substring(1), Boolean.TRUE);
        }
        else if (arg.charAt(0) == '-') {
            final int eq = arg.indexOf(61);
            if (eq > 1) {
                final String keyword = arg.substring((arg.charAt(1) == '-') ? 2 : 1, eq);
                final String value = arg.substring(eq + 1);
                Boolean b = Boolean.FALSE;
                if (value.equalsIgnoreCase("true")) {
                    b = Boolean.TRUE;
                }
                else if (!value.equalsIgnoreCase("false")) {
                    System.err.println("invalid value " + value + " for " + keyword);
                    System.exit(-1);
                }
                this.keywords.put(keyword, b);
            }
            else {
                this.keywords.put(arg.substring(1), Boolean.FALSE);
            }
        }
        else {
            try {
                this.filter(arg);
            }
            catch (Throwable ex) {
                System.err.println("caught " + ex);
                ex.printStackTrace();
                System.exit(-1);
            }
        }
    }
    
    public static void main(final String[] args) {
        final PreProcess pp = new PreProcess();
        pp.keywords.put("true", Boolean.TRUE);
        pp.keywords.put("false", Boolean.FALSE);
        for (int i = 0; i < args.length; ++i) {
            final String arg = args[i];
            if (arg.equals("-o") && i + 1 < args.length) {
                pp.outFilename = args[++i];
            }
            else {
                pp.handleArg(arg);
            }
        }
    }
    
    static {
        PreProcess.version_features = new String[] { "java1", "-JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -use:javax.lang.model -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java2", "+JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -use:javax.lang.model -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java4", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java4x", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 +use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java6compat5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6 -JAVA7 -JAVA8 -JAVA9 +JAVA6COMPAT5 +use:java.text.Normalizer -use:javax.lang.model -use:java.lang.invoke -Android", "java6", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 -JAVA7 -JAVA8 -JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model -use:java.lang.invoke -Android", "java7", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 -JAVA8 -JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model +use:java.lang.invoke -Android", "java8", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 +JAVA8 -JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model +use:java.lang.invoke -Android", "java9", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 +JAVA8 +JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model +use:java.lang.invoke -Android", "android", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 -JAXP-QName -use:javax.xml.transform -JAVA6 -JAVA6COMPAT5 +Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "OBJECT", "/+OBJECT/$DESC$=objects/$TAG$=F/$ptype$=Object/$BTYPE$=Object/$CNAME$=FVector<E>/$SUPER$=SimpleVector<E>/$KIND$=OBJECT/$RETURN_IF_UNEQUAL$(v1,v2)={int d = ((Comparable) v1).compareTo((Comparable) v2); if (d != 0)  return d; }/$WRITE(i,out)=out.writeObject(get(i))/$ZERO$=null", "BIT", "/+BIT/$DESC$=Boolean values/$TAG$=Bit/$tag$=b/$ptype$=boolean/$BTYPE$=Boolean/$CNAME$=BitVector/$SUPER$=SimpleVector<Boolean>/$KIND$=BOOLEAN/$RETURN_IF_UNEQUAL$(v1,v2)=return v1 && ! v2 ? 1 : -1/$WRITE(i,out)=out.writeBoolean(getBoolean(i))/$ZERO$=false", "BYTE", "/+BYTE/$DESC$=signed or unsigned 8-bit integers (bytes)/$TAG$=Byte/$ptype$=byte/$BTYPE$=E/$CNAME$=ByteVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "SHORT", "/+SHORT/$DESC$=signed or unsigned 16-bit integers (shorts)/$TAG$=Short/$ptype$=short/$BTYPE$=E/$CNAME$=ShortVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "INT", "/+INT/$DESC$=signed or unsigned 32-bit integers (ints)/$TAG$=Int/$ptype$=int/$BTYPE$=E/$CNAME$=IntVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "LONG", "/+LONG/$DESC$=signed or unsigned 64-bit integers (longs)/$TAG$=Long/$ptype$=long/$BTYPE$=E/$CNAME$=LongVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "F32", "/+F32/$DESC$=32-bit floats/$TAG$=F32/$ptype$=float/$BTYPE$=Float/$CNAME$=F32Vector/$SUPER$=SimpleVector<Float>/$KIND$=FLOAT/$WRITE(i,out)=out.writeFloat(getFloat(i))", "F64", "/+F64/$DESC$=64-bit doubles/$TAG$=F64/$ptype$=double/$BTYPE$=Double/$CNAME$=F64Vector/$SUPER$=SimpleVector<Double>/$KIND$=DOUBLE/$WRITE(i,out)=out.writeDouble(getDouble(i))", "S8", "/+S8/$DESC$=signed 8-bit integers (bytes)/$TAG$=S8/$ptype$=byte/$BTYPE$=Byte/$KIND$=INT_S8/$CNAME$=S8Vector/$SUPER$=ByteVector<Byte>", "S16", "/+S16/$DESC$=signed 16-bit integers (shorts)/$TAG$=S16/$ptype$=short/$BTYPE$=Short/$KIND$=INT_S16/$CNAME$=S16Vector/$SUPER$=ShortVector<Short>", "S32", "/+S32/$DESC$=signed 32-bit integers (ints)/$TAG$=S32/$ptype$=int/$BTYPE$=Integer/$KIND$=INT_S32/$CNAME$=S32Vector/$SUPER$=IntVector<Integer>", "S64", "/+S64/$DESC$=signed 64-bit integers (longs)/$TAG$=S64/$ptype$=long/$BTYPE$=Long/$KIND$=INT_S64/$CNAME$=S64Vector/$SUPER$=LongVector<Long>/$WRITE(i,out)=out.writeLong(getLong(i))", "U8", "/+U8/$DESC$=unsigned 8-bit integers (bytes)/$TAG$=U8/$ptype$=byte/$BTYPE$=UByte/$KIND$=INT_U8/$CNAME$=U8Vector/$SUPER$=ByteVector<UByte>/$MASK$= & 0xff", "U16", "/+U16/$DESC$=unsigned 16-bit integers (shorts)/$TAG$=U16/$ptype$=short/$BTYPE$=UShort/$KIND$=INT_U16/$CNAME$=U16Vector/$SUPER$=ShortVector<UShort>/$MASK$= & 0xffff", "U32", "/+U32/$DESC$=unsigned 32-bit integers (ints)/$TAG$=U32/$ptype$=int/$BTYPE$=UInt/$KIND$=INT_U32/$CNAME$=U32Vector/$SUPER$=IntVector<UInt>/$MASK$= & 0xffffffffL/$WRITE(i,out)=Sequences.writeUInt(getInt(i), out)", "U64", "/+U64/$DESC$=unsigned 64-bit integers (longs)/$TAG$=U64/$ptype$=long/$BTYPE$=ULong/$KIND$=INT_U64/$CNAME$=U64Vector/$SUPER$=LongVector<ULong>/$WRITE(i,out)=Sequences.writeULong(getLong(i), out)/$RETURN_IF_UNEQUAL(v1,v2)=return (v1^0x8000000000000000L) > (v2^0x8000000000000000L) ? 1 : -1" };
    }
}
