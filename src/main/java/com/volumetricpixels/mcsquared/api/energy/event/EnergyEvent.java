package com.volumetricpixels.mcsquared.api.energy.event;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import org.spout.api.event.Event;

public abstract class EnergyEvent extends Event {

	private Energy energy;

	public EnergyEvent(Energy energy) {
		this.energy = energy;
	}

	public Energy getEnergy() {
		return energy;
	}

	public void setEnergy(Energy energy) {
		this.energy = energy;
	}
}