package gnu.kawa.util;

import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;










































class FileInfo
{
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
  
  FileInfo() {}
  
  public static FileInfo find(File file)
    throws Throwable
  {
    String abs = file.getCanonicalPath();
    FileInfo info = (FileInfo)fileMap.get(abs);
    if (info == null)
    {
      info = new FileInfo();
      file = file;
      fileMap.put(abs, info);
    }
    return info;
  }
  
  static final Pattern childPat = Pattern.compile("<a .*</a>");
  static final Pattern parentPat = Pattern.compile("<ul[^>]* parent=['\"]([^'\"]*)['\"]");
  
  static final Pattern linkPat = Pattern.compile(" href=['\"]([^'\"]*)['\"]");
  
  public void scan() throws Throwable
  {
    if (scanned)
      return;
    scanned = true;
    fin = new FileInputStream(file);
    in = new InPort(new BufferedInputStream(fin));
    oldNavbarText = new StringBuffer();
    newNavbarText = new StringBuffer();
    if (writeNeeded)
    {
      bout = new ByteArrayOutputStream();
      cout = new OutPort(bout);
    }
    int lineno = 0;
    boolean inNavbar = false;
    boolean inChildList = false;
    Vector chvec = new Vector();
    for (;;)
    {
      String line = in.readLine();
      if (line == null)
        break;
      if (inNavbar)
      {
        if (line.indexOf("<!--end-generated-navbar-->") >= 0)
        {
          inNavbar = false;
          break;
        }
        oldNavbarText.append(line);
        oldNavbarText.append('\n');
        if (inChildList)
        {
          if (line.indexOf("<!--end-children-toc-->") >= 0) {
            inChildList = false;
          }
          else {
            Matcher childMatcher = childPat.matcher(line);
            if (childMatcher.find())
            {
              chvec.add(childMatcher.group());
            }
            Matcher parentMatcher = parentPat.matcher(line);
            if ((parentMatcher.find()) && (parentName == null))
            {
              parentName = parentMatcher.group(1);
            }
          }
        }
        if (line.indexOf("<!--start-children-toc-->") >= 0) {
          inChildList = true;
        }
        
      }
      else if (line.indexOf("<!--start-generated-navbar-->") >= 0)
      {
        inNavbar = true;
      }
      
      if ((writeNeeded) && (!inNavbar))
        cout.println(line);
    }
    String[] charr = new String[chvec.size()];
    nchildren = charr.length;
    chvec.copyInto(charr);
    childLinkText = charr;
    if (!writeNeeded)
      in.close();
    if (parentName != null)
    {
      File parentFile = new File(file.toURI().resolve(parentName));
      FileInfo parentInfo = find(parentFile);
      parentInfo.scan();
      parent = parentInfo;
    }
  }
  
  public void writeLinks(int uplevel, StringBuffer out)
    throws Throwable
  {
    FileInfo current = this;
    FileInfo thischild = null;
    int i = uplevel; for (;;) { i--; if (i < 0)
        break;
      thischild = current;
      current = parent;
    }
    if (uplevel == 0)
      out.append("<!--start-children-toc-->\n");
    if ((uplevel == 0) && (parentName != null))
    {
      out.append("<ul parent=\"");
      out.append(parentName);
      out.append("\">\n");
    }
    else {
      out.append("<ul>\n"); }
    URI thisURI = file.toURI();
    URI currentURI = file.toURI();
    for (int i = 0; i < nchildren; i++)
    {
      String linkText = childLinkText[i];
      boolean ancestor = false;
      
      if (uplevel > 0)
      {
        Matcher linkMatcher = linkPat.matcher(linkText);
        linkMatcher.find();
        String hrefText = linkMatcher.group(1);
        URI linkURI = currentURI.resolve(hrefText);
        linkText = linkMatcher.replaceFirst(" href=\"" + Path.relativize(linkURI.toString(), thisURI.toString()) + "\"");
        int hash = hrefText.indexOf('#');
        if (hash >= 0)
          hrefText = hrefText.substring(0, hash);
        FileInfo curchild = find(new File(currentURI.resolve(hrefText)));
        ancestor = curchild == thischild;
        
        if ((!ancestor) && (uplevel > 1)) {}
      }
      else {
        out.append("<li>");
        out.append(linkText);
        if (ancestor)
        {
          out.append('\n');
          writeLinks(uplevel - 1, out);
        }
        out.append("</li>\n");
      } }
    out.append("</ul>\n");
    if (uplevel == 0) {
      out.append("<!--end-children-toc-->\n");
    }
  }
  
  public void write() throws Throwable {
    int level = 0;
    FileInfo current = this;
    while (parent != null)
    {
      current = parent;
      level++;
    }
    cout.println("<!--start-generated-navbar-->");
    writeLinks(level, newNavbarText);
    cout.print(newNavbarText);
    cout.println("<!--end-generated-navbar-->");
    for (;;)
    {
      String line = in.readLine();
      if (line == null)
        break;
      cout.println(line);
    }
    StringBuffer sbuf = new StringBuffer();
    in.close();
    if (oldNavbarText.toString().equals(newNavbarText.toString())) {
      System.err.println("fixup " + file + " - no change");
    }
    else {
      FileOutputStream outs = new FileOutputStream(file);
      byte[] bbuf = bout.toByteArray();
      outs.write(bbuf);
      outs.close();
      System.err.println("fixup " + file + " - updated");
    }
  }
}
