package com.volumetricpixels.mcsquared.api.energy_matter;

/**
 * @author thehutch
 */
public interface EnergyReceiver extends Connectable {
    /**
     * Called when energy is received from a source
     * 
     * @param energy 
     */
    public void onEnergyReceive(double energy);
}