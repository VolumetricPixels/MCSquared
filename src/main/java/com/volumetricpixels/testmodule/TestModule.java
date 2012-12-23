package com.volumetricpixels.testmodule;

import org.spout.api.plugin.CommonPlugin;

public class TestModule extends CommonPlugin {
	public static final WindmillBlock w = new WindmillBlock("Windmill", 512);
	
	public void onDisable() {
		getLogger().info("disabled.");
	}

	public void onEnable() {
		getLogger().info("enabled.");
	}

}
