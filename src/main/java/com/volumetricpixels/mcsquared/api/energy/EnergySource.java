package com.volumetricpixels.mcsquared.api.energy;

/**
 *
 * @author kitskub
 */
public interface EnergySource {
	/**
     * Transfers the amount of energy from the current
     * EnergyHolder into the destination.
     *
     * @param destination
     * @param energy
     * @return energy that couldn't be transmitted 
     */
    public double onTransmit(EnergyReceiver destination, double energy);
}
