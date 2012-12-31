package com.volumetricpixels.mcsquared.api.energy;

import java.util.Set;

public interface EnergyReceiver extends EnergyNode {
    
    /**
     * Called when energy is received from a source
     * 
     * @param source 
     * @param energy
     * @return energy that couldn't be received 
     */
    public Energy onReceive(EnergySource source, Set<EnergyNode> visited, Energy energy);
    
}