// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import gnu.lists.FString;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.lang.reflect.Method;
import gnu.mapping.WrappedException;
import gnu.mapping.ThreadLocation;

public abstract class Display
{
    public static ThreadLocation myDisplay;
    
    public static Display getInstance() {
        final Object d = Display.myDisplay.get(null);
        if (d instanceof Display) {
            return (Display)d;
        }
        String name = (d == null) ? "swing" : d.toString();
        final Class[] noClasses = new Class[0];
        while (true) {
            final int comma = name.indexOf(44);
            String rest = null;
            if (comma >= 0) {
                rest = name.substring(comma + 1);
                name = name.substring(0, comma);
            }
            if (name.equals("swing")) {
                name = "gnu.kawa.swingviews.SwingDisplay";
            }
            else if (name.equals("swt")) {
                name = "gnu.kawa.swtviews.SwtDisplay";
            }
            else if (name.equals("echo2")) {
                name = "gnu.kawa.echo2.Echo2Display";
            }
            try {
                final Class clas = Class.forName(name);
                final Method method = clas.getDeclaredMethod("getInstance", (Class[])noClasses);
                return (Display)method.invoke(null, new Object[0]);
            }
            catch (ClassNotFoundException ex2) {
                if (rest == null) {
                    throw new RuntimeException("no display toolkit: " + d);
                }
                name = rest;
            }
            catch (Exception ex) {
                throw WrappedException.wrapIfNeeded(ex);
            }
        }
    }
    
    public abstract Window makeWindow();
    
    public abstract void addButton(final Button p0, final Object p1);
    
    public abstract void addLabel(final Label p0, final Object p1);
    
    public abstract void addImage(final DrawImage p0, final Object p1);
    
    public void addText(final Text model, final Object where) {
        throw new Error("makeView called on Text");
    }
    
    public void addSpacer(final Spacer model, final Object where) {
        throw new Error("makeView called on Spacer");
    }
    
    public abstract void addBox(final Box p0, final Object p1);
    
    public abstract void addView(final Object p0, final Object p1);
    
    public static Dimension asDimension(final Dimension2D dim) {
        if (dim instanceof Dimension || dim == null) {
            return (Dimension)dim;
        }
        return new Dimension((int)(dim.getWidth() + 0.5), (int)(dim.getHeight() + 0.5));
    }
    
    public Model coerceToModel(final Object component) {
        if (component instanceof FString || component instanceof String) {
            return new Label(component.toString());
        }
        return (Model)component;
    }
    
    static {
        Display.myDisplay = new ThreadLocation("my-display");
    }
}
