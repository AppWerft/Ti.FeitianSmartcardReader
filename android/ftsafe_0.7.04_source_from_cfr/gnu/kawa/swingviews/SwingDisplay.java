/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Display;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Picture;
import gnu.kawa.models.Spacer;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.kawa.swingviews.ComponentModel;
import gnu.kawa.swingviews.ProcActionListener;
import gnu.kawa.swingviews.SwingBox;
import gnu.kawa.swingviews.SwingButton;
import gnu.kawa.swingviews.SwingContent;
import gnu.kawa.swingviews.SwingFrame;
import gnu.kawa.swingviews.SwingLabel;
import gnu.kawa.swingviews.SwingPicture;
import gnu.lists.CharBuffer;
import gnu.mapping.Procedure;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.WeakHashMap;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class SwingDisplay
extends Display {
    static final SwingDisplay instance = new SwingDisplay();
    private static WeakHashMap documents = null;

    public static Display getInstance() {
        return instance;
    }

    @Override
    public Window makeWindow() {
        SwingFrame window = new SwingFrame(null, null, null);
        window.display = this;
        return window;
    }

    @Override
    public void addButton(Button model, Object where) {
        this.addView(new SwingButton(model), where);
    }

    @Override
    public void addLabel(Label model, Object where) {
        this.addView(new SwingLabel(model), where);
    }

    @Override
    public void addImage(DrawImage model, Object where) {
        this.addView(new JLabel(new ImageIcon(model.getImage())), where);
    }

    @Override
    public void addText(Text model, Object where) {
        this.addView(new JTextField(SwingDisplay.getSwingDocument(model), model.getText(), 50), where);
    }

    static synchronized Document getSwingDocument(Text model) {
        Object existing;
        if (documents == null) {
            documents = new WeakHashMap();
        }
        if ((existing = documents.get(model)) != null) {
            return (Document)existing;
        }
        PlainDocument doc = new PlainDocument(new SwingContent(model.buffer));
        documents.put(model, doc);
        return doc;
    }

    @Override
    public void addBox(Box model, Object where) {
        this.addView(new SwingBox(model, this), where);
    }

    @Override
    public void addSpacer(Spacer model, Object where) {
        this.addView(new Box.Filler(model.getMinimumSize(), model.getPreferredSize(), model.getMaximumSize()), where);
    }

    @Override
    public void addView(Object view, Object where) {
        ((Container)where).add((Component)view);
    }

    public static ActionListener makeActionListener(Object command) {
        if (command instanceof ActionListener) {
            return (ActionListener)command;
        }
        return new ProcActionListener((Procedure)command);
    }

    @Override
    public Model coerceToModel(Object component) {
        if (component instanceof Component) {
            return new ComponentModel((Component)component);
        }
        if (component instanceof Picture) {
            return new ComponentModel(new SwingPicture((Picture)component));
        }
        return super.coerceToModel(component);
    }
}

