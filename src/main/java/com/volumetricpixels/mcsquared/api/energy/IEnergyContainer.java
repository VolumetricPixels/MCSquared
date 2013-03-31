package com.volumetricpixels.mcsquared.api.energy;

/**
 * Represents a container of electricity, used to store electricity
 */
public interface IEnergyContainer extends IEnergyNetworkMember {
	/**
	 * Gets the amount of joules currently stored within this container
	 * 
	 * @return This electricity containers currently stored joules
	 */
	double getEnergy();

	/**
	 * Sets the amount of joules currently stored within this container. If
	 * joules is higher than getMaximumEnergy, this machine should 'melt down'
	 * 
	 * @param joules The new amount of joules for the container
	 */
	void setEnergy(double joules);

	/**
	 * Gets the maximum amount of joules this electricity container can store
	 * 
	 * @return This electricity container's maximum capacity in joules
	 */
	double getMaximumEnergy();
}
