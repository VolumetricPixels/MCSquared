package com.volumetricpixels.mcsquared;

import java.util.logging.Level;
import org.spout.api.plugin.CommonPlugin;

public class MCSquared extends CommonPlugin {

    public void onEnable() {
		getLogger().log(Level.INFO, "MCSquared version: {0} has been Enabled.", getDescription().getVersion());
	}
    
	public void onDisable() {
		getLogger().log(Level.INFO, "MCSquared version: {0} has been Disabled.", getDescription().getVersion());
	}
}