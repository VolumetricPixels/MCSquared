package com.volumetricpixels.mcsquared.api;

import com.volumetricpixels.mcsquared.api.electricity.IElectricityPacket;

/**
 * Used for creation of electricity packets in an implementation independant
 * way, so that IElectricityPacket can be an interface and not an implementation
 */
public abstract class ElectricityPacketFactory {
	/**
	 * Creates a new electricity packet containing the given amounts amps and
	 * volts
	 * 
	 * @param amps The amount of amps in the packet
	 * @param volts The amount of volts in the packet
	 * @return A packet with the given amounts of amps and volts
	 */
	public abstract IElectricityPacket newElectricityPacket(double amps, double volts);

	/**
	 * Creates a new electricity packet containing the given amounts amps and
	 * volts. Redirects to the non-static version of this method based on the
	 * factory instance
	 * 
	 * @param amps The amount of amps in the packet
	 * @param volts The amount of volts in the packet
	 * @return A packet with the given amounts of amps and volts
	 */
	public static final IElectricityPacket newPacket(double amps, double volts) {
		return factory.newElectricityPacket(amps, volts);
	}

	private static ElectricityPacketFactory factory;

	public static void setFactory(ElectricityPacketFactory newFactory) {
		if (newFactory == null) {
			throw new IllegalArgumentException("newFactory must not be null!");
		}
		factory = newFactory;
	}
}
