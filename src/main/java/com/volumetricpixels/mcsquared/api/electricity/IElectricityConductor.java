package com.volumetricpixels.mcsquared.api.electricity;

/**
 * Represents a conductor of electricity
 */
public interface IElectricityConductor extends IElectricityNetworkMember {
	/**
	 * Gets the resistance of this conductor
	 * 
	 * @return This conductor's resistance, as a double
	 */
	double getResistance();

	/**
	 * Gets the capacity of this conductor
	 * 
	 * @return This conductor's capacity in amps, as a double
	 */
	double getCapacity();
}
