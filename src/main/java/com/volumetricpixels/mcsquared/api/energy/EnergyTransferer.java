package com.volumetricpixels.mcsquared.api.energy;

/**
 * @author thehutch
 */
public interface EnergyTransferer extends Connectable {
    /**
     * Transfers the amount of energy from the current
     * EnergyHolder into the destination.
     *
     * @param destination
     * @param energy
     */
    public void transferTo(EnergyReceiver destination, double energy);
}