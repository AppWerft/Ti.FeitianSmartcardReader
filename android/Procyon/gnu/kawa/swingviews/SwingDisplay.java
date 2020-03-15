// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.kawa.models.Picture;
import gnu.kawa.models.Model;
import gnu.mapping.Procedure;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Container;
import gnu.kawa.models.Spacer;
import gnu.kawa.models.Box;
import javax.swing.text.AbstractDocument;
import javax.swing.text.PlainDocument;
import javax.swing.text.Document;
import javax.swing.JTextField;
import gnu.kawa.models.Text;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Label;
import gnu.kawa.models.Button;
import javax.swing.JMenuBar;
import gnu.kawa.models.Window;
import java.util.WeakHashMap;
import gnu.kawa.models.Display;

public class SwingDisplay extends Display
{
    static final SwingDisplay instance;
    private static WeakHashMap documents;
    
    public static Display getInstance() {
        return SwingDisplay.instance;
    }
    
    @Override
    public Window makeWindow() {
        final SwingFrame window = new SwingFrame(null, null, null);
        window.display = this;
        return window;
    }
    
    @Override
    public void addButton(final Button model, final Object where) {
        this.addView(new SwingButton(model), where);
    }
    
    @Override
    public void addLabel(final Label model, final Object where) {
        this.addView(new SwingLabel(model), where);
    }
    
    @Override
    public void addImage(final DrawImage model, final Object where) {
        this.addView(new JLabel(new ImageIcon(model.getImage())), where);
    }
    
    @Override
    public void addText(final Text model, final Object where) {
        this.addView(new JTextField(getSwingDocument(model), model.getText(), 50), where);
    }
    
    static synchronized Document getSwingDocument(final Text model) {
        if (SwingDisplay.documents == null) {
            SwingDisplay.documents = new WeakHashMap();
        }
        final Object existing = SwingDisplay.documents.get(model);
        if (existing != null) {
            return (Document)existing;
        }
        final Document doc = new PlainDocument(new SwingContent(model.buffer));
        SwingDisplay.documents.put(model, doc);
        return doc;
    }
    
    @Override
    public void addBox(final Box model, final Object where) {
        this.addView(new SwingBox(model, this), where);
    }
    
    @Override
    public void addSpacer(final Spacer model, final Object where) {
        this.addView(new javax.swing.Box.Filler(model.getMinimumSize(), model.getPreferredSize(), model.getMaximumSize()), where);
    }
    
    @Override
    public void addView(final Object view, final Object where) {
        ((Container)where).add((Component)view);
    }
    
    public static ActionListener makeActionListener(final Object command) {
        if (command instanceof ActionListener) {
            return (ActionListener)command;
        }
        return new ProcActionListener((Procedure)command);
    }
    
    @Override
    public Model coerceToModel(final Object component) {
        if (component instanceof Component) {
            return new ComponentModel((Component)component);
        }
        if (component instanceof Picture) {
            return new ComponentModel(new SwingPicture((Picture)component));
        }
        return super.coerceToModel(component);
    }
    
    static {
        instance = new SwingDisplay();
        SwingDisplay.documents = null;
    }
}
