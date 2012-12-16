package com.volumetricpixels.mcsquared;

import com.volumetricpixels.mcsquared.modules.ModuleManager;
import org.spout.api.plugin.CommonPlugin;

/**
 * @author thehutch
 */
public class MCSquared extends CommonPlugin {

    private static ModuleManager module_manager;
    
    @Override
    public void onEnable() {
        module_manager = new ModuleManager();
    }

    @Override
    public void onDisable() {
        module_manager.unloadModules();
    }
    
    public static ModuleManager getModuleManager() {
        return module_manager;
    }
}