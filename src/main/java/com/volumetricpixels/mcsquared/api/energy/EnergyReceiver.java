package com.volumetricpixels.mcsquared.api.energy;

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