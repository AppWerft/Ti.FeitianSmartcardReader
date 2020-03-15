// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.lang.reflect.Method;

public class LazyPropertyKey<T> extends PropertyKey<T>
{
    public LazyPropertyKey(final String name) {
        super(name);
    }
    
    @Override
    public T get(final PropertySet container, final T defaultValue) {
        final Object raw = container.getProperty(this, defaultValue);
        if (!(raw instanceof String)) {
            return (T)raw;
        }
        final String str = (String)raw;
        final boolean factory = false;
        final int cstart = (str.charAt(0) == '*') ? 1 : 0;
        final int colon = str.indexOf(58);
        if (colon <= cstart || colon >= str.length() - 1) {
            throw new RuntimeException("lazy property " + this + " must have the form \"ClassName:fieldName\" or \"ClassName:staticMethodName\"");
        }
        final Method method = null;
        final String cname = str.substring(cstart, colon);
        final String mname = str.substring(colon + 1);
        T result;
        try {
            final Class clas = Class.forName(cname, true, container.getClass().getClassLoader());
            if (cstart == 0) {
                result = (T)clas.getField(mname).get(null);
            }
            else {
                result = (T)clas.getDeclaredMethod(mname, Object.class).invoke(null, container);
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("lazy property " + this + " has specifier \"" + str + "\" but there is no such " + ((cstart == 0) ? "field" : "method"), ex);
        }
        container.setProperty(this, result);
        return result;
    }
    
    public void set(final PropertySet container, final String specifier) {
        container.setProperty(this, specifier);
    }
}
