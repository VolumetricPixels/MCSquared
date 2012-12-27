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
    public void onTransfer(EnergyTransferer destination, double energy);
    
    /**
     * Called when energy is received from a source
     * 
     * @param energy 
     */
    public void onReceive(double energy);
}