package com.volumetricpixels.mcsquared.api.electricity;

/**
 * Represents a container of electricity, used to store electricity
 */
public interface IElectricityContainer extends IElectricityNetworkMember {
	/**
	 * Gets the amount of joules currently stored within this container
	 * 
	 * @return This electricity containers currently stored joules
	 */
	double getJoules();

	/**
	 * Sets the amount of joules currently stored within this container. If
	 * joules is higher than getMaximumJoules, this machine should 'melt down'
	 * 
	 * @param joules The new amount of joules for the container
	 */
	void setJoules(double joules);

	/**
	 * Gets the maximum amount of joules this electricity container can store
	 * 
	 * @return This electricity container's maximum capacity in joules
	 */
	double getMaximumJoules();
}
