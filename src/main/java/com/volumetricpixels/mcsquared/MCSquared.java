package com.volumetricpixels.mcsquared;

import org.spout.api.plugin.CommonPlugin;

import com.volumetricpixels.mcsquared.impl.MC2ElectricityPacketFactory;

/**
 * Main class for the MCSquared plugin
 */
public class MCSquared extends CommonPlugin {
	@Override
	public void onEnable() {
		new MC2ElectricityPacketFactory();
	}

	@Override
	public void onDisable() {
	}
}
