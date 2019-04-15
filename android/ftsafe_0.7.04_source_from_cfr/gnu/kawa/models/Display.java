/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Spacer;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.lists.FString;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrappedException;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.lang.reflect.Method;

public abstract class Display {
    public static ThreadLocation myDisplay = new ThreadLocation<T>("my-display");

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Display getInstance() {
        Object d = myDisplay.get(null);
        if (d instanceof Display) {
            return (Display)d;
        }
        String name = d == null ? "swing" : d.toString();
        Class[] noClasses = new Class[]{};
        do {
            int comma = name.indexOf(44);
            String rest = null;
            if (comma >= 0) {
                rest = name.substring(comma + 1);
                name = name.substring(0, comma);
            }
            if (name.equals("swing")) {
                name = "gnu.kawa.swingviews.SwingDisplay";
            } else if (name.equals("swt")) {
                name = "gnu.kawa.swtviews.SwtDisplay";
            } else if (name.equals("echo2")) {
                name = "gnu.kawa.echo2.Echo2Display";
            }
            try {
                Class<?> clas = Class.forName(name);
                Method method = clas.getDeclaredMethod("getInstance", noClasses);
                return (Display)method.invoke(null, new Object[0]);
            }
            catch (ClassNotFoundException ex) {
                if (rest == null) {
                    throw new RuntimeException("no display toolkit: " + d);
                }
                name = rest;
                continue;
            }
            break;
        } while (true);
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    public abstract Window makeWindow();

    public abstract void addButton(Button var1, Object var2);

    public abstract void addLabel(Label var1, Object var2);

    public abstract void addImage(DrawImage var1, Object var2);

    public void addText(Text model, Object where) {
        throw new Error("makeView called on Text");
    }

    public void addSpacer(Spacer model, Object where) {
        throw new Error("makeView called on Spacer");
    }

    public abstract void addBox(Box var1, Object var2);

    public abstract void addView(Object var1, Object var2);

    public static Dimension asDimension(Dimension2D dim) {
        if (dim instanceof Dimension || dim == null) {
            return (Dimension)dim;
        }
        return new Dimension((int)(dim.getWidth() + 0.5), (int)(dim.getHeight() + 0.5));
    }

    public Model coerceToModel(Object component) {
        if (component instanceof FString || component instanceof String) {
            return new Label(component.toString());
        }
        return (Model)component;
    }
}

