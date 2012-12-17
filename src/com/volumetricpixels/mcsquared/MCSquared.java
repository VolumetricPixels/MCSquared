package com.volumetricpixels.mcsquared;

import org.spout.api.plugin.CommonPlugin;

import com.volumetricpixels.mcsquared.modules.ModuleManager;

/**
 * @author thehutch
 */
public class MCSquared extends CommonPlugin {
    private static ModuleManager moduleManager;

    @Override
    public void onEnable() {
        moduleManager = new ModuleManager();
    }

    @Override
    public void onDisable() {
        moduleManager.unloadModules();
    }

    public static ModuleManager getModuleManager() {
        return moduleManager;
    }
}