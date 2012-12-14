package com.volumetricpixels.mcsquared;

import com.volumetricpixels.mcsquared.modules.ModuleManager;
import org.spout.api.plugin.CommonPlugin;

/**
 * @author thehutch
 */
public class MCSquared extends CommonPlugin {

    private ModuleManager module_manager;
    
    @Override
    public void onEnable() {
        module_manager = new ModuleManager();
    }

    @Override
    public void onDisable() {
        
    }
    
    public final ModuleManager getModuleManager() {
        return module_manager;
    }
}