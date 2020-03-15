// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.models.Picture;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Viewable;
import gnu.kawa.format.GenericFormat;
import gnu.lists.Consumer;
import gnu.kawa.format.AbstractFormat;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;
import java.awt.Component;
import javax.swing.text.MutableAttributeSet;
import java.io.Writer;
import gnu.kawa.io.Path;
import javax.swing.text.AttributeSet;
import gnu.kawa.io.OutPort;

public class ReplPaneOutPort extends OutPort
{
    ReplDocument document;
    AttributeSet style;
    String str;
    TextPaneWriter tout;
    
    public ReplPaneOutPort(final ReplDocument document, final String path, final AttributeSet style) {
        this(new TextPaneWriter(document, style), document, path, style);
    }
    
    ReplPaneOutPort(final TextPaneWriter tout, final ReplDocument document, final String path, final AttributeSet style) {
        super(tout, true, true, Path.valueOf(path));
        this.str = "";
        this.tout = tout;
        this.document = document;
        this.style = style;
    }
    
    public void write(final String str, final MutableAttributeSet style) {
        this.flush();
        this.document.write(str, style);
        this.setColumnNumber(1);
    }
    
    public synchronized void write(final Component c) {
        final MutableAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setComponent(style, c);
        this.write(" ", style);
    }
    
    public static GenericFormat.TryFormatResult writeComponent(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Component)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput() || !(out instanceof ReplPaneOutPort)) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        ((ReplPaneOutPort)out).write((Component)value);
        return GenericFormat.TryFormatResult.HANDLED;
    }
    
    public static GenericFormat.TryFormatResult writeViewable(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Viewable)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput() || !(out instanceof ReplPaneOutPort)) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        final MutableAttributeSet style = new SimpleAttributeSet();
        style.addAttribute("$ename", "Viewable");
        style.addAttribute(ReplPane.ViewableAttribute, value);
        ((ReplPaneOutPort)out).write(" ", style);
        return GenericFormat.TryFormatResult.HANDLED;
    }
    
    public static GenericFormat.TryFormatResult writePicture(final Object value, final AbstractFormat format, final Consumer out) {
        final Picture pic = DrawImage.toPictureOrNull(value);
        if (pic == null) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput() || !(out instanceof ReplPaneOutPort)) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        final MutableAttributeSet style = new SimpleAttributeSet();
        style.addAttribute("$ename", "Picture");
        style.addAttribute(ReplPane.PictureAttribute, pic);
        ((ReplPaneOutPort)out).write(" ", style);
        return GenericFormat.TryFormatResult.HANDLED;
    }
    
    static {
        final Class thisCls = ReplPaneOutPort.class;
        final GenericFormat format = DisplayFormat.standardFormat;
        format.invalidateCache(BufferedImage.class);
        format.invalidateCache(Shape.class);
        format.invalidateCache(Picture.class);
        format.invalidateCache(Viewable.class);
        format.invalidateCache(Component.class);
        format.add(thisCls, "writePicture");
        format.add(thisCls, "writeComponent");
        format.add(thisCls, "writeViewable");
    }
}
