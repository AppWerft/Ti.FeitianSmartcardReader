/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.kawa.format.AbstractFormat;
import gnu.kawa.format.GenericFormat;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Picture;
import gnu.kawa.models.Viewable;
import gnu.lists.Consumer;
import java.awt.Component;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.Writer;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import kawa.ReplDocument;
import kawa.ReplPane;
import kawa.TextPaneWriter;

public class ReplPaneOutPort
extends OutPort {
    ReplDocument document;
    AttributeSet style;
    String str = "";
    TextPaneWriter tout;

    public ReplPaneOutPort(ReplDocument document, String path, AttributeSet style) {
        this(new TextPaneWriter(document, style), document, path, style);
    }

    ReplPaneOutPort(TextPaneWriter tout, ReplDocument document, String path, AttributeSet style) {
        super(tout, true, true, Path.valueOf(path));
        this.tout = tout;
        this.document = document;
        this.style = style;
    }

    public void write(String str, MutableAttributeSet style) {
        this.flush();
        this.document.write(str, style);
        this.setColumnNumber(1);
    }

    public synchronized void write(Component c) {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setComponent(style, c);
        this.write(" ", style);
    }

    public static GenericFormat.TryFormatResult writeComponent(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Component)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput() || !(out instanceof ReplPaneOutPort)) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        ((ReplPaneOutPort)out).write((Component)value);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeViewable(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Viewable)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput() || !(out instanceof ReplPaneOutPort)) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        SimpleAttributeSet style = new SimpleAttributeSet();
        style.addAttribute("$ename", "Viewable");
        style.addAttribute(ReplPane.ViewableAttribute, value);
        ((ReplPaneOutPort)out).write(" ", style);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writePicture(Object value, AbstractFormat format, Consumer out) {
        Picture pic = DrawImage.toPictureOrNull(value);
        if (pic == null) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput() || !(out instanceof ReplPaneOutPort)) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        SimpleAttributeSet style = new SimpleAttributeSet();
        style.addAttribute("$ename", "Picture");
        style.addAttribute(ReplPane.PictureAttribute, pic);
        ((ReplPaneOutPort)out).write(" ", style);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    static {
        Class<ReplPaneOutPort> thisCls = ReplPaneOutPort.class;
        GenericFormat format = DisplayFormat.standardFormat;
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

