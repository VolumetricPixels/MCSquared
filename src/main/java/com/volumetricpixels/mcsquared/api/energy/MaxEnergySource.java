package com.volumetricpixels.mcsquared.api.energy;

public interface MaxEnergySource<T extends Energy<T>> {

	/**
	 * Gets the maximum energy able to be stored in this node.
	 *
	 * @return Maximum energy
	 */
	public T getMaxEnergy();
}