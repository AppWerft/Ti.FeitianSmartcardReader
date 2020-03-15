// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;

public class ModuleContext
{
    static ModuleContext global;
    ModuleManager manager;
    public static int IN_HTTP_SERVER;
    public static int IN_SERVLET;
    int flags;
    private ClassToInstanceMap table;
    
    public int getFlags() {
        return this.flags;
    }
    
    public void setFlags(final int flags) {
        this.flags = flags;
    }
    
    public void addFlags(final int flags) {
        this.flags |= flags;
    }
    
    public ModuleContext(final ModuleManager manager) {
        this.table = new ClassToInstanceMap();
        this.manager = manager;
    }
    
    public static ModuleContext getContext() {
        return ModuleContext.global;
    }
    
    public ModuleManager getManager() {
        return this.manager;
    }
    
    public synchronized Object findInstance(final ModuleInfo info) {
        Class clas;
        try {
            clas = info.getModuleClass();
        }
        catch (ClassNotFoundException ex) {
            final String cname = info.getClassName();
            throw new WrappedException("cannot find module " + cname, ex);
        }
        return this.findInstance(clas);
    }
    
    public synchronized Object searchInstance(final Class clas) {
        return ((AbstractHashTable<Entry, K, Object>)this.table).get(clas);
    }
    
    public synchronized Object findInstance(final Class clas) {
        Object inst = this.table.get(clas);
        if (inst == null) {
            try {
                try {
                    inst = clas.getDeclaredField("$instance").get(null);
                }
                catch (NoSuchFieldException ex2) {
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
    
    public synchronized void setInstance(final Object instance) {
        ((AbstractWeakHashTable<Class<?>, Object>)this.table).put(instance.getClass(), instance);
    }
    
    public ModuleInfo findFromInstance(final Object instance) {
        final Class instanceClass = instance.getClass();
        synchronized (this) {
            final ModuleManager manager = this.manager;
            final ModuleInfo info = ModuleManager.findWithClass(instanceClass);
            this.setInstance(instance);
            return info;
        }
    }
    
    public synchronized void clear() {
        this.table.clear();
    }
    
    static {
        ModuleContext.global = new ModuleContext(ModuleManager.instance);
        ModuleContext.IN_HTTP_SERVER = 1;
        ModuleContext.IN_SERVLET = 2;
    }
    
    static class ClassToInstanceMap extends AbstractWeakHashTable<Class, Object>
    {
        @Override
        protected Class getKeyFromValue(final Object instance) {
            return instance.getClass();
        }
        
        protected boolean matches(final Class oldValue, final Class newValue) {
            return oldValue == newValue;
        }
    }
}
