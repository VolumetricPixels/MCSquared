package com.volumetricpixels.mcsquared.api.energy;

public interface EnergyHolder extends EnergyNode {

    /**
     * Gets the energy held inside on this node
     * 
     * @return Energy held
     */
    public Energy getEnergyHeld();

}