// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;

public class Options
{
    public static final int BOOLEAN_OPTION = 1;
    public static final int STRING_OPTION = 2;
    Options previous;
    OptionInfo first;
    OptionInfo last;
    HashMap<String, Object> valueTable;
    HashMap<String, OptionInfo> infoTable;
    public static final String UNKNOWN = "unknown option name";
    
    public Options() {
    }
    
    public Options(final Options previous) {
        this.previous = previous;
    }
    
    public OptionInfo add(final String key, final int kind, final String documentation) {
        return this.add(key, kind, null, documentation);
    }
    
    public OptionInfo add(final String key, final int kind, final Object defaultValue, final String documentation) {
        if (this.infoTable == null) {
            this.infoTable = new HashMap<String, OptionInfo>();
        }
        else if (this.infoTable.get(key) != null) {
            throw new RuntimeException("duplicate option key: " + key);
        }
        final OptionInfo info = new OptionInfo();
        info.key = key;
        info.kind = kind;
        info.defaultValue = defaultValue;
        info.documentation = documentation;
        if (this.first == null) {
            this.first = info;
        }
        else {
            this.last.next = info;
        }
        this.last = info;
        this.infoTable.put(key, info);
        return info;
    }
    
    public static Boolean booleanValue(final String argument) {
        if (argument == null || argument.equals("1") || argument.equals("on") || argument.equals("yes") || argument.equals("true")) {
            return Boolean.TRUE;
        }
        if (argument.equals("0") || argument.equals("off") || argument.equals("no") || argument.equals("false")) {
            return Boolean.FALSE;
        }
        return null;
    }
    
    static Object valueOf(final OptionInfo info, final String argument) {
        if ((info.kind & 0x1) != 0x0) {
            return booleanValue(argument);
        }
        return argument;
    }
    
    private void error(final String message, final SourceMessages messages) {
        if (messages == null) {
            throw new RuntimeException(message);
        }
        messages.error('e', message);
    }
    
    public void set(final String key, final Object value) {
        this.set(key, value, null);
    }
    
    public Object set(final String key, Object value, final SourceMessages messages) {
        if (this.valueTable == null) {
            this.valueTable = new HashMap<String, Object>();
        }
        final Object oldValue = this.valueTable.get(key);
        final OptionInfo info = this.getInfo(key);
        if (info == null) {
            this.error("invalid option key: " + key, messages);
            return oldValue;
        }
        if ((info.kind & 0x1) != 0x0) {
            if (value instanceof String) {
                value = valueOf(info, (String)value);
            }
            if (!(value instanceof Boolean)) {
                this.error("value for option " + key + " must be boolean or yes/no/true/false/on/off/1/0", messages);
                return oldValue;
            }
        }
        else if (value == null) {
            value = "";
        }
        this.valueTable.put(key, value);
        return oldValue;
    }
    
    public void reset(final String key, final Object oldValue) {
        if (this.valueTable == null) {
            this.valueTable = new HashMap<String, Object>();
        }
        if (oldValue == null) {
            this.valueTable.remove(key);
        }
        else {
            this.valueTable.put(key, oldValue);
        }
    }
    
    public String set(final String key, final String argument) {
        final OptionInfo info = this.getInfo(key);
        if (info == null) {
            return "unknown option name";
        }
        final Object value = valueOf(info, argument);
        if (value == null && (info.kind & 0x1) != 0x0) {
            return "value of option " + key + " must be yes/no/true/false/on/off/1/0";
        }
        if (this.valueTable == null) {
            this.valueTable = new HashMap<String, Object>();
        }
        this.valueTable.put(key, value);
        return null;
    }
    
    public OptionInfo getInfo(final String key) {
        Object info = (this.infoTable == null) ? null : this.infoTable.get(key);
        if (info == null && this.previous != null) {
            info = this.previous.getInfo(key);
        }
        return (OptionInfo)info;
    }
    
    public Object get(final String key, final Object defaultValue) {
        final OptionInfo info = this.getInfo(key);
        if (info == null) {
            throw new RuntimeException("invalid option key: " + key);
        }
        return this.get(info, defaultValue);
    }
    
    public Object get(final OptionInfo key, Object defaultValue) {
        for (Options options = this; options != null; options = options.previous) {
            OptionInfo info = key;
            while (true) {
                final Object val = (options.valueTable == null) ? null : options.valueTable.get(info.key);
                if (val != null) {
                    return val;
                }
                if (!(info.defaultValue instanceof OptionInfo)) {
                    if (info.defaultValue != null) {
                        defaultValue = info.defaultValue;
                    }
                    break;
                }
                info = (OptionInfo)info.defaultValue;
            }
        }
        return defaultValue;
    }
    
    public Object get(final OptionInfo key) {
        return this.get(key, null);
    }
    
    public Object getLocal(final String key) {
        return (this.valueTable == null) ? null : this.valueTable.get(key);
    }
    
    public boolean getBoolean(final String key) {
        return (boolean)this.get(key, Boolean.FALSE);
    }
    
    public boolean getBoolean(final String key, final boolean defaultValue) {
        final Boolean defaultObject = defaultValue ? Boolean.TRUE : Boolean.FALSE;
        return (boolean)this.get(key, defaultObject);
    }
    
    public boolean getBoolean(final OptionInfo key, final boolean defaultValue) {
        final Boolean defaultObject = defaultValue ? Boolean.TRUE : Boolean.FALSE;
        return (boolean)this.get(key, defaultObject);
    }
    
    public boolean getBoolean(final OptionInfo key) {
        final Object value = this.get(key, null);
        return value != null && (boolean)value;
    }
    
    public void pushOptionValues(final Vector options) {
        for (int len = options.size(), i = 0; i < len; i += 3) {
            final String key = options.elementAt(i);
            final Object oldValue = this.set(key, options.elementAt(i + 2), null);
            options.setElementAt(oldValue, i + 1);
        }
    }
    
    public void popOptionValues(final Vector options) {
        int i = options.size();
        while (true) {
            i -= 3;
            if (i < 0) {
                break;
            }
            final String key = options.elementAt(i);
            final Object oldValue = options.elementAt(i + 1);
            options.setElementAt(null, i + 1);
            this.reset(key, oldValue);
        }
    }
    
    public ArrayList<String> keys() {
        final ArrayList<String> allKeys = new ArrayList<String>();
        for (Options options = this; options != null; options = options.previous) {
            if (options.infoTable != null) {
                for (final String k : options.infoTable.keySet()) {
                    if (!allKeys.contains(k)) {
                        allKeys.add(k);
                    }
                }
            }
        }
        return allKeys;
    }
    
    public String getDoc(final String key) {
        final OptionInfo info = this.getInfo(key);
        if (key == null) {
            return null;
        }
        return info.documentation;
    }
    
    public static final class OptionInfo
    {
        OptionInfo next;
        String key;
        int kind;
        String documentation;
        Object defaultValue;
    }
}
