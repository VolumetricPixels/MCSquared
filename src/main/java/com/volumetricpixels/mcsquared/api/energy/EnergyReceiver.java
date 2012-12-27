package com.volumetricpixels.mcsquared.api.energy;

/**
 *
 * @author kitskub
 */
public interface EnergyReceiver {
    
    /**
     * Called when energy is received from a source
     * 
     * @param source 
     * @param energy
     * @return energy that couldn't be received 
     */
    public double onReceive(EnergySource source, double energy);
}
