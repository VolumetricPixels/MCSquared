package me.thehutch.mcsquared.modules;

import java.util.List;

/**
 * @author thehutch
 */
public class ModuleManager {
    
    private final List<Module> modules;
    
    public ModuleManager() {
        modules = ModuleLoader.loadModules();
    }
    
    public Module getModule(String name) {
        for(Module module : modules) {
            if (module.getName().equals(name)) {
                return module;
            }
        }
        return null;
    }
    
    public boolean moduleExists(String name) {
        return getModule(name) != null;
    }
    
    public boolean unloadModule(Module module) {
        if (module == null) {
            return false;
        }
        module.onUnload();
        return modules.remove(module);
    }
    
    public void unloadModules() {
        for(Module module : modules) {
            unloadModule(module);
            System.out.println("[MCSquared] Module: " + module.getName() + " has been unloaded");
        }
    }
}