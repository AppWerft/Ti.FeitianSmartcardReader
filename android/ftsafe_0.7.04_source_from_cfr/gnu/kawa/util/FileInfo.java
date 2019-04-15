/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileInfo {
    static Hashtable fileMap = new Hashtable();
    boolean writeNeeded;
    String path;
    File file;
    FileInfo parent;
    String parentName;
    String[] childLinkText;
    int nchildren;
    FileInputStream fin;
    InPort in;
    ByteArrayOutputStream bout;
    OutPort cout;
    boolean scanned;
    StringBuffer beforeNavbarText;
    StringBuffer oldNavbarText;
    StringBuffer newNavbarText;
    static final Pattern childPat = Pattern.compile("<a .*</a>");
    static final Pattern parentPat = Pattern.compile("<ul[^>]* parent=['\"]([^'\"]*)['\"]");
    static final Pattern linkPat = Pattern.compile(" href=['\"]([^'\"]*)['\"]");

    FileInfo() {
    }

    public static FileInfo find(File file2) throws Throwable {
        String abs = file2.getCanonicalPath();
        FileInfo info = (FileInfo)fileMap.get(abs);
        if (info == null) {
            info = new FileInfo();
            info.file = file2;
            fileMap.put(abs, info);
        }
        return info;
    }

    public void scan() throws Throwable {
        String line;
        if (this.scanned) {
            return;
        }
        this.scanned = true;
        this.fin = new FileInputStream(this.file);
        this.in = new InPort(new BufferedInputStream(this.fin));
        this.oldNavbarText = new StringBuffer();
        this.newNavbarText = new StringBuffer();
        if (this.writeNeeded) {
            this.bout = new ByteArrayOutputStream();
            this.cout = new OutPort(this.bout);
        }
        boolean lineno = false;
        boolean inNavbar = false;
        boolean inChildList = false;
        Vector<String> chvec = new Vector<String>();
        while ((line = this.in.readLine()) != null) {
            if (inNavbar) {
                if (line.indexOf("<!--end-generated-navbar-->") >= 0) {
                    inNavbar = false;
                    break;
                }
                this.oldNavbarText.append(line);
                this.oldNavbarText.append('\n');
                if (inChildList) {
                    if (line.indexOf("<!--end-children-toc-->") >= 0) {
                        inChildList = false;
                    } else {
                        Matcher parentMatcher;
                        Matcher childMatcher = childPat.matcher(line);
                        if (childMatcher.find()) {
                            chvec.add(childMatcher.group());
                        }
                        if ((parentMatcher = parentPat.matcher(line)).find() && this.parentName == null) {
                            this.parentName = parentMatcher.group(1);
                        }
                    }
                }
                if (line.indexOf("<!--start-children-toc-->") >= 0) {
                    inChildList = true;
                }
            } else if (line.indexOf("<!--start-generated-navbar-->") >= 0) {
                inNavbar = true;
            }
            if (!this.writeNeeded || inNavbar) continue;
            this.cout.println(line);
        }
        Object[] charr = new String[chvec.size()];
        this.nchildren = charr.length;
        chvec.copyInto(charr);
        this.childLinkText = charr;
        if (!this.writeNeeded) {
            this.in.close();
        }
        if (this.parentName != null) {
            File parentFile = new File(this.file.toURI().resolve(this.parentName));
            FileInfo parentInfo = FileInfo.find(parentFile);
            parentInfo.scan();
            this.parent = parentInfo;
        }
    }

    public void writeLinks(int uplevel, StringBuffer out) throws Throwable {
        FileInfo current = this;
        FileInfo thischild = null;
        int i = uplevel;
        while (--i >= 0) {
            thischild = current;
            current = current.parent;
        }
        if (uplevel == 0) {
            out.append("<!--start-children-toc-->\n");
        }
        if (uplevel == 0 && this.parentName != null) {
            out.append("<ul parent=\"");
            out.append(this.parentName);
            out.append("\">\n");
        } else {
            out.append("<ul>\n");
        }
        URI thisURI = this.file.toURI();
        URI currentURI = current.file.toURI();
        for (int i2 = 0; i2 < current.nchildren; ++i2) {
            String linkText = current.childLinkText[i2];
            boolean ancestor = false;
            if (uplevel > 0) {
                FileInfo curchild;
                Matcher linkMatcher = linkPat.matcher(linkText);
                linkMatcher.find();
                String hrefText = linkMatcher.group(1);
                URI linkURI = currentURI.resolve(hrefText);
                linkText = linkMatcher.replaceFirst(" href=\"" + Path.relativize(linkURI.toString(), thisURI.toString()) + "\"");
                int hash = hrefText.indexOf(35);
                if (hash >= 0) {
                    hrefText = hrefText.substring(0, hash);
                }
                boolean bl = ancestor = (curchild = FileInfo.find(new File(currentURI.resolve(hrefText)))) == thischild;
                if (!ancestor && uplevel > 1) continue;
            }
            out.append("<li>");
            out.append(linkText);
            if (ancestor) {
                out.append('\n');
                this.writeLinks(uplevel - 1, out);
            }
            out.append("</li>\n");
        }
        out.append("</ul>\n");
        if (uplevel == 0) {
            out.append("<!--end-children-toc-->\n");
        }
    }

    public void write() throws Throwable {
        String line;
        int level = 0;
        FileInfo current = this;
        while (current.parent != null) {
            current = current.parent;
            ++level;
        }
        this.cout.println("<!--start-generated-navbar-->");
        this.writeLinks(level, this.newNavbarText);
        this.cout.print(this.newNavbarText);
        this.cout.println("<!--end-generated-navbar-->");
        while ((line = this.in.readLine()) != null) {
            this.cout.println(line);
        }
        StringBuffer sbuf = new StringBuffer();
        this.in.close();
        if (this.oldNavbarText.toString().equals(this.newNavbarText.toString())) {
            System.err.println("fixup " + this.file + " - no change");
        } else {
            FileOutputStream outs = new FileOutputStream(this.file);
            byte[] bbuf = this.bout.toByteArray();
            outs.write(bbuf);
            outs.close();
            System.err.println("fixup " + this.file + " - updated");
        }
    }
}

