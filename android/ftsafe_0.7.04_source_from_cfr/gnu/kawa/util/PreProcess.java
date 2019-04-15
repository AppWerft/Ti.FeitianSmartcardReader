/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class PreProcess {
    Hashtable<String, Boolean> keywords = new Hashtable();
    ArrayList<String>[] substitutions = new ArrayList[128];
    int maxkey;
    String filename;
    int lineno;
    String outFilename;
    static final String JAVA4_FEATURES = "+JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio";
    static final String NO_JAVA4_FEATURES = "-JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -use:javax.lang.model -SAX2 -use:java.nio -Android";
    static final String JAVA5_FEATURES = "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName";
    static final String NO_JAVA6_FEATURES = "-JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model";
    static String[] version_features = new String[]{"java1", "-JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -use:javax.lang.model -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java2", "+JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -use:javax.lang.model -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java4", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java4x", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 +use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "java6compat5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6 -JAVA7 -JAVA8 -JAVA9 +JAVA6COMPAT5 +use:java.text.Normalizer -use:javax.lang.model -use:java.lang.invoke -Android", "java6", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 -JAVA7 -JAVA8 -JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model -use:java.lang.invoke -Android", "java7", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 -JAVA8 -JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model +use:java.lang.invoke -Android", "java8", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 +JAVA8 -JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model +use:java.lang.invoke -Android", "java9", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 +JAVA8 +JAVA9 -JAVA6COMPAT5 +use:java.text.Normalizer +use:javax.lang.model +use:java.lang.invoke -Android", "android", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 -JAXP-QName -use:javax.xml.transform -JAVA6 -JAVA6COMPAT5 +Android -JAVA6 -JAVA7 -JAVA8 -JAVA9 -use:java.lang.invoke -use:java.text.Normalizer -use:javax.lang.model", "OBJECT", "/+OBJECT/$DESC$=objects/$TAG$=F/$ptype$=Object/$BTYPE$=Object/$CNAME$=FVector<E>/$SUPER$=SimpleVector<E>/$KIND$=OBJECT/$RETURN_IF_UNEQUAL$(v1,v2)={int d = ((Comparable) v1).compareTo((Comparable) v2); if (d != 0)  return d; }/$WRITE(i,out)=out.writeObject(get(i))/$ZERO$=null", "BIT", "/+BIT/$DESC$=Boolean values/$TAG$=Bit/$tag$=b/$ptype$=boolean/$BTYPE$=Boolean/$CNAME$=BitVector/$SUPER$=SimpleVector<Boolean>/$KIND$=BOOLEAN/$RETURN_IF_UNEQUAL$(v1,v2)=return v1 && ! v2 ? 1 : -1/$WRITE(i,out)=out.writeBoolean(getBoolean(i))/$ZERO$=false", "BYTE", "/+BYTE/$DESC$=signed or unsigned 8-bit integers (bytes)/$TAG$=Byte/$ptype$=byte/$BTYPE$=E/$CNAME$=ByteVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "SHORT", "/+SHORT/$DESC$=signed or unsigned 16-bit integers (shorts)/$TAG$=Short/$ptype$=short/$BTYPE$=E/$CNAME$=ShortVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "INT", "/+INT/$DESC$=signed or unsigned 32-bit integers (ints)/$TAG$=Int/$ptype$=int/$BTYPE$=E/$CNAME$=IntVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "LONG", "/+LONG/$DESC$=signed or unsigned 64-bit integers (longs)/$TAG$=Long/$ptype$=long/$BTYPE$=E/$CNAME$=LongVector<E>/$SUPER$=PrimIntegerVector<E>/@Abstract=abstract", "F32", "/+F32/$DESC$=32-bit floats/$TAG$=F32/$ptype$=float/$BTYPE$=Float/$CNAME$=F32Vector/$SUPER$=SimpleVector<Float>/$KIND$=FLOAT/$WRITE(i,out)=out.writeFloat(getFloat(i))", "F64", "/+F64/$DESC$=64-bit doubles/$TAG$=F64/$ptype$=double/$BTYPE$=Double/$CNAME$=F64Vector/$SUPER$=SimpleVector<Double>/$KIND$=DOUBLE/$WRITE(i,out)=out.writeDouble(getDouble(i))", "S8", "/+S8/$DESC$=signed 8-bit integers (bytes)/$TAG$=S8/$ptype$=byte/$BTYPE$=Byte/$KIND$=INT_S8/$CNAME$=S8Vector/$SUPER$=ByteVector<Byte>", "S16", "/+S16/$DESC$=signed 16-bit integers (shorts)/$TAG$=S16/$ptype$=short/$BTYPE$=Short/$KIND$=INT_S16/$CNAME$=S16Vector/$SUPER$=ShortVector<Short>", "S32", "/+S32/$DESC$=signed 32-bit integers (ints)/$TAG$=S32/$ptype$=int/$BTYPE$=Integer/$KIND$=INT_S32/$CNAME$=S32Vector/$SUPER$=IntVector<Integer>", "S64", "/+S64/$DESC$=signed 64-bit integers (longs)/$TAG$=S64/$ptype$=long/$BTYPE$=Long/$KIND$=INT_S64/$CNAME$=S64Vector/$SUPER$=LongVector<Long>/$WRITE(i,out)=out.writeLong(getLong(i))", "U8", "/+U8/$DESC$=unsigned 8-bit integers (bytes)/$TAG$=U8/$ptype$=byte/$BTYPE$=UByte/$KIND$=INT_U8/$CNAME$=U8Vector/$SUPER$=ByteVector<UByte>/$MASK$= & 0xff", "U16", "/+U16/$DESC$=unsigned 16-bit integers (shorts)/$TAG$=U16/$ptype$=short/$BTYPE$=UShort/$KIND$=INT_U16/$CNAME$=U16Vector/$SUPER$=ShortVector<UShort>/$MASK$= & 0xffff", "U32", "/+U32/$DESC$=unsigned 32-bit integers (ints)/$TAG$=U32/$ptype$=int/$BTYPE$=UInt/$KIND$=INT_U32/$CNAME$=U32Vector/$SUPER$=IntVector<UInt>/$MASK$= & 0xffffffffL/$WRITE(i,out)=Sequences.writeUInt(getInt(i), out)", "U64", "/+U64/$DESC$=unsigned 64-bit integers (longs)/$TAG$=U64/$ptype$=long/$BTYPE$=ULong/$KIND$=INT_U64/$CNAME$=U64Vector/$SUPER$=LongVector<ULong>/$WRITE(i,out)=Sequences.writeULong(getLong(i), out)/$RETURN_IF_UNEQUAL(v1,v2)=return (v1^0x8000000000000000L) > (v2^0x8000000000000000L) ? 1 : -1"};
    byte[] resultBuffer;
    int resultLength;

    void error(String msg) {
        System.err.println(this.filename + ':' + this.lineno + ": " + msg);
        System.exit(-1);
    }

    public void filter(String filename) throws Throwable {
        boolean changed = this.filter(filename, new BufferedInputStream(new FileInputStream(filename)));
        String outname = this.outFilename == null ? filename : this.outFilename;
        boolean overwrite = filename.equals(outname);
        if (changed || !overwrite) {
            FileOutputStream out = new FileOutputStream(outname);
            out.write(this.resultBuffer, 0, this.resultLength);
            out.close();
            System.err.println("Pre-processed " + filename + (overwrite ? "" : new StringBuilder().append(" to ").append(outname).toString()));
        }
    }

    public boolean filter(String filename, BufferedInputStream in) throws Throwable {
        int c;
        this.filename = filename;
        boolean changed = false;
        byte[] buf = new byte[2000];
        int len = 0;
        int lineStart = 0;
        int dataStart = -1;
        int cmdLine = 0;
        boolean removeCommented = this.outFilename != null && !filename.equals(this.outFilename);
        this.lineno = 1;
        int commentAt = -1;
        int curIndent = 0;
        int nesting = 0;
        int skipNesting = 0;
        String cmd = null;
        int changedLine = 0;
        boolean skipLine = false;
        while ((c = in.read()) >= 0) {
            int needed = len + this.maxkey + 10;
            int buflen = buf.length;
            if (needed >= buflen) {
                byte[] nbuf = new byte[needed + (buflen >> 2)];
                System.arraycopy(buf, 0, nbuf, 0, len);
                buf = nbuf;
            }
            if (commentAt >= 0 && dataStart < 0 && changedLine <= 0 && c != 13 && c != 10 && (commentAt == curIndent || c != 32 && c != 9)) {
                boolean doComment;
                if (c == 47) {
                    in.mark(100);
                    int d = in.read();
                    if (d == 47) {
                        doComment = false;
                    } else if (d == 42) {
                        while ((d = in.read()) == 32 || d == 9) {
                        }
                        doComment = d != 35;
                    } else {
                        doComment = true;
                    }
                    in.reset();
                } else {
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
                    if (c < 0) break;
                    if (c != 47) {
                        buf[len++] = 47;
                    } else {
                        c = in.read();
                        if (c < 0) break;
                        changedLine = -1;
                        changed = true;
                        if (c == 32 && ((c = in.read()) == 32 || c == 9)) {
                            dataStart = -1;
                        }
                    }
                }
            }
            buf[len++] = (byte)c;
            if (c < 127 && c > 32 && this.substitutions[c] != null) {
                int keystart = len - 1;
                ArrayList<String> subs = this.substitutions[c];
                int nsub = subs.size();
                int next = in.read();
                for (int i = 0; i != nsub; i += 2) {
                    int j;
                    String key = subs.get(i);
                    String val = subs.get(i + 1);
                    int keylen = key.length();
                    for (j = 1; j < keylen; ++j) {
                        if (j == len - keystart) {
                            if (next != key.charAt(j)) break;
                            buf[len++] = (byte)next;
                            next = in.read();
                            continue;
                        }
                        if (buf[keystart + j] != key.charAt(j)) break;
                    }
                    if (j != keylen) continue;
                    len = keystart;
                    int vallen = val.length();
                    for (int k = 0; k < vallen; ++k) {
                        if (len >= buf.length) {
                            throw new ArrayIndexOutOfBoundsException("index:" + len + " arr-len:" + buf.length + " vallen:" + vallen);
                        }
                        buf[len++] = (byte)val.charAt(k);
                    }
                    break;
                }
                if (next < 0) break;
                c = next;
                buf[len++] = (byte)c;
            }
            if (c == 10) {
                if (len == lineStart + 1 && commentAt >= 0) {
                    skipLine = removeCommented;
                }
                int firstNonSpace = -1;
                int lastNonSpace = 0;
                for (int i = lineStart; i < len - 1; ++i) {
                    if (buf[i] == 32 || buf[i] == 9 || buf[i] == 13) continue;
                    lastNonSpace = i;
                    if (firstNonSpace >= 0) continue;
                    firstNonSpace = i;
                }
                if (lastNonSpace - firstNonSpace >= 4 && buf[firstNonSpace] == 47 && buf[firstNonSpace + 1] == 42 && buf[lastNonSpace - 1] == 42 && buf[lastNonSpace] == 47) {
                    firstNonSpace += 2;
                    while (firstNonSpace < lastNonSpace && buf[firstNonSpace] == 32) {
                        ++firstNonSpace;
                    }
                    lastNonSpace -= 2;
                    while (lastNonSpace > firstNonSpace && buf[lastNonSpace] == 32) {
                        --lastNonSpace;
                    }
                    if (buf[firstNonSpace] == 35) {
                        String rest;
                        Boolean binding;
                        String cmnt = new String(buf, firstNonSpace, lastNonSpace - firstNonSpace + 1, "ISO-8859-1");
                        int sp = cmnt.indexOf(32);
                        cmdLine = this.lineno;
                        if (sp > 0) {
                            cmd = cmnt.substring(0, sp);
                            rest = cmnt.substring(sp).trim();
                            do {
                                int bar;
                                if ((bar = rest.indexOf(124)) < 0) {
                                    binding = this.keywords.get(rest);
                                } else {
                                    binding = this.keywords.get(rest.substring(0, bar));
                                    if (binding != Boolean.TRUE) {
                                        rest = rest.substring(bar + 1);
                                        continue;
                                    }
                                }
                                break;
                            } while (true);
                        } else {
                            cmd = cmnt;
                            rest = "";
                            binding = null;
                        }
                        if ("#ifdef".equals(cmd) || "#ifndef".equals(cmd)) {
                            if (binding == null) {
                                binding = Boolean.FALSE;
                            }
                            ++nesting;
                            if (skipNesting > 0) {
                                commentAt = curIndent;
                            } else if (cmd.charAt(3) == 'n' != (binding == Boolean.FALSE)) {
                                commentAt = curIndent;
                                skipNesting = nesting;
                            }
                            skipLine = removeCommented;
                        } else if ("#else".equals(cmd)) {
                            if (nesting == 0) {
                                this.error("unexpected " + cmd);
                            } else if (nesting == skipNesting) {
                                commentAt = -1;
                                skipNesting = 0;
                            } else {
                                commentAt = curIndent;
                                if (skipNesting == 0) {
                                    skipNesting = nesting;
                                }
                            }
                        } else if ("#endif".equals(cmd)) {
                            if (nesting == 0) {
                                this.error("unexpected " + cmd);
                            }
                            if (nesting == skipNesting) {
                                skipNesting = 0;
                                commentAt = -1;
                            } else if (skipNesting > 0) {
                                commentAt = curIndent;
                            }
                            --nesting;
                            skipLine = removeCommented;
                        } else {
                            this.error("unknown command: " + cmnt);
                        }
                    }
                }
                if (skipLine) {
                    len = lineStart;
                } else {
                    lineStart = len;
                }
                dataStart = -1;
                curIndent = 0;
                ++this.lineno;
                skipLine = false;
                changedLine = 0;
                continue;
            }
            if (dataStart >= 0) continue;
            curIndent = c == 9 ? curIndent + 8 & -8 : curIndent + 1;
        }
        if (nesting != 0) {
            this.lineno = cmdLine;
            this.error("unterminated " + cmd);
        }
        this.resultBuffer = buf;
        this.resultLength = len;
        return changed;
    }

    void putSubstitution(String key, String val) {
        ArrayList<String> substitution;
        int vallen;
        int keylen;
        char key0 = key.charAt(0);
        if (key0 <= ' ' || key0 >= '') {
            this.error("invalid start character of substituton " + key);
        }
        if ((substitution = this.substitutions[key0]) == null) {
            substitution = new ArrayList();
            this.substitutions[key0] = substitution;
        }
        if ((keylen = key.length()) > this.maxkey) {
            this.maxkey = keylen;
        }
        if ((vallen = val.length()) > this.maxkey) {
            this.maxkey = vallen;
        }
        substitution.add(key);
        substitution.add(val);
    }

    String getSubstitution(String key) {
        char key0 = key.charAt(0);
        if (key0 <= ' ' || key0 >= '') {
            return null;
        }
        ArrayList<String> substitution = this.substitutions[key0];
        if (substitution == null) {
            return null;
        }
        int sz = substitution.size();
        for (int i = 0; i < sz; i += 2) {
            if (!substitution.get(i).equals(key)) continue;
            return substitution.get(i + 1);
        }
        return null;
    }

    void handleArg(String arg) {
        block28 : {
            char arg0 = arg.charAt(0);
            if (arg0 == '=' || arg0 == '$' || arg0 == '@') {
                int eq = arg.indexOf(61, 1);
                if (eq < 0) {
                    this.error("missing substiution keyword in " + arg);
                }
                String key = arg.substring(arg0 == '=' ? 1 : 0, eq);
                String val = arg.substring(eq + 1);
                this.putSubstitution(key, val);
            } else {
                if (arg.charAt(0) == '%') {
                    arg = arg.substring(1);
                    int i = 0;
                    do {
                        if (arg.equals("UniformVector")) {
                            String ptype;
                            this.putSubstitution("-*- java -*-", "");
                            this.putSubstitution("$PREAMBLE$", "This file is generated from PrimVector.template. DO NOT EDIT!");
                            String TAG = this.getSubstitution("$TAG$");
                            if (TAG != null && this.getSubstitution("$tag$") == null) {
                                this.putSubstitution("$tag$", TAG.toLowerCase());
                            }
                            if ((ptype = this.getSubstitution("$ptype$")) != null && this.getSubstitution("$Ptype$") == null) {
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
                            break block28;
                        }
                        if (i >= version_features.length) {
                            System.err.println("Unknown version: " + arg);
                            System.exit(-1);
                        }
                        if (arg.equals(version_features[i])) {
                            String features = version_features[i + 1];
                            System.err.println("(variant " + arg + " maps to: " + features + ")");
                            int feat0 = features.charAt(0);
                            int sep = feat0 == 47 || feat0 == 59 ? feat0 : 32;
                            int start = 0;
                            while (start >= 0) {
                                String farg;
                                int ind = features.indexOf(sep, start);
                                if (ind >= 0) {
                                    farg = features.substring(start, ind);
                                    start = ind + 1;
                                } else {
                                    farg = features.substring(start);
                                    start = -1;
                                }
                                if (farg.length() <= 0) continue;
                                this.handleArg(farg);
                            }
                            break block28;
                        }
                        i += 2;
                    } while (true);
                }
                if (arg.charAt(0) == '+') {
                    this.keywords.put(arg.substring(1), Boolean.TRUE);
                } else if (arg.charAt(0) == '-') {
                    int eq = arg.indexOf(61);
                    if (eq > 1) {
                        String keyword = arg.substring(arg.charAt(1) == '-' ? 2 : 1, eq);
                        String value = arg.substring(eq + 1);
                        Boolean b = Boolean.FALSE;
                        if (value.equalsIgnoreCase("true")) {
                            b = Boolean.TRUE;
                        } else if (!value.equalsIgnoreCase("false")) {
                            System.err.println("invalid value " + value + " for " + keyword);
                            System.exit(-1);
                        }
                        this.keywords.put(keyword, b);
                    } else {
                        this.keywords.put(arg.substring(1), Boolean.FALSE);
                    }
                } else {
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
        }
    }

    public static void main(String[] args) {
        PreProcess pp2 = new PreProcess();
        pp2.keywords.put("true", Boolean.TRUE);
        pp2.keywords.put("false", Boolean.FALSE);
        for (int i = 0; i < args.length; ++i) {
            String arg = args[i];
            if (arg.equals("-o") && i + 1 < args.length) {
                pp2.outFilename = args[++i];
                continue;
            }
            pp2.handleArg(arg);
        }
    }
}

