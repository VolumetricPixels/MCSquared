package com.volumetricpixels.mcsquared;

import java.util.logging.Level;

import org.spout.api.plugin.CommonPlugin;

public class MCSquared extends CommonPlugin {

    public void onEnable() {
        getLogger().log(Level.INFO, "MCSquared version {0} is now enabled", getDescription().getVersion());
    }

    public void onDisable() {
        getLogger().log(Level.INFO, "MCSquared version {0} is now disabled", getDescription().getVersion());
    }
}