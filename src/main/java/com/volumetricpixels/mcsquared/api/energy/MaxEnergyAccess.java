package com.volumetricpixels.mcsquared.api.energy;

public interface MaxEnergyAccess<T extends Energy<T>> extends MaxEnergySource<T> {

	/**
	 * Sets the maximum energy able to be stored in this node.
	 *
	 * @param maxEnergy Energy value to set the maximum at
	 */
	public void setMaxEnergy(T maxEnergy);
}