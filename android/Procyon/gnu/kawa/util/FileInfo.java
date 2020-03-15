// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.io.FileOutputStream;
import java.net.URI;
import gnu.kawa.io.Path;
import java.util.regex.Matcher;
import java.util.Vector;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.regex.Pattern;
import gnu.kawa.io.OutPort;
import java.io.ByteArrayOutputStream;
import gnu.kawa.io.InPort;
import java.io.FileInputStream;
import java.io.File;
import java.util.Hashtable;

class FileInfo
{
    static Hashtable fileMap;
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
    static final Pattern childPat;
    static final Pattern parentPat;
    static final Pattern linkPat;
    
    public static FileInfo find(final File file) throws Throwable {
        final String abs = file.getCanonicalPath();
        FileInfo info = FileInfo.fileMap.get(abs);
        if (info == null) {
            info = new FileInfo();
            info.file = file;
            FileInfo.fileMap.put(abs, info);
        }
        return info;
    }
    
    public void scan() throws Throwable {
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
        final int lineno = 0;
        boolean inNavbar = false;
        boolean inChildList = false;
        final Vector chvec = new Vector();
        while (true) {
            final String line = this.in.readLine();
            if (line == null) {
                break;
            }
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
                    }
                    else {
                        final Matcher childMatcher = FileInfo.childPat.matcher(line);
                        if (childMatcher.find()) {
                            chvec.add(childMatcher.group());
                        }
                        final Matcher parentMatcher = FileInfo.parentPat.matcher(line);
                        if (parentMatcher.find() && this.parentName == null) {
                            this.parentName = parentMatcher.group(1);
                        }
                    }
                }
                if (line.indexOf("<!--start-children-toc-->") >= 0) {
                    inChildList = true;
                }
            }
            else if (line.indexOf("<!--start-generated-navbar-->") >= 0) {
                inNavbar = true;
            }
            if (!this.writeNeeded || inNavbar) {
                continue;
            }
            this.cout.println(line);
        }
        final String[] charr = new String[chvec.size()];
        this.nchildren = charr.length;
        chvec.copyInto(charr);
        this.childLinkText = charr;
        if (!this.writeNeeded) {
            this.in.close();
        }
        if (this.parentName != null) {
            final File parentFile = new File(this.file.toURI().resolve(this.parentName));
            final FileInfo parentInfo = find(parentFile);
            parentInfo.scan();
            this.parent = parentInfo;
        }
    }
    
    public void writeLinks(final int uplevel, final StringBuffer out) throws Throwable {
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
        }
        else {
            out.append("<ul>\n");
        }
        final URI thisURI = this.file.toURI();
        final URI currentURI = current.file.toURI();
        for (int j = 0; j < current.nchildren; ++j) {
            String linkText = current.childLinkText[j];
            boolean ancestor = false;
            if (uplevel > 0) {
                final Matcher linkMatcher = FileInfo.linkPat.matcher(linkText);
                linkMatcher.find();
                String hrefText = linkMatcher.group(1);
                final URI linkURI = currentURI.resolve(hrefText);
                linkText = linkMatcher.replaceFirst(" href=\"" + Path.relativize(linkURI.toString(), thisURI.toString()) + "\"");
                final int hash = hrefText.indexOf(35);
                if (hash >= 0) {
                    hrefText = hrefText.substring(0, hash);
                }
                final FileInfo curchild = find(new File(currentURI.resolve(hrefText)));
                ancestor = (curchild == thischild);
                if (!ancestor && uplevel > 1) {
                    continue;
                }
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
        int level = 0;
        for (FileInfo current = this; current.parent != null; current = current.parent, ++level) {}
        this.cout.println("<!--start-generated-navbar-->");
        this.writeLinks(level, this.newNavbarText);
        this.cout.print(this.newNavbarText);
        this.cout.println("<!--end-generated-navbar-->");
        while (true) {
            final String line = this.in.readLine();
            if (line == null) {
                break;
            }
            this.cout.println(line);
        }
        final StringBuffer sbuf = new StringBuffer();
        this.in.close();
        if (this.oldNavbarText.toString().equals(this.newNavbarText.toString())) {
            System.err.println("fixup " + this.file + " - no change");
        }
        else {
            final FileOutputStream outs = new FileOutputStream(this.file);
            final byte[] bbuf = this.bout.toByteArray();
            outs.write(bbuf);
            outs.close();
            System.err.println("fixup " + this.file + " - updated");
        }
    }
    
    static {
        FileInfo.fileMap = new Hashtable();
        childPat = Pattern.compile("<a .*</a>");
        parentPat = Pattern.compile("<ul[^>]* parent=['\"]([^'\"]*)['\"]");
        linkPat = Pattern.compile(" href=['\"]([^'\"]*)['\"]");
    }
}
