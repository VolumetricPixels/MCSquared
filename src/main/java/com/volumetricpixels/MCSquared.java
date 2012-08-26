package com.volumetricpixels;

import org.spout.api.plugin.CommonPlugin;

public class MCSquared extends CommonPlugin {

	public void onDisable() {
		getLogger().info("[MC2] v" + getDescription().getVersion() + " disabled.");
	}

	public void onEnable() {
		getLogger().info("[MC2] v" + getDescription().getVersion() + " enabled.");
	}

}
