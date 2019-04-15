/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.models.Display;
import gnu.kawa.models.Picture;
import gnu.kawa.models.Viewable;
import gnu.kawa.models.Window;
import gnu.kawa.swingviews.SwingDisplay;
import gnu.kawa.swingviews.SwingPicture;
import gnu.lists.AbstractSequence;
import gnu.lists.FString;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class SwingFrame
extends JFrame
implements Window {
    SwingDisplay display;

    @Override
    public Display getDisplay() {
        return this.display;
    }

    public SwingFrame(String title, JMenuBar menubar, Object contents) {
        SwingFrame fr = this;
        if (title != null) {
            fr.setTitle(title);
        }
        if (menubar != null) {
            fr.setJMenuBar(menubar);
        }
        Container pane = this.getContentPane();
        pane.setLayout(new BoxLayout(pane, 0));
        this.addComponent(contents);
    }

    @Override
    public void setContent(Object content) {
        this.setContentPane(new JPanel());
        this.addComponent(content);
        this.pack();
    }

    @Override
    public void setMenuBar(Object menubar) {
        this.setJMenuBar((JMenuBar)menubar);
    }

    public void addComponent(Object contents) {
        if (contents instanceof FString || contents instanceof String) {
            this.getContentPane().add(new JLabel(contents.toString()));
        } else if (contents instanceof AbstractSequence) {
            AbstractSequence seq = (AbstractSequence)contents;
            int iter = seq.startPos();
            while ((iter = seq.nextPos(iter)) != 0) {
                this.addComponent(seq.getPosPrevious(iter));
            }
        } else if (contents instanceof Viewable) {
            ((Viewable)contents).makeView(this.getDisplay(), this.getContentPane());
        } else if (contents instanceof Picture) {
            this.getContentPane().add(new SwingPicture((Picture)contents));
        } else if (contents != null) {
            this.getContentPane().add((Component)contents);
        }
    }

    @Override
    public void open() {
        this.pack();
        this.setVisible(true);
    }
}

