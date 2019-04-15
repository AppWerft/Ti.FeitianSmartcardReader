/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.text.SourceMessages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Options {
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

    public Options(Options previous) {
        this.previous = previous;
    }

    public OptionInfo add(String key, int kind, String documentation) {
        return this.add(key, kind, null, documentation);
    }

    public OptionInfo add(String key, int kind, Object defaultValue, String documentation) {
        if (this.infoTable == null) {
            this.infoTable = new HashMap();
        } else if (this.infoTable.get(key) != null) {
            throw new RuntimeException("duplicate option key: " + key);
        }
        OptionInfo info = new OptionInfo();
        info.key = key;
        info.kind = kind;
        info.defaultValue = defaultValue;
        info.documentation = documentation;
        if (this.first == null) {
            this.first = info;
        } else {
            this.last.next = info;
        }
        this.last = info;
        this.infoTable.put(key, info);
        return info;
    }

    public static Boolean booleanValue(String argument) {
        if (argument == null || argument.equals("1") || argument.equals("on") || argument.equals("yes") || argument.equals("true")) {
            return Boolean.TRUE;
        }
        if (argument.equals("0") || argument.equals("off") || argument.equals("no") || argument.equals("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    static Object valueOf(OptionInfo info, String argument) {
        if ((info.kind & 1) != 0) {
            return Options.booleanValue(argument);
        }
        return argument;
    }

    private void error(String message, SourceMessages messages) {
        if (messages == null) {
            throw new RuntimeException(message);
        }
        messages.error('e', message);
    }

    public void set(String key, Object value) {
        this.set(key, value, null);
    }

    public Object set(String key, Object value, SourceMessages messages) {
        if (this.valueTable == null) {
            this.valueTable = new HashMap();
        }
        Object oldValue = this.valueTable.get(key);
        OptionInfo info = this.getInfo(key);
        if (info == null) {
            this.error("invalid option key: " + key, messages);
            return oldValue;
        }
        if ((info.kind & 1) != 0) {
            if (value instanceof String) {
                value = Options.valueOf(info, (String)value);
            }
            if (!(value instanceof Boolean)) {
                this.error("value for option " + key + " must be boolean or yes/no/true/false/on/off/1/0", messages);
                return oldValue;
            }
        } else if (value == null) {
            value = "";
        }
        this.valueTable.put(key, value);
        return oldValue;
    }

    public void reset(String key, Object oldValue) {
        if (this.valueTable == null) {
            this.valueTable = new HashMap();
        }
        if (oldValue == null) {
            this.valueTable.remove(key);
        } else {
            this.valueTable.put(key, oldValue);
        }
    }

    public String set(String key, String argument) {
        OptionInfo info = this.getInfo(key);
        if (info == null) {
            return UNKNOWN;
        }
        Object value = Options.valueOf(info, argument);
        if (value == null && (info.kind & 1) != 0) {
            return "value of option " + key + " must be yes/no/true/false/on/off/1/0";
        }
        if (this.valueTable == null) {
            this.valueTable = new HashMap();
        }
        this.valueTable.put(key, value);
        return null;
    }

    public OptionInfo getInfo(String key) {
        OptionInfo info;
        OptionInfo optionInfo = info = this.infoTable == null ? null : this.infoTable.get(key);
        if (info == null && this.previous != null) {
            info = this.previous.getInfo(key);
        }
        return info;
    }

    public Object get(String key, Object defaultValue) {
        OptionInfo info = this.getInfo(key);
        if (info == null) {
            throw new RuntimeException("invalid option key: " + key);
        }
        return this.get(info, defaultValue);
    }

    public Object get(OptionInfo key, Object defaultValue) {
        Options options = this;
        while (options != null) {
            OptionInfo info = key;
            do {
                Object val;
                Object object2 = val = options.valueTable == null ? null : options.valueTable.get(info.key);
                if (val != null) {
                    return val;
                }
                if (!(info.defaultValue instanceof OptionInfo)) break;
                info = (OptionInfo)info.defaultValue;
            } while (true);
            if (info.defaultValue != null) {
                defaultValue = info.defaultValue;
            }
            options = options.previous;
        }
        return defaultValue;
    }

    public Object get(OptionInfo key) {
        return this.get(key, null);
    }

    public Object getLocal(String key) {
        return this.valueTable == null ? null : this.valueTable.get(key);
    }

    public boolean getBoolean(String key) {
        return (Boolean)this.get(key, (Object)Boolean.FALSE);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Boolean defaultObject = defaultValue ? Boolean.TRUE : Boolean.FALSE;
        return (Boolean)this.get(key, (Object)defaultObject);
    }

    public boolean getBoolean(OptionInfo key, boolean defaultValue) {
        Boolean defaultObject = defaultValue ? Boolean.TRUE : Boolean.FALSE;
        return (Boolean)this.get(key, (Object)defaultObject);
    }

    public boolean getBoolean(OptionInfo key) {
        Object value = this.get(key, null);
        return value == null ? false : (Boolean)value;
    }

    public void pushOptionValues(Vector options) {
        int len = options.size();
        for (int i = 0; i < len; i += 3) {
            String key = (String)options.elementAt(i);
            Object oldValue = this.set(key, options.elementAt(i + 2), null);
            options.setElementAt(oldValue, i + 1);
        }
    }

    public void popOptionValues(Vector options) {
        int i = options.size();
        while ((i -= 3) >= 0) {
            String key = (String)options.elementAt(i);
            Object oldValue = options.elementAt(i + 1);
            options.setElementAt(null, i + 1);
            this.reset(key, oldValue);
        }
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<String>();
        Options options = this;
        while (options != null) {
            if (options.infoTable != null) {
                for (String k : options.infoTable.keySet()) {
                    if (allKeys.contains(k)) continue;
                    allKeys.add(k);
                }
            }
            options = options.previous;
        }
        return allKeys;
    }

    public String getDoc(String key) {
        OptionInfo info = this.getInfo(key);
        if (key == null) {
            return null;
        }
        return info.documentation;
    }

    public static final class OptionInfo {
        OptionInfo next;
        String key;
        int kind;
        String documentation;
        Object defaultValue;
    }

}

