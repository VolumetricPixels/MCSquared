package com.volumetricpixels.mcsquared;

import org.spout.api.plugin.CommonPlugin;

public class MCSquared extends CommonPlugin {

	public void onDisable() {
		getLogger().info("disabled.");
	}

	public void onEnable() {
		getLogger().info("enabled.");
	}

}
