package kawa;

import gnu.expr.Language;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class GuiConsole extends JFrame implements ActionListener, ReplDocument.DocumentCloseListener
{
  private static String CLOSE = "Close";
  private static String EXIT = "Exit";
  private static String NEW = "New";
  private static String NEW_SHARED = "New (Shared)";
  private static String PURGE_MESSAGE = "Purge Buffer";
  
  static int window_number = 0;
  ReplPane pane;
  ReplDocument document;
  
  public static void main(String[] args)
  {
    CheckConsole.setHaveConsole(true);
    int iArg = repl.processArgs(args, 0, args.length);
    repl.getLanguage();
    repl.setArgs(args, iArg);
    repl.checkInitFile();
    new GuiConsole();
  }
  
  public GuiConsole()
  {
    this(Language.getDefaultLanguage(), Environment.getCurrent(), false);
  }
  
  public GuiConsole(ReplDocument doc)
  {
    super("Kawa");
    init(doc);
  }
  
  void init(ReplDocument doc)
  {
    document = doc;
    document.addDocumentCloseListener(this);
    pane = new ReplPane(document);
    window_number += 1;
    setLayout(new java.awt.BorderLayout(0, 0));
    add("Center", new javax.swing.JScrollPane(pane));
    setupMenus();
    
    setLocation(100 * window_number, 50 * window_number);
    setSize(700, 500);
    EventQueue.invokeLater(new Runnable() {
      public void run() { setVisible(true); }
    });
  }
  
  public GuiConsole(Language language, Environment penvironment, boolean shared) {
    super("Kawa");
    repl.getLanguage();
    init(new ReplDocument(language, penvironment, shared));
  }
  



  public void closed(ReplDocument doc)
  {
    close();
  }
  
  void close() {
    document.removeDocumentCloseListener(this);
    dispose();
  }
  





  private void setupMenus()
  {
    java.awt.event.WindowListener windowExitCmd = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        close();
      }
      

    };
    MenuBar menubar = new MenuBar();
    Menu fileMenu = new Menu("File");
    Menu utilitiesMenu = new Menu("Utilities");
    
    menubar.add(fileMenu);
    menubar.add(utilitiesMenu);
    
    MenuItem menuItem = new MenuItem(NEW);
    menuItem.addActionListener(this);
    fileMenu.add(menuItem);
    
    menuItem = new MenuItem(NEW_SHARED);
    menuItem.addActionListener(this);
    fileMenu.add(menuItem);
    
    menuItem = new MenuItem(CLOSE);
    menuItem.addActionListener(this);
    fileMenu.add(menuItem);
    
    menuItem = new MenuItem(EXIT);
    menuItem.addActionListener(this);
    addWindowListener(windowExitCmd);
    fileMenu.add(menuItem);
    
    menuItem = new MenuItem(PURGE_MESSAGE);
    menuItem.addActionListener(this);
    utilitiesMenu.add(menuItem);
    
    setMenuBar(menubar);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    String cmd = e.getActionCommand();
    
    if (cmd.equals(NEW)) {
      new GuiConsole(document.language, Environment.getGlobal(), false);
    } else if (cmd.equals(NEW_SHARED)) {
      new GuiConsole(document.language, document.environment, true);
    } else if (cmd.equals(EXIT)) {
      System.exit(0);
    } else if (cmd.equals(CLOSE)) {
      close();
    } else if (cmd.equals(PURGE_MESSAGE)) {
      pane.document.deleteOldText();
    }
    else {
      OutPort.outDefault().println("Unknown menu action: " + cmd);
    }
  }
}
