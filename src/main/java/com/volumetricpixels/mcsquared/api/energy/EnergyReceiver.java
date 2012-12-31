package com.volumetricpixels.mcsquared.api.energy;

public interface EnergyReceiver {
    
    /**
     * Called when energy is received from a source
     * 
     * @param source 
     * @param energy
     * @return energy that couldn't be received 
     */
    public Energy onReceive(EnergySource source, Energy energy);
}
