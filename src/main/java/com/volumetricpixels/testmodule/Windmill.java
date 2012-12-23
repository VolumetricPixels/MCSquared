package com.volumetricpixels.testmodule;

import org.spout.api.entity.Player;
import org.spout.api.inventory.Inventory;
import org.spout.vanilla.component.inventory.WindowHolder;
import org.spout.vanilla.inventory.window.block.CraftingTableWindow;

import com.volumetricpixels.mcsquared.api.energy_matter.EnergyGenerator;

public class Windmill extends EnergyGenerator {
	int energy;
	
	public void onTick(float dt) {
		final int height = this.getBlock().getPosition().getBlockY();
		energy = height - (height % 10);
	}
	
	public Inventory getInventory() {
		return null;
	}

	public void open(Player player) {
		player.get(WindowHolder.class).openWindow(new CraftingTableWindow(player));
		player.sendMessage("Energy: " + energy);
	}

}
