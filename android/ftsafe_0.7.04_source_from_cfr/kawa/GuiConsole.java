/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.expr.Language;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import kawa.ReplDocument;
import kawa.ReplPane;
import kawa.repl;

public class GuiConsole
extends JFrame
implements ActionListener,
ReplDocument.DocumentCloseListener {
    private static String CLOSE = "Close";
    private static String EXIT = "Exit";
    private static String NEW = "New";
    private static String NEW_SHARED = "New (Shared)";
    private static String PURGE_MESSAGE = "Purge Buffer";
    static int window_number = 0;
    ReplPane pane;
    ReplDocument document;

    public static void main(String[] args) {
        CheckConsole.setHaveConsole(true);
        int iArg = repl.processArgs(args, 0, args.length);
        repl.getLanguage();
        repl.setArgs(args, iArg);
        repl.checkInitFile();
        new GuiConsole();
    }

    public GuiConsole() {
        this(Language.getDefaultLanguage(), Environment.getCurrent(), false);
    }

    public GuiConsole(ReplDocument doc) {
        super("Kawa");
        this.init(doc);
    }

    void init(ReplDocument doc) {
        this.document = doc;
        this.document.addDocumentCloseListener(this);
        this.pane = new ReplPane(this.document);
        this.setLayout(new BorderLayout(0, 0));
        this.add("Center", new JScrollPane(this.pane));
        this.setupMenus();
        this.setLocation(100 * ++window_number, 50 * window_number);
        this.setSize(700, 500);
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                GuiConsole.this.setVisible(true);
            }
        });
    }

    public GuiConsole(Language language, Environment penvironment, boolean shared) {
        super("Kawa");
        repl.getLanguage();
        this.init(new ReplDocument(language, penvironment, shared));
    }

    @Override
    public void closed(ReplDocument doc) {
        this.close();
    }

    void close() {
        this.document.removeDocumentCloseListener(this);
        this.dispose();
    }

    private void setupMenus() {
        WindowAdapter windowExitCmd = new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                GuiConsole.this.close();
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
        this.addWindowListener(windowExitCmd);
        fileMenu.add(menuItem);
        menuItem = new MenuItem(PURGE_MESSAGE);
        menuItem.addActionListener(this);
        utilitiesMenu.add(menuItem);
        this.setMenuBar(menubar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(NEW)) {
            new GuiConsole(this.document.language, Environment.getGlobal(), false);
        } else if (cmd.equals(NEW_SHARED)) {
            new GuiConsole(this.document.language, this.document.environment, true);
        } else if (cmd.equals(EXIT)) {
            System.exit(0);
        } else if (cmd.equals(CLOSE)) {
            this.close();
        } else if (cmd.equals(PURGE_MESSAGE)) {
            this.pane.document.deleteOldText();
        } else {
            OutPort.outDefault().println("Unknown menu action: " + cmd);
        }
    }

}

