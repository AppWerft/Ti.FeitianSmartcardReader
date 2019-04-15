/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;

public class ModuleContext {
    static ModuleContext global = new ModuleContext(ModuleManager.instance);
    ModuleManager manager;
    public static int IN_HTTP_SERVER = 1;
    public static int IN_SERVLET = 2;
    int flags;
    private ClassToInstanceMap table = new ClassToInstanceMap();

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public void addFlags(int flags) {
        this.flags |= flags;
    }

    public ModuleContext(ModuleManager manager) {
        this.manager = manager;
    }

    public static ModuleContext getContext() {
        return global;
    }

    public ModuleManager getManager() {
        return this.manager;
    }

    public synchronized Object findInstance(ModuleInfo info) {
        Class clas;
        try {
            clas = info.getModuleClass();
        }
        catch (ClassNotFoundException ex) {
            String cname = info.getClassName();
            throw new WrappedException("cannot find module " + cname, ex);
        }
        return this.findInstance(clas);
    }

    public synchronized Object searchInstance(Class clas) {
        return this.table.get(clas);
    }

    public synchronized Object findInstance(Class clas) {
        Object inst = this.table.get(clas);
        if (inst == null) {
            try {
                try {
                    inst = clas.getDeclaredField("$instance").get(null);
                }
                catch (NoSuchFieldException ex) {
                    inst = clas.newInstance();
                }
            }
            catch (Exception ex) {
                throw new WrappedException("exception while initializing module " + clas.getName(), ex);
            }
            this.setInstance(inst);
        }
        return inst;
    }

    public synchronized void setInstance(Object instance) {
        this.table.put(instance.getClass(), instance);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModuleInfo findFromInstance(Object instance) {
        Class<?> instanceClass = instance.getClass();
        ModuleContext moduleContext = this;
        synchronized (moduleContext) {
            ModuleInfo info = ModuleManager.findWithClass(instanceClass);
            this.setInstance(instance);
            return info;
        }
    }

    public synchronized void clear() {
        this.table.clear();
    }

    static class ClassToInstanceMap
    extends AbstractWeakHashTable<Class, Object> {
        ClassToInstanceMap() {
        }

        @Override
        protected Class getKeyFromValue(Object instance) {
            return instance.getClass();
        }

        protected boolean matches(Class oldValue, Class newValue) {
            return oldValue == newValue;
        }
    }

}

