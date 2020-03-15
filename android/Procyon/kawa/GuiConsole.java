// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import gnu.kawa.io.OutPort;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.MenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.EventQueue;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import gnu.mapping.Environment;
import gnu.expr.Language;
import gnu.kawa.io.CheckConsole;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class GuiConsole extends JFrame implements ActionListener, ReplDocument.DocumentCloseListener
{
    private static String CLOSE;
    private static String EXIT;
    private static String NEW;
    private static String NEW_SHARED;
    private static String PURGE_MESSAGE;
    static int window_number;
    ReplPane pane;
    ReplDocument document;
    
    public static void main(final String[] args) {
        CheckConsole.setHaveConsole(true);
        final int iArg = repl.processArgs(args, 0, args.length);
        repl.getLanguage();
        repl.setArgs(args, iArg);
        repl.checkInitFile();
        new GuiConsole();
    }
    
    public GuiConsole() {
        this(Language.getDefaultLanguage(), Environment.getCurrent(), false);
    }
    
    public GuiConsole(final ReplDocument doc) {
        super("Kawa");
        this.init(doc);
    }
    
    void init(final ReplDocument doc) {
        (this.document = doc).addDocumentCloseListener(this);
        this.pane = new ReplPane(this.document);
        ++GuiConsole.window_number;
        this.setLayout(new BorderLayout(0, 0));
        this.add("Center", new JScrollPane(this.pane));
        this.setupMenus();
        this.setLocation(100 * GuiConsole.window_number, 50 * GuiConsole.window_number);
        this.setSize(700, 500);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiConsole.this.setVisible(true);
            }
        });
    }
    
    public GuiConsole(final Language language, final Environment penvironment, final boolean shared) {
        super("Kawa");
        repl.getLanguage();
        this.init(new ReplDocument(language, penvironment, shared));
    }
    
    @Override
    public void closed(final ReplDocument doc) {
        this.close();
    }
    
    void close() {
        this.document.removeDocumentCloseListener(this);
        this.dispose();
    }
    
    private void setupMenus() {
        final WindowListener windowExitCmd = new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                GuiConsole.this.close();
            }
        };
        final MenuBar menubar = new MenuBar();
        final Menu fileMenu = new Menu("File");
        final Menu utilitiesMenu = new Menu("Utilities");
        menubar.add(fileMenu);
        menubar.add(utilitiesMenu);
        MenuItem menuItem = new MenuItem(GuiConsole.NEW);
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);
        menuItem = new MenuItem(GuiConsole.NEW_SHARED);
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);
        menuItem = new MenuItem(GuiConsole.CLOSE);
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);
        menuItem = new MenuItem(GuiConsole.EXIT);
        menuItem.addActionListener(this);
        this.addWindowListener(windowExitCmd);
        fileMenu.add(menuItem);
        menuItem = new MenuItem(GuiConsole.PURGE_MESSAGE);
        menuItem.addActionListener(this);
        utilitiesMenu.add(menuItem);
        this.setMenuBar(menubar);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        if (cmd.equals(GuiConsole.NEW)) {
            new GuiConsole(this.document.language, Environment.getGlobal(), false);
        }
        else if (cmd.equals(GuiConsole.NEW_SHARED)) {
            new GuiConsole(this.document.language, this.document.environment, true);
        }
        else if (cmd.equals(GuiConsole.EXIT)) {
            System.exit(0);
        }
        else if (cmd.equals(GuiConsole.CLOSE)) {
            this.close();
        }
        else if (cmd.equals(GuiConsole.PURGE_MESSAGE)) {
            this.pane.document.deleteOldText();
        }
        else {
            OutPort.outDefault().println("Unknown menu action: " + cmd);
        }
    }
    
    static {
        GuiConsole.CLOSE = "Close";
        GuiConsole.EXIT = "Exit";
        GuiConsole.NEW = "New";
        GuiConsole.NEW_SHARED = "New (Shared)";
        GuiConsole.PURGE_MESSAGE = "Purge Buffer";
        GuiConsole.window_number = 0;
    }
}
