package com.volumetricpixels.mcsquared.api.electricity;

/**
 * Represents a 'packet' of electricity (this class is also used as a utility
 * for storing an amount of energy)
 */
public interface IElectricityPacket extends Cloneable {
	/**
	 * Gets the amount of amps in this packet
	 * 
	 * @return The amount of amps contained within this packet, as a double
	 */
	double getAmps();

	/**
	 * Gets the amount of volts in this packet
	 * 
	 * @return The amount of volts contained within this packet, as a double
	 */
	double getVolts();

	/**
	 * Gets the amount of watts in this packet
	 * 
	 * @return The amount of watts contained within this packet, as a double
	 */
	double getWatts();

	/**
	 * Gets the conductance of this packet
	 * 
	 * @return The conductance of this packet, as a double
	 */
	double getConductance();

	/**
	 * Gets the resistance of this packet
	 * 
	 * @return The resistance of this packet, as a double
	 */
	double getResistance();

	/**
	 * {@inheritDoc}
	 */
	IElectricityPacket clone();

	/**
	 * {@inheritDoc}
	 */
	boolean equals(Object o);

	/**
	 * {@inheritDoc}
	 */
	int hashCode();

	/**
	 * {@inheritDoc}
	 */
	String toString();
}
