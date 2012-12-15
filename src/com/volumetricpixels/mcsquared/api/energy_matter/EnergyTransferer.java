package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public interface EnergyTransferer {
    
    /**
     * Transfers the amount of energy from the current 
     * EnergyHolder into the destination.
     *
     * @param destination
     * @param energy 
     */
    public void transferTo(EnergyHolder destination, double energy);
    
    
    /**
     * Called when energy is received from a source
     * 
     * @param source
     * @param energy 
     */
    public void onEnergyReceive(double energy);

}