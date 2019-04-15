/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.PropertyKey;
import gnu.mapping.PropertySet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LazyPropertyKey<T>
extends PropertyKey<T> {
    public LazyPropertyKey(String name) {
        super(name);
    }

    @Override
    public T get(PropertySet container, T defaultValue) {
        Object raw = container.getProperty(this, defaultValue);
        if (raw instanceof String) {
            Object result;
            String str = (String)raw;
            boolean factory = false;
            int cstart = str.charAt(0) == '*' ? 1 : 0;
            int colon = str.indexOf(58);
            if (colon <= cstart || colon >= str.length() - 1) {
                throw new RuntimeException("lazy property " + this + " must have the form \"ClassName:fieldName\" or \"ClassName:staticMethodName\"");
            }
            Object method = null;
            String cname = str.substring(cstart, colon);
            String mname = str.substring(colon + 1);
            try {
                Class<?> clas = Class.forName(cname, true, container.getClass().getClassLoader());
                result = cstart == 0 ? clas.getField(mname).get(null) : clas.getDeclaredMethod(mname, Object.class).invoke(null, container);
            }
            catch (Exception ex) {
                throw new RuntimeException("lazy property " + this + " has specifier \"" + str + "\" but there is no such " + (cstart == 0 ? "field" : "method"), ex);
            }
            container.setProperty(this, result);
            return (T)result;
        }
        return (T)raw;
    }

    @Override
    public void set(PropertySet container, String specifier) {
        container.setProperty(this, specifier);
    }
}

