package com.volumetricpixels.mcsquared;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.spout.api.plugin.CommonPlugin;

public class MCSquared extends CommonPlugin {
    private Logger logger;

    public void onEnable() {
        logger = getLogger();

        logger.log(Level.INFO, "MCSquared version {0} is now enabled", getDescription().getVersion());
    }

    public void onDisable() {
        logger.log(Level.INFO, "MCSquared version {0} is now disabled", getDescription().getVersion());
    }
}